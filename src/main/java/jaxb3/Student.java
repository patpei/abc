package jaxb3;

import java.io.File;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @XmlAccessorType用于指定由java对象生成xml文件时对java对象属性的访问方式。常与@XmlRootElement、
 * @XmlType一起使用。它的属性值是XmlAccessType的4个枚举值，分 别为：
 * 
 * XmlAccessType.FIELD:java对象中的所有成员变量
 * 
 * XmlAccessType.PROPERTY：java对象中所有通过getter/setter方式访问的成员变量
 * 
 * XmlAccessType.PUBLIC_MEMBER：java对象中所有的public访问权限的成员变量和通过getter/
 * setter方式访问的成员变量
 * 
 * XmlAccessType.NONE:java对象的所有属性都不映射为xml的元素
 * 
 * 注意：@XmlAccessorType的默认访问级别是XmlAccessType.PUBLIC_MEMBER，因此，
 * 如果java对象中的private成员变量设置了public权限的getter/setter方法，就不要在
 * private变量上使用@XmlElement和@XmlAttribute注解，否则在由java对象生成xml时会报同一个属性在java类里存在两次的错误
 * 。同理，如果@XmlAccessorType的访问权限
 * 为XmlAccessType.NONE，如果在java的成员变量上使用了@XmlElement或@XmlAttribute注解，
 * 这些成员变量依然可以映射到xml文件。
 * 
 * @author pps
 *
 */
@XmlRootElement(name = "student")
@XmlAccessorType(XmlAccessType.FIELD)
public class Student implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8317239764136972094L;

	@XmlElement(name = "minzi")
	private String name;

	private String country;

	private String birthDate;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the birthDate
	 */
	public String getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate
	 *            the birthDate to set
	 */
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public void obj2Xml(String fileName) {
		File xmlFile = new File(fileName);
		JAXBContext ctx;
		try {
			// important
			ctx = JAXBContext.newInstance(Student.class);

			Marshaller marshaller = ctx.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);// 格式化输出
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");// 设置输出编码,默认为UTF-8

			marshaller.marshal(this, xmlFile);
			System.out.println("Obj2Xml Over!");

		} catch (JAXBException e) {
			System.out.println("error");

			System.out.println(e.toString());
			System.out.println(e.getStackTrace());
			// TODO: handle exception
		}
	}

	public void xmlToObj(String fileName) {

		try {

			File file = new File(fileName);
			JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);

			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			Student stu = (Student) unmarshaller.unmarshal(file);
			System.out.println(stu);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "Student [" + (name != null ? "name=" + name + ", " : "")
				+ (country != null ? "country=" + country + ", " : "")
				+ (birthDate != null ? "birthDate=" + birthDate : "") + "]";
	}

	public static void main(String[] args) {
		Student stu = new Student();
		stu.setName("Zhangsan");
		stu.setCountry("CN");

		// 指定时间格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		stu.setBirthDate(sdf.format(new Date()));

		stu.obj2Xml("C:\\ztmp\\testJaxb.xml");
		stu.xmlToObj("C:/ztmp/testJaxb.xml");
	}
}
