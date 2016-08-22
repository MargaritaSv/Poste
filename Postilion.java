import exceprions.ValidationExceptions;

public class Postilion extends JuniorPostilion {

	public Postilion(String name, int staj) throws ValidationExceptions{
		super(name, staj);
	}

	@Override
	public String toString() {
		return super.getName() + " years in poststate:" + super.getStaj();
	}
}
