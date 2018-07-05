
public class project02 {
	
	private static final Integer PERCENT_HAWKS = 20;
	private static final Integer RESOURCE_AMT = 50;
	private static final Integer COST_HAWK_HAWK = 100;

	public static void main(String[] args) {
		if (args.length == 0 || args.length > 4) {
			usage();
		} else  {
			Integer popSize = parseParameter(args[0], "popSize");
			Integer percentHawks;
			Integer resouceAmt;
			Integer costHawkHawk;
			
			if (args.length == 1) {
				percentHawks = PERCENT_HAWKS;
				resouceAmt = RESOURCE_AMT;
				costHawkHawk = COST_HAWK_HAWK;
			} else {
				percentHawks = parseParameter(args[1], "[percentHawks]");
				resouceAmt = parseParameter(args[2], "[resourceAmt]");
				costHawkHawk = parseParameter(args[3], "[costHawk-Hawk]");
			}
			
			
		}
	}
	
	private static Integer parseParameter(String input, String label) {
		Integer ret = null;
		try {
			ret = Integer.parseInt(input);
		} catch(NumberFormatException nfe) {
			System.err.println("Error: Received non-integer for " + label);
		}
		
		return ret;
	}
	
	private static void usage() {
		System.err.println("Usage: ./project02 popSize [percentHawks] [resourceAmt] [costHawk-Hawk]");
		System.exit(-1);
	}
}
