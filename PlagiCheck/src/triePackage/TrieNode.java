package triePackage;

import java.util.Iterator;
import java.util.Map;

import mapPackage.IMapFactory;
import actionsPackage.IActionAtInsert;

public class TrieNode implements ITrieNode{
	final private IMapFactory mapFactory;
	final private Map<Integer, ITrieNode> outgoingEdgeMap;
	final private ITrieNode parent;
	final private Integer ingoingPartialKey;
	private Integer actionValue; //muss hier der Token hin?
	private int row;

	public TrieNode(IMapFactory mapFactory, ITrieNode parent, Integer ingoingPartialKey, int row){
		this.mapFactory = mapFactory;
		this.outgoingEdgeMap = this.mapFactory.create();
		this.parent = parent;
		this.ingoingPartialKey = ingoingPartialKey;
		this.actionValue = null;
		this.row = row;
	}
	
	public TrieNode(IMapFactory mapFactory){
		this(mapFactory, null, null, 0);
	}

	public ITrieReference recursiveInsert(Iterator iterator, IActionAtInsert action) {
		int currentRow = row;
		if(iterator.hasNext()){
			Object next = iterator.next();
			
			if(outgoingEdgeMap.containsKey(next)) {
				//Knoten existiert bereits
				//System.out.println("Knoten "+next.toString()+" existiert bereits!");
				return outgoingEdgeMap.get(next).recursiveInsert(iterator, action);
			} else {
				//Knoten nicht gefunden, muss angelegt werden
				currentRow++;
				ITrieNode newNode = new TrieNode(mapFactory, this, (Integer) next, currentRow);
				outgoingEdgeMap.put((Integer) next, newNode);
				//System.out.println("Knoten "+next.toString()+" existiert nicht, muss angelegt werden!");
				return newNode.recursiveInsert(iterator, action);
			}
		} else if(actionValue == null){
			this.actionValue = (Integer) action.actionAtKeyNotFound();
			return new TrieReference(false, this.actionValue, this);
		} else return new TrieReference(true, action.actionAtKeyFound(this.actionValue), this);
	}

	public ITrieReference recursiveInsert(String s, IActionAtInsert a) {
		//s.toCharArray();
		return null;
	}
	
	public Map<Integer, ITrieNode> getOutgoingEdgeMap() {
		return this.outgoingEdgeMap;
	}
	
	public String recursiveToString(){

		Iterator iterator = outgoingEdgeMap.keySet().iterator();
		String stringPart = "";
		
		while(iterator.hasNext()){
			int contentInt = (Integer) iterator.next();
			char content = (char) contentInt;
			
			//System.out.println("Lese Buchstabe: "+content);
			
			stringPart += "\n";
			for(int i = 0; i<this.row; i++){
				stringPart += "..";
			}
			stringPart += content;
			
			if(outgoingEdgeMap.get(contentInt).getActionValue() != null){
				//System.out.println("ContentInt = "+contentInt);
				//Länge stringPart auslesen und mit Leerzeichen auffüllen
				if(stringPart.length()<15){
					for(int i = stringPart.length(); i<=15; i++){
						stringPart += " ";
					}
				}
				stringPart += "\t\t\t   -> Key = "
						+ outgoingEdgeMap.get(contentInt).getActionValue();
				
				if(!outgoingEdgeMap.get(contentInt).getOutgoingEdgeMap().isEmpty()){
					stringPart += outgoingEdgeMap.get(contentInt).recursiveToString();
				}
			} else stringPart += outgoingEdgeMap.get(contentInt).recursiveToString();
		}
		return stringPart;
	}
	

	public Integer getActionValue() {
		return this.actionValue;
	}

}
