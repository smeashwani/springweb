package springweb.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class HibernateConf {

	@Bean
	public HibernateTemplate getDBTemplate() {
		HibernateTemplate temp = new HibernateTemplate();
		temp.setSessionFactory(sessionFactory().getObject());
		return temp;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("springweb.entity");
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}

	/*
	 * @Bean public DataSource dataSource() { BasicDataSource dataSource = new
	 * BasicDataSource(); dataSource.setDriverClassName("org.hsqldb.jdbcDriver");
	 * dataSource.setUrl("jdbc:hsqldb:mem:training"); dataSource.setUsername("sa");
	 * dataSource.setPassword(""); return dataSource; }
	 */

	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/training");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}
	
	private final Properties hibernateProperties() {
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "create");
		hibernateProperties.setProperty("show_sql", "true");
		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		return hibernateProperties;
	}

	@Bean
	public PlatformTransactionManager hibernateTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}

	
}
