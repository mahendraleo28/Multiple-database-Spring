package com.example.demo.db1.Config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "entityManagerFactory",
		basePackages = {"com.example.demo.db1.Repo"},
		transactionManagerRef = "transactionManager")

public class Db1Config {
//	dataSource
	@Autowired
	private Environment environment;
	
	@Bean
	@Primary
	public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(environment.getProperty("spring.datasource.url"));
        dataSource.setUsername(environment.getProperty("spring.datasource.username"));
        dataSource.setPassword(environment.getProperty("spring.datasource.password"));
        dataSource.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name"));
        return dataSource;
    }
	
	
	
//	enitity manger factory
	
	@Bean(name = "entityManagerFactory")
	@Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactorybean() {
			LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
			bean.setDataSource(dataSource());
			JpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
			bean.setJpaVendorAdapter(adapter);
			Map<String , String> props= new HashMap<>();
			props.put("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
			props.put("hibernate.show_sql","true");
			props.put("hibernate.hbm2ddl.auto","update");
			bean.setJpaPropertyMap(props);
			bean.setPackagesToScan("com.example.demo.db1.Entity");
        return bean;
    }

	
//	transaction manager factory
	@Bean(name = "transactionManager")
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager manager = new JpaTransactionManager();
		manager.setEntityManagerFactory(entityManagerFactorybean().getObject());
		return manager;
	}

}
