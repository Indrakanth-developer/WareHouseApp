package com.app.config;

import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@PropertySource("classpath:app.properties")
@EnableWebMvc
@ComponentScan("com.app")
@EnableTransactionManagement //to enable @Transactional anntn in service layer
public class AppConfig implements WebMvcConfigurer{

	@Autowired
	private Environment env;
	@Bean
	public BasicDataSource bds() {
		BasicDataSource b=new BasicDataSource();
		b.setDriverClassName(env.getProperty("driver"));
		b.setUrl(env.getProperty("url"));
		b.setUsername(env.getProperty("user"));
		b.setPassword(env.getProperty("password"));
			return b;
		}
		
	
	@Bean
	public LocalSessionFactoryBean lsfb() {
		LocalSessionFactoryBean b=new LocalSessionFactoryBean();
		b.setDataSource(bds());
		b.setHibernateProperties(props());
		//b.setAnnotatedClasses(ShipmentType.class,UoM.class,OrderMethod.class,WhUserType.class,Item.class);
		b.setPackagesToScan("com.app.model");
		return b;
	}
	@Bean
	public Properties props() {
		Properties p=new Properties();
		p.put("hibernate.dialect", env.getProperty("dial"));
		p.put("hibernate.show_sql", env.getProperty("shw"));
		p.put("hibernate.format_sql", env.getProperty("fmt"));
		p.put("hibernate.hbm2ddl.auto", env.getProperty("ddl"));
		return p;
	}
	
	@Bean
	public HibernateTemplate ht() {
		HibernateTemplate h=new HibernateTemplate();
		h.setSessionFactory(lsfb().getObject());
		return h;
	}
	
	@Bean
	public HibernateTransactionManager htm() {
		HibernateTransactionManager h=new HibernateTransactionManager();
		h.setSessionFactory(lsfb().getObject());
		
		return h;
	}
	@Bean
	public InternalResourceViewResolver irvr() {
		return new InternalResourceViewResolver(env.getProperty("pre"), env.getProperty("suf"));
	}
	
	//adding resource path
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	//adding multipart resolver for file uploads (Document module)
	//activating multipartResolver method name must be multipartResolver
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		return new CommonsMultipartResolver();
	}
}
