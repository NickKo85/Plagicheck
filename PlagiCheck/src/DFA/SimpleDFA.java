package DFA;
import token.Token;

public class SimpleDFA implements IDFA {
	
	private final int START_STATE = 0;
	private final int FAILURE_STATE = 1;
	private final int EOF_STATE = 2;
	private final int ID_STATE = 3;
	private final int PM_STATE = 4;
	private final int WS_STATE = 5;
	private final int FIRST_OF_DAY_STATE = 6;
	private final int SECOND_OF_DAY_STATE = 7;
	private final int DAY_STATE = 8;
	private final int FIRST_OF_MONTH_STATE = 9;
	private final int SECOND_OF_MONTH_STATE = 10;
	private final int MONTH_STATE = 11;
	private final int FIRST_OF_YEAR_STATE = 12;
	private final int DATE_STATE = 13;
	private final int INTCONS_STATE = 14;
	
	public int initialState() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int trans(int state, int symbol) {
		
		switch(state){
		case START_STATE:	if(symbol == -1){
							    return EOF_STATE;
							}
							if(Character.isWhitespace(symbol)){
								return WS_STATE;
							}
							if(symbol == 46 || symbol == 44){
								return PM_STATE;
							}
							if(Character.isAlphabetic(symbol) || Character.isLetter(symbol)){
								return ID_STATE;
							}
							if(Character.isDigit(symbol)){
								return FIRST_OF_DAY_STATE;
							} else {
								return FAILURE_STATE;
							}
		
		case ID_STATE:		if(Character.isLetter(symbol)){
								return ID_STATE;
							} else {
								return FAILURE_STATE;
							}
		case PM_STATE:		return FAILURE_STATE;
		case WS_STATE:		if(Character.isWhitespace(symbol)){
								return WS_STATE;
							} else {
								return FAILURE_STATE;
							}
		case FIRST_OF_DAY_STATE:if(Character.isDigit(symbol)){
								return SECOND_OF_DAY_STATE;
							} else {
								return FAILURE_STATE;
							}
		case SECOND_OF_DAY_STATE:if(Character.isDigit(symbol)){
								return FIRST_OF_MONTH_STATE;
							} else {
								return FAILURE_STATE;
							}
		case DAY_STATE:		if(Character.isDigit(symbol)){
								return FIRST_OF_MONTH_STATE;
							} else {
								return FAILURE_STATE;
							}
		case FIRST_OF_MONTH_STATE: if(Character.isDigit(symbol)){
								return SECOND_OF_MONTH_STATE;
							} else {
								return FAILURE_STATE;
							}
		case SECOND_OF_MONTH_STATE: if (symbol == 46){
								return MONTH_STATE;
							} else {
								return FAILURE_STATE;
							}
		case MONTH_STATE:	if(Character.isDigit(symbol)){
								return FIRST_OF_YEAR_STATE;
							} else {
								return FAILURE_STATE;
							}
	    case FIRST_OF_YEAR_STATE: if(Character.isDigit(symbol)){
	    						return DATE_STATE;
	    					} else {
	    						return FAILURE_STATE;
	    					}
	    case INTCONS_STATE: if(Character.isDigit(symbol)){
	    						return INTCONS_STATE;
	    					} else {
	    						return FAILURE_STATE;
	    					}
		default: return FAILURE_STATE;
		}
	}

	public boolean isFinal(int state) {
		if(state == EOF_STATE) {
			return true;
		}
		return false;
	}
	
	public boolean isError(int state) {
		if(state == FAILURE_STATE) {
			return true;
		}
		return false;
	}
	
	public String stateToString(int state) {
		switch(state) {
		case START_STATE: return "START_STATE";
		case FAILURE_STATE: return "FAILURE_STATE";
		case EOF_STATE: return "EOF_STATE";
		case ID_STATE: return "ID_STATE";
		case PM_STATE: return "PM_STATE";
		case WS_STATE: return "WS_STATE";
		case FIRST_OF_DAY_STATE: return "FIRST_OF_DAY_STATE";
		case SECOND_OF_DAY_STATE: return "SECOND_OF_DAY_STATE";
		case DAY_STATE: return "DAY_STATE";
		case FIRST_OF_MONTH_STATE: return "FIRST_OF_MONTH_STATE";
		case SECOND_OF_MONTH_STATE: return "SECOND_OF_MONTH_STATE";
		case MONTH_STATE: return "MONTH_STATE";
		case FIRST_OF_YEAR_STATE: return "FIRST_OF_YEAR_STATE";
		case INTCONS_STATE: return "INTCONS_STATE";
		case DATE_STATE: return "DATE_STATE";
		default: return "";
		}
	}
	
	public int getTokenClass(int state) {
		switch(state){
		case ID_STATE: return Token.IDENTIFIER;
		case WS_STATE: return Token.WS;
		case PM_STATE: return Token.PMARK;
		case FIRST_OF_DAY_STATE: return Token.INTCONS;
		case SECOND_OF_DAY_STATE: return Token.INTCONS;
		case DATE_STATE: return Token.DATE;
		case INTCONS_STATE: return Token.INTCONS;
		default: return -1;
		}
	} 
}
