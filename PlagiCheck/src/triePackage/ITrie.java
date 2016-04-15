package triePackage;

import java.util.Iterator;

import actionsPackage.IActionAtInsert;

public interface ITrie {
	public ITrieReference insert (Iterator k, IActionAtInsert a);
	
	public ITrieReference insert (String s, IActionAtInsert a);

	public String print();

}
