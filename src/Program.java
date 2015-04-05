

import java.io.File;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Scanner;
/**
 * 
 * @author Lilly_94
 *
 */
public class Program {
	static int N;
	private String path;
	private Hashtable<String, Integer> table = new Hashtable<String, Integer>();
	public Hashtable<String, Integer>[] vector;
	public LinkedList<String> file = new LinkedList<String>();
	public static int P;
	public static int H;
	private void readFromFile(){
		try {
			Scanner scan = new Scanner(new File(path));
			while(scan.hasNext()){
				file.add(scan.nextLine());
			}
		} catch (Exception e) {
		}
	}
	public void amount(){
		Evaluator[] threads = new Evaluator[P];
		readFromFile();
		N = file.size();
		H = N/P;
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Evaluator(vector[i], i+1, file.toArray(new String[file.size()]));
			threads[i].start();
		}
		for (int i = 0; i < threads.length; i++) {
			try {
				threads[i].join();
			} catch (Exception e) {

			}
		}
		Integer amount;
		for (int i = 0; i < vector.length; i++) {
			Object[] k = vector[i].keySet().toArray();
			for (int j = 0; j < k.length; j++) {
				amount = table.get(k[j]);
				if(amount == null){
					table.put((String)k[j], new Integer(vector[i].get(k[j])));
				}else{
					table.put((String) k[j], new Integer(vector[i].get(k[j]) + amount.intValue()));
				}
			}
		}
	}
	public int getFrequency(String key){
		return table.get(key);
	}
	/**
	 * 
	 * @param path path to file
	 * @param P amount of threads
	 */
	public Program(String path, int P){
		this.path = path;
		this.P = P;
		vector = new Hashtable[P];
		for (int i = 0; i < vector.length; i++) {
			vector[i] = new Hashtable<String, Integer>();
		}
	}
}
