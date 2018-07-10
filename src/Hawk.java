
public class Hawk extends Individual {

	private int penalty;
	
	public Hawk(int uid, int penalty) {
		super(uid);
		this.penalty = penalty;
	}
	
	@Override
	String compete(Individual indiv, int resource) {
		if (indiv instanceof Dove) {
			super.addResource(resource);
			return String.format("%1$s/%2$s: %1$s: +%3$d\t%2$s: +%4$d", getType(), indiv.getType(), resource, 0);
		} else if (indiv instanceof Hawk) {
			int net = resource - penalty;
			super.addResource(net);
			indiv.addResource(-penalty);
			return String.format("%1$s/%2$s: %1$s: %3$d\t%2$s: %4$d", getType(), indiv.getType(), net, -penalty);
		}
		
		return null;
	}
	
	@Override
	String getType() {
		return "Hawk";
	}
}
