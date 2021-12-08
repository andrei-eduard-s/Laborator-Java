package tema4;
import java.util.Comparator;

public class SortareDupaNumeProfesor implements Comparator<Curs>{
	@Override
	public int compare(Curs c1, Curs c2)
	{
		return c1.profu.nume.compareTo(c2.profu.nume);
	}
}
