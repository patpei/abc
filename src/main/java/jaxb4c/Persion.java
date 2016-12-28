package jaxb4c;

import java.io.StringReader;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import jaxb4b.DemoField;

@XmlRootElement 
@XmlAccessorType(XmlAccessType.FIELD) 
public class Persion { 
 
    @XmlElement(name = "filed") 
    private List<DemoField> infos; 
 
    public List<DemoField> getInfos() { 
        return infos; 
    } 
 
    public void setInfos(List<DemoField> infos) { 
        this.infos = infos; 
    } 
 
    @Override 
    public String toString() { 
        StringBuilder builder = new StringBuilder(); 
        builder.append("Persion [infos="); 
        builder.append(infos); 
        builder.append("]"); 
        return builder.toString(); 
    } 
 
    public static void main(String[] args) { 
        try { 
            JAXBContext jaxbContext = JAXBContext.newInstance(Persion.class); 
            Persion persion = new Persion(); 
 
            List<DemoField> infos = new ArrayList<DemoField>(); 
 
            DemoField userid = new DemoField(); 
            userid.setName("userid"); 
            userid.setValue("112"); 
            infos.add(userid); 
 
            DemoField username = new DemoField(); 
            username.setName("username"); 
            username.setValue("就不告诉你"); 
            infos.add(username); 
 
            DemoField birthday = new DemoField(); 
            birthday.setName("birthday"); 
            birthday.setValue(new SimpleDateFormat("yyyy-MM-dd").format(new Date())); 
            infos.add(birthday); 
 
            persion.setInfos(infos); 
 
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
