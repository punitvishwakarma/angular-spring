/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.punit.angular.dao;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

/**
 *
 * @author punitvishwakarma
 */
public class BaseNamedParameterJdbcDaoSupport extends NamedParameterJdbcDaoSupport {

    @Autowired
    public void setDataSource2(DataSource dataSource) {
        setDataSource(dataSource);
    }
}
