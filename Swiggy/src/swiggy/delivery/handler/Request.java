package swiggy.delivery.handler;

public abstract class Request {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
