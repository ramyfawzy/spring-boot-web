package com.lab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.lab.configuration.DataSourceConfig;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class JdbcTemplateProvider {
	
	private static Logger logger = LoggerFactory.getLogger(JdbcTemplateProvider.class);
	
	public static final String datasourcePrefix = "datasource.";
	
	static HikariDataSource dataSource = new HikariDataSource();
	
	public JdbcTemplateProvider() {
	}

	public static JdbcTemplate getJdbcTemplate(DataSourceConfig dataSourceConfig) {
		logger.info("preparing Jdbc template ...");
		if(dataSource.getDriverClassName() == null || dataSource.isClosed())
			dataSource = new HikariDataSource(configureHikari(dataSourceConfig));
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate;
	}
	
	public static HikariConfig configureHikari(DataSourceConfig dataSourceConfig) {
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setCatalog(dataSourceConfig.getCatalog());
		hikariConfig.setJdbcUrl(dataSourceConfig.getUrl());
		hikariConfig.setUsername(dataSourceConfig.getUsername());
//		hikariConfig.sh
		hikariConfig.setPassword(dataSourceConfig.getPassword());
		hikariConfig.setDriverClassName(dataSourceConfig.getDriverClassName());
		return hikariConfig;
	}
}
