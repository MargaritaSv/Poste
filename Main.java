import java.util.List;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class Main {
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
		for (int i = 0; i < 200; i++) {
			citizens = new Citizens(
					names[(int) (Math.random() * names.length)],
					neightborhood[(int) (Math.random() * neightborhood.length - 1)]);
			listCitizens.add(citizens);
		}

		printPeople(listCitizens);

		// create postilions
		List<JuniorPostilion> listPostelions = new LinkedList();
		JuniorPostilion postelion;
		for (int i = 0; i < 50; i++) {
			if (Math.random() > 0.5) {// .nextInt((max - min) + 1) + min
				postelion = new JuniorPostilion(names[(int) Math.random()
						* names.length], new Random().nextInt((12 - 1) + 1) + 1);
			} else {
				postelion = new Postilion(names[(int) Math.random()
						* names.length], new Random().nextInt((69 - 1) + 1) + 1);
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
