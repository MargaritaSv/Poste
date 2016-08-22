import exceptions.ValidationExceptions;

import java.util.ArrayList;
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
	private static final int MAX_VALUE = 100;
	private static final int MIN_VALUE = 5;
	public static final String[] NAMES = new String[] { "Stefan", "Mitko","Nadq", "Pasha", "Ekaterina", "Kircho", "Pesho", "Stefka" };
	public static final String[] NEIGHBORHOOD = { "Mladost", "Center","Nadejda", "Vladaq", "Dryjba", "Lulin", "Ovcha kupel 2","Ovacha kupel 1" };

	public static void main(String[] string) {

		try {
			// create post state
			PostState sofia = new PostState("Sofia");
            System.out.println("            The poste in "+sofia +"\n");
            
			// create citizens
            System.out.println("\n --------------- Citizens ---------------\n");
			List<Citizens> listCitizens = new LinkedList();
			createCitizens(listCitizens);
            print(listCitizens);
            
			System.out.println("\n --------------- Postilions ---------------\n");
			List<JuniorPostilion> listPostilions = new LinkedList();
			createPostilions(listPostilions);
			print(listPostilions);

			// create packets
			List<IPackage> listPackages = new ArrayList<IPackage>();
			createPackages(listCitizens, listPackages);
			print(listPackages);

		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
	}

	private static void createCitizens(List listCitizens) throws ValidationExceptions {
		Citizens citizens;
		for (int i = 0; i < NUMBER_OF_CITIZENS; i++) {
			citizens = new Citizens(NAMES[(int) (Math.random() * NAMES.length)],NEIGHBORHOOD[(int) (Math.random() * NEIGHBORHOOD.length)]);
			listCitizens.add(citizens);
		}
	}

	private static void createPostilions(List<JuniorPostilion> listPostilions) throws ValidationExceptions {
		JuniorPostilion postilion;
		for (int i = 0; i < NUMBER_OF_POSTILIONS; i++) {
			if (Math.random() > 0.5) {
				postilion = new JuniorPostilion(NAMES[new Random().nextInt(NAMES.length-1)],new Random().nextInt((MAX_MONTH - MIN_MONTH) + 1)+ MIN_MONTH);
			} else {
				postilion = new Postilion(NAMES[new Random().nextInt(NAMES.length-1)],new Random().nextInt((MAX_YEARS - MIN_YEARS) + 1)+ MIN_YEARS);
			}

			listPostilions.add(postilion);
		}
	}

	private static void createPackages(List listCitizens, List<IPackage> listPackages)throws ValidationExceptions {
		IPackage postPackage;
		for (int i = 0; i < 80; i++) {
			if (Math.random() > 0.4) {
				postPackage = new Letter((Citizens) ((listCitizens.get(new Random().nextInt(listCitizens.size()+ 1) + 1))),
						(Citizens) (listCitizens.get(new Random().nextInt(listCitizens.size()+ 1) + 1)));
			} else {
				postPackage = new Colet((Citizens) (listCitizens.get((new Random().nextInt(listCitizens.size()+ 1) + 1))),
						(Citizens) (listCitizens.get(new Random().nextInt((listCitizens.size() -1 ) + 1) + 1)),
						new Random().nextInt((MAX_VALUE - MIN_VALUE) + 1) + MIN_VALUE,// width
						new Random().nextInt((MAX_VALUE - MIN_VALUE) + 1) + MIN_VALUE, // length
						new Random().nextInt((MAX_VALUE - MIN_VALUE) + 1) + MIN_VALUE,// high
						(i % 2 == 0) ? true : false); // fragile
			}
			listPackages.add(postPackage);
		}
	}

	private static void print(List people) {
		for (Iterator it = people.iterator(); it.hasNext();) {
			Object person = it.next();
			System.out.println(person);
		}
	}
}
