import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {

	public static String readFile(String fileName){
		String inputString;
		try {
			BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
			inputString = fileReader.readLine();
		} catch (Exception e) {
			// TODO: handle exception
			inputString = e.getMessage();
		}
		return  inputString;
	}
	public static boolean writeInFile(String fileName , String dataString){
		try {
			BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName, true));

			Date date = new Date();
			String dateFormation = "dd/mm/yyyy-hh:mm:ss a";
			DateFormat dateFormat = new SimpleDateFormat(dateFormation);
			String dateString = dateFormat.format(date);
			fileWriter.write(", " + dataString + "\nList last updated on " + dateString);
			fileWriter.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
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

					String inpuString = readFile("students.txt");
					String nameList[] = inpuString.split(",");
					for (String name : nameList) {
						System.out.println(name);
					} 
				System.out.println(constantsLitarals.LOADED_MESSAGE);
			}
			else if (args[0].equals("r")) 
			{
				System.out.println(constantsLitarals.LOADING_MESSAGE);

					String inpuString = readFile("students.txt");
					String i[] = inpuString.split(",");
					Random randomNumber = new Random();
					System.out.println(i[randomNumber.nextInt()]);
				System.out.println(constantsLitarals.LOADED_MESSAGE);
			} 
			else if (args[0].contains("+")) 
			{
				System.out.println(constantsLitarals.LOADING_MESSAGE);
				String readedString = args[0].substring(1);
				writeInFile("students.txt", readedString);
				System.out.println(constantsLitarals.LOADED_MESSAGE);
			} 
			else if (args[0].contains("?")) 
			{
				System.out.println(constantsLitarals.LOADING_MESSAGE);

					String r = readFile("students.txt");
					String i[] = r.split(",");
					String name = args[0].substring(1);
					for(String nme:i){
						if(nme.equals(name)){
							System.out.println(constantsLitarals.FOUND_MESSAGE);
							break;
						}
					}
				System.out.println(constantsLitarals.LOADED_MESSAGE);
			} 
			else if (args[0].contains("c")) 
			{
			System.out.println(constantsLitarals.LOADING_MESSAGE);
				String D = readFile("students.txt");
				char a[] = D.toCharArray();
				String words[] = D.split(",");
				System.out.println(words.length + " word(s) found " + a.length);

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