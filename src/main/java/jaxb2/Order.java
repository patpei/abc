package jaxb2;

import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlType(name="order",propOrder={"shopName","orderNumber","price","amount","purDate","customer"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Order {
 
//  @XmlElement　　
    private String shopName;
 
    @XmlAttribute
    private String orderNumber;
 
//  @XmlElement
    @XmlJavaTypeAdapter(value=DateAdapter.class)
    private Date purDate;
 
//  @XmlElement
    private BigDecimal price;
 
//  @XmlElement
    private int amount;
 
//  @XmlElement
    private Customer customer;
 
    public Order() {
    }
 
    
    public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public String getOrderNumber() {
		return orderNumber;
	}


	public Customer getCustomer() {
		return customer;
	}


	public Order(String shopName, String orderNumber, Date purDate,
            BigDecimal price, int amount) {
        this.shopName = shopName;
        this.orderNumber = orderNumber;
        this.purDate = purDate;
        this.price = price;
        this.amount = amount;
    }
}