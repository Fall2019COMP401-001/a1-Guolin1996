package a1;

import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		J_Store store = new J_Store(scan.nextInt());
		for(int i=0; i<store.getS_Item().length; i++ ) {
			store.getS_Item()[i] = new J_Item();
			store.getS_Item()[i].setI_name(scan.next());
			store.getS_Item()[i].setI_price(scan.nextDouble());
		}
		store.setCustomer(scan.nextInt());
		for(int j=0; j<store.getCustomer().length; j++) {
			store.getCustomer()[j] = new J_Customer();
			store.getCustomer()[j].setF_name(scan.next());
			store.getCustomer()[j].setL_name(scan.next());
			store.getCustomer()[j].setC_item(scan.nextInt());
			for(int m=0; m<store.getCustomer()[j].getC_item().length; m++) {
				store.getCustomer()[j].getC_item()[m] = new J_Item();
				store.getCustomer()[j].getC_item()[m].setI_quantity(scan.nextInt());
				store.getCustomer()[j].getC_item()[m].setI_name(scan.next());
//				for(int i=0; i<store.getS_Item().length; i++ ) {
//					if(store.getCustomer()[j].getC_item()[m].getI_name().equals(store.getS_Item()[i].getI_name())) {
//						store.getCustomer()[j].getC_item()[m].setI_price(store.getS_Item()[i].getI_price());
//					}
//						
//				}
			}
		}
		
		J_out(store);		
	}

	private static void J_out(J_Store store) {
		// TODO Auto-generated method stub
		for(int i=0; i<store.getS_Item().length; i++ ) {
			int num = 0;
			int quantity = 0;
			for(int j=0; j<store.getCustomer().length; j++) {
				for(int p=0; p<store.getCustomer()[j].getC_item().length; p++) {
					if(store.getS_Item()[i].getI_name().equals(store.getCustomer()[j].getC_item()[p].getI_name())){
						num++;
						quantity += store.getCustomer()[j].getC_item()[p].getI_quantity();
						break;
					}
				}
			}
			if(num != 0)
			 System.out.println(num + " customers bought " + quantity + " " + store.getS_Item()[i].getI_name());
			else
				System.out.println("No customers bought " + store.getS_Item()[i].getI_name());
			
		}
	}
	
}

class J_Store{
	private J_Item[] S_Item;
	private J_Customer[] Customer;
	
	J_Store(int i){
		setJ_Item(i);
	}
	
	public J_Item[] getS_Item() {
		return S_Item;
	}
	public void setJ_Item(int i) {
		S_Item = new J_Item[i];
	}
	public J_Customer[] getCustomer() {
		return Customer;
	}
	public void setCustomer(int j) {
		Customer = new J_Customer[j];
	}
}

class J_Item{
	private String I_name;
	private double I_price;
	private int I_quantity;
	
	public String getI_name() {
		return I_name;
	}
	public void setI_name(String i_name) {
		I_name = i_name;
	}
	public double getI_price() {
		return I_price;
	}
	public void setI_price(double i_price) {
		I_price = i_price;
	}
	public int getI_quantity() {
		return I_quantity;
	}
	public void setI_quantity(int i_quantity) {
		I_quantity = i_quantity;
	}
	
}

class J_Customer{
	private String F_name;
	private String L_name;
	private J_Item[] C_item;
	
	public String getF_name() {
		return F_name;
	}
	public void setF_name(String f_name) {
		F_name = f_name;
	}
	public String getL_name() {
		return L_name;
	}
	public void setL_name(String l_name) {
		L_name = l_name;
	}
	public J_Item[] getC_item() {
		return C_item;
	}
	public void setC_item(int i) {
		C_item = new J_Item[i];
	}
}