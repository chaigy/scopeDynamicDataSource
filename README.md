#scopeDynamicDataSource
使用@refrehScope 来动态属性数据源

主要配置在需要刷新的bean上加次注解

@Bean("cgy")
@RefreshScope
@ConfigurationProperties(prefix="spring.datasource.cgy")
public DataSource getSource(){
	return DataSourceBuilder.create().build();
}
