import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Simulation {

	List<Individual> population;
	int encounter;
	int popSize;
	int percentHawks;
	int numHawks;
	int resourceAmt;
	int costHawkHawk;

	Scanner scanner;

	public Simulation(Integer popSize, Integer percentHawks, Integer resourceAmt, Integer costHawkHawk) {
		this.encounter = 0;
		this.population = new ArrayList<Individual>(popSize);
		double ratio = ((double) percentHawks / 100.0);
		this.numHawks = (int) ((double) popSize * ratio);
		
		for (int i = 0; i < popSize - numHawks; i++) {
			population.add(new Dove(i));
		}
		
		for (int i = popSize - numHawks; i < popSize; i++) {
			population.add(new Hawk(i, costHawkHawk));
		}
		
		Collections.shuffle(population);
		
		this.percentHawks = percentHawks;
		this.resourceAmt = resourceAmt;
		this.costHawkHawk = costHawkHawk;
	}

	public void showMenu() {
		System.out.println("===============MENU=============");
		System.out.println("1 ) Starting Stats");
		System.out.println("2 ) Display Individuals and Points");
		System.out.println("3 ) Display Sorted");
		System.out.println("4 ) Have 1000 interactions");
		System.out.println("5 ) Have 10000 interactions");
		System.out.println("6 ) Have N interactions");
		System.out.println("7 ) Step through interactions \"Stop\" to return to menu");
		System.out.println("8 ) Quit");
		System.out.println("================================");
	}

	public void waitForInput() {
		if (scanner == null) {
			scanner = new Scanner(System.in);
		}

		// blocks until
		int option = scanner.nextInt();

		switch (option) {
		case 1:
			displayStartingStats();
			break;
		case 2:
			displayScores();
			break;
		case 3:
			displaySorted();
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			break;
		case 8:
			System.exit(0);
			return;
		}
		
		waitForInput();
	}

	public void displayStartingStats() {
		System.out.println("Population size: " + popSize);
		System.out.println("Percentage of Hawks: " + percentHawks + "%");
		System.out.println("Number of Hawks: " + numHawks);
		System.out.println("");
		System.out.println("Percentage of Doves: " + (100 - percentHawks) + "%");
		System.out.println("Number of Doves: " + (popSize - numHawks));
		System.out.println("");
		System.out.println("Each resource is worth: " + resourceAmt);
		System.out.println("Cost of Hawk-Hawk interaction: " + costHawkHawk);
	}
	
	public void displayScores() {
		int alive = 0;
		
		for (int i = 0; i < population.size(); i++) {
			Individual indiv = population.get(i);
			
			if (!indiv.isDead()) {
				alive++;
				System.out.println(String.format("Individual[%d]=%s:%d", i, indiv.getType(), indiv.getResource()));
			} else {
				System.out.println(String.format("Individual[%d]=DEAD:%d", i, indiv.getResource()));
			}
		}
		
		System.out.println("Living: " + alive);
	}
	
	public void displaySorted() {
		List<Individual> copy = new ArrayList<>();
		copy.addAll(population);
		Collections.sort(copy);
		
		for (Individual indiv : copy) {
			System.out.println(indiv.getType() + ":" + indiv.getResource());
		}
	}
	
	public Individual getNext(int index) {
		Individual indiv = population.get(index);
		
		while(indiv.isDead()) {
			indiv = population.get(++index);
		}
		
		System.out.println("Individual " + index + ": " + indiv.getType());
		
		return indiv;
	}
	
	public void stepSimulation() {
		System.out.println("Encounter: " + ++encounter);
		
		int index = 0;
		Collections.shuffle(population);
		Individual one = getNext(index);
		Individual two = getNext(++index);
		
		while (one == two) {
			two = getNext(++index);
		}
		
		if (one.getType().equals("Hawk")) {
			one.compete(two, resourceAmt);
		} else {
			two.compete(one, resourceAmt);
		}
	}
}
