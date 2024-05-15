import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<Integer, String> wordMap = new HashMap<>(); //create a Map for the coding_qual_input
        try{
            BufferedReader reader = new BufferedReader(new FileReader("src/coding_qual_input.txt"));
            String lineCode = "";//initialize lineCode
            while ((lineCode = reader.readLine()) != null) { //while every line is not empty
                String[] parts = lineCode.split(" "); //split between numbers and words
                if (parts.length == 2) {
                    int number = Integer.parseInt(parts[0]); //set number by the first portion
                    String word = parts[1];  //word is the second portion
                    wordMap.put(number, word); //Applying to the hashmap
                }
            }
        } catch (IOException e) {
            System.err.println("Error from file: " + e.getMessage());
        }
        //Pyramid file
        try {
        Scanner input = new Scanner(System.in); //file input
        File PyramidTxt = new File("src/pyramid.txt."); //Our pyramid numbers
        input = new Scanner(PyramidTxt);
        String numbers; //initialize numbers from pyramid
        String Final = ""; //initialize final text

    while (input.hasNextLine()) {
        String line = input.nextLine();//take the text as a string.
        String[] PyramidNum = line.split(" "); //splits by spaces
        numbers = PyramidNum[PyramidNum.length - 1]; //get the last digits
        int numResult = Integer.parseInt(numbers); //turn the string into a number
        String word = wordMap.get(numResult); //enter into word map
        Final = Final + numResult + ": " + word + "\n";
    }
    System.out.println(Final);

    input.close();

}catch(IOException e) {
            System.err.println("Error from file: " + e.getMessage());
        }
    }
    }