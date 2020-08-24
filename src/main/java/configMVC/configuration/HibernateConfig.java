package configMVC.configuration;

import java.util.Properties;

import javax.persistence.SharedCacheMode;
import javax.persistence.ValidationMode;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan({ "configMVC" })
@EnableJpaRepositories("configMVC")
public class HibernateConfig {

	@Autowired
	private DataSource dataSource;
	
	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory()
	{
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		
		factory.setJpaVendorAdapter(this.jpaVendorAdapter());
		factory.setDataSource(this.dataSource);
		factory.setPackagesToScan("configMVC");
		factory.setJpaProperties(this.hibernateProperties());
		factory.setSharedCacheMode(SharedCacheMode.ENABLE_SELECTIVE);
		factory.setValidationMode(ValidationMode.NONE);
		
		return factory;
		
	}
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter()
	{
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		
		hibernateJpaVendorAdapter.setShowSql(true);
		hibernateJpaVendorAdapter.setGenerateDdl(false);
		hibernateJpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQL8Dialect");

		return hibernateJpaVendorAdapter;
	}
	
	private Properties hibernateProperties()
	{
		

				 

		Properties jpaProperties = new Properties();
		
		jpaProperties.put("javax.persistence.schema-generation.database.action", "none");
		jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		jpaProperties.put("hibernate.show_sql", "false");
		jpaProperties.put("hibernate.format_sql","true");

//		// Setting C3P0 properties
//		jpaProperties.put("C3P0_MIN_SIZE, "5");
//		jpaProperties.put(C3P0_MAX_SIZE, "20");
//		jpaProperties.put(C3P0_ACQUIRE_INCREMENT, "1");
//		jpaProperties.put(C3P0_TIMEOUT, "1800");
//		jpaProperties.put(C3P0_MAX_STATEMENTS, "150");
		
		return jpaProperties;
	}
	
	@Bean
	public JpaTransactionManager transactionManager()
	{
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		
		return transactionManager;
	}
	
}

