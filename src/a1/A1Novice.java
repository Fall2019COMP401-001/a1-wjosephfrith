package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		//*a class for each item that a customer buys
		
		class Items {
			int quant = 0;
			String nam = "";
			double price = 0.0;
			
			Items(int quant, String nam, double price) {
				this.quant = quant;
				this.nam = nam;
				this.price = price;
			}
		}
	
		//*a class for each individual customer
		
		class Customer {
		   String first;
		   char firstInit;
		   String last;
		   int num;
		   Items[] items;
//		   double price = 0.0;
		   

		   Customer(String first, String last, int num)
		   {
		      this.first = first;
		      this.firstInit = first.charAt(0);
		      this.last = last;
		      this.num = num;
		      this.items = new Items[num];
//		      this.price = pricePer(this);
		   }
		   
		   char firstInit(String name) {
			   return name.charAt(0);
		   }
		   
		   //*method for finding the total cost per customer
		   
		   double pricePer(Customer cust) {
				double total = 0;
				for (int i=0; i<cust.items.length; i++) {
					total += cust.items[i].quant * cust.items[i].price;
				}
				return total;
			}
		}
		
		int count = scan.nextInt();
		
		//*initialization for the array of customers
		
		Customer[] customers = new Customer[count];
		
		//*fill in the array of customers
		
		for (int i=0; i<customers.length; i++) {
			customers[i] = new Customer(scan.next(), scan.next(), scan.nextInt());
//			customers[i].first = scan.next();
//			customers[i].last = scan.next();
//			customers[i].num = scan.nextInt();
			customers[i].items = new Items[customers[i].num];
			
			//*fill in items for each customer
			
			for (int n=0; n<customers[i].items.length; n++) {
				customers[i].items[n] = new Items(scan.nextInt(), scan.next(), scan.nextDouble());
//				customers[i].items[n].quant = scan.nextInt();
//				customers[i].items[n].nam = scan.next();
//				customers[i].items[n].price = scan.nextInt();
			}
		}
		
		
		
		scan.close();
		
		//*print out the finished product
		for (int i=0; i<customers.length; i++) {
			System.out.println(customers[i].firstInit(customers[i].first) + ". " + customers[i].last + ": " + String.format("%.2f", customers[i].pricePer(customers[i])));
		}
	}
				
}


