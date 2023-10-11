package classTests.seleniumExceptions;

import org.openqa.selenium.devtools.v85.runtime.model.StackTraceId;

public class NoCoffeeException extends RuntimeException{
    /*
    runtime exception
    exception
     */

    public NoCoffeeException(String message){
        super(message);
    }

    public NoCoffeeException(){
        super();
    }

}
