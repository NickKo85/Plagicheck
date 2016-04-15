package triePackage;

public class TrieReference implements ITrieReference {
	private boolean getFound;
	private Object getValue;
	private ITrieNode getNode;
	
	public TrieReference(boolean getFound, Object getValue, ITrieNode getNode){
		this.getFound = getFound;
		this.getValue = getValue;
		this.getNode = getNode;
	}

	public Boolean getFound() {
		return this.getFound;
	}

	public Object getValue() {
		return this.getValue;
	}

	public ITrieNode getNode() {
		return this.getNode;
	}

}
