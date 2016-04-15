package actionsPackage;

public interface IActionAtInsert {
	
	public Object actionAtKeyFound(Object old);
	public Object actionAtKeyNotFound();
}