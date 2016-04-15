package plagiCheck;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import token.IToken;
import lexer.ILexer;
import lexer.SimpleLexer;

public class AligmentController {
    final private String original;
    final private String suspect;

    public AligmentController(String original, String suspect){
        this.original = original;
        this.suspect = suspect;
    }

    public void run() throws FileNotFoudException, IOException {
        //erstes File lesen
        ImputStream istreamOriginal = new FileInputStream(original);
        Reader readerOriginal = new InputStreamReader(istreamOriginal);
        BufferedReader inputOriginal = new BufferedReader(readerOriginal);

        //später hier zweites File

        ILexer lexer = new SimpleLexer(inputOriginal);
        IToken token = lexer.getNextToken();
        while(token != null){
            System.out.println("Gelesen: "+token);
            token = lexer.getNextToken();
        }

        //später hier Lexer an zweiten Input binden; Leseschleife
    }
}