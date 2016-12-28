package jaxb2;

import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;



@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Customer {
 
    @XmlAttribute
    private String name;
 
    public String getName() {
		return name;
	}

	private String gender;
 
    private String phoneNo;
 
    private Address address;
 
    private Set<Order> orders;
 

 
    public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Customer(String name, String gender, String phoneNo, Address address1) {
        this.name = name;
        this.gender = gender;
        this.phoneNo = phoneNo;
        this.address = address1;
    }
}