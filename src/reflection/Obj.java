package reflection;

/**
 *
 * @author ljx
 * @Date Jan 22, 2019 11:20:22 AM
 *
 */
public class Obj {

	private String name;
	private int id;
	
	public String addr;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "Obj [name=" + name + ", id=" + id + ", addr=" + addr + "]";
	}

	public Obj(String name, int id, String addr) {
		super();
		this.name = name;
		this.id = id;
		this.addr = addr;
	}

	public Obj() {
	}
	
	
}
