import java.util.List;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class Main {
	private static final int NUMBER_OF_CITIZENS = 200;
	private static final int NUMBER_OF_POSTILIONS = 50;
	private static final int MIN_YEARS = 1;
	private static final int MAX_YEARS = 69;
	private static final int MIN_MONTH = 1;
	private static final int MAX_MONTH = 12;

	public static void main(String[] string) {
		final String[] names = new String[] { "Stefan", "Mitko", "Nadq",
				"Pasha", "Ekaterina", "Kircho", "Pesho", "Stefka" };
		final String[] neightborhood = { "Mladost", "Center", "Nadejda",
				"Vladaq", "Dryjba", "Lulin", "Ovcha kupel 2", "Ovacha kupel 1" };

		// create post state
		PostState sofia = new PostState("Sofia");

		// create citizens
		List listCitizens = new LinkedList();
		Citizens citizens;
		for (int i = 0; i < NUMBER_OF_CITIZENS; i++) {
			citizens = new Citizens(
					names[(int) (Math.random() * names.length)],
					neightborhood[(int) (Math.random() * neightborhood.length - 1)]);
			listCitizens.add(citizens);
		}

		printPeople(listCitizens);

		// create postilions
		List<JuniorPostilion> listPostelions = new LinkedList();
		JuniorPostilion postelion;
		for (int i = 0; i < NUMBER_OF_POSTILIONS; i++) {
			if (Math.random() > 0.5) {
				postelion = new JuniorPostilion(names[(int) Math.random()
						* names.length], new Random().nextInt((MAX_MONTH - MIN_MONTH) + 1) + MIN_MONTH);
			} else {
				postelion = new Postilion(names[(int) Math.random()
						* names.length], new Random().nextInt((MAX_YEARS - MIN_YEARS) + 1) + MIN_YEARS);
			}
			
			listPostelions.add(postelion);
		}
		
		printPeople(listPostelions);

	}

	private static void printPeople(List people) {
		for (Iterator it = people.iterator(); it.hasNext();) {
			Object persen = (Object) it.next();
			System.out.println(persen);
		}
	}
}
