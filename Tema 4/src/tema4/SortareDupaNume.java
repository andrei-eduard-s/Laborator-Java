package tema4;
import java.util.Comparator;

public class SortareDupaNume implements Comparator<Curs>{
	@Override
	public int compare(Curs c1, Curs c2)
	{
		return c1.nume.compareTo(c2.nume);
	}
}
