import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

import exceprions.ValidationExceptions;

public class Main {
	private static final int NUMBER_OF_CITIZENS = 200;
	private static final int NUMBER_OF_POSTILIONS = 50;
	private static final int MIN_YEARS = 1;
	private static final int MAX_YEARS = 69;
	private static final int MIN_MONTH = 1;
	private static final int MAX_MONTH = 12;
	private static final int MAX_VALUE = 100;
	private static final int MIN_VALUE = 5;
	public static final String[] names = new String[] { "Stefan", "Mitko","Nadq", "Pasha", "Ekaterina", "Kircho", "Pesho", "Stefka" };
	public static final String[] neightborhood = { "Mladost", "Center","Nadejda", "Vladaq", "Dryjba", "Lulin", "Ovcha kupel 2","Ovacha kupel 1" };

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
			List<JuniorPostilion> listPostelions = new LinkedList();
			createPostelions(listPostelions);
			print(listPostelions);

			// create packets
			List<IPackage> listPackages = new ArrayList<IPackage>();
			createPackeges(listCitizens, listPackages);
			print(listPackages);

		} catch (Exception ex) {
			System.err.println(ex.getMessage());
			return;
		}
	}

	private static void createCitizens(List listCitizens) throws ValidationExceptions{
		Citizens citizens;
		for (int i = 0; i < NUMBER_OF_CITIZENS; i++) {
			citizens = new Citizens(
					names[(int) (Math.random() * names.length)],
					neightborhood[(int) (Math.random() * neightborhood.length - 1)]);
			listCitizens.add(citizens);
		}
	}

	private static void createPostelions(List<JuniorPostilion> listPostelions) throws ValidationExceptions {
		JuniorPostilion postelion;
		for (int i = 0; i < NUMBER_OF_POSTILIONS; i++) {
			if (Math.random() > 0.5) {
				postelion = new JuniorPostilion(names[(int) Math.random()* names.length],new Random().nextInt((MAX_MONTH - MIN_MONTH) + 1)+ MIN_MONTH);
			} else {
				postelion = new Postilion(names[(int) Math.random()	* names.length],new Random().nextInt((MAX_YEARS - MIN_YEARS) + 1)+ MIN_YEARS);
			}

			listPostelions.add(postelion);
		}
	}

	private static void createPackeges(List listCitizens,List<IPackage> listPackages)throws ValidationExceptions {
		IPackage postPackage;
		for (int i = 0; i < 80; i++) {
			if (Math.random() > 0.4) {
				postPackage = new Letter((Citizens) (listCitizens.get((int) Math.random()* listCitizens.size())),
						(Citizens) (listCitizens.get((int) Math.random()* listCitizens.size())));
			} else {
				postPackage = new Collet((Citizens) (listCitizens.get((int) Math.random()* listCitizens.size())),
						(Citizens) (listCitizens.get((int) Math.random()* listCitizens.size())),
						new Random().nextInt((MAX_VALUE - MIN_VALUE) + 1) // width
								+ MIN_VALUE,
						new Random().nextInt((MAX_VALUE - MIN_VALUE) + 1) // length
								+ MIN_VALUE,
						new Random().nextInt((MAX_VALUE - MIN_VALUE) + 1) // high
								+ MIN_VALUE, (i % 2 == 0) ? true : false); // fragile
			}
			listPackages.add(postPackage);
		}
	}

	private static void print(List people) {
		for (Iterator it = people.iterator(); it.hasNext();) {
			Object persen = (Object) it.next();
			System.out.println(persen);
		}
	}
}
