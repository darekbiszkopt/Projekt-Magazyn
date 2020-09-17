import org.w3c.dom.ls.LSOutput;

import java.io.IOException;

public class ExceptionWrongOption extends IOException {

    public ExceptionWrongOption(){
        System.out.println("Wybrano złą opcje");
    }

}
