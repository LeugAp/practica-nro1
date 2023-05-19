/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.exception.SpaceException;
import controller.sd.exception.EmptyException;
import controller.sd.exception.IndexException;
import controller.sd.exception.TopException;
import controller.sd.list.MyLinkedList;
import model.Branch;
import model.MonthEnum;
import model.Sale;

/**
 *
 * @author miguel
 */
public class BranchController {

    private ActionController history = new ActionController();
    private MyLinkedList<Branch> branches;
    private Branch branch;
    private Sale sale;

    public BranchController() {
        this.branches = new MyLinkedList<>();
    }

    public void register() {
        if (this.branches.getSize() == 4) {
            throw new IndexOutOfBoundsException("This position doesn't exist");
        }

        addListSales();
        branches.add(branch);
        history.getAction().setDescription("Registered branch " + branch.getName());
        try {
            history.register();
        } catch (TopException e) {
            System.out.println(e.getMessage());
        }
    }

    private void addListSales() {

        if (branch.getSales().isEmpty()) {
            for (MonthEnum m : MonthEnum.values()) {
                branch.getSales().add(new Sale(m.ordinal(), m, 0.0));
            }
        }
        history.getAction().setDescription("Added list of sales in " + branch.getName());
        try {
            history.register();
        } catch (TopException e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveSale(int index, double value) throws SpaceException, EmptyException, IndexException {
        if (index >= this.branch.getSales().getSize()) {
            throw new SpaceException();
        }

        if (this.branch == null) {
            throw new NullPointerException("Branch doesn't exit");
        }
        
        branch.getSales().get(index).setValue(value);
        history.getAction().setDescription("Saved " + sale + " in branch " + branch.getName());
        try {
            history.register();
        } catch (TopException ex) {
            System.out.println(ex.getCause());
        }
    }

    public MyLinkedList<Branch> getBranches() {
        return branches;
    }

    public void setBranches(MyLinkedList<Branch> branches) {
        this.branches = branches;
    }

    public Branch getBranch() {
        if (branch == null) {
            branch = new Branch();
        }
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Sale getSale() {
        if (sale == null) {
            sale = new Sale();
        }
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public ActionController getHistory() {
        return history;
    }

    public void setHistory(ActionController history) {
        this.history = history;
    }

    
}
