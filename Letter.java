import exceptions.ValidationExceptions;

public class Letter implements IPackage {
	private static float price = 0.5f;

	private TwoPeople connection;

	private class TwoPeople {
		private Citizens citizen1;
		private Citizens citizens2;

		public TwoPeople(Citizens citizen1, Citizens citizens2)throws ValidationExceptions {
			if (citizen1 != null || citizens2 != null || citizen1 != citizens2) {
				this.citizen1 = citizen1;
				this.citizens2 = citizens2;
			} else {
				throw new ValidationExceptions("The citizens isn't correct!");
			}
		}

		@Override
		public String toString() {
			return "Sender is " + this.citizen1.getName() + " and recipient is " + this.citizens2.getName();
		}
	}

	public Letter(Citizens citizen1, Citizens citizens2)throws ValidationExceptions {
		this.connection = new TwoPeople(citizen1, citizens2);
	}

	
	protected TwoPeople getConnection() {
		return connection;
	}


	@Override
	public String toString() {
		return "Letter \n"+ this.getConnection() + ". Price:" + price + "$\n";
	}
}