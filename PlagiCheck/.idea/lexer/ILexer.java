package lexer;
import java.io.IOException;
import token.IToken;

public Interface ILexer {
        IToken getNextToken() throws IOException;
        String decode(IToken tk);
        }