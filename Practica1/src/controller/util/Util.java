/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.util;

import controller.sd.list.Node;
import model.Branch;
import model.Sale;

/**
 *
 * @author miguel
 */
public class Util {
    public static void print(Object[] obj) {

        System.out.println("List of " + obj.getClass().getSimpleName());

        for (Object o : obj) {
            if (o != null) {
                System.out.println(o.toString());
            }
        }
    }

    public static Double sumSales(Branch b) {
        if (b.getSales() == null) {
            return 0.0;
        }

        Double sales = 0.0;
        Node<Sale> tmp = b.getSales().getHeader();
        
        while (tmp != null) {
            sales += tmp.getInfo().getValue();
            tmp = tmp.getNext();
        }

        return sales;
    }

    public static Double meanSales(Branch b) {
        Double sum = sumSales(b);

        if (sum == 0)
            return sum;

        return sum / (b.getSales().getSize());

    }
}