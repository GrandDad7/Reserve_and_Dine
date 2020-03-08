import java.util.LinkedList;

public class Restaurant {
	Table tA = new Table("A", 4);
	Table tB = new Table("B", 3);
	Table tC = new Table("B", 2);
	Table tD = new Table("D", 5);
	Table tE = new Table("E", 3);
	Table tF = new Table("F", 6);
	Table tG = new Table("G", 6);
	Table tH = new Table("H", 4);
	Table tI = new Table("I", 2);
	Table tJ = new Table("J", 3);
	
	
	LinkedList<Table> reserved = new LinkedList<Table>();
	LinkedList<Table> available = new LinkedList<Table>();
	LinkedList<Table> taken = new LinkedList<Table>();
	
	int chairsInReserve = 10;
	
	public void setAllTablesFree() {
		tA.setState(Table.State.FREE);
		tB.setState(Table.State.FREE);
		tC.setState(Table.State.FREE);
		tD.setState(Table.State.FREE);
		tE.setState(Table.State.FREE);
		tF.setState(Table.State.FREE);
		tG.setState(Table.State.FREE);
		tH.setState(Table.State.FREE);
		tI.setState(Table.State.FREE);
		tJ.setState(Table.State.FREE);

	}
	
	public void freeAllTables() {
		reserved.clear();
		taken.clear();
		this.setAllTablesFree();
	}
	
	public Table reserveTable() {
		this.reserved.add(available.peek());
		available.peek().setState(Table.State.RESERVED);
		return this.reserved.poll();
	}
	
	public Table takeTable(Table ttr) {
		for (int i = 0; i < reserved.size(); i++) {
			if (reserved.get(i).equals(ttr)) {
				reserved.remove(i);
				taken.add(ttr);
				return ttr;
			}
		}
		return null;
	}
	
	public boolean freeTable(Table ttr) {
		if (reserved.contains(ttr)) {
			this.reserved.remove(ttr);
			this.available.add(ttr);
			return true;
		}
		
		if (taken.contains(ttr)) {
			this.taken.remove(ttr);
			this.available.add(ttr);
			return true;
		}
			return false;
		
	}
	
	
}
