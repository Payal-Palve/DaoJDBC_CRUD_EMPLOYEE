package com.util;

public class QueryUtil {

	public static String insertQuery() {
		return "INSERT INTO EMPLOYEE (EMPLOYEE_NAME,EMPLOYEE_LOCATION,EMPLOYEE_SALARY) VALUES(?,?,?);";
	}

	public static String SelectAll() {
		return " SELECT * FROM EMPLOYEE";
	}

	public static String selectEmployeeId(int id) {
		// TODO Auto-generated method stub
		return " SELECT * FROM EMPLOYEE where employee_id = " + id;
	}

	public static String deleteEmployeeId(int id) {
		// TODO Auto-generated method stub
		return " DELETE  FROM EMPLOYEE where employee_id = " + id;
	}

	public static String UpdateEmployee(int id) {
		return "UPDATE EMPLOYEE SET EMPLOYEE_NAME = ?,EMPLOYEE_LOCATION = ?,EMPLOYEE_SALARY = ? WHERE EMPLOYEE_ID = "
				+ id;
	}
}
