package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Section05Main {
	public static void main(String [] args) {
		
		// Creation of list of politicions
		List<Politician> collection = new ArrayList<>();
		initCollection(collection);
		
		holdDebates(collection);
		
		// Choose representatives for each party
		Republican rep = chooseRepCandidate(collection);
		Democrat dem = chooseDemCandidate(collection);
		Libertarian oth = chooseOther(collection);
		
		// Run election simulator
		stateElections(dem, rep, oth);
		
		// Output information about the candidates who made it into the final campaign, and who won
		System.out.println(dem.getName() + " votes: " + dem.getTotalVotes());
		System.out.println(rep.getName() + " votes: " + rep.getTotalVotes());
		System.out.println(oth.getName() + " votes: " + oth.getTotalVotes()); 
		System.out.println();
		
		if (dem.getTotalVotes() > rep.getTotalVotes()) {
			System.out.println(dem.toString());
			System.out.println(dem.getSlogan());
		} else if (dem.getTotalVotes() < rep.getTotalVotes()){
			System.out.println(rep.toString());
			System.out.println(rep.getSlogan());
		} else {
			System.out.println("Recount!");
		}
				
	}
	
	// Method used to initialize the politician list. No return is included, 
	// as the list will be modified in place
	public static void initCollection(List<Politician> collection) {
		// Create objects
		Politician trump = new Republican("Donald Trump", 72, "Make America Great Again");
		Politician bernie = new Democrat("Bernie sanders", 77, "Not Me. Us.");
		Politician booker = new Democrat("Cory Booker", 49, "I stand with Cory Booker");
		Politician kaisch = new Republican("John Kasich", 66, "I'm running");
		Politician klobuchar = new Democrat("Amy Klobuchar", 58, "Minnesota Nice.");
		Politician romney = new Republican("Mitt Romney", 71, "Believe in America");
		Politician johnson = new Libertarian("Gary Johnson", 66, "Our Best America Yet");
		
		// add to list
		collection.add(trump);
		collection.add(bernie);
		collection.add(booker);
		collection.add(kaisch);
		collection.add(klobuchar);
		collection.add(romney);
		collection.add(johnson);
	}
	
	// Method used to decide on politician standings with debate rankings based on 
	// debate wins. The way debate wins work in this situation is through comparing 
	// the current statistics of each runner. If they have won more debates previously, they
	// will win the current one they are on, and if they are tied for debate wins, then 
	// the democrat is sided with as they technically have the advantage in the next 
	// election, and finally, if the two candidates are of the same party, a coin flip
	// is done.
	public static void holdDebates(List<Politician> runners) {
		
		// a nested for loop is used to avoid two potential runners debating with each other
		// twice
		for (int i = 0; i < runners.size(); i++) {
			for (int j = i + 1; j < runners.size(); j++) {
				if (runners.get(i).getDebatesWon() > runners.get(j).getDebatesWon()) {
					runners.get(i).wonDebate();
				} else if (runners.get(i).getDebatesWon() > runners.get(j).getDebatesWon()) {
					runners.get(j).wonDebate();
				} else {
					if (runners.get(i) instanceof Democrat && !(runners.get(j) instanceof Democrat)) {
						runners.get(i).wonDebate();
					} else if (runners.get(j) instanceof Democrat && !(runners.get(i) instanceof Democrat)) {
						runners.get(j).wonDebate();
					} else {
						Random generator = new Random();
						if (generator.nextInt(2) == 0) {
							runners.get(i).wonDebate();
						} else {
							runners.get(j).wonDebate();
						}
					}
				}
			}
		}
	}
	
	// Function for parsing the politicians, and picking the republican 
	// with the highest debate win
	public static Republican chooseRepCandidate(List<Politician> all) {
		int currMax = -1;
		Republican output = null;
		for (int i = 0; i < all.size(); i++) {
			if (all.get(i) instanceof Republican && all.get(i).getDebatesWon() > currMax) {
				output = (Republican) all.get(i);
				currMax = all.get(i).getDebatesWon();
			}
		}
		
		return output;
	}
	
	// Funciton for parsing politicians again, and selecting the democrat
	// with the highest debate win
	public static Democrat chooseDemCandidate(List<Politician> all) {
		int currMax = -1;
		Democrat output = null;
		for (int i = 0; i < all.size(); i++) {
			if (all.get(i) instanceof Democrat && all.get(i).getDebatesWon() > currMax) {
				output = (Democrat) all.get(i);
				currMax = all.get(i).getDebatesWon();
			}
		}
		return output;
	}
	
	// Choice of outside party. Since there is only one in this example, 
	// no comparisons need to be done
	public static Libertarian chooseOther(List<Politician> all) {
		for (int i = 0; i < all.size(); i++) {
			if (!(all.get(i) instanceof Republican) && !(all.get(i) instanceof Democrat)) {
				return (Libertarian) all.get(i);
			}
		}	
		return null;
	}
	
	// Process of assigning votes to the different candidates based on the probability
	// of democrats vs republicans winning in each state's electoral college vote.
	// This info about the states vote number and democratic vs republican association
	// is stored inside of states.txt, which is parsed and used to assign votes. 
	public static void stateElections(Democrat dem, Republican rep, Libertarian oth) {
		try {
			File file = new File("info/states.txt");
			Scanner reader = new Scanner(file);
			
			String currLine;
			String [] splitLine;
			Random generator = new Random();
			int randNum;
			while (reader.hasNextLine()) {
				currLine = reader.nextLine();
				// each line in the file is formatted to be split into the following list
				// [STATE_CODE, VOTE_AMOUNT, DEMOCRATS, REPUBLICANS]
				splitLine = currLine.split("\\s+");
				if (!splitLine[0].equals("%")) {
					// in the event that the state is entirely filled with one party or the other, 
					// being represented by the opposing party having a zero, assign the votes to 
					// the respective party they represent. 
					if (Integer.parseInt(splitLine[2]) == 0) {
						dem.addVotes(Integer.parseInt(splitLine[1]));
					} else if (Integer.parseInt(splitLine[3]) == 0) {
						rep.addVotes(Integer.parseInt(splitLine[1]));
						
					// otherwise the probability of a candidate winning is based on the total number of 
					// possible representatives voting, which is compared against a random number. 
					// In the rare event this is equal to the number of votes, the outside party is 
					// picked to represent the small possibility of this party winning. 
					} else {
						int totalVotes = Integer.parseInt(splitLine[2]) + Integer.parseInt(splitLine[3]);
						randNum = generator.nextInt(totalVotes + 1);
						if (randNum > Integer.parseInt(splitLine[2]) && randNum != totalVotes {
							rep.addVotes(Integer.parseInt(splitLine[1]));
						} else if (randNum == totalVotes) {
							oth.addVotes(Integer.parseInt(splitLine[1]));
						} else {
							dem.addVotes(Integer.parseInt(splitLine[1]));
						}
					}
				}
			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.err.println("File could not be found");
			System.exit(1);
		}
	}
}
