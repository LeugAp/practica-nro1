
package controller;

import controller.dao.DaoBranch;
import controller.exception.SpaceException;
import controller.sd.exception.EmptyException;
import controller.sd.exception.IndexException;
import controller.sd.exception.TopException;
import controller.sd.list.MyLinkedList;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Branch;
import model.MonthEnum;
import model.Sale;

/**
 *
 * @author miguel
 */
public class BranchController {

    private DaoBranch dao;
    private ActionController history = new ActionController();
    private MyLinkedList<Branch> branches;
    private Branch branch;
    private Sale sale;

    public BranchController() {
        this.dao = new DaoBranch();
        loadBranches();
    }

    public void loadBranches() {
        try {
            setBranches(dao.getAll());
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void register() throws IOException, TopException {
        if (this.branches.getSize() == 4) {
            throw new IndexOutOfBoundsException("This position doesn't exist");
        }

        addListSales();

        saveJson();

        loadBranches();

        history.getAction().setDescription("Registered branch " + branch.getName());

        history.register();

    }

    private void saveJson() {
        try {
            dao.save(branch);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void addListSales() throws TopException, IOException {

        if (branch.getSales().isEmpty()) {
            for (MonthEnum m : MonthEnum.values()) {
                branch.getSales().add(new Sale(m.ordinal(), m, 0.0));
            }
        }

        history.getAction().setDescription("Added list of sales in " + branch.getName());

        history.register();

    }

    public void saveSale(int index, double value) throws SpaceException, EmptyException, IndexException, FileNotFoundException, TopException, IOException {
        if (index >= this.branch.getSales().getSize()) {
            throw new SpaceException();
        }

        if (this.branch == null) {
            throw new NullPointerException("Branch doesn't exit");
        }

        branch.getSales().get(index).setValue(value);

        update(branch.getId());

        loadBranches();
        history.getAction().setDescription("Saved " + sale + " in branch " + branch.getName());

        history.register();

    }

    private void update(int index) {
        try {
            dao.update(branch, index);
        } catch (IOException | EmptyException | IndexException ex) {
            Logger.getLogger(BranchController.class.getName()).log(Level.SEVERE, null, ex);
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
