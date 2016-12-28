package jaxb1;  
  
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;  

/**
 * http://desert3.iteye.com/blog/1570092
 * @author pps
 *
 */
  
@XmlRootElement // 必须要标明这个元素  
@XmlAccessorType(XmlAccessType.FIELD)  
class BoyField {     
    String name = "CY";  
}  
  
public class TestField {  
  
    public static void main(String[] args) throws JAXBException {  
        JAXBContext context = JAXBContext.newInstance(BoyField.class);  
         
        Marshaller marshaller = context.createMarshaller();  
        Unmarshaller unmarshaller = context.createUnmarshaller();  
         
        BoyField boy = new BoyField();  
        marshaller.marshal(boy, System.out);  
        System.out.println();  
         
        String xml = "<boyField><name>David</name></boyField>";  
        BoyField boy2 = (BoyField) unmarshaller.unmarshal(new StringReader(xml));  
        System.out.println(boy2.name);  
    }  
}  

