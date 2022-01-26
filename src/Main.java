
import exceptions.InputNotMatch;
import exceptions.MemoryOverflowException;
import utils.*;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws InputNotMatch, MemoryOverflowException {
        // Initialize db helper object to handle the operations to handle the list
        // Initialize DB spaces DATA Object and variable id and total amount.
        DbHelper dbHelper = new DbHelper();
        LinkedList<Data> spaces = new LinkedList<>();
        int totalSpaces = 0;
        int spaceId = 0;
        Scanner scanner = new Scanner(System.in);
        String input = "";
        System.out.println("********* DUMMY DB *********");
        // Initialize loop
        while (true){
            System.out.println("-> Please Enter C(create) for create a new process follow by process type [S]System-[A]Application.\n" +
                    "-> Please Enter D(delete) to delete a process follow by the id of the process.\n" +
                    "-> Please Enter exit if you want to end the app.");
            System.out.print("->>");
            input = scanner.next().toLowerCase();
            Pattern pattern = Pattern.compile("ca|cs|d[0-9]+");

            if (input.equals("exit")){
                break;
            }
            // Handle wrong inputs
            try {
                if(!pattern.matcher(input).matches()){
                    throw  new InputNotMatch("No match any command please enter a right one \n");
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }

            // Handle right input
            try{
                if(input.equals("ca")){
                    spaceId++;
                    int randomNumber=(int)Math.floor(Math.random()*(22-(10+1))+(10));
                    totalSpaces += randomNumber;
                    if(totalSpaces>200){
                        totalSpaces -= randomNumber;
                        throw  new MemoryOverflowException("You exceeded the memory storage \n");
                    }
                    spaces.add(new Data(spaceId,randomNumber,"a"));
                    dbHelper.addToDatabase(spaces);
                    dbHelper.printDb();
                }
                if(input.equals("cs")){
                    spaceId++;
                    int randomNumber=(int)Math.floor(Math.random()*(17-(5+1))+(5));
                    totalSpaces += randomNumber;
                    if(totalSpaces>200){
                        totalSpaces -= randomNumber;
                        throw  new MemoryOverflowException("You exceeded the memory storage \n");
                    }
                    spaces.add(new Data(spaceId,randomNumber,"s"));
                    dbHelper.addToDatabase(spaces);
                    dbHelper.printDb();
                }
                if(input.contains("d")){
                    String[] parts = input.split("d");
                    int idInput = Integer.parseInt(parts[1]);
                    if(idInput > 999){
                        throw  new InputNotMatch("Id not valid just for id less than 999 \n");
                    }
                    int queryId = dbHelper.getId(spaces,idInput);
                    if (queryId < 0){
                        throw  new InputNotMatch("Item not found in the database \n");
                    }
                    totalSpaces-= spaces.get(queryId).getSpaces();
                    spaces.remove(queryId);
                    dbHelper.addToDatabase(spaces);
                    dbHelper.printDb();
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}


