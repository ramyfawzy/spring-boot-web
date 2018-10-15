/**
 * 
 */
package com.lab.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.lab.JdbcTemplateProvider;
import com.lab.configuration.DataSourceConfig;
import com.lab.configuration.Instance;
import com.lab.domain.Country;

/**
 * @author Ramy
 *
 */
@Controller
@Configuration
public class BlankController {

	private Logger logger = LoggerFactory.getLogger(BlankController.class);
	
	/*@RequestMapping("/blank")
	String blank() {
		try {
			int i =0;
			for(Instance instance : Instance.values()) {
				DataSourceConfig dataSourceConfig = new DataSourceConfig(instance.toString());
				new JdbcTemplateProvider();
				JdbcTemplate jdbcTemplate = JdbcTemplateProvider.getJdbcTemplate(dataSourceConfig);
				logger.error(instance.toString() + i+"  ======234242343 ===>  " + jdbcTemplate
						.queryForList("select first_name from actor", Object.class));
				++i;
			}
			DataSourceConfig dataSourceConfig = new DataSourceConfig("fifth");
			JdbcTemplate jdbcTemplate = JdbcTemplateProvider.getJdbcTemplate(dataSourceConfig);
			logger.error("fifth" + i+"  >>>>>>>>>>>  " + jdbcTemplate
					.queryForList("select name from country", Object.class));
			
			DataSourceConfig dataSourceConfig2 = new DataSourceConfig("sixth");
			JdbcTemplate jdbcTemplate2 = JdbcTemplateProvider.getJdbcTemplate(dataSourceConfig2);
			logger.error("sixth" + i+"  >>>>>>>>>>>  " + jdbcTemplate2
					.queryForList("select title from book", Object.class));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return "blank";
	}*/
	
	 @RequestMapping("/blank")
	    public String hello(Model model) {
		 DataSourceConfig dataSourceConfig = new DataSourceConfig("fifth");
			JdbcTemplate jdbcTemplate = JdbcTemplateProvider.getJdbcTemplate(dataSourceConfig);
			
			List<Country> countries = Lists.newArrayList();
			
//			countries = jdbcTemplate.queryForList("select code,name,population from country", Country.class);
			jdbcTemplate.query("select code,name,population from country", new RowMapper<Country>() {
				
				

				@Override
				public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
					Country country = new Country(rs.getString(1), rs.getString(2), rs.getInt(3));
					countries.add(country);
					return country;
				}
				
			});
	        model.addAttribute("countries", countries);
	        return "blank";
	    }
}
