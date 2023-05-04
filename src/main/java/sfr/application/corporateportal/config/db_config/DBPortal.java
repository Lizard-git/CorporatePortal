package sfr.application.corporateportal.config.db_config;

import jakarta.persistence.ValidationMode;
import org.hibernate.boot.SchemaAutoTooling;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * Сайт с информацией
 * https://struchkov.dev/blog/ru/multiple-databases-spring-boot/
 * /-------------------------------------------------------------------------------------------------------------------/
 * Чтобы работать с двумя базами нужно создать для каждой БД свой EntityManagerFactory и TransactionManager.
 * А также указать, какие JPA репозитории и Entity относятся к этой БД.
 * /-------------------------------------------------------------------------------------------------------------------/
 * В наших конфигурациях будут отличаться только строки 12-18 это переменные настройки:
 * /-------------------------------------------------------------------------------------------------------------------/
 * PROPERTY_PREFIX – Префикс для конфигурации в файле application.property
 * JPA_REPOSITORY_PACKAGE – Путь до пакета, где лежат JPA репозитории для данной БД
 * ENTITY_PACKAGE – Путь до пакета, где лежат Entity
 * ENTITY_MANAGER_FACTORY – Название бина EntityManager
 * DATA_SOURCE – Название бина DataSource
 * DATABASE_PROPERTY – Название бина DatabaseProperty
 * TRANSACTION_MANAGER – Название бина TransactionManager
 * /-------------------------------------------------------------------------------------------------------------------/
 * Названия для бинов нужны, чтобы спринг из двух вариантов выбирал правильный для конкретной БД.
 */

@EnableJpaRepositories(
        entityManagerFactoryRef = DBPortal.ENTITY_MANAGER_FACTORY,
        transactionManagerRef = DBPortal.TRANSACTION_MANAGER,
        basePackages = DBPortal.JPA_REPOSITORY_PACKAGE
)
@Configuration
public class DBPortal {
    public static final String PROPERTY_PREFIX = "app.portal.datasource";
    public static final String JPA_REPOSITORY_PACKAGE = "sfr.application.corporateportal.portal.repository";
    public static final String ENTITY_PACKAGE = "sfr.application.corporateportal.portal.entity";
    public static final String ENTITY_MANAGER_FACTORY = "portalEntityManagerFactory";
    public static final String DATA_SOURCE = "portalDataSource";
    public static final String DATABASE_PROPERTY = "portalDatabaseProperty";
    public static final String TRANSACTION_MANAGER = "portalTransactionManager";


    @Bean(DATABASE_PROPERTY)
    @ConfigurationProperties(prefix = PROPERTY_PREFIX)
    public DatabaseProperty appDatabaseProperty() {
        return new DatabaseProperty();
    }

    @Bean(DATA_SOURCE)
    public DataSource appDataSource(
            @Qualifier(DATABASE_PROPERTY) DatabaseProperty databaseProperty
    ) {
        return DataSourceBuilder
                .create()
                .username(databaseProperty.getUsername())
                .password(databaseProperty.getPassword())
                .url(databaseProperty.getUrl())
                .driverClassName(databaseProperty.getClassDriver())
                .build();
    }

    @Bean(ENTITY_MANAGER_FACTORY)
    public LocalContainerEntityManagerFactoryBean appEntityManager(
            @Qualifier(DATA_SOURCE) DataSource dataSource
    ) {
        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();

        HibernateJpaVendorAdapter a = new HibernateJpaVendorAdapter();
        a.setGenerateDdl(false);//менять на true при генерации
        a.setShowSql(true);
        em.setDataSource(dataSource);
        em.setPersistenceUnitName(ENTITY_MANAGER_FACTORY);
        em.setPackagesToScan(ENTITY_PACKAGE);
        em.setJpaVendorAdapter(a);

        em.setValidationMode(ValidationMode.CALLBACK);
        final HashMap<String, Object> properties = new HashMap<>();
        //properties.put("jakarta.persistence.validation.mode", "CALLBACK");
        //none - Никаких действий не выполняется. Схема не будет создана.
        //create-only - Будет создана схема базы данных.
        //drop - Схема базы данных будет удалена.
        //create - Схема базы данных будет удалена и создана позже.
        //create-drop - Схема базы данных будет удалена и создана позже. После закрытия SessionFactory схема базы данных будет удалена.
        //validate - Схема базы данных будет проверена с использованием сопоставлений сущностей.
        //update - Схема базы данных будет обновлена путем сравнения существующей схемы базы данных с сопоставлениями сущностей.
        properties.put("hibernate.hbm2ddl.auto", "none");
        //DB2 - org.hibernate.dialect.DB2Dialect
        //MySQL - org.hibernate.dialect.MySQLDialect
        //PostgreSQL - org.hibernate.dialect.PostgreSQLDialect
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        em.setJpaPropertyMap(properties);
        return em;
    }

    @Bean(TRANSACTION_MANAGER)
    public PlatformTransactionManager sqlSessionTemplate(
            @Qualifier(ENTITY_MANAGER_FACTORY) LocalContainerEntityManagerFactoryBean entityManager,
            @Qualifier(DATA_SOURCE) DataSource dataSource
    ) {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManager.getObject());
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }
}
