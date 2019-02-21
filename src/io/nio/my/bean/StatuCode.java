package io.nio.my.bean;

/**
 *
 * @author ljx
 * @Date Feb 21, 2019 12:28:54 AM
 *
 */
public enum StatuCode {
	
	NOT_FOUND("404",404)
	,SERVER_FAIL("500",500)
	,SUCCESS("200",200);

	private String name;
	private int index;
	
	private StatuCode(String name,int index) {
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
