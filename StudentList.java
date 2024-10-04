import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
	public static void main(String[] args) {
		Constants constantsLitarals = new Constants();

		boolean isValidArg = true;
		// Check arguments
		while(isValidArg)
		{
			isValidArg = false;
			if (args[0].equals("a")) 
			{
				System.out.println(constantsLitarals.LOADING_MESSAGE);
				try 
				{
					BufferedReader fileReader = new BufferedReader(
							new InputStreamReader(
									new FileInputStream("students.txt")));
					String inpuString = fileReader.readLine();
					String nameList[] = inpuString.split(",");
					for (String name : nameList) {
						System.out.println(name);
					}
				} catch (Exception e) {
				}
				System.out.println(constantsLitarals.LOADED_MESSAGE);
			}
			else if (args[0].equals("r")) 
			{
				System.out.println(constantsLitarals.LOADING_MESSAGE);
				try 
				{
					BufferedReader s = new BufferedReader(
							new InputStreamReader(
									new FileInputStream("students.txt")));
					String r = s.readLine();
					System.out.println(r);
					String i[] = r.split(",");
					Random x = new Random();
					int y = x.nextInt();
					System.out.println(i[y]);
				}
				catch (Exception e) 
				{
				}
				System.out.println("Data Loaded.");
			} 
			else if (args[0].contains("+")) 
			{
				System.out.println("Loading data ...");
				try 
				{
					BufferedWriter fileWriter = new BufferedWriter(
							new FileWriter("students.txt", true));
					String readedString = args[0].substring(1);
					Date date = new Date();
					String dateFormation = constantsLitarals.DATE_FORMATE;
					DateFormat dateFormat = new SimpleDateFormat(dateFormation);
					String dateString = dateFormat.format(date);
					fileWriter.write(", " + readedString + "\nList last updated on " + dateString);
					fileWriter.close();
				} 
				catch (Exception e) 
				{
				}

				System.out.println(constantsLitarals.LOADED_MESSAGE);
			} 
			else if (args[0].contains("?")) 
			{
				System.out.println(constantsLitarals.LOADING_MESSAGE);
				try 
				{
					BufferedReader s = new BufferedReader(
							new InputStreamReader(
									new FileInputStream("students.txt")));
					String r = s.readLine();
					String i[] = r.split(",");
					boolean done = false;
					String t = args[0].substring(1);
					for (int idx = 0; idx < i.length && !done; idx++) 
					{
						if (i[idx].equals(t)) 
						{
							System.out.println(constantsLitarals.FOUND_MESSAGE);
							done = true;
						}
					}
				} 
				catch (Exception e) 
				{
				}
				System.out.println(constantsLitarals.LOADED_MESSAGE);
			} 
			else if (args[0].contains("c")) 
			{
			System.out.println(constantsLitarals.LOADING_MESSAGE);
			try 
			{
				BufferedReader s = new BufferedReader(
						new InputStreamReader(
								new FileInputStream("students.txt")));
				String D = s.readLine();
				char a[] = D.toCharArray();
				boolean in_word = false;
				int count = 0;
				for (char c : a) {
					if (c == ' ') {
						if (!in_word) {
							count++;
							in_word = true;
						} else {
							in_word = false;
						}
					}
				}
				System.out.println(count + " word(s) found " + a.length);
			} 
			catch (Exception e) 
			{
			}
			System.out.println(constantsLitarals.LOADED_MESSAGE);
		}
		else
		{
			System.out.println("The argument is invalid please give an valid argument :(a,r,c,?studentName,+studentName) ");
			Scanner takeString = new Scanner(System.in);
			String inputString = takeString.nextLine();
			args = inputString.split("//s+");
			isValidArg = true;
		}
		}	
	}
}