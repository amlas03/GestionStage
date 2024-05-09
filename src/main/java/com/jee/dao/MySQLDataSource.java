package com.jee.dao;

public class MySQLDataSource extends DataSource{
	
	public MySQLDataSource(String dbname) {
		super("com.mysql.cj.jdbc.Driver","jdbc:mysql://localhost:3306/"+dbname,"root", "1234");
	}
	
	public MySQLDataSource(String user, String pwd, String host, String dbname) {
		super("com.mysql.cj.jdbc.Driver","jdbc:mysql://"+host+":3306/"+dbname,user, pwd);
	}
	
	public MySQLDataSource(String dbname, String pwd) {
		super("com.mysql.cj.jdbc.Driver","jdbc:mysql://localhost:3306/"+dbname,"root", pwd);
	}
}
