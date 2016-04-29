package token;

public class Token implements IToken{
	//private int classCode;
	private TokenClass classCode;
	private int relativeCode;
	//private int line;
	//private int start_position_in_line;

	public Token(TokenClass tC, int rC/*, int line, int posInLine*/) {
		this.classCode = tC;
		this.relativeCode = rC;
		//this.line = line;
		//this.start_position_in_line = posInLine;
	
	}

	public String getClassCode() {
		return classCode.toString(); //geht das so, da ENUM ja auch nur Strings enthält?
	}

	public int getRelativeCode() {
		return relativeCode;
	}
	
	public String toString(){
		return this.classCode+" class/"+this.relativeCode;
		//return clearText(this.classCode)+"/"+this.relativeCode;
	}
	
	private String clearText(int i){
		String retStr = "";
		switch(i) {
		case 1: retStr = "identifier class";
			break;
		case 2: retStr = "intcons class";
			break;
		case 3: retStr = "date class";
			break;
		case 4: retStr = "white space class";
			break;
		case 5: retStr = "punctuation mark class";
			break;
		case -1: retStr = "end of file";
			break;
		default: retStr = "unnown";
			break;
		}
		return retStr;
	}

	public IToken getNextToken() {
		// TODO Auto-generated method stub
		return null;
	}

	public String decode(IToken tk) {
		// TODO Auto-generated method stub
		return null;
	}

}
