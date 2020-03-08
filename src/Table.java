public class Table {
	private String designation;
	private State state;
	public int chairs;

	public enum State {
		FREE, TAKEN, RESERVED;
	}

	public Table() {
		this.designation = "";
		this.state = State.FREE;
		this.chairs = 0;
	}

	public Table(String designation) {
		this.designation = designation;
		this.state = State.FREE;
		this.chairs = 0;
	}

	public Table(String designation, int chairs) {
		this.designation = designation;
		this.state = State.FREE;
		this.chairs = chairs;
	}

	public String getDesignation() {
		return designation;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getChairs() {
		return this.chairs;
	}

	public void setChairs(int chairs) {
		this.chairs = chairs;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Table other = (Table) obj;
		if (designation == null) {
			if (other.designation != null)
				return false;
		} else if (!designation.equals(other.designation))
			return false;
		return true;
	}

}
