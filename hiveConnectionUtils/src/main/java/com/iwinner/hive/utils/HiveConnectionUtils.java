package com.iwinner.hive.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HiveConnectionUtils {

  // Hive Server Start Command:

  // hive --service hiveserver2			

	private static Connection connection = null;
	private static String driverName = "org.apache.hive.jdbc.HiveDriver";

	public static Connection getConnection() {
		if (connection != null)
			return connection;
		else {
			try {
				Class.forName(driverName);
				connection = DriverManager.getConnection("jdbc:hive2://127.0.0.1:10000/iwinnerdb", "hadoop", "");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return connection;
		}

	}

}
