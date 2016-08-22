


public class TwoPeople {
	private Citizens citizen1;
	private Citizens citizens2;

	public TwoPeople(Citizens citizen1, Citizens citizens2) {
		if (citizen1 != null && citizens2 != null && citizen1 != citizens2) {
			this.citizen1 = citizen1;
			this.citizens2 = citizens2;
		} else {
			throw new IllegalArgumentException("The citizens isn't correct!");
		}
	}

}
