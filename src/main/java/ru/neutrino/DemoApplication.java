package ru.neutrino;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@SpringBootApplication
@EnableTransactionManagement
public class DemoApplication {

	@Value("${data.url}")
	private String url;
	@Value("${data.username}")
	private String username;
	@Value("${data.password}")
	private String password;
	@Value("${data.driver}")
	private String driver;

	@Bean
	public LocalSessionFactoryBean sessionFactory() {

		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL94Dialect");

		LocalSessionFactoryBean result = new LocalSessionFactoryBean();
		result.setDataSource(dataSource());
		result.setPackagesToScan("ru.neutrino.model");
		result.setHibernateProperties(hibernateProperties);
		return result;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}

	@Bean
	public PlatformTransactionManager transactionManager() throws IOException {
		return new HibernateTransactionManager(sessionFactory().getObject());
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
