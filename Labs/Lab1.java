import java.util.ArrayList;

/**
 * @author Shweta
 *
 */
public class Lab1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		// Solution a
        System.out.println(2 + 2 + "2");
        
        //Solution b
        ArrayList<String> countries = new ArrayList<String>();
        countries.add("India");
        countries.add("America");
        countries.add("Japan");
        System.out.println("" + countries);
        
        // Solution c
        String greeting = "Hello" + new Greeter("World"); 
        System.out.println(greeting);
        
	}
}

class Greeter {
	private String greeting;
	public Greeter(String greeting) {
		this.greeting = greeting;
	}
	@Override
	public String toString() {
		assert greeting!=null;
		return " " + greeting.toString();
	}
}

