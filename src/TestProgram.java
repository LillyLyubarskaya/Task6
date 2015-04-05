import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestProgram {
	@Test
	public void test_1() {
		Program amounter = new Program("text.txt", 1);
		amounter.amount();
		assertEquals(38, amounter.getFrequency("object"));
		assertEquals(1959, amounter.getFrequency("love"));
		assertEquals(319, amounter.getFrequency("use"));
		assertEquals(242, amounter.getFrequency("return"));
		assertEquals(5099, amounter.getFrequency("him"));
		assertEquals(1454, amounter.getFrequency("see"));
		assertEquals(3803, amounter.getFrequency("her"));
		
		
	}
	
	@Test
	public void test_2() {
		Program amounter = new Program("text.txt", 2);
		amounter.amount();
		assertEquals(38, amounter.getFrequency("object"));
		assertEquals(1959, amounter.getFrequency("love"));
		assertEquals(319, amounter.getFrequency("use"));
	}
	
	@Test
	public void test_3() {
		Program amounter = new Program("text.txt", 3);
		amounter.amount();
		assertEquals(38, amounter.getFrequency("object"));
		assertEquals(1959, amounter.getFrequency("love"));
		assertEquals(319, amounter.getFrequency("use"));
	}

}
