import exceprions.ValidationExceptions;

public class Collet extends Letter implements ICollet {

	private int width;
	private int lenght;
	private int hight;
	private boolean isFragile;
	private float price = 2.0f;

	public Collet(Citizens citizen1, Citizens citizens2, int width, int lenght,int hight, boolean isFragile) throws ValidationExceptions {
		super(citizen1, citizens2);

		if (checkValue(width)) {
			throw new ValidationExceptions("Width is not valis ->" + width);
		}
		this.width = width;

		if (checkValue(lenght)) {
			throw new ValidationExceptions("Length is not valis ->" + lenght);
		}
		this.lenght = lenght;

		if (checkValue(hight)) {
			throw new ValidationExceptions("Hight is not valis ->" + hight);
		}
		this.hight = hight;

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
		if (this.width >= 60 || this.lenght >= 60 || this.hight >= 60) {
			return this.price * 2;
		}
		return this.price;
	}

	public float checkFragile() {
		return (this.isFragile = true) ? this.price * 2 : this.price;
	}

	@Override
	public String toString() {
		return "Collet: \n" + super.getConnection()
				+ ". The collet has dimentions: width:" + this.width
				+ "; length:" + this.lenght + "; hight:" + this.hight + ";"
				+ "\nFragile:" + ((isFragile == true) ? "Yes" : "No")
				+ "\nBecause of that the price is:" + this.price + "$" + "\n";
	}
}