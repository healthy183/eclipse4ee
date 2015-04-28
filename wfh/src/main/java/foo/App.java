package foo;

import org.apache.commons.lang3.StringUtils;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ){
     
    	boolean isTrue = StringUtils.isNotBlank("wfh");
    	System.out.println( "Hello World!" );
    	System.out.println("this is "+isTrue);
    }
}
