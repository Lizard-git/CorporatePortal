package sfr.application.corporateportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class CorporatePortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(CorporatePortalApplication.class, args);
    }

}
