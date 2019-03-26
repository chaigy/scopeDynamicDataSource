package com.cgy.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages="com.cgy.dao",sqlSessionFactoryRef="sessionFactory")
public class DataSourceConfig {
	
	@Bean("cgy")
	@RefreshScope
	@ConfigurationProperties(prefix="spring.datasource.cgy")
	public DataSource getSource(){
		return DataSourceBuilder.create().build();
	}
	
	@Bean("sessionFactory")
	public SqlSessionFactory getSqlSessionFactory(@Qualifier("cgy") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
		factory.setDataSource(dataSource);
		return factory.getObject();
	}
	
	@Bean
	public SqlSessionTemplate getTemp(@Qualifier("sessionFactory") SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
