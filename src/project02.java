
public class project02 {
	
	// Default values
	private static final Integer PERCENT_HAWKS = 20;
	private static final Integer RESOURCE_AMT = 50;
	private static final Integer COST_HAWK_HAWK = 100;

	public static void main(String[] args) {
		if (args.length == 0 || args.length > 4) {
			usage();
		} else {
			Integer popSize = parseParameter(args[0], "popSize");
			Integer percentHawks = PERCENT_HAWKS;
			Integer resourceAmt = RESOURCE_AMT;
			Integer costHawkHawk = COST_HAWK_HAWK;

			if (args.length > 1) {
				percentHawks = parseParameter(args[1], "[percentHawks]");
				
				// No percentages over 100 allowed
				if (percentHawks > 100) {
					percentHawks = 100;
				}
			}
			if (args.length > 2) {
				resourceAmt = parseParameter(args[2], "[resourceAmt]");
			}

			if (args.length > 3) {
				costHawkHawk = parseParameter(args[3], "[costHawk-Hawk]");
			}

			// Create simulation and show menu
			new Simulation(popSize, percentHawks, resourceAmt, costHawkHawk).showMenu();
		}
	}
	
	/**
	 * Parse input from command line argument
	 * @param input string
	 * @param label debug message
	 * @return
	 */
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
