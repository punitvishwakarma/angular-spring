/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.punit.angular.dao;

import com.punit.angular.domain.Employee;
import com.punit.angular.mapper.EmployeeMapper;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

/**
 *
 * @author punitvishwakarma
 */
@Repository
public class EmployeeDAOImpl extends BaseNamedParameterJdbcDaoSupport implements EmployeeDAO {

    @Override
    public void save(Employee employee) {
        String q = "INSERT INTO emp_details("
                + "            emp_name "
                + "           ,emp_email "
                + "           ,emp_gender "
                + "           ,emp_address "
                + "            )VALUES( "
                + "            :emp_name "
                + "           ,:emp_email"
                + "           ,:emp_gender"
                + "           ,:emp_address )";
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("emp_name", employee.getEmpName());
        param.addValue("emp_email", employee.getEmpEmail());
        param.addValue("emp_gender", employee.getEmpGender());
        param.addValue("emp_address", employee.getEmpAddress());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        getNamedParameterJdbcTemplate().update(q, param, keyHolder);
        employee.setEmpId(keyHolder.getKey().intValue());
    }

    @Override
    public void update(Employee employee) {
        String q = " UPDATE emp_details "
                + "  SET  emp_name = :emp_name "
                + "      ,emp_email = :emp_email "
                + "      ,emp_gender = :emp_gender "
                + "      ,emp_address = :emp_address "
                + "  WHERE emp_id = :emp_id ";
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("emp_id", employee.getEmpId());
        param.addValue("emp_name", employee.getEmpName());
        param.addValue("emp_email", employee.getEmpEmail());
        param.addValue("emp_gender", employee.getEmpGender());
        param.addValue("emp_address", employee.getEmpAddress());
        getNamedParameterJdbcTemplate().update(q, param);
    }

    @Override
    public Employee findById(Long id) {
        String query = "SELECT emp_id "
                + "           ,emp_name "
                + "           ,emp_email "
                + "           ,emp_gender "
                + "           ,emp_address"
                + "      FROM emp_details "
                + "      WHERE emp_id = :emp_id ";
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("emp_id", id);
        return (Employee) getNamedParameterJdbcTemplate().queryForObject(query, param, new EmployeeMapper());
    }
 
    @Override
    public List<Employee> findAll() {
        String query = "SELECT emp_id "
                + "           ,emp_name "
                + "           ,emp_email "
                + "           ,emp_gender "
                + "           ,emp_address "
                + "      FROM emp_details ";
        MapSqlParameterSource param = new MapSqlParameterSource();
        List<Employee> employees = getNamedParameterJdbcTemplate().query(query, param, new EmployeeMapper());
        return employees;
    }
    
    @Override
    public void delete(Employee employee) {
        String q = " DELETE FROM emp_details WHERE emp_id = :emp_id ";
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("emp_id", employee.getEmpId());
        getNamedParameterJdbcTemplate().update(q, param);
    }

}
