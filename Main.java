import java.awt.List;
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
		LinkedList listCitizens = new LinkedList();
		Citizens citizens;
		for (int i = 0; i < 200; i++) {
			citizens = new Citizens(
					names[(int) (Math.random() * names.length)],
					neightborhood[(int) (Math.random() * neightborhood.length - 1)]);
			listCitizens.add(citizens);
		}

		for (Iterator it = listCitizens.iterator(); it.hasNext();) {
			Citizens citizen = (Citizens) it.next();
			System.out.println(citizen);

		}
	}
}
