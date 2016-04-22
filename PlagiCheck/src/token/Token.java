package token;

public class Token implements IToken{
	private int classCode;
	private int relativeCode;

	public Token(int i, int j) {
		this.classCode = i;
		this.relativeCode = j;
	}

	public int getClassCode() {
		return classCode;
	}

	public int getRelativeCode() {
		return relativeCode;
	}
	
	public String toString(){
		return this.classCode+"/"+this.relativeCode;
	}

}
