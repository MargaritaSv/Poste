import exceprions.ValidationExceptions;

public abstract class Name {
	private String name;

	public Name(String name) throws ValidationExceptions {
		if (checkString(name)) {
			throw new ValidationExceptions("The name " + name + "is not correct.");
		}
		this.name = name;
	}

	public static boolean checkString(String word) {
		return word == null || word.trim().length() == 0;
	}

	protected String getName() {
		return name;
	}

	public String toString() {
		return this.name + " ";
	}
}
