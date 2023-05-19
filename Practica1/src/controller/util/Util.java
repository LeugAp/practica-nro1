/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.util;

import controller.sd.exception.EmptyException;
import controller.sd.exception.IndexException;
import controller.sd.list.MyLinkedList;
import controller.sd.list.Node;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import model.Branch;
import model.MonthEnum;
import model.Sale;

/**
 *
 * @author miguel
 */
public class Util {

    public static void printStruct(MyLinkedList<Branch> list) throws EmptyException, IndexException {
        for (int i = 0; i < list.getSize(); i++) {
            Branch tmp = list.get(i);
            System.out.println("Branch -> " + tmp.getName());
            System.out.println("Sales {");
            for (int j = 0; j < tmp.getSales().getSize(); j++) {
                Sale s = tmp.getSales().get(j);
                System.out.println(s.getMonth() + " -> " + s.getValue());
            }
            System.out.println("}");
        }
    }

    public static Branch largestSale(MyLinkedList<Branch> list, int month) throws EmptyException, IndexException {
        Branch largest = null;
        double aux = -1;

        for (int i = 0; i < list.getSize(); i++) {
            Branch tmp = list.get(i);
            if (aux < tmp.getSales().get(month).getValue()) {
                aux = tmp.getSales().get(month).getValue();
                largest = tmp;
            }
        }
        return largest;
    }

    public static MonthEnum smallestSalesMonth(MyLinkedList<Branch> list) throws EmptyException, IndexException {
        double sumMonth = 0;
        double aux = -1;
        MonthEnum smallest = null;
        for (MonthEnum m : MonthEnum.values()) {
            sumMonth = 0;
            for (int i = 0; i < list.getSize(); i++) {
                Branch tmp = list.get(i);
                sumMonth += tmp.getSales().get(m.ordinal()).getValue();
            }
            if (aux > sumMonth || aux == -1) {
                aux = sumMonth;
                smallest = m;
            }
        }
        System.out.println("Sum -> "+ aux);
        return smallest;
    }
    
    public static double totalMonth (MyLinkedList<Branch> list, int month) throws EmptyException, IndexException {
        double sum = 0;
        for (int i = 0; i < list.getSize(); i++) {
            sum += list.get(i).getSales().get(month).getValue();
        }
        
        return sum;
    }
    
    public static String getTime(LocalDateTime time){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatTime = time.format(formatter);
        return formatTime;
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

        if (sum == 0) {
            return sum;
        }

        return sum / (b.getSales().getSize());

    }
}
