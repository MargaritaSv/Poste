import exceptions.ValidationExceptions;

public class Citizens extends Name {
	private String address;

	public Citizens(String name, String address) throws ValidationExceptions {
		super(name);
		if (checkString(address)) {
			throw new ValidationExceptions("Don't lie!The address is not valid!");
		}
		this.address = address;
	}

	public String toString() {
			return super.toString() + this.address;
		}
}
