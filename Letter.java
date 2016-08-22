public class Letter implements IPackage {
	private static float price = 0.5f;

	private TwoPeople connection;

	public Letter(Citizens citizen1, Citizens citizens2) {
		this.connection = new TwoPeople(citizen1, citizens2);
	}
}
