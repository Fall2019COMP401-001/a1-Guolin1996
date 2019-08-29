package a1;

import java.util.Scanner;
//import java.text.DecimalFormat;   

public class A1Novice {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		// Your code follows here.

		//read num of customer and new array
		int t_customer = scan.nextInt();
		Customer[] customer = new Customer[t_customer];
		
		for(int i = 0; i < customer.length; i++) {
			//instantiate
			customer[i] = new Customer();
			//enter c info
			customer[i].setFname(scan.next());
			customer[i].setLname(scan.next());
			//item number of specific c 
			int I_count = scan.nextInt();
			customer[i].setIcount(I_count);
			//enter item info
			Item[] item = new Item[I_count];
			for(int j = 0; j < I_count; j++) {
				item[j] = new Item();
				//count of the item
				item[j].setTotal(scan.nextInt());
				item[j].setI_name(scan.next());
				item[j].setI_price(scan.nextDouble());
				//amount money of 1 item
				item[j].setI_amount();
			}
			customer[i].setCitem(item);
		}
		
		for(int i=0; i< customer.length; i++) {
			//print out result
			C_out(customer[i]);
		}
		
	}
		
	public static void C_out(Customer c) {
		//total cost to two decimal places
//		DecimalFormat df = new DecimalFormat("0.00");
		//select initial
		System.out.print(c.getFname().substring(0,1) + ". ");
		System.out.print(c.getLname() + ": ");
		double total_cost = 0;
		for(int i = 0; i < c.getIcount(); i++) {
			total_cost += c.getCitem()[i].getI_amount();
		}
		System.out.println(String.format("%.2f", total_cost) + ": ");
		
	}
}

class Customer{
	private String F_name;
	private String L_name;
	private int I_count;
	private Item[] C_item;
	
	public Customer() {};

	public String getFname() {
		return F_name;
	}
	public void setFname(String name) {
		F_name = name;
	}
	
	public String getLname() {
		return L_name;
	}
	public void setLname(String name) {
		L_name = name;
	}
	
	public int getIcount() {
		return I_count;
	}
	public void setIcount(int count) {
		I_count = count;
	}
	
	public Item[] getCitem() {
		return C_item;
	}
	public void setCitem(Item[] item) {
		C_item = item;
	}
}

class Item{
	private String I_name;
	private int total;
	private double I_price;
	private double I_amount;
	
	public Item() {}
	
	public double getI_amount() {
		return I_amount;
	}
	
	public void setI_amount() {
		I_amount = I_price * total;
		}

	public String getI_name() {
		return I_name;
	}
	public void setI_name(String i_name) {
		I_name = i_name;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public double getI_price() {
		return I_price;
	}
	public void setI_price(double i_price) {
		I_price = i_price;
	}
}
