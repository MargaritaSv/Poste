import exceptions.ValidationExceptions;

public class Colet extends Letter implements IColet {

	private int width;
	private int length;
	private int high;
	private boolean isFragile;
	private float price = 2.0f;

	public Colet(Citizens citizen1, Citizens citizens2, int width, int length, int high, boolean isFragile) throws ValidationExceptions {
		super(citizen1, citizens2);

		if (checkValue(width)) {
			throw new ValidationExceptions("Width is not valid ->" + width);
		}
		this.width = width;

		if (checkValue(length)) {
			throw new ValidationExceptions("Length is not valid ->" + length);
		}
		this.length = length;

		if (checkValue(high)) {
			throw new ValidationExceptions("Height is not valid ->" + high);
		}
		this.high = high;

		this.isFragile = isFragile;

		this.price = check();
	}

	private static boolean checkValue(int value) {
		return value <= 0;
	}

	private float check() {
		this.price = checkFragile();
		this.price = checkSize();
		return this.price;
	}

	public float checkSize() {
		if (this.width >= 60 || this.length >= 60 || this.high >= 60) {
			return this.price * 2;
		}
		return this.price;
	}

	public float checkFragile() {
		return (this.isFragile = true) ? this.price * 2 : this.price;
	}

	@Override
	public String toString() {
		return "Colet: \n" + super.getConnection()
				+ ". The colet has dimensions: width:" + this.width
				+ "; length:" + this.length + "; high:" + this.high + ";"
				+ "\nFragile:" + ((isFragile == true) ? "Yes" : "No")
				+ "\nBecause of that the price is:" + this.price + "$" + "\n";
	}
}