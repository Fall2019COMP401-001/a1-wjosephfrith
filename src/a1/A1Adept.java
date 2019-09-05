package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		//*initiate the number of items in the store
		
		int num = scan.nextInt();
		
		//*class for each individual item in the store
		
		class Grocery {
			String name;
			double price;
			
			Grocery(String name, double price){
				this.name = name;
				this.price = price;
			}
		}
		
		//*items without pricetags
		
		class Priceless {
			String name;
			int quant;
			
			Priceless(int quant, String name){
				this.name = name;
				this.quant = quant;
			}
		}
		
		//*create the array of groceries in the store
		
		Grocery[] groceryStore = new Grocery[num];
		
		//*fill in the array of groceries in the store
		
		for(int i=0; i<groceryStore.length; i++) {
			groceryStore[i] = new Grocery(scan.next(), scan.nextDouble());
		}
		
		//*class for each customer
		
		class Customer {
			String first;
			String last;
			int quant;
			Priceless[] groceries;
			
			Customer(String first, String last, int quant) {
				this.first = first;
				this.last = last;
				this.quant = quant;
				this.groceries = new Priceless[quant];
			}
			
			//*helper method to find total spent by customer
			
			double total(Customer cust) {
				double sum = 0.0;
				
				for(int i=0; i<cust.groceries.length; i++) {
					for(int n=0; n<groceryStore.length; n++) {
						if(cust.groceries[i].name.contentEquals(groceryStore[n].name)) {
							sum += groceryStore[n].price * cust.groceries[i].quant;
						}
					}
				}
				return sum;
			}
			
			//*helper method to find the biggest spender
			
			Customer big(Customer[] customers) {
				int index = -1;
				boolean firstTime = true;
				for(int i=0; i<customers.length; i++) {
					if(firstTime) {
						firstTime = false;
						index = i;
					} else if(customers[i].total(customers[i])>customers[index].total(customers[index])) {
						index = i;
					}
				}
				return customers[index];
			}
			
			//*helper method to find the smallest spender
			
			Customer small(Customer[] customers) {
				int index = -1;
				boolean firstTime = true;
				for(int i=0; i<customers.length; i++) {
					if(firstTime) {
						firstTime = false;
						index = i;
					} else if(customers[i].total(customers[i])<customers[index].total(customers[index])) {
						index = i;
					}
				}
				return customers[index];
			}
			
			//*helper method to find the smallest spender
			
			double average(Customer[] customers) {
				double avg = 0;
				double total = 0;
				for(int i=0; i<customers.length; i++) {
					 total += customers[i].total(customers[i]);
				}
				avg = total / customers.length;
				return avg;
			}
		}
		
		//*create array and add the customers in
		
		Customer[] custs = new Customer[scan.nextInt()];
		for(int i=0; i<custs.length; i++) {
			custs[i] = new Customer(scan.next(), scan.next(), scan.nextInt());
			for(int n=0; n<custs[i].quant; n++) {
				custs[i].groceries[n] = new Priceless(scan.nextInt(), scan.next());
			}
		}
		
		//*print the final output
		
		System.out.println("Biggest: " + custs[0].big(custs).first + " " + custs[0].big(custs).last + " (" + String.format("%.2f", custs[0].total(custs[0].big(custs))) + ")");
		System.out.println("Smallest: " + custs[0].small(custs).first + " " + custs[0].small(custs).last + " (" + String.format("%.2f", custs[0].total(custs[0].small(custs))) + ")");
		System.out.println("Average: " + String.format("%.2f", custs[0].average(custs)));
	}
}
