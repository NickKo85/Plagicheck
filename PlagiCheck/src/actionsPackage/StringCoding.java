package actionsPackage;

public class StringCoding implements IActionAtInsert {
	
	private int counter = 0;
	//Konstruktor setzt Zähler von außen
	public StringCoding(int start) {
		counter = start;
	}
	//tut nichts, gibt das Argument wieder zurück
	public Object actionAtKeyFound(Object previous) {
		return previous;
	}
	//erhöht Zähler und gibt neuen Wert zurück
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