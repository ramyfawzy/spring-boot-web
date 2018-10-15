package com.lab.configuration;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

public class DataSourceConfig {

	private String url;
	private String username;
	private String password;
	private String driverClassName;
	private String maximumPoolSize;
	private String catalog;
	
	public static final String datasourcePrefix = "datasource.";
	
	
	
	/**
	 * 
	 */
	public DataSourceConfig() {
	}
	
	public DataSourceConfig(String instance) {
		String url = new StringBuilder(datasourcePrefix).append(instance).append(".jdbcUrl").toString();
		String username = new StringBuilder(datasourcePrefix).append(instance).append(".username").toString();
		String password = new StringBuilder(datasourcePrefix).append(instance).append(".password").toString();
		String driverClassName = new StringBuilder(datasourcePrefix).append(instance).append(".driverClassName").toString();
		String maximumPoolSize = new StringBuilder(datasourcePrefix).append(instance).append(".maximumPoolSize").toString();
		String catalog = new StringBuilder(datasourcePrefix).append(instance).append(".catalog").toString();
		PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
		YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
		yaml.setResources(new ClassPathResource("application.yml"));
		propertySourcesPlaceholderConfigurer.setProperties(yaml.getObject());
		this.setUrl(yaml.getObject().getProperty(url));
		this.setUsername(yaml.getObject().getProperty(username));
		this.setPassword(yaml.getObject().getProperty(password));
		this.setMaximumPoolSize(yaml.getObject().getProperty(maximumPoolSize));
		this.setDriverClassName(yaml.getObject().getProperty(driverClassName));
		this.setCatalog(yaml.getObject().getProperty(catalog));
	}
	
	/**
	 * @param url
	 * @param username
	 * @param password
	 * @param driverClassName
	 */
	public DataSourceConfig(String url, String username, String password,
			String driverClassName, String maximumPoolSize, String catalog) {
		this.url = url;
		this.username = username;
		this.password = password;
		this.driverClassName = driverClassName;
		this.maximumPoolSize = maximumPoolSize;
		this.catalog = catalog;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the driverClassName
	 */
	public String getDriverClassName() {
		return driverClassName;
	}
	/**
	 * @param driverClassName the driverClassName to set
	 */
	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}
	/**
	 * @return the maximumPoolSize
	 */
	public String getMaximumPoolSize() {
		return maximumPoolSize;
	}

	/**
	 * @param maximumPoolSize the maximumPoolSize to set
	 */
	public void setMaximumPoolSize(String maximumPoolSize) {
		this.maximumPoolSize = maximumPoolSize;
	}

	/**
	 * @return the catalog
	 */
	public String getCatalog() {
		return catalog;
	}

	/**
	 * @param catalog the catalog to set
	 */
	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DataSourceConfig [url=").append(url).append(", username=")
				.append(username).append(", password=").append(password)
				.append(", driverClassName=").append(driverClassName)
				.append(", maximumPoolSize=").append(maximumPoolSize).append("]");
		return builder.toString();
	}
	
	

	
	
	

}
