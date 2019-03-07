/**
 * 
 */
package me.abel.utils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;

/**
*@description: 
*@author: able.li
*@create: 2018/8/3 18:02
*/
public class JaxbUtil {

    @SuppressWarnings("unchecked")
	public static <T> T toBean(String xml, Class<T> clazz) throws JAXBException {  
    	JAXBContext context = JAXBContext.newInstance(clazz);  
    	Unmarshaller unmarshaller = context.createUnmarshaller();  
    	return (T) unmarshaller.unmarshal(new StringReader(xml));
    }
	
	public static String toXML(Object xmlBean) throws Exception{
		return toXML(xmlBean, "UTF-8");
	}

	/**
	 *
	 * @param xmlBean
	 * @param encode
	 * @return
	 * @throws JAXBException
	 * @throws IOException
	 */
	private static String toXML(Object xmlBean, String encode) throws JAXBException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try {
            JAXBContext jc = JAXBContext.newInstance(xmlBean.getClass());
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_ENCODING, encode);
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);
            marshaller.marshal(xmlBean, output);
            return output.toString();

        } finally {
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
	}
}
