package jaxb4a;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * public abstract class XmlAdapter<ValueType, BoundType>
 * @author pps
 *
 */
public class DateXmlAdapter extends XmlAdapter<String, Date> { 
    
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
 
    /**
     * 将xml中的值转换为bean中的对象
     */ 
    @Override 
    public Date unmarshal(String paramValueType) throws Exception { 
        return format.parse(paramValueType); 
    } 
 
    /**
     * 将bean中的对象转换为xml字符串
     */ 
    @Override 
    public String marshal(Date paramBoundType) throws Exception { 
        return format.format(paramBoundType); 
    } 
 
} 
