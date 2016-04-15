package mapPackage;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapFactory implements IMapFactory {

	public Map create() {
		return new TreeMap();
	}
	
}