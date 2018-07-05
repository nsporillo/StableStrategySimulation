
public class Dove extends Individual {

	public Dove(int uid) {
		super(uid);
	}

	@Override
	String compete(Individual indiv, int resource) {
		if (indiv instanceof Dove) {
			// Split the resource
			int payoff = (int) Math.floor(resource / 2);
			indiv.addResource(payoff);
			super.addResource(payoff);
		} else if (indiv instanceof Hawk) {
			return null;
		}
		
		return String.format("%s/%2$s: %1$s: + %d\t%2$s: +%d", getType(), indiv.getType(), getResource(), indiv.getResource());
	}

	@Override
	String getType() {
		return "Dove";
	}
}
