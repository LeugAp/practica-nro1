
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
    
    public static String lowestSaleMonth(MyLinkedList<Branch> list) throws EmptyException, IndexException {
        double totalMonth = 0;
        double tmp = -1;
        MonthEnum month = null;
        
        for (MonthEnum m : MonthEnum.values()) {
            totalMonth = totalMonth(list, m.ordinal());
            
            if (tmp > totalMonth || tmp == -1) {
                tmp = totalMonth;
                month = m;
            }
        }
        
        return month + " -> Total: " + tmp;
    }

    public static int highestSaleIndex(MyLinkedList<Branch> list, int month) throws EmptyException, IndexException {
        int id = 0;
        double maxSale = -1;

        for (int i = 0; i < list.getSize(); i++) {
            Branch tmp = list.get(i);
            if (maxSale < tmp.getSales().get(month).getValue()) {
                maxSale = tmp.getSales().get(month).getValue();
                id = tmp.getId();
            }
        }
        
        return id - 1;
    }
    
    public static String averageSaleMonth(MyLinkedList<Branch> listbranch, int month) throws EmptyException, IndexException {
        double totalValueMonth = totalMonth(listbranch, month);
        
        if (totalValueMonth == 0) {
            return MonthEnum.values()[month] +" -> 0.0";
        } 
        
        for (int i = 0; i < listbranch.getSize() ; i++) {
            if (listbranch.get(i) != null) {
                listbranch.get(i).getSales().get(month);
            }
        }
        
        return MonthEnum.values()[month] +" -> "+ totalValueMonth / 4;
    }
    
    public static double totalMonth(MyLinkedList<Branch> list, int month) throws EmptyException, IndexException {
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

    public static Double totalSale(Branch b) {
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

    public static Double averageSale(Branch b) {
        Double sum = totalSale(b);

        if (sum == 0) {
            return sum;
        }

        return sum / (b.getSales().getSize());

    }
}
