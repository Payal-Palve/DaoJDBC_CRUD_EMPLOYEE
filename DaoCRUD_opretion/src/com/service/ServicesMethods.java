package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.model.Employee;
import com.util.Dbutil;
import com.util.QueryUtil;

public class ServicesMethods {

	Dbutil db = new Dbutil();

	public void InsertEmployee(Employee emp) throws SQLException {
//		System.out.println("insert is called..............");
		try (Connection con = db.getConnection();
				PreparedStatement pst = con.prepareStatement(QueryUtil.insertQuery());) {
			pst.setString(1, emp.getEmpName());
			pst.setString(2, emp.getEmpLocation());
			pst.setDouble(3, emp.getEmpSalary());

			int n = pst.executeUpdate();
			if (n > 0) {
				System.out.println("record created " + n);
			} else {
				System.out.println("record not created........");
			}
		}
	}
//end of insert method

	public void displayAll() throws SQLException {
		try (Connection con = db.getConnection();
				Statement pst = con.createStatement();
				ResultSet rs = pst.executeQuery(QueryUtil.SelectAll());) {

			while (rs.next()) {
				printEmployee(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4)));
			}
		}

	}

	private void printEmployee(Employee emp) {
		System.out.println("\nEmployee id : " + emp.getEmpId() + "\nEmployeee name : " + emp.getEmpName()
				+ "\nEmployee location : " + emp.getEmpLocation() + "\nEmployee salary : " + emp.getEmpSalary()
				+ "\n--------------------------------------------------");
	}

	public boolean getEmployeebyId(int id) throws SQLException {
		boolean isFound= false;
		try (Connection con = db.getConnection();
				Statement pst = con.createStatement();
				ResultSet rs = pst.executeQuery(QueryUtil.selectEmployeeId(id));) {

			if (rs.next()) {
				isFound = true;
				printEmployee(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4)));
			} else {
				System.out.println("Record not existed ............" + id);
			}
		}
		return isFound;
	}
	
	public void deleteEmployeeId(int id) throws SQLException {
		try (Connection con = db.getConnection();
				Statement pst = con.createStatement();
				) {
			int n = pst.executeUpdate(QueryUtil.deleteEmployeeId(id));
			System.out.println(n+" record deleted...........");
		}
		
	}
	//update employee
	public void updateEmployee(Employee emp) throws SQLException {
		try(Connection con=db.getConnection();
		PreparedStatement pst=con.prepareStatement(QueryUtil.UpdateEmployee(emp.getEmpId()))
				){
			pst.setString(1, emp.getEmpName());
			pst.setString(2, emp.getEmpLocation());
			pst.setDouble(3, emp.getEmpSalary());
			
			int n=pst.executeUpdate();
		    if(n>0) {
		    	System.out.println(n+ " record updated..........");
		    }else {
		    	System.out.println("record not updated.........");
		    }
		}
	}
	
}
