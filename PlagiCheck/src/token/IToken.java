package token;

public interface IToken {
	
	int IDENTIFIER = 1;
	int INTCONS = 2;
	int DATE = 3;
	int WS = 4;
	int PMARK = 5;
	int EOF = -1;
	
	//public int getClassCode();
	
	public String getClassCode();
	
	public int getRelativeCode();
	
	public IToken getNextToken();
	
	public String decode(IToken tk);

}
