package jaxb4b;

import java.io.StringReader;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <p>attribute属性值不会加,看这个例子</p>
 */ 
@XmlRootElement 
@XmlAccessorType(XmlAccessType.FIELD) 
public class Persion { 
     
    private DemoField userid; 
 
    private DemoField username; 
 
    private DemoField birthday; 
 
    public DemoField getUserid() { 
        return userid; 
    } 
 
    public void setUserid(DemoField userid) { 
        this.userid = userid; 
    } 
 
    public DemoField getUsername() { 
        return username; 
    } 
 
    public void setUsername(DemoField username) { 
        this.username = username; 
    } 
 
    public DemoField getBirthday() { 
        return birthday; 
    } 
 
    public void setBirthday(DemoField birthday) { 
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
 
            DemoField userid = new DemoField(); 
            userid.setName("userid"); 
            userid.setValue("112"); 
            persion.setUserid(userid); 
 
            DemoField username = new DemoField(); 
            username.setName("username"); 
            username.setValue("就不告诉你"); 
            persion.setUsername(username); 
 
            DemoField birthday = new DemoField(); 
            birthday.setName("birthday"); 
            birthday.setValue(new SimpleDateFormat("yyyy-MM-dd").format(new Date())); 
            persion.setBirthday(birthday); 
 
 
            Marshaller marshaller = jaxbContext.createMarshaller(); 
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); 
             
            //换个显示方式 
            marshaller.marshal(persion, System.out); 
 
            StringWriter writer = new StringWriter(); 
            marshaller.marshal(persion, writer); 
            String xml = writer.getBuffer().toString(); 
 
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller(); 
            Object bean = unmarshaller.unmarshal(new StringReader(xml)); 
            System.out.println(bean); 
 
        } catch (JAXBException e) { 
            e.printStackTrace(); 
        } 
    } 
 
} 
