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

public class AlignmentController {
    final private String original;
    final private String suspect;

    public AlignmentController(String original, String suspect){
        this.original = original;
        this.suspect = suspect;
    }

    public void run() throws FileNotFoundException, IOException {
        //erstes File lesen
        InputStream istreamOriginal = new FileInputStream(original);
        Reader readerOriginal = new InputStreamReader(istreamOriginal);
        BufferedReader inputOriginal = new BufferedReader(readerOriginal);

        //später hier zweites File

        ILexer lexer = new SimpleLexer(inputOriginal);
        IToken token = lexer.getNextToken();
        while(token != null){
            //System.out.println("Gelesen: "+token.toString());
            token = lexer.getNextToken();
        }
        
        System.out.print(lexer.toString());
        

        //später hier Lexer an zweiten Input binden; Leseschleife
    }
}