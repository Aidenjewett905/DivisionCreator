package oob;
/**
 * Class is for a hoi4 Division being spawned in.
 */
public class Division {
	
	private String divisionTemplate; //Division Name (With Quotes)
	private double expFactor; //Division Experience
	private int nameOrder, location; //Division name order (I.E. 1st division, 2nd division) and location
	
	public Division() {
		divisionTemplate = "No Name Listed";
		location = 1;
		expFactor = 0.3;
		nameOrder = 0;
	}
	/**
	 * 
	 * @param temp The division template name, surrounded by quotes
	 * @param loc The division location, string variable but always a number
	 * @param xp The exp factor for the division
	 * @param ord The order of the division's name (I.E. 1st division, 2nd division)
	 */
	public Division(String temp, int loc, double xp, int ord) {
		divisionTemplate = temp;
		location = loc;
		expFactor = xp;
		nameOrder = ord;
	}
	public String getTemplate() {
		return divisionTemplate;
	}
	public int getLoc() {
		return location;
	}
	public double getXp() {
		return expFactor;
	}
	public int getOrd() {
		return nameOrder;
	}
	public void setXp(double xp) {
		expFactor = xp;
	}
	public void setTemplate(String temp) {
		divisionTemplate = temp;
	}
	public void setLoc(int loc) {
		location = loc;
	}
	public void setOrd(int ord) {
		nameOrder = ord;
	}
	public String toString() {
		return "\tdivision = { # " + divisionTemplate + "\n\t\tdivision_name = {\n\t\t\tis_name_ordered = yes\n\t\t\t" +
				   "name_order = " + nameOrder + "\n\t\t}\n\t\tlocation = " + location + 
				   "\n\t\tdivision_template = " + divisionTemplate + "\n\t\tstart_experience_factor = " + expFactor + "\n\t}";
	}
	
}
