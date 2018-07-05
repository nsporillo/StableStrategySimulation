
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
		} else if (indiv instanceof Hawk) {
			super.addResource(-penalty);
		}
		
		return String.format("%s/%2$s: %1$s: + %d\t%2$s: +%d", getType(), indiv.getType(), getResource(), indiv.getResource());
	}
	
	@Override
	String getType() {
		return "Hawk";
	}
}
