/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.combomodel;

import javax.swing.DefaultComboBoxModel;
import model.MonthEnum;

/**
 *
 * @author migue
 */
public class MonthComboModel extends DefaultComboBoxModel<String> {

    private String item;

    private String[] month = {MonthEnum.JANUARY.name(),
        MonthEnum.FEBRUARY.name(),
        MonthEnum.MARCH.name(),
        MonthEnum.APRIL.name(),
        MonthEnum.MAY.name(),
        MonthEnum.JUNE.name(),
        MonthEnum.JULY.name(),
        MonthEnum.AUGUST.name(),
        MonthEnum.SEPTEMBER.name(),
        MonthEnum.OCTOBER.name(),
        MonthEnum.NOVEMBER.name(),
        MonthEnum.DECEMBER.name()};

    public MonthComboModel() {
        this.item = month[0];
    }

    @Override
    public void setSelectedItem(Object anItem) {
        item = (String) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return item;
    }

    @Override
    public int getSize() {
        return month.length;
    }

    @Override
    public String getElementAt(int index) {
        return month[index];
    }

}
