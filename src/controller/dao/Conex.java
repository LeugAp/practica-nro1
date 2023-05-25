
package controller.dao;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

/**
 *
 * @author migue
 */
public class Conex {

    private XStream xstream;
    public static String URL = "data/";

    public Conex() {
        this.xstream = new XStream(new JettisonMappedXmlDriver());
        this.xstream.setMode(XStream.NO_REFERENCES);
        this.xstream.addPermission(AnyTypePermission.ANY);
    }

    public XStream getXstream() {
        return xstream;
    }

    public void setXstream(XStream xstream) {
        this.xstream = xstream;
    }

}
