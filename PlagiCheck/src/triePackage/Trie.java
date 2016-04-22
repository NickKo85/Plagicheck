package triePackage;

import java.util.ArrayList;
import java.util.Iterator;

import mapPackage.IMapFactory;
import actionsPackage.IActionAtInsert;

public class Trie implements ITrie{
	IMapFactory mapFactory;
	private ITrieNode root;
	
	public Trie(IMapFactory mapFactory){
		this.root = new TrieNode(mapFactory);
		this.mapFactory = mapFactory;
	}

	public ITrieReference insert(Iterator k, IActionAtInsert a) {
		return root.recursiveInsert(k, a);
	}

	public ITrieReference insert(String s, IActionAtInsert a) {
		return this.insert(createIterator(s), a);
	}
	
	private Iterator createIterator(String s){
		ArrayList<Integer> list = new ArrayList<Integer>();
		//typecast von char nach int möglich
		for(char c: s.toCharArray()){
			Integer i = (int)c;
			list.add(i);
		}
		return list.iterator();
	}

	public String print() {
		return root.recursiveToString();
	}

}
