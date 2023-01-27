package come.velocity.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class Test {
	static int marks = 0;
	// question one with answers
	final static String q_one = "Choose Correct Answer form  the options\n>> 5+5 ?\nOptions>>\n1)5\n2)10\n3)7\n4)0";
	// question two with answers

	final static String q_two = "Choose Correct Answer form  the options\n>> 5-5 ?\nOptions>>\n1)0\n2)5\n3)7\n4)8";
	// question three
	final static String q_three = "Choose Correct Answer form  the options\n>> 5/5 ?\nOptions>>\n1)5\n2)\n3)1\n4)0";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome To Quiz Compition.....");
		System.out.print("Enter Your Mobile number.....");
		String StudMono = sc.nextLine();
		if(StudMono.length()==10) {
			StudMono=StudMono;
			
		}else {
			System.err.println("mobile Number is not valid");
		}
		System.out.println("Enter Your Name...");
		String StudName = sc.next();
		System.out.println("Enter Your Age...");
		int StudAge = sc.nextInt();
		
		if (StudAge >= 18) {
			System.out.println("You are Elegible");

			System.out.println("Wait your Quiz test is Loading.....");
			System.err.println(q_one);
			int q1 = sc.nextInt();
			if (q1 == 2) {
				marks++;
			} else {
				marks = marks;
			}
			System.err.println(q_two);
			int q2 = sc.nextInt();
			if (q2 == 1) {
				marks++;
			} else {
				marks = marks;
			}

			System.err.println(q_three);
			int q3 = sc.nextInt();
			if (q3 == 3) {
				marks++;
			} else {
				marks = marks;
			}
		}else {
			System.out.println("you are not eligible for the quiz");
		}
		//inserting into mysql
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
			Statement statement = con.createStatement();
			PreparedStatement stmt = con.prepareStatement("insert into patricipent(StudMono,StudName,StudAge,marks)"
														+ "values(?,?,?,?)");
			stmt.setString(1,StudMono ); 
			 stmt.setString(2, StudName);
			 stmt.setInt(3,StudAge );
			 stmt.setInt(4,marks );
			 int i=stmt.executeUpdate();
			 System.out.println("Insertion successfully...");
			 con.close();
			 statement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Nmae"+StudName+"\nMarks>>"+marks);
	}
}