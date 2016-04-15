package lexer;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

import actionsPackage.IActionAtInsert;
import actionsPackage.StringCoding;
import log.Log;
import token.IToken;
import token.Token;
import triePackage.ITrie;
import triePackage.ITrieReference;
import triePackage.Trie;
import mapPackage.IMapFactory;
import mapPackage.TreeMapFactory;

public class SimpleLexer implements ILexer {
    final private BufferedReader reader;
    final private IMapFactory mapFactory = new TreeMapFactory(); //DIC
    final private IActionAtInsert action = new StringCoding(4711); //DIC
    final private ITrie trie; //DIC
    //final private MapTokenToString tokenToString;
    private String line;
    private StringTokenizer tk = null;

    public SimpleLexer(BufferedReader reader) throws IOException {
        this.reader = reader;
        line = reader.readLine();
        if (line != null) tk = new StringTokenizer(line);
        this.trie = new Trie(mapFactory); //DIC
        //this.tokenToString = new MapTokenToString(); //Decoding
    }

    public IToken getNextToken() throws IOException {
        //Log.println(Log.URGENT, "--> next token");
        ITrieReference ref = null;
        IToken result = null;
        boolean foundToken = false;
        boolean noMoreToken = false;
        do //Invariante: Es gibt einen Tokenizer; tk != null;
        { //Schleife dient nur dem Lesen der Zeilen
            result = null;
            if(tk != null){
                if(tk.hasMoreTokens()){
                    String intermediate = tk.nextToken();
                    //Log.println(Log.URGENT,"--- next token: "+intermediate)
                    //später ist hier der Klassencode des Strings bekannt und es kann der richtige Trie angesteuert werden
                    ref = trie.insert(intermediate,action); //DIC
                    //später: Extraktion des relative Codes aus ref und Bilden des Tokens aus Klassencode und Relativcode
                    result = new Token(-1,-1); //ein dummy !!!!
                    foundToken = true;
                }
                else{
                    //neue Zeile lesen
                    tk = null;
                    line = reader.readLine();
                    if(line != null) tk = new StringTokenizer(line);
                }
            }
            else
                noMoreToken = true;
        }
        while(! foundToken && noMoreToken);
        //Log.println(Log.URGENT,"<-- result token: "+result);
        return result;
    }

    public String decode(IToken tk) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("nochnichtimplementiert");
    }

    public String toString() {
        return "\nResult Trie \n"+trie.print();
    }
}