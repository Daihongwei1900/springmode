package com.imooc.transmanager.utils;


import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * Spring数据库操作工具类
 */
public class TemplateUtils {
	private final static String dbDriver = "com.mysql.jdbc.Driver";
	private final static String dbUrl = "jdbc:mysql://127.0.0.1:3306/test";
	private final static String dbUser = "root";
	private final static String dbPwd = "root";

	private static BasicDataSource dataSource;

	//静态初识：创建连接数据源
	static {
		//配置数据源
		dataSource = new BasicDataSource();
		dataSource.setDriverClassName(dbDriver);
		dataSource.setUrl(dbUrl);
		dataSource.setUsername(dbUser);
		dataSource.setPassword(dbPwd);
		//指定连接池初始连接数
		dataSource.setInitialSize(10);
		//设定同时向数据库申请的最大连接数
		dataSource.setMaxTotal(50);
		//数据库保持的最小连接数
		dataSource.setMinIdle(5);
	}
		//获取事务
	public static TransactionTemplate getTransactionTemplate(){
		DataSourceTransactionManager txManager = new DataSourceTransactionManager(dataSource);
		return new TransactionTemplate(txManager);
	}
	public static JdbcTemplate getJdbcTemplate(){
		return new JdbcTemplate(dataSource);
	}
	public static NamedParameterJdbcTemplate getNamedParameterJdbcTemplate(){
		return  new NamedParameterJdbcTemplate(dataSource);
	}
	public static SimpleJdbcInsert getSimpleJdbcTemplate(){
		return new SimpleJdbcInsert(dataSource);
	}

	/**
	 *获取事务管理器；TransactionManager
	 * 根据需求，可以是JDBC，Hibernate,这里定义JDBC事务管理
	 * @return DataSourcesactionManager
	 */
	public static DataSourceTransactionManager getDataSourceTransacionManager(){
		DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
		//设置事务源
		dataSourceTransactionManager.setDataSource(dataSource);
		return dataSourceTransactionManager;
	}

	public static DataSourceTransactionManager getDataSourceTransactionManager() {
		DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
		// 设置数据源:此事务数据源须和正式事务管理器的数据源一致
		dataSourceTransactionManager.setDataSource(dataSource);
		return dataSourceTransactionManager;
	}
}
