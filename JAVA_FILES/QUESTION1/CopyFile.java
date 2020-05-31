/*Create a class CopyFile having main method. Provide source file and
destination file
names as command line arguments or Input user. Perform following
functionality:
 Program should copy contents of source file to destination file
 If source file does not exist, display appropriate error message
 If destination file does not exist, it should be created.
 If destination file already exist, program should ask Want to Overwrite?
(yes/no). If user selects Yes then overwrite otherwise do not overwrite*/

import java.io.*;
import java.util.*;

public class CopyFile {
	public void c_file(File src_f, File dest_f){
		Scanner f_read;
		// Reading the source file
		try{
			f_read = new Scanner(src_f);
		}
		catch(FileNotFoundException e){
			System.out.println("File which has to be copied is not found");
			return;
		}
		if(dest_f.exists()==true){
			System.out.println("FILE ALREADY EXIST!!!");
			System.out.println("Want to overwrite the file?(y/n)");
			String opt;
			Scanner sc = new Scanner(System.in);
			opt = sc.next();
			if(opt.equals("y")){
				try{
					FileWriter f_write=new FileWriter(dest_f);
					int i;
					while(f_read.hasNextLine()){
						f_write.write(f_read.nextLine());
					 }
					 f_write.close();
					 System.out.println("File overwritten successfully");
				}
				catch(Exception e){
				System.out.println("A problem occured while writing the file");
				return;
				}
			}
			else{
				System.out.println("User does not want the file to get copied or ovewritten.");
				return;
			}
		}
		else{
			try{
				dest_f.createNewFile();
				try{
					FileWriter f_write=new FileWriter(dest_f);
					int i;
					while(f_read.hasNextLine()){
						f_write.write(f_read.nextLine());
				}
				System.out.println("Contents copied to the new destination file");
				}
				catch(Exception e){
					System.out.println("File created, but copying of contents was unsuccesfull");
				}
			}
			catch (IOException e){
				System.out.println("Destination file was not created due to an exception");
			}
		}

	}
	public static void main(String[] args){
		File s1_file = new File("C:\\Users\\PRANJAL\\Desktop\\JAVA_FILES\\Source_file.txt");
		File s2_file = new File("C:\\Users\\PRANJAL\\Desktop\\JAVA_FILES\\Source_file2.txt");
		File d_file = new File("C:\\Users\\PRANJAL\\Desktop\\JAVA_FILES\\Destination_file.txt");
		CopyFile obj = new CopyFile();
		obj.c_file(s1_file,d_file);
		obj.c_file(s2_file,d_file);
		}

}
	
