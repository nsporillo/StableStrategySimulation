
public abstract class Individual implements Comparable<Individual> {

	private boolean dead;
	private int resource;
	private int uid;
	
	public Individual(int uid) {
		this.dead = false;
		this.resource = 0;
		this.uid = uid;
	}
	
	abstract String getType();
	
	abstract String compete(Individual indiv, int resource);
	
	public int getResource() {
		return resource;
	}

	public void addResource(int delta) {
		this.resource += delta;
		
		if (this.resource < 0) {
			setDead();
		}
	}

	public boolean isDead() {
		return dead;
	}

	public void setDead() {
		this.dead = true;
	}

	@Override
	public int compareTo(Individual other) {
		return Integer.compare(other.resource, resource);
	}
	
	public int getUid() {
		return uid;
	}
	
	@Override
	public String toString() {
		return String.format("Individual %d=%d", uid, resource);
	}
}
