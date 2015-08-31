import java.util.ArrayList;
import java.util.Random;

class Range {
	   public char startRange;
	   public char endRange;
	   public Range(char startRange, char endRange) {
		   this.startRange = startRange;
		   this.endRange = endRange;
	   }
	   @Override
	   public String toString() {
		   String printRange = "[ " + startRange + ", " + endRange +" ]";
		   return printRange;
	   }
	}

public class RandomStringGenerator {
	
	private ArrayList<Range> range;
	private Range currentRange;
	private static int minRange;
	private static int maxRange;
	
	private static final int RANDOM_NUMBERS_TO_BE_GENERATED = 10;
	
	public RandomStringGenerator() {
		range = new ArrayList<Range>();
	}
	/*
	 * Range is a customized data type that stores the start and
	 * end range for Random String Generation. Whenever addRange method is called
	 * a new Range object is created that stores the current Range provided.
	 */
	
	public void addRange(char startRange, char endRange) {
	    currentRange = new Range(startRange, endRange);
        range.add(currentRange);
	}
	
	public String nextString() {
		Random random = new Random();
		StringBuffer buffer = new StringBuffer();
		if(!isRangeValid()) {
			return "Please enter valid range\nValidation Criteria :- \n"
					+ "1. Start Range cannot be greater than or equal to end Range\n"
					+ "2. Start and or Range can not be null";
		}
		for( int i = 0; i < RANDOM_NUMBERS_TO_BE_GENERATED ; i++) {
			buffer.append(nextString(random));
		}
		return buffer.toString();
	}
	
	
	
	private boolean isRangeValid() {
		int startRange;
		int endRange;
		minRange = range.get(0).startRange;
		maxRange = range.get(0).endRange;
		for(Range currentRange: range) {
			startRange = currentRange.startRange;
			endRange = currentRange.endRange;
			if (startRange == '\0' || endRange == '\0') {
				return false;
			}
			if (startRange >= endRange) {
				return false;
			}
			setMinMaxRange(startRange, endRange);	
		}
		
		return true;
	}
	
	private void setMinMaxRange(int startRange, int endRange) {
		if(minRange > startRange) {
			minRange = startRange;
		}
		if(maxRange < endRange) {
			maxRange = endRange;
		}
	}
	
	private char nextString(Random random) {
		long range = (long)maxRange - (long)minRange + 1;
	    // compute a fraction of the range, 0 <= frac < range
	    long fraction = (long)(range * random.nextDouble());
	    int randomNumber =  (int)(fraction + minRange); 
	    // Handling special characters 
	    if(randomNumber >= 91 && randomNumber <= 96) {
	         randomNumber = nextString(random);
	    }
		return (char)randomNumber;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       RandomStringGenerator generator = new RandomStringGenerator();
       generator.addRange('a', 'c');
       generator.addRange('d', 'g');
       String s = generator.nextString();
       System.out.println(s);
	}

}
