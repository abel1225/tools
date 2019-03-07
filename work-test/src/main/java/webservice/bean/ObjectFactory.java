
package webservice.bean;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the webservice.bean package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _MTHCM20301JCCRM2ERPRes_QNAME = new QName("http://www.gcl-power.com/ERP/HCM", "MT_HCM20301_JCCRM2ERP_Res");
    private final static QName _MTHCM20301JCCRM2ERPReq_QNAME = new QName("http://www.gcl-power.com/ERP/HCM", "MT_HCM20301_JCCRM2ERP_Req");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webservice.bean
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DTHCM20301JCCRM2ERPRes }
     * 
     */
    public DTHCM20301JCCRM2ERPRes createDTHCM20301JCCRM2ERPRes() {
        return new DTHCM20301JCCRM2ERPRes();
    }

    /**
     * Create an instance of {@link DTHCM20301JCCRM2ERPReq }
     * 
     */
    public DTHCM20301JCCRM2ERPReq createDTHCM20301JCCRM2ERPReq() {
        return new DTHCM20301JCCRM2ERPReq();
    }

    /**
     * Create an instance of {@link DTHCM20301JCCRM2ERPRes.ITEM }
     * 
     */
    public DTHCM20301JCCRM2ERPRes.ITEM createDTHCM20301JCCRM2ERPResITEM() {
        return new DTHCM20301JCCRM2ERPRes.ITEM();
    }

    /**
     * Create an instance of {@link DTHCM20301JCCRM2ERPReq.ITEM }
     * 
     */
    public DTHCM20301JCCRM2ERPReq.ITEM createDTHCM20301JCCRM2ERPReqITEM() {
        return new DTHCM20301JCCRM2ERPReq.ITEM();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DTHCM20301JCCRM2ERPRes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gcl-power.com/ERP/HCM", name = "MT_HCM20301_JCCRM2ERP_Res")
    public JAXBElement<DTHCM20301JCCRM2ERPRes> createMTHCM20301JCCRM2ERPRes(DTHCM20301JCCRM2ERPRes value) {
        return new JAXBElement<DTHCM20301JCCRM2ERPRes>(_MTHCM20301JCCRM2ERPRes_QNAME, DTHCM20301JCCRM2ERPRes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DTHCM20301JCCRM2ERPReq }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gcl-power.com/ERP/HCM", name = "MT_HCM20301_JCCRM2ERP_Req")
    public JAXBElement<DTHCM20301JCCRM2ERPReq> createMTHCM20301JCCRM2ERPReq(DTHCM20301JCCRM2ERPReq value) {
        return new JAXBElement<DTHCM20301JCCRM2ERPReq>(_MTHCM20301JCCRM2ERPReq_QNAME, DTHCM20301JCCRM2ERPReq.class, null, value);
    }

}
