package com.example.demo.db2.Config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
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
@EntityScan("com.example.demo.db2.Entity")
@EnableJpaRepositories(
    entityManagerFactoryRef = "secondEntityManagerFactory",
    basePackages = "com.example.demo.db2.Repo",
    transactionManagerRef = "secondTransactionManager"
)


public class Db2Config {
//	dataSource
	@Autowired
	private Environment environment;
	
	@Bean(name = "secondDataSource")
	@Primary
	public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(environment.getProperty("second.datasource.url"));
        dataSource.setUsername(environment.getProperty("second.datasource.username"));
        dataSource.setPassword(environment.getProperty("second.datasource.password"));
        dataSource.setDriverClassName(environment.getProperty("second.datasource.driver-class-name"));
        return dataSource;
    }
	
	
	
//	enitity manger factory
	
	@Bean(name = "secondEntityManagerFactory")
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
			bean.setPackagesToScan("com.example.demo.db2.Enitity");
        return bean;
    }

	
//	transaction manager factory
	@Bean(name = "secondTransactionManager")
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager manager = new JpaTransactionManager();
		manager.setEntityManagerFactory(entityManagerFactorybean().getObject());
		return manager;
	}

}
