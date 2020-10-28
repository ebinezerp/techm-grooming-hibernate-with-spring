package grooming.hiberatewithspring;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import grooming.hiberatewithspring.dto.Customer;

@org.springframework.context.annotation.Configuration
@EnableTransactionManagement
public class HibernateConfiguration {

	@Bean
	public SessionFactory getSessionFactory() {

		Configuration config = new Configuration();

		Properties properties = new Properties();
		properties.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
		properties.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/hiberatespringdemo");
		properties.setProperty("hibernate.connection.username", "root");
		properties.setProperty("hiberante.connection.password", "root");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL57InnoDBDialect");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.show_sql", "true");

		config.setProperties(properties);
		config.addAnnotatedClass(Customer.class);
		return config.buildSessionFactory();
	}

	@Bean
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory) {
		return new HibernateTransactionManager(sessionFactory);
	}

}
