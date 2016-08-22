public abstract class Name {
	private String name;

	public Name(String name) {
		if (checkString(name)) {
			throw new IllegalArgumentException();
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
