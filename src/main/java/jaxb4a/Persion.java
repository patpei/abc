package jaxb4a;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement 
@XmlAccessorType(XmlAccessType.FIELD) 
public class Persion { 
 
	@XmlElement(name="USER_ID") 
    private Integer userid; 
    
    private String username; 
    
    @XmlJavaTypeAdapter(value = DateXmlAdapter.class) 
    private Date birthday; 
 
    public Integer getUserid() { 
        return userid; 
    } 
 
    public void setUserid(Integer userid) { 
        this.userid = userid; 
    } 
 
    public String getUsername() { 
        return username; 
    } 
 
    public void setUsername(String username) { 
        this.username = username; 
    } 
 
    public Date getBirthday() { 
        return birthday; 
    } 
 
    public void setBirthday(Date birthday) { 
        this.birthday = birthday; 
    } 
 
    @Override 
    public String toString() { 
        StringBuilder builder = new StringBuilder(); 
        builder.append("Persion [userid="); 
        builder.append(userid); 
        builder.append(", username="); 
        builder.append(username); 
        builder.append(", birthday="); 
        builder.append(birthday); 
        builder.append("]"); 
        return builder.toString(); 
    } 
 
    public static void main(String[] args) { 
        try { 
            JAXBContext jaxbContext = JAXBContext.newInstance(Persion.class); 
            Persion persion = new Persion(); 
 
            persion.setUserid(112); 
            persion.setUsername("就不告诉你"); 
            persion.setBirthday(new Date()); 
 
            Marshaller marshaller = jaxbContext.createMarshaller(); 
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); 
 
            StringWriter writer = new StringWriter(); 
            marshaller.marshal(persion, writer); 
            String xml = writer.getBuffer().toString(); 
            System.out.println(xml); 
 
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller(); 
            Object bean = unmarshaller.unmarshal(new StringReader(xml)); 
            System.out.println(bean); 
 
        } catch (JAXBException e) { 
            e.printStackTrace(); 
        } 
    } 
 
} 