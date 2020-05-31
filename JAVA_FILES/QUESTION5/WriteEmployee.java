/*Create a class Employee having members as follows:
private int empNo
private String empName
private int empBasic
Parameterized constructor to initialize members. Getter methods for all
instance
variables
Create a class WriteEmployee having main method. Ask user to enter details of
an
employee and set them in an Employee object. Store details of this object in
a file
emp.txt.
Read employee details from the file and display those details. (Object
Serialization)*/

import java.util.*;
import java.io.*;
public class WriteEmployee {
	public void update_info(File new_file){
		FileWriter f_write = null;
		BufferedWriter b_write = null;
		Scanner sc = new Scanner(System.in);
		try{
			f_write = new FileWriter(new_file);
			b_write = new BufferedWriter(f_write);
			while(true){
				System.out.println("Enter details of an employee: ");
				System.out.println("In order of (NAME/BASIC/NUMBER)");
				String s;
				int basic,no;
				s = sc.nextLine();
				basic = sc.nextInt();
				no = sc.nextInt();
				Employee e = new Employee(no,s,basic);
				b_write.write("Employee Number: ");
				b_write.write(Integer.toString(e.getEmpNo()));
				b_write.newLine();
				b_write.write("Employee Name: ");
				b_write.write(e.getEmpName());
				b_write.newLine();
				b_write.write("Employee Basic Salary: ");
				b_write.write(Integer.toString(e.getEmpBasic()));
				b_write.newLine();
				b_write.newLine();
				System.out.println("Do you want to add details of more employees (y/n) :");
							String answer = sc.next();
						if(!answer.equals("y")){
							b_write.close();
							System.out.println("DETAILS UPDATED SUCCESSFULLY!!");
							break;
						}
			}
		}
		catch(Exception err){
			System.out.println("Error occured while writing employee's details to file");
		}
	}
	public void read_info(File new_file){
		Scanner f_read = null;
		try{
			f_read = new Scanner(new_file);
			int i=0;
			while(f_read.hasNextLine()){
				if(i%4==0)
					System.out.println("----------------");
				System.out.println(f_read.nextLine());
				i+=1;
			}
		}
		catch(Exception e){
			System.out.println("Error occurred while reading the file!!");
		}
	}
	public static void main(String args[]){
		File new_file = new File("C:\\Users\\PRANJAL\\Desktop\\JAVA_FILES\\emp.txt");
		if(!new_file.exists()){
			try{
				new_file.createNewFile();
			}
			catch(IOException er){
				System.out.println("An error occurred while creating the file");
			}
		}
		WriteEmployee obj = new WriteEmployee();
		obj.update_info(new_file);
		obj.read_info(new_file);
	}
}
