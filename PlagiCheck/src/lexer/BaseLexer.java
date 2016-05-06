package lexer;

import java.util.TreeMap;

import actionsPackage.IActionAtInsert;
import mapPackage.IMapFactory;
import mapPackage.TreeMapFactory;
import token.IToken;
import token.TokenClass;
import triePackage.ITrie;
import triePackage.ITrieNode;
import triePackage.Trie;
import actionsPackage.StringCoding;

public class BaseLexer implements ILexer{
	
	final private IMapFactory mapFactory = new TreeMapFactory();
	final private ITrie[] tries;
	final private IActionAtInsert[] actionArray;
	final private TreeMap<TokenClass, ITrieNode>[] treeMap;
	
	public BaseLexer(){
		actionArray = new StringCoding[TokenClass.values().length];
		tries = new Trie[TokenClass.values().length];
		treeMap = new TreeMap[TokenClass.values().length];
		this.buildInitialTrees();
	}
	
	private void buildInitialTrees (){
		int i = 0;
		for(TokenClass t : TokenClass.values()){
			System.out.println("Build initial Tree for "+t);
			Trie trie = new Trie(mapFactory);
			tries[i] = trie;
			actionArray[i] = new StringCoding(4711);
			treeMap[i] = new TreeMap<TokenClass , ITrieNode>();
			i++;
		}
	}
	
	public IToken getNextToken(){
		return null;
	}
	
	public String decode(IToken tk){
		return "";
	}

}
