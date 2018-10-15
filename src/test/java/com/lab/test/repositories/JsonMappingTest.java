/**
 * 
 */
package com.lab.test.repositories;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.common.base.Functions;
import com.google.common.base.Predicate;
import com.google.common.base.Stopwatch;
import com.google.common.base.Strings;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.math.IntMath;
import com.lab.JdbcTemplateProvider;
import com.lab.configuration.DataSourceConfig;
import com.lab.domain.Actor;

/**
 * @author Ramy
 *
 */
@RunWith( SpringJUnit4ClassRunner.class )
public class JsonMappingTest {
	
	@Autowired 
	public Environment env;
	
	private static Logger logger = LoggerFactory.getLogger(JdbcTemplateProvider.class);
	
	@Before
	public void setUp() throws Exception {
	}

	/*@Test
	public void test() {
		try {
			car= mapper.readValue(carJson, Car.class);
			mapper.enable(SerializationFeature.INDENT_OUTPUT);
			mapper.writeValue(new File("outputfile.json"), car);
		    System.out.println(car);
		}
		catch (IOException jmde) {
			jmde.printStackTrace();
		}
	}*/
	
	/*@Test
	public void testYaml() {
		  PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
		  YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
		  DataSourceConfig dataSourceConfig = new DataSourceConfig();
		  yaml.setResources(new ClassPathResource("application.yml"));
		  propertySourcesPlaceholderConfigurer.setProperties(yaml.getObject());
		  dataSourceConfig.setUrl(yaml.getObject().getProperty("datasource.primary.url"));
		  dataSourceConfig.setUsername(yaml.getObject().getProperty("datasource.primary.username"));
		  dataSourceConfig.setPassword(yaml.getObject().getProperty("datasource.primary.password"));
		  dataSourceConfig.setDriverClassName(yaml.getObject().getProperty("datasource.primary.driver-class-name"));
		  System.out.println("----------->>>>>>>>>> "+dataSourceConfig);
		  
	}*/
	
	@Test
	public void testJdbcTemplateProvider() throws InterruptedException {
		PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
		YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
		DataSourceConfig dataSourceConfig = new DataSourceConfig();
		yaml.setResources(new ClassPathResource("application.yml"));
		propertySourcesPlaceholderConfigurer.setProperties(yaml.getObject());
		dataSourceConfig.setUrl(yaml.getObject().getProperty("datasource.primary.one.jdbcUrl"));
		dataSourceConfig.setUsername(yaml.getObject().getProperty("datasource.primary.one.username"));
		dataSourceConfig.setPassword(yaml.getObject().getProperty("datasource.primary.one.password"));
		dataSourceConfig.setDriverClassName(yaml.getObject().getProperty("datasource.primary.one.driverClassName"));
		JdbcTemplate jdbcTemplate1 = JdbcTemplateProvider.getJdbcTemplate(dataSourceConfig);
		logger.info(jdbcTemplate1.toString());
		dataSourceConfig.setUrl(yaml.getObject().getProperty("datasource.secondary.jdbcUrl"));
		dataSourceConfig.setUsername(yaml.getObject().getProperty("datasource.secondary.username"));
		dataSourceConfig.setPassword(yaml.getObject().getProperty("datasource.secondary.password"));
		dataSourceConfig.setDriverClassName(yaml.getObject().getProperty("datasource.secondary.driverClassName"));
		JdbcTemplate jdbcTemplate2 = JdbcTemplateProvider.getJdbcTemplate(dataSourceConfig);
		logger.info(jdbcTemplate2.toString());
	}
}
