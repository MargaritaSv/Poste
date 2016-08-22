import exceprions.ValidationExceptions;

public class Letter implements IPackage {
	private static float price = 0.5f;

	private TwoPeople connection;

	public Letter(Citizens citizen1, Citizens citizens2)throws ValidationExceptions {
		this.connection = new TwoPeople(citizen1, citizens2);
	}

	
	protected TwoPeople getConnection() {
		return connection;
	}


	@Override
	public String toString() {
		return "Letter \n"+ super.toString() + "\n.Price:" + price + "$";
	}
}