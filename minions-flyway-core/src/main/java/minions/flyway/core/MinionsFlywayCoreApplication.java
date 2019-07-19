package minions.flyway.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackageClasses = MinionsFlywayCoreApplication.class)
@EntityScan(basePackageClasses = MinionsFlywayCoreApplication.class)
@EnableJpaAuditing// 启用 JPA 审计功能
@SpringBootApplication
public class MinionsFlywayCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(MinionsFlywayCoreApplication.class, args);
	}

}
