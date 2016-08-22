import exceptions.ValidationExceptions;

public class Postilion extends JuniorPostilion {

	public Postilion(String name, int internship) throws ValidationExceptions{
		super(name, internship);
	}

	@Override
	public String toString() {
		return super.getName() + " years in post state:" + super.getStaj();
	}
}
