package jaxb1;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="b", namespace ="http://test")  // 必须要标明这个元素
@XmlAccessorType(XmlAccessType.PROPERTY)
class BoyProperty {

	//name 不是属性（因为没有 get set方法），所以name不转换成标签。
	String name = "CY";
	
	//给gender属性添加 get set 方法
	String gender = "man";
	
	@XmlElement  
    int age = 10;  

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
		
}

public class TestProperty {

	public static void main(String[] args) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(BoyProperty.class);

		Marshaller marshaller = context.createMarshaller();
		Unmarshaller unmarshaller = context.createUnmarshaller();

		BoyProperty boy = new BoyProperty();
		marshaller.marshal(boy, System.out);
		System.out.println();
		
		/**
		 * <boy/> CY 就是说 java object 转换成 xml 的时候，name 不是属性（因为没有 get
		 * set方法），所以name不转换成标签。
		 */
//		String xml = "<boyProperty><name>David</name></boyProperty>";
//		BoyProperty boy2 = (BoyProperty) unmarshaller.unmarshal(new StringReader(xml));
//		System.out.println(boy2.name);
	}
}
