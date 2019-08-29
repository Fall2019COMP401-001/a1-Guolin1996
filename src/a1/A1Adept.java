package a1;

//import java.text.DecimalFormat;
import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		//Store
		Store store = new Store(scan.nextInt());
		for(int i = 0; i < store.getS_item_num(); i++) {
			store.getS_Item()[i] = new A_Item();
			store.getS_Item()[i].setI_name(scan.next());
			store.getS_Item()[i].setPrice(scan.nextDouble());
		}
		store.setS_cus_num(scan.nextInt());
		store.setS_Customer();
		
		for(int i = 0; i < store.getS_cus_num(); i++) {
			store.getS_Customer()[i] = new A_Customer();
			store.getS_Customer()[i].setF_name(scan.next());
			store.getS_Customer()[i].setL_name(scan.next());
			store.getS_Customer()[i].setI_brought(scan.nextInt());
			store.getS_Customer()[i].setC_item();
			for(int j=0; j < store.getS_Customer()[i].getI_brought(); j++) {
				store.getS_Customer()[i].getC_item()[j] = new A_Item();
				store.getS_Customer()[i].getC_item()[j].setI_num(scan.nextInt());
				store.getS_Customer()[i].getC_item()[j].setI_name(scan.next());
				for(int p=0; p < store.getS_item_num(); p++) {
					if(store.getS_Customer()[i].getC_item()[j].getI_name().equals(store.getS_Item()[p].getI_name()))
					{
						store.getS_Customer()[i].getC_item()[j].setPrice(store.getS_Item()[p].getPrice());
					}
				}
			}
			store.getS_Customer()[i].setT_cost();
		}
		A_out(store);	
	}
	
	public static void A_out(Store store){
		String Biggest = null;
		int b = 0;
		String Smallest = null;
		int s = 0;
		double Average = 0;
//		DecimalFormat df = new DecimalFormat("0.00");
		
			A_Customer[] sort_customer = store.getS_Customer();
			for(int j = 1; j< sort_customer.length; j++) {
				if(sort_customer[j].getT_cost() >= sort_customer[b].getT_cost()) {
					b = j;
				}
				if(sort_customer[j].getT_cost() <= sort_customer[s].getT_cost()) {
					s = j;
				}
			}
			Biggest = "Biggest: " + sort_customer[b].getF_name() + " " + sort_customer[b].getL_name() + " ("
					+ String.format("%.2f", sort_customer[b].getT_cost()) + ")";
			Smallest = "Smallest: " + sort_customer[s].getF_name() + " " + sort_customer[s].getL_name() + " ("
					+ String.format("%.2f", sort_customer[s].getT_cost()) + ")";
			
			for(int m = 0; m < sort_customer.length; m++) {
				Average += sort_customer[m].getT_cost();
			}
			Average = Average / sort_customer.length;
		System.out.println(Biggest);
		System.out.println(Smallest);
		System.out.println("Average: " + String.format("%.2f",Average));
	}
}

class Store{
	private int S_item_num;//item type num
	private int S_cus_num;
	private A_Item[] S_Item;
	private A_Customer[] S_Customer;
	
	public Store(int i) {
		setS_item_num(i);
		setS_Item();
	}
	
	public int getS_item_num() {
		return S_item_num;
	}
	public void setS_item_num(int s_item_num) {
		S_item_num = s_item_num;
	}
	
	public A_Item[] getS_Item() {
		return S_Item;
	}
	public void setS_Item() {
		S_Item = new A_Item[S_item_num];
	}

	
	public int getS_cus_num() {
		return S_cus_num;
	}

	public void setS_cus_num(int s_cus_num) {
		S_cus_num = s_cus_num;
	}

	public A_Customer[] getS_Customer() {
		return S_Customer;
	}

	public void setS_Customer() {
		S_Customer = new A_Customer[S_cus_num];
	}

	
}

class A_Item{
	private int I_num; //item num
	private String I_name;
	private double price;
	
	//double I_amount;
	public int getI_num() {
		return I_num;
	}
	public void setI_num(int i_num) {
		I_num = i_num;
	}
	public String getI_name() {
		return I_name;
	}
	public void setI_name(String i_name) {
		I_name = i_name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}

class A_Customer{
	private String F_name;
	private String L_name;
	private int I_brought;
	private A_Item[] C_item;
	private double T_cost = 0;
	
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
	public int getI_brought() {
		return I_brought;
	}
	public void setI_brought(int i_brought) {
		I_brought = i_brought;
	}
	public A_Item[] getC_item() {
		return C_item;
	}
	public void setC_item() {
		C_item = new A_Item[I_brought];
	}
	public double getT_cost() {
		return T_cost;
	}
	public void setT_cost() {
		for(int i =0; i < C_item.length; i++) {
			T_cost += C_item[i].getPrice() * C_item[i].getI_num();
		}
	}
	
	
}