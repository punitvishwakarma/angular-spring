/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.punit.angular.dao;

import com.punit.angular.domain.Employee;
import java.util.List;

/**
 *
 * @author punitvishwakarma
 */
public interface EmployeeDAO {

    public abstract void save(Employee employee);

    public abstract void update(Employee employee);

    public abstract Employee findById(Long id);

    public abstract void delete(Employee employee);

    public abstract List<Employee> findAll();
}
