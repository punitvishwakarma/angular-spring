/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.punit.angular.dao;

import com.punit.angular.domain.Stock;
import com.punit.angular.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Punit
 */
public class StockDAO {

    public static List<Stock> getStockList() {
        List<Stock> stocks = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            String hql = "from Stock";
            Query query = session.createQuery(hql);
            stocks = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stocks;
    }
}
