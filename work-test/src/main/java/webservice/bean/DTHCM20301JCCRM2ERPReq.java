
package webservice.bean;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 出差接口
 * 
 * <p>DT_HCM20301_JCCRM2ERP_Req complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="DT_HCM20301_JCCRM2ERP_Req">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ITEM" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="PERNR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="BEGDA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="BEGUZ" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ENDDA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ENDUZ" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="AWART" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESTIN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="REASON" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="CLAIM_STATUS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DT_HCM20301_JCCRM2ERP_Req", propOrder = {
    "item"
})
public class DTHCM20301JCCRM2ERPReq {

    @XmlElement(name = "ITEM", required = true)
    protected List<DTHCM20301JCCRM2ERPReq.ITEM> item;

    /**
     * Gets the value of the item property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the item property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getITEM().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DTHCM20301JCCRM2ERPReq.ITEM }
     * 
     * 
     */
    public List<DTHCM20301JCCRM2ERPReq.ITEM> getITEM() {
        if (item == null) {
            item = new ArrayList<DTHCM20301JCCRM2ERPReq.ITEM>();
        }
        return this.item;
    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="PERNR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="BEGDA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="BEGUZ" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ENDDA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ENDUZ" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="AWART" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESTIN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="REASON" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="CLAIM_STATUS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "pernr",
        "begda",
        "beguz",
        "endda",
        "enduz",
        "awart",
        "destin",
        "reason",
        "claimstatus"
    })
    public static class ITEM {

        @XmlElement(name = "PERNR")
        protected String pernr;
        @XmlElement(name = "BEGDA")
        protected String begda;
        @XmlElement(name = "BEGUZ")
        protected String beguz;
        @XmlElement(name = "ENDDA")
        protected String endda;
        @XmlElement(name = "ENDUZ")
        protected String enduz;
        @XmlElement(name = "AWART")
        protected String awart;
        @XmlElement(name = "DESTIN")
        protected String destin;
        @XmlElement(name = "REASON")
        protected String reason;
        @XmlElement(name = "CLAIM_STATUS")
        protected String claimstatus;

        /**
         * 获取pernr属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPERNR() {
            return pernr;
        }

        /**
         * 设置pernr属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPERNR(String value) {
            this.pernr = value;
        }

        /**
         * 获取begda属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBEGDA() {
            return begda;
        }

        /**
         * 设置begda属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBEGDA(String value) {
            this.begda = value;
        }

        /**
         * 获取beguz属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBEGUZ() {
            return beguz;
        }

        /**
         * 设置beguz属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBEGUZ(String value) {
            this.beguz = value;
        }

        /**
         * 获取endda属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getENDDA() {
            return endda;
        }

        /**
         * 设置endda属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setENDDA(String value) {
            this.endda = value;
        }

        /**
         * 获取enduz属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getENDUZ() {
            return enduz;
        }

        /**
         * 设置enduz属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setENDUZ(String value) {
            this.enduz = value;
        }

        /**
         * 获取awart属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAWART() {
            return awart;
        }

        /**
         * 设置awart属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAWART(String value) {
            this.awart = value;
        }

        /**
         * 获取destin属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESTIN() {
            return destin;
        }

        /**
         * 设置destin属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESTIN(String value) {
            this.destin = value;
        }

        /**
         * 获取reason属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getREASON() {
            return reason;
        }

        /**
         * 设置reason属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setREASON(String value) {
            this.reason = value;
        }

        /**
         * 获取claimstatus属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCLAIMSTATUS() {
            return claimstatus;
        }

        /**
         * 设置claimstatus属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCLAIMSTATUS(String value) {
            this.claimstatus = value;
        }

    }

}
