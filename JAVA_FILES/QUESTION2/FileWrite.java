package QUESTION2;

/*Create a class FileWrite having main method. Read 5 lines from user.
Write these lines to a file letter.txt. Display the size of the file. Read the
contents of the file and display them on console. Delete letter.txt file*/
import java.util.*;
import java.io.*;
public class FileWrite {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		String st;
		int i;
		File new_file= new File("C:\\Users\\PRANJAL\\Desktop\\JAVA_FILES\\letter.txt");
		if(!new_file.exists()){
		try{
			new_file.createNewFile();
		}
		catch(IOException e){
			System.out.println("File could not be created due to an exception");
		}
	}
	System.out.println("Enter five line, more than that will be discarded");
	try{
		FileWriter f_write= new FileWriter(new_file);
		BufferedWriter b_write = new BufferedWriter((f_write));
		for(i=0;i<5;i++){
			st = sc.nextLine();
			b_write.write(st);
			b_write.newLine();
		}
		b_write.close();
		System.out.println("All lines have been written successfully!!");
	}
	catch(Exception e){
		System.out.println("File writing could not be completed due to an exception!!");
		return;
	}
	System.out.println("The size of file (in bytes) is:"+new_file.length());
	System.out.println("Contents of file are as follows: ");
	Scanner f_read = null;
	try{
		f_read = new Scanner(new_file);
		while(f_read.hasNextLine()){
		System.out.println(f_read.nextLine());
	}
		f_read.close();
	}
	catch(Exception e){
		System.out.println("Problem occurred in reading the file!!");
		return;
	}
	System.out.println("Want to delete the file?(y/n)");
	st = sc.next();
	if(st.equals("y")){
		if(new_file.delete())
			System.out.println("File deleted");
		else{
			System.out.println("Problem occurred while deleting the file");
		}
	}
	}
}
