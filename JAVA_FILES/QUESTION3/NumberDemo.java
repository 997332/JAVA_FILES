/*Create a class NumberDemo having main method. Ask user to
enter 10 numbers. Store all these numbers in a file number.txt.
Read all numbers, check whether a number is Even or Odd. Store all
even numbers in a file even.txt and all odd numbers in a file odd.txt.*/
import java.util.*;
import java.io.*;
public abstract class NumberDemo {
public static void main(String args[]){
	System.out.println("Enter 10 numbers:");
	File new_file = new File("C:\\Users\\PRANJAL\\Desktop\\JAVA_FILES\\number.txt");
	int i;
	int num;
    FileWriter f_write = null;
    Scanner sc = new Scanner(System.in);
    try{
    	f_write = new FileWriter(new_file);
    	BufferedWriter b_write = new BufferedWriter((f_write));
    	for(i=0;i<10;i++){
    		num = sc.nextInt();
    		b_write.write(Integer.toString(num));
    		b_write.newLine();
    	}
    	b_write.close();
    }
    catch(IOException e){
    	System.out.println("Error occured while writing the numbers to file!!");
    }
    File odd_f = new File("C:\\Users\\PRANJAL\\Desktop\\JAVA_FILES\\odd.txt");
    File even_f = new File("C:\\Users\\PRANJAL\\Desktop\\JAVA_FILES\\even.txt");
    FileWriter fw_o=null,fw_e=null;
    if(!odd_f.exists()){
    	try{
    		odd_f.createNewFile();
    	}
    	catch(IOException e){
    	System.out.println("Error occurred while creating the odd file");
    	}
    }
    if(!even_f.exists()){
    	try{
    		even_f.createNewFile();
    	}
    	catch(IOException e){
    	System.out.println("Error occurred while creating the even file");
    	}
    }
    Scanner f_read = null;
    try{
    	f_read = new Scanner(new_file);
    }
    catch(Exception e){
    	System.out.println("Error occured while reading the number file");
    }
    try{
    	fw_o = new FileWriter(odd_f);
    	fw_e = new FileWriter(even_f);
    	BufferedWriter bw_o = new BufferedWriter((fw_o));
    	BufferedWriter bw_e = new BufferedWriter((fw_e));
    	while(f_read.hasNextInt()){
    		int no = f_read.nextInt();
    		if(no%2==0){
    			try{
    				bw_e.write(Integer.toString(no));
    				bw_e.newLine();
    			}
    			catch(Exception e){
    				System.out.println("Error!!");
    			}
    		}
    		else{
    			try{
    				bw_o.write(Integer.toString(no));
    				bw_o.newLine();
    			}
    			catch(Exception e){
    				System.out.println("Error!!");
    			}
    		}
    	}
    	bw_o.close();
    	bw_e.close();
    	f_read.close();
    	System.out.println("Numbers stored as per odd and even");
    }
    catch(Exception e){
    	System.out.println("Could not store numbers as per requirement!1");
    }
	}
}

