package DFA;

public interface IDFA {
	
	public int initialState();
	
	int trans(int state, int symbol);
	
	boolean isFinal (int state);
	
	boolean isError (int state);
	
	String stateToString (int state);
	
	int getTokenClass (int s);

}
