package edu.indiana.d2i.netkarma.xsp.adapter;

public class Annotation {
	
	private String property = null;
	private Object value = null;

	public void setProperty(String property){
		this.property = property;
	}
	
	public void setValue(Object value){
		this.value = value;
	}
	
	public String getProperty(){
		return property;
	}
	
	public Object getValue(){
		return value;
	}
}
