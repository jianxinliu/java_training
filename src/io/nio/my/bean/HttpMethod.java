package io.nio.my.bean;

/**
 *
 * @author ljx
 * @Date Feb 21, 2019 12:15:24 AM
 *
 */
public enum HttpMethod {

	GET("GET",0)
	,POST("POST",1)
	,DELETE("DELETE",2)
	,PUT("PUT",3);
	
	private String name;
	private int index;
	
	private HttpMethod(String name,int index) {
		this.name = name;
		this.index = index;
	}

	public String getName() {
		return name;
	}
	
	public int getIndex() {
		return index;
	}
	
}
