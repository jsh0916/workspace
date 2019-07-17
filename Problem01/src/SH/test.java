package SH;

import java.util.Scanner;

/*
 * In this challenge, we're going to learn about the difference between a class and an instance;
 * because this is an Object Oriented concept, it's only enabled in certain languages.
 * Check out the Tutorial tab for learning materials and an instructional video!
 * 
 * 
   Sample Input

	4
	-1
	10
	16
	18
   Sample Output
	
	Age is not valid, setting age to 0.
	You are young.
	You are young.
	
	You are young.
	You are a teenager.
	
	You are a teenager.
	You are old.
	
	You are old.
	You are old.
 * */
public class test {
	private int age;	
	  
	public test(int initialAge) {
  		// Add some more code to run some checks on initialAge
          age = initialAge;
	}

	public void amIOld() {
  		// Write code determining if this person's age is old and print the correct statement:
        if (age < 0) {
            System.out.println("Age is not valid, setting age to 0.");
            System.out.println("You are young.");
            age = 0;
        } else if (age > 0 && age < 13) {
            System.out.println("You are young.");
        } else if (age >= 13 && age < 18) {
            System.out.println("You are a teenager.");
        } else {
            System.out.println("You are old.");
        }
	}

	public void yearPasses() {
  		age++;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int age = sc.nextInt();
			test p = new test(age);
			p.amIOld();
			for (int j = 0; j < 3; j++) {
				p.yearPasses();
			}
			p.amIOld();
			System.out.println();
        }
		sc.close();
    }
}
