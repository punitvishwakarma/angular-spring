/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.punit.angular.controller;

import com.google.gson.Gson;
import com.punit.angular.dao.EmployeeDAO;
import com.punit.angular.domain.Employee;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.apache.log4j.Logger;
/**
 *
 * @author punitvishwakarma
 */
@RestController
public class EmployeeController {
    
    private static Logger Log = Logger.getLogger(EmployeeController.class.getName());


    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView("employee");
        try {
            List<Employee> e = employeeDAO.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            Log.error("Error:");
            return null;
        }
        return mav;
    }

    @RequestMapping(value = "/employee_details", method = RequestMethod.POST)
    @ResponseBody
    public String getEmployeeDetails() {
        String data = "";
        try {
            List<Employee> e = employeeDAO.findAll();
            Gson g = new Gson();
            data = g.toJson(e);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
        return data;
    }

    @RequestMapping(value = "/employee_save", method = RequestMethod.POST)
    @ResponseBody
    public boolean employeeSave(@RequestBody Employee employee) {
        try {
            employeeDAO.save(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    
    @RequestMapping(value = "/employee_update", method = RequestMethod.POST)
    @ResponseBody
    public boolean employeeUpdate(@RequestBody Employee employee) {
        try {
            employeeDAO.update(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @RequestMapping(value = "/employee_delete", method = RequestMethod.POST)
    @ResponseBody
    public boolean employeeDelete(@RequestBody Employee employee) {
        try {
            employeeDAO.delete(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    
    @Autowired
    EmployeeDAO employeeDAO;
}
