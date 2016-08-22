public class JuniorPostilion extends Name {

	private int staj;

	public JuniorPostilion(String name, int staj) {
		super(name);

		if (staj <= 0 || staj > 70) {
			throw new IllegalArgumentException("The staj is not correct");
		}
		this.staj = staj;
	}

	
	protected int getStaj() {
		return staj;
	}


	@Override
	public String toString() {
		return super.toString() + " -> probation:" + this.getStaj();
	}
}
