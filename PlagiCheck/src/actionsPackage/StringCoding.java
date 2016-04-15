package actionsPackage;

public class StringCoding implements IActionAtInsert {
	
	private int counter = 0;
	//Konstruktor setzt Z�hler von au�en
	public StringCoding(int start) {
		counter = start;
	}
	//tut nichts, gibt das Argument wieder zur�ck
	public Object actionAtKeyFound(Object previous) {
		return previous;
	}
	//erh�ht Z�hler und gibt neuen Wert zur�ck
	public Object actionAtKeyNotFound() {
		return new Integer(counter++);
	}
	public int getActualValue() {
		return counter;
	}
	public String toString() {
		return "Counter= "+counter;
	}
	
}