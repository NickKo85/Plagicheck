package mapPackage;

import java.util.Map;

import triePackage.ITrieNode;

public interface IMapFactory {

	Map<Integer, ITrieNode> create();
	
}