
public class Dove extends Individual {

	public Dove(int uid) {
		super(uid);
	}

	@Override
	String compete(Individual indiv, int resource) {
		int payoff = (int) Math.floor(resource / 2);
		if (indiv instanceof Dove) {
			// Split the resource
			indiv.addResource(payoff);
			super.addResource(payoff);
		} else if (indiv instanceof Hawk) {
			return null;
		}
		
		return String.format("%1$s/%2$s: %1$s: +%3$d\t%2$s: +%4$d", getType(), indiv.getType(), payoff, payoff);
	}

	@Override
	String getType() {
		return "Dove";
	}
}
