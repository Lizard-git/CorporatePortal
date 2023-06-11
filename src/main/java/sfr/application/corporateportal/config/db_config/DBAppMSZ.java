package sfr.application.corporateportal.config.db_config;

import jakarta.persistence.ValidationMode;
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

@EnableJpaRepositories(
        entityManagerFactoryRef = DBAppMSZ.ENTITY_MANAGER_FACTORY,
        transactionManagerRef = DBAppMSZ.TRANSACTION_MANAGER,
        basePackages = DBAppMSZ.JPA_REPOSITORY_PACKAGE
)
@Configuration
public class DBAppMSZ {
    //Указание имя property в конфигурационном файле для данной конфигурации------------------------------------------//
    public static final String PROPERTY_PREFIX = "app.msz.datasource";
    //----------------------------------------------------------------------------------------------------------------//

    //Указание места нахождения сущностей и репозиториев для данной конфигурации--------------------------------------//
    public static final String JPA_REPOSITORY_PACKAGE = "sfr.application.corporateportal.msz.repository";
    public static final String ENTITY_PACKAGE = "sfr.application.corporateportal.msz.entity";
    //----------------------------------------------------------------------------------------------------------------//

    //Имена новых бинов TransactionManager, EntityManagerFactory и других---------------------------------------------//
    public static final String ENTITY_MANAGER_FACTORY = "mszEntityManagerFactory";
    public static final String DATA_SOURCE = "mszDataSource";
    public static final String DATABASE_PROPERTY = "mszDatabaseProperty";
    public static final String TRANSACTION_MANAGER = "mszTransactionManager";
    //----------------------------------------------------------------------------------------------------------------//


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
        //------------------------------------------------------------------------------------------------------------//
        HibernateJpaVendorAdapter a = new HibernateJpaVendorAdapter();
        a.setGenerateDdl(false); //менять на true при генерации
        a.setShowSql(true);
        //------------------------------------------------------------------------------------------------------------//

        //------------------------------------------------------------------------------------------------------------//
        final HashMap<String, Object> properties = new HashMap<>();
        //properties.put("jakarta.persistence.validation.mode", "CALLBACK");
        properties.put("hibernate.hbm2ddl.auto", "none");
            //none - Никаких действий не выполняется. Схема не будет создана.
            //create-only - Будет создана схема базы данных.
            //drop - Схема базы данных будет удалена.
            //create - Схема базы данных будет удалена и создана позже.
            //create-drop - Схема базы данных будет удалена и создана позже. После закрытия SessionFactory
            // схема базы данных будет удалена.
            //validate - Схема базы данных будет проверена с использованием сопоставлений сущностей.
            //update - Схема базы данных будет обновлена путем сравнения существующей схемы базы данных
            // с сопоставлениями сущностей.
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
            //DB2 - org.hibernate.dialect.DB2Dialect
            //MySQL - org.hibernate.dialect.MySQLDialect
            //PostgreSQL - org.hibernate.dialect.PostgreSQLDialect
        //------------------------------------------------------------------------------------------------------------//

        //------------------------------------------------------------------------------------------------------------//
        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPersistenceUnitName(ENTITY_MANAGER_FACTORY);
        em.setPackagesToScan(ENTITY_PACKAGE);
        em.setJpaVendorAdapter(a);
        em.setValidationMode(ValidationMode.CALLBACK);
        em.setJpaPropertyMap(properties);
        //------------------------------------------------------------------------------------------------------------//
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
