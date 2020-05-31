package com.product;
import java.util.*;
import java.io.*;
public class ProductDemo {
public static void main(String args[]){
	Product[] arr = new Product[10];
	File file = new File("C:\\Users\\PRANJAL\\Desktop\\JAVA_FILES\\product.txt");
	FileReader f_read = null;
	try{
		f_read = new FileReader(file);
	}
	catch(Exception e){
		System.out.println("Could not read product file!!");
	}
	BufferedReader b_read = new BufferedReader(f_read);
	String first_line = null;
	try{
		first_line = b_read.readLine();
	}
	catch(Exception e){
		System.out.println("First line is not read!!");
	}
	Scanner scr = null;
	int i=0;
	try{
		scr = new Scanner(file);
		while(scr.hasNextLine()){
			String text = scr.nextLine();
			if(!text.equals(first_line)){
				String[] str_arr = text.split(", ");
				arr[i] = new Product();
				arr[i].setProdName(str_arr[1]);
				arr[i].setProdNo(Integer.parseInt(str_arr[0]));
				arr[i].setProdPrice(Integer.parseInt(str_arr[2]));
				i = i+1;
			}
		}
		int j=0;
		System.out.println("PRODUCT DETAILS :");
		for(j=0;j<i;j++){
			System.out.println("PRODUCT NAME:"+arr[j].getProdName());
			System.out.println("PRODUCT NO:"+arr[j].getProdNo());
			System.out.println("PRODUCT PRICE:"+arr[j].getProdPrice());
		}
	}
	catch(Exception e){
		System.out.println("File could not be read");
	}
	System.out.println("Enter the price:");
	Scanner sc = new Scanner(System.in);
	double pr;
	pr = sc.nextDouble();
	int j=0;
	for(j=0;j<i;j++){
		double prod_price = arr[j].getProdPrice();
		if(prod_price<=pr){
			System.out.println("PRODUCT NAME:"+arr[j].getProdName());
			System.out.println("PRODUCT NO:"+arr[j].getProdNo());
			System.out.println("PRODUCT PRICE:"+arr[j].getProdPrice());
			System.out.println("\n");
		}
	}
	System.out.println("Enter the name of product: ");
	String user_name;
	boolean f=false;
	user_name = sc.next();
	for(j=0;j<i;j++){
		if(user_name.equals(arr[j].getProdName())){
			f=true;
			System.out.println("PRODUCT NAME:"+arr[j].getProdName());
			System.out.println("PRODUCT NO:"+arr[j].getProdNo());
			System.out.println("PRODUCT PRICE:"+arr[j].getProdPrice());
			System.out.println("\n");
		}
	}
	if(f==false){
		System.out.println("Product is not present in the stock!!");
	}
	}
}
