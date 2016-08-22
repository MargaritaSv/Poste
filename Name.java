public abstract class Name {
	private String name;

	public Name(String name) {
		if (name == null || name.trim().length() == 0) {
			throw new IllegalArgumentException();
		}
		this.name = name;
	}
}
