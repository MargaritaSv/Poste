import exceprions.ValidationExceptions;

public class Collet extends Letter {

	private int width;
	private int lenght;
	private int hight;
	private boolean isFragile;

	public Collet(Citizens citizen1, Citizens citizens2, int width, int lenght,
			int hight, boolean isFragile) throws ValidationExceptions {
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
	}

	private static boolean checkValue(int value) {
		return value <= 0;
	}

	@Override
	public String toString() {
		return"Collet: \n"+ super.getConnection() + "The collet has dimentions: width:" + this.width + "; length:" + this.lenght + "; hight:" + this.hight+";";
	}
}
