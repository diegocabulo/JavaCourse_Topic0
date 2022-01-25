package utils;

import java.util.ArrayList;
import java.util.LinkedList;

// We create a java class to handle the database
public class DbHelper {

    private ArrayList<String> printArray = new ArrayList<>();

    private static final Integer SIZE_DB = 199;

    // We add the objects to the array for printing
    public ArrayList<String> addToDatabase(LinkedList<Data> spaces){
        this.printArray.clear();
        for (Data space : spaces) {
            for (int i = 0;i< space.getSpaces();i++){
                this.printArray.add(space.formatData());
            }
        }
        return this.printArray;
    }
    // Method to query the id of the object
    public Integer getId(LinkedList<Data> data, Integer id){
        for(int i = 0; i < data.size(); i++){
            if(data.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }
    // Method to print the database in the format
    public void printDb(){
        for (int i =SIZE_DB; i>=0; i--){
            boolean sizeArrayList = i < this.printArray.size();
            if(i % 10 == 0){
                if(sizeArrayList){
                    System.out.println(this.printArray.get(i) + " \n");
                }
                else {
                    System.out.print("**** \n");
                }
            }else {
                if(sizeArrayList){
                    System.out.print(this.printArray.get(i)+ " ");
                }
                else {
                    System.out.print("**** ");
                }
            }
        }
    }

}
