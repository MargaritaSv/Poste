public class JuniorPostelion extends Name {

	private float staj;

	public JuniorPostelion(String name, float staj) {
		super(name);

		if (staj <= 0 || staj > 70) {
			throw new IllegalArgumentException("The staj is not correct");
		}
		this.staj=staj;
	}
}
