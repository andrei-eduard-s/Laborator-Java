package tema4;
import java.util.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

public class TestClass {	
	public static void main(String[] args) {
		DataManager dataManager = new DataManager();
		
		dataManager.gradeStudents();
		dataManager.manager.reportAllCourses();
		dataManager.manager.reportAllStudentsGrades();
		dataManager.manager.reportAllCourses();
		try {
			dataManager.manager.RemoveCurs(new Curs("PLCP 1"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Dupa stergere:");
		dataManager.manager.reportAllCourses();
		
		dataManager.manager.reportAllStudentsGrades();
		
		try {
			dataManager.manager.EditCurs(new Curs("Limba engleza"), new Curs("Limba engleza II", "descriere", new Profesor("Ana", "Maria"), dataManager.createRandomSetOfStudents()));
			dataManager.manager.reportAllCourses();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		HashMap<Integer, ArrayList<Student>> grupareStudentiDupaGrupa = new HashMap<Integer, ArrayList<Student>>();
		for (Curs c : dataManager.manager.cursuri) {
			for (Student s : c.studenti) {
				ArrayList<Student> stud = grupareStudentiDupaGrupa.get(s.grupa);
				if (stud != null) {
					stud.add(s);
					grupareStudentiDupaGrupa.replace(s.grupa, stud);
				} else {
					stud = new ArrayList<Student>();
					stud.add(s);
					grupareStudentiDupaGrupa.put(s.grupa, stud);
			
				}
			}
		}
		System.out.println("---------------------Gruparea studentilor dupa grupa---------------------");
		for (Integer g : grupareStudentiDupaGrupa.keySet()) {
			System.out.println("Studentii din grupa "+g);
			System.out.println(grupareStudentiDupaGrupa.get(g));
		}
		
		ArrayList<Student> arrayList = new ArrayList<>(dataManager.manager.cursuri.get(0).studenti);
		System.out.print("\n");
		
		System.out.println("---------------------Inainte de sortarea alfabetica---------------------");
		System.out.println(arrayList);
		System.out.print("\n");
		
		Collections.sort(arrayList);
		System.out.println("---------------------Dupa sortarea alfabetica---------------------");
		//sortarea in ordine alfabetica a studentilor
		Collections.sort(dataManager.manager.cursuri, new SortareDupaNume());
		System.out.println(arrayList);
		System.out.print("\n");
		
		//Sortarea cursurilor dupa nume, numele profesorului, numarul de studenti inscrisi
		System.out.println("---------------------Sortarea cursurilor---------------------");
		System.out.println(" @ Dupa nume:");
		for(Curs c : dataManager.manager.cursuri)
		{
			System.out.println(c.nume);
		}
		System.out.print("\n");
		
		System.out.println(" @ Dupa numele profesorului:");
		Collections.sort(dataManager.manager.cursuri, new SortareDupaNumeProfesor());
		for(Curs c : dataManager.manager.cursuri)
		{
			System.out.println(c.nume);
		}
		System.out.print("\n");
		
		System.out.println(" @ Dupa numarul de studenti inscrisi:");
		Collections.sort(dataManager.manager.cursuri, new SortareDupaNrStudenti());
		for(Curs c : dataManager.manager.cursuri)
		{
			System.out.println(c.nume);
		}	
	}	
}
	//Solomon Andrei-Eduard - 4LF701

	//Metoda ineficienta:
		/*Set<Student>studenti=new HashSet<Student>();
		//definire studenti:
		studenti.add(new Student("Solomon","Andrei",101));
		studenti.add(new Student("Popescu","Alin",102));
		studenti.add(new Student("Ionescu","Aurel",101));
		studenti.add(new Student("Iorga","Vlad",103));
		studenti.add(new Student("Benone","Sinulescu",101));
		studenti.add(new Student("Zuckerberg","Mark",103));
		studenti.add(new Student("Gardescu","Dragos",104));
		studenti.add(new Student("Marshall ","Mathers",101));
		//definire profesori:
		Profesor profjava = new Profesor("Danciu", "Gabriel");
		Profesor profalgad = new Profesor("Negoita", "Tudor");
		Profesor profrezis = new Profesor("Bobonete", "Mihai");
		//definire cursuri:
		Curs cursjava = new Curs("Programare Java", "PJ", profjava,studenti);
		Curs cursalgad = new Curs("ALGAD", "Algebra Liniara si Geometrie Descriptiva", profalgad,studenti);
		Curs cursrezis = new Curs("Rezistenta Materialelor", "Calculul reacþiunilor, diagramele de eforturi", profrezis,studenti);
		//adaugarea cursurilor:
		ManagerCursuri cursuri = new ManagerCursuri();
		cursuri.AddCurs(cursjava);
		cursuri.AddCurs(cursalgad);
		cursuri.AddCurs(cursrezis);
		//afisarea tuturor cursurilor:
		System.out.println("---------------------Afisarea cursurilor---------------------");
		cursuri.reportAllCourses();
		
		System.out.println("---------------------Gruparea studentilor dupa grupa---------------------");
		List<Student> lista_studenti = new ArrayList<Student>(studenti);
		HashMap<Integer, ArrayList<Student>> grupare_studenti = new HashMap<Integer, ArrayList<Student>>();
		
		for(int i=0; i<studenti.size();i++)
		{
			ArrayList<Student> studentigrupati = new ArrayList<Student>();
			studentigrupati.add(lista_studenti.get(i));
			int grupa = lista_studenti.get(i).grupa;
			int j=0;
			for(j=i+1; j<lista_studenti.size();j++)
			{
				if(lista_studenti.get(i).compareTo(lista_studenti.get(j)) == 0)
				{
					studentigrupati.add(lista_studenti.get(j));
				}
				else
				{
					i=j-1;
					grupare_studenti.put(grupa, studentigrupati);
					break;
				}	
			}
			if(j>=studenti.size() && studentigrupati.size() != 0)
			{
				grupare_studenti.put(grupa, studentigrupati);
			}
		}
		for(Integer grupa : grupare_studenti.keySet())
		{
			ArrayList<Student> sGrupati = grupare_studenti.get(grupa);
			for(Student s : sGrupati)
			{
				System.out.println(s);
			}
		}*/