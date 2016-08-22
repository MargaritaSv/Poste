public class Citizens extends Name {
	private String address;

	public Citizens(String name, String address) {
		super(name);
		if (checkString(address)) {
			throw new IllegalArgumentException();
		}
		this.address = address;
	}

	public String toString() {
			return super.toString() + this.address;
		}
}
