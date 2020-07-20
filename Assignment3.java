package project_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Assignment3 {

	public static void main(String[] args) {
		try {

			EquivalenceSetManager manager = new EquivalenceSetManager();
    		Scanner scanner = new Scanner(new File("data.txt"));

    		while(scanner.hasNextLine()) {
    			manager.add(scanner.next(), scanner.next());
			}
    		System.out.println("ALL SETS:");
			manager.print();

    		System.out.println("\nFIND (a,w):");
    		manager.print("a","w");

			System.out.println("\nFIND (p,j):");
			manager.print("p","j");

			System.out.println("\nFIND (r,t):");
			manager.print("q","t");
		}catch(FileNotFoundException e) {
			System.out.println("data.txt doesn't exist.");
		}
	}

}
