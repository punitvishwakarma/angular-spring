/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.punit.angular.controller;

import com.google.gson.Gson;
import com.punit.angular.dao.StockDAO;
import com.punit.angular.domain.Stock;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.apache.log4j.Logger;

/**
 *
 * @author punitvishwakarma
 */
@RestController
public class HibernateController {

    private static Logger Log = Logger.getLogger(HibernateController.class.getName());

    @RequestMapping(value = "/hibernate_stock", method = RequestMethod.GET)
    public String home() {
        List<Stock> stocks = null;
        try {
            stocks = StockDAO.getStockList();
        } catch (Exception e) {
            e.printStackTrace();
            Log.error("Error:", e);
            return null;
        }
        Gson g = new Gson();
        return g.toJson(stocks);
    }
}
