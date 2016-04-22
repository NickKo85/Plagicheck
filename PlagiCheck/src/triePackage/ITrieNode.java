package triePackage;

import java.util.Iterator;
import java.util.Map;

import actionsPackage.IActionAtInsert;

public interface ITrieNode {
	
	public ITrieReference recursiveInsert(Iterator k, IActionAtInsert a);
	
	public ITrieReference recursiveInsert(String s, IActionAtInsert a);

	public Integer getActionValue();

	public Map<Integer, ITrieNode> getOutgoingEdgeMap();

	public String recursiveToString();

}
