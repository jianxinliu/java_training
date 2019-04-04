package pattern.pattern.pattern;

import java.io.Serializable;

/**
 *
 * @author ljx
 * @Date Jan 22, 2019 10:50:50 AM
 *
 */
public class BaseResp<T> implements Serializable {

	private String code;
	private String msg;
	private T data;
	
	
	/**
	 * @param code
	 * @param msg
	 * @param data
	 */
	public BaseResp(String code, String msg, T data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BaseResp [code=");
		builder.append(code);
		builder.append(", msg=");
		builder.append(msg);
		builder.append(", data=");
		builder.append(data);
		builder.append("]");
		return builder.toString();
	}
}
