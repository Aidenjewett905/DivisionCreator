package oob;

import java.util.*;

import java.io.*;

public class OutputDivisionsToFile {

	public static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
		
		ArrayList<Division> units = new ArrayList<>(); //List of all the divisions being added
		
		String name; //Name of division, including quotes
		System.out.print("What is the name of the division? (Include the quotes): ");
		name = keyboard.nextLine();
		
		int order = 1; //Name order of division
		System.out.print("What is the name order of the division (I.E. Division 1, Division 2)? ");
		order = keyboard.nextInt();
		
		double xp; //Xp Factor
		do {
		System.out.print("What is the experience value of the divisions (0.0 to 1.0)? ");
		xp = keyboard.nextDouble();
		}while(!validXP(xp)); //When not within the values, continue
		
		int location = 1; //Initialize location for the loop
		
		while(location >= 0) //Keep looping until user enters -1
		{
			System.out.print("What is the location of division " + order + "? " +
							 "(Enter a negative value to quit): ");
			location = keyboard.nextInt();
			if(location < 0)
				break;
			units.add(new Division(name, location, xp, order));
			order++; //Go to the next name order
		}
		
		outputToFile(units);
		
		keyboard.close();

	}
	//Output all the divisions to a file to copypaste to the oob file.
	public static void outputToFile(ArrayList<Division> units) throws IOException {
		PrintWriter outputFile = new PrintWriter("Units.txt");
		
		for(Division unit: units) //Output each unit
		{
			outputFile.println("\tdivision = { # " + unit.getTemplate() + "\n\t\tdivision_name = {\n\t\t\tis_name_ordered = yes\n\t\t\t" +
							   "name_order = " + unit.getOrd() + "\n\t\t}\n\t\tlocation = " + unit.getLoc() + 
							   "\n\t\tdivision_template = " + unit.getTemplate() + "\n\t\tstart_experience_factor = " + unit.getXp() + "\n\t}");
		}
		
		outputFile.close();
		
	}
	public static boolean validXP(double xp) {
		if(xp < 0.0 || xp > 1.0)
			return false;
		else
			return true;
	}

}
