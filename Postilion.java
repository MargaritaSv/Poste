public class Postilion extends JuniorPostilion {

	public Postilion(String name, int staj) {
		super(name, staj);
	}

	@Override
	public String toString() {
		return super.getName() + " years in poststate:" + super.getStaj();
	}
}
