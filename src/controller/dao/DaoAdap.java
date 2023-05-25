
package controller.dao;


/**
 *
 * @author migue
 * @param <T>
 */
public class DaoAdap<T>{
    private final Conex conex;
    private final Class clas;
    private final String url;
    
    public DaoAdap (Class clas) {
        this.conex = new Conex();
        this.clas = clas;
        this.url = Conex.URL+clas.getSimpleName().toLowerCase()+".json";
    }

    public Conex getConex() {
        return conex;
    }

    public Class getClas() {
        return clas;
    }

    public String getUrl() {
        return url;
    }
    
}
