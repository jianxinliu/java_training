package io.nio.my.bean;

/**
 *
 * @author ljx
 * @Date Feb 21, 2019 12:08:49 AM
 *
 */
public class RequestBean {

	private HttpMethod method;
	private String host;
	private String url;
	private String protocol;
	private String connection;
	private String userAgent;
	private String accept;
	private String acceptEncoding;
	private String acceptLanguage;
	private String data;
	public HttpMethod getMethod() {
		return method;
	}
	public void setMethod(HttpMethod method) {
		this.method = method;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getConnection() {
		return connection;
	}
	public void setConnection(String connection) {
		this.connection = connection;
	}
	public String getUserAgent() {
		return userAgent;
	}
	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}
	public String getAccept() {
		return accept;
	}
	public void setAccept(String accept) {
		this.accept = accept;
	}
	public String getAcceptEncoding() {
		return acceptEncoding;
	}
	public void setAcceptEncoding(String acceptEncoding) {
		this.acceptEncoding = acceptEncoding;
	}
	public String getAcceptLanguage() {
		return acceptLanguage;
	}
	public void setAcceptLanguage(String acceptLanguage) {
		this.acceptLanguage = acceptLanguage;
	}
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
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
		sb.append(method).append(" ").append(url).append(" ").append(protocol).append("\n");
		sb.append("Host: ").append(host).append("\n");
		sb.append("Connection: ").append(connection).append("\n");
		sb.append("User-Agent: ").append(userAgent).append("\n");
		sb.append("Accept: ").append(accept).append("\n");
		sb.append("Accept-Encoding: ").append(acceptEncoding).append("\n");
		sb.append("Accept-Language: ").append(acceptLanguage).append("\n");
		sb.append("\n");
		sb.append(data).append("\n");
		return sb.toString();
	}
	
	public RequestBean parse(String data) {
		RequestBean ret = new RequestBean();
		String[] items = data.split("\n");
		for(int i = 0;i<items.length;i++) {
			System.out.println(items[i]);
		}
		return ret;
	}
}
