package com.iwt.traing.pra02.hive;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.iwinner.hive.utils.HiveConnectionUtils;

public class HiveStudentExample {

	/**
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {

		
		 Statement stmt = HiveConnectionUtils.getConnection().createStatement();
		// show tables
		System.out.println("================================");
		String query1 = "show tables";
		System.out.println("Running Query : " + query1);
		ResultSet res = stmt.executeQuery(query1);
		while (res.next()) {
			System.out.println(res.getString(1));
		}

		String tableName = "student";
		
		
		// create table student
		System.out.println("================================");
		String query2 = "create table if not exists " + tableName
				+ " (name string, id int , course string, year int) row format delimited fields terminated by '\t'";
		System.out.println("Running Query : " + query2);
		stmt.execute(query2);

		
		
		// load data into student table
		System.out.println("================================");
		String path = "/home/hadoop/hive_inputs/student.txt";
		String query3 = "load data local inpath '" + path + "' overwrite into table " + tableName;
		System.out.println("Running Query : " + query3);
		stmt.execute(query3);

		
		
		stmt.execute("set hive.cli.print.header=true");
		
		
		// query student table
		System.out.println("================================");
		String query4 = "select * from " + tableName;
		System.out.println("Running Query : " + query4);
		res = stmt.executeQuery(query4);
		while (res.next()) {
			System.out.println(res.getString(1) + ":" + res.getString(2) + ":" + res.getString(3) + ":" + res.getString(4));
		}
		
	}
}
