package io.nio.my.bean;

import java.util.Date;

/**
 *
 * @author ljx
 * @Date Feb 21, 2019 12:27:34 AM
 *
 */
public class ResponseBean {

	private String protocol;
	private StatuCode statu;
	private String contentType;
	private String contentLen;
	private Date date;
	
	private String data;

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public StatuCode getStatu() {
		return statu;
	}

	public void setStatu(StatuCode statu) {
		this.statu = statu;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getContentLen() {
		return contentLen;
	}

	public void setContentLen(String contentLen) {
		this.contentLen = contentLen;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(protocol).append(" ").append(statu.getName()).append("\n");
		sb.append("Content-Type: ").append(contentType).append("\n");
		sb.append("Content-Length: ").append(contentLen).append("\n");
		sb.append("Date: ").append(date).append("\n");
		sb.append("\n");
		sb.append(data).append("\n");
		return sb.toString();
	}
}
