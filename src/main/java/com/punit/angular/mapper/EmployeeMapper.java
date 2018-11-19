/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.punit.angular.mapper;

import com.punit.angular.domain.Employee;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author punitvishwakarma
 */
public class EmployeeMapper implements RowMapper<Employee>{
   
    @Override
    public Employee mapRow(ResultSet rs, int rowNo) throws SQLException {
        Employee employee = new Employee();
        employee.setEmpId(rs.getInt("emp_id"));
        employee.setEmpName(rs.getString("emp_name"));
        employee.setEmpEmail(rs.getString("emp_email"));
        employee.setEmpGender(rs.getString("emp_gender"));
        employee.setEmpAddress(rs.getString("emp_address"));
        return employee;
    }
}
