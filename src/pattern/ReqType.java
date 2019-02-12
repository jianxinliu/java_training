package pattern;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ljx
 * @Date Jan 22, 2019 7:10:42 PM
 *
 */
public enum ReqType {

	ADD(1,"加"),
	MINUS(2,"减"),
	MUTIL(3,"乘"),
	DIVIDE(4,"除"),
	POW(5,"乘方"),
	SQRT(6,"开方");
	
	public static List<ReqType> list(){
		return (List<ReqType>) Arrays.asList(ReqType.values());
	}
	private ReqType(int reqType,String name) {
		this.type = reqType;
		this.name = name;
	}
	private int type;
	private String name;
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
