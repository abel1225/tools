
package webservice.bean;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "SI_HCM20301_JCCRM2ERP_Syn_Out", targetNamespace = "http://www.gcl-power.com/ERP/HCM")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface SIHCM20301JCCRM2ERPSynOut {


    /**
     * 
     * @param mtHCM20301JCCRM2ERPReq
     * @return
     *     returns webservice.bean.DTHCM20301JCCRM2ERPRes
     */
    @WebMethod(operationName = "SI_HCM20301_JCCRM2ERP_Syn_Out", action = "http://sap.com/xi/WebService/soap1.1")
    @WebResult(name = "MT_HCM20301_JCCRM2ERP_Res", targetNamespace = "http://www.gcl-power.com/ERP/HCM", partName = "MT_HCM20301_JCCRM2ERP_Res")
    public DTHCM20301JCCRM2ERPRes siHCM20301JCCRM2ERPSynOut(
        @WebParam(name = "MT_HCM20301_JCCRM2ERP_Req", targetNamespace = "http://www.gcl-power.com/ERP/HCM", partName = "MT_HCM20301_JCCRM2ERP_Req")
        DTHCM20301JCCRM2ERPReq mtHCM20301JCCRM2ERPReq);

}