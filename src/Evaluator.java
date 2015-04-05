
import java.util.Hashtable;
/**
 * Class counts frequency of words
 * @author Lilly_94
 *
 */
public class Evaluator extends Thread {
	private int id;
	private Hashtable<String, Integer> t;
	private int minimum;
	private int maximum;
	private String[] file;
	@Override
	public void run(){
		Integer count;
		for (int i = minimum; i < maximum; i++) {
			String[] array = file[i].split("[\\s!?,.:;'\"]");
			for (int j = 0; j < array.length; j++) {
				if(array[j].length() != 0){
					array[j] = array[j].toLowerCase();
					count = t.get(array[j]);
					if(count == null){
						t.put(array[j], new Integer(1));
					}else{
						t.put(array[j], new Integer(count.intValue()+1));
					}
				}
			}
		}
	}
	public Evaluator(Hashtable<String, Integer> t, int id, String[] file){
		this.t = t;
		this.id = id;
		this.file = file;
		if(id == Program.P){
			maximum = Program.N;
		}else{
			maximum = id*Program.H;
		}
		minimum = (id-1)*Program.H;
	}
	
	
	
}
