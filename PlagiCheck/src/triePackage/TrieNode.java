package triePackage;

import java.util.Iterator;
import java.util.Map;

import mapPackage.IMapFactory;
import actionsPackage.IActionAtInsert;

public class TrieNode implements ITrieNode{
	final private IMapFactory mapFactory;
	final private Map<Integer, ITrieNode> edgeMap;
	final private ITrieNode parent;
	final private Integer ingoingPartialKey;
	private Integer actionValue;
	private int row;

	
	
	public TrieNode(IMapFactory mapFactory, ITrieNode parent, Integer ingoingPartialKey, int row){
		this.mapFactory = mapFactory;
		this.edgeMap = this.mapFactory.create();
		this.parent = parent;
		this.ingoingPartialKey = ingoingPartialKey;
		this.actionValue = null;
		this.row = row;
	}
	
	public TrieNode(IMapFactory mapFactory){
		this(mapFactory, null, null, 0);
	}

	public ITrieReference recursiveInsert(Iterator k, IActionAtInsert a) {
		int currentRow = row;
		if(k.hasNext()){
			Object next = k.next();
			
			if(edgeMap.containsKey(next)){
				//Knoten existiert bereits
				return edgeMap.get(next).recursiveInsert(k, a);
			} else {
				//Knoten nicht gefunden, muss angelegt werden
				currentRow++;
				ITrieNode newNode = new TrieNode(mapFactory, this, (Integer) next, currentRow);
				edgeMap.put((Integer) next, newNode);
				return newNode.recursiveInsert(k, a);
			}
		} else if(actionValue == null){
			this.actionValue = (Integer) a.actionAtKeyNotFound();
			return new TrieReference(false, this.actionValue, this);
		} else return new TrieReference(true, a.actionAtKeyFound(this.actionValue), this);
	}

	public ITrieReference recursiveInsert(String s, IActionAtInsert a) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Map<Integer, ITrieNode> getEdgeMap() {
		return this.edgeMap;
	}
	
	public String toString(){
		Iterator it = edgeMap.keySet().iterator();
		String s = "";
		
		while(it.hasNext()){
			int contentInt = (Integer) it.next();
			char content = (char) contentInt;
			
			s += "\n";
			for(int i = 0; i<this.row; i++){
				s += ".";
			}
			s += content;
			
			if(edgeMap.get(contentInt).getActionValue() != null){
				s += " "+ edgeMap.get(contentInt).getActionValue();
				
				if(!edgeMap.get(contentInt).getEdgeMap().isEmpty()){
					s += edgeMap.get(contentInt).toString();
				}
			}
		}
		return s;
	}

	public Integer getActionValue() {
		return this.actionValue;
	}

}
