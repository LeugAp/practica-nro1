
package controller.dao;

import controller.sd.exception.EmptyException;
import controller.sd.exception.IndexException;
import controller.sd.list.MyLinkedList;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import model.Branch;

/**
 *
 * @author migue
 */
public class DaoBranch extends DaoAdap<Branch> implements DaoInterface<Branch> {

    public DaoBranch() {
        super(Branch.class);
    }

    @Override
    public void save(Branch obj) throws IOException {
        MyLinkedList<Branch> listBranchTmp = getAll();

        obj.setId(listBranchTmp.getSize() + 1);

        listBranchTmp.add(obj);

        saving(listBranchTmp);
    }

    @Override
    public void update(Branch obj, Integer index) throws IOException, EmptyException, IndexException {
        MyLinkedList<Branch> listBranchTmp = getAll();
        
        listBranchTmp.modify((index - 1), obj);
        
        saving(listBranchTmp);
    }

    @Override
    public MyLinkedList<Branch> getAll() throws FileNotFoundException {
        getConex().getXstream().alias(getClas().getSimpleName().toLowerCase(), getClas());
        MyLinkedList<Branch> listBranchTmp = (MyLinkedList<Branch>) getConex().getXstream().fromXML(new FileReader(getUrl()));

        return listBranchTmp;
    }

    @Override
    public Branch get(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void saving(MyLinkedList<Branch> listBranch) throws IOException {
        getConex().getXstream().alias(getClas().getSimpleName().toLowerCase(), getClas());
        getConex().getXstream().toXML(listBranch, new FileWriter(getUrl()));
    }

}
