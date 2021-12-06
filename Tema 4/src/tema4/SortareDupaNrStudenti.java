package tema4;
import java.util.Comparator;

public class SortareDupaNrStudenti implements Comparator<Curs>{
	@Override
	public int compare(Curs c1, Curs c2)
	{
		if(c1.studenti.size() < c2.studenti.size())
			return c2.studenti.size();
		else
			return c1.studenti.size();
	}
}
