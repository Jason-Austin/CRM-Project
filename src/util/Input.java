package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    private Scanner scan;

    public String getString(){
        this.scan = new Scanner(System.in);
        return scan.nextLine();
    }

    public boolean yesNo(){
        this.scan = new Scanner(System.in);
        String userInput = scan.nextLine();
        return userInput.equals("yes") || userInput.equals("y") || userInput.equals("ys") || userInput.equals("yea");

    }

    public int getInt(){
        this.scan = new Scanner(System.in);
        return scan.nextInt();
    }

    public double getInt(String prompt) {
        try {
            return Integer.valueOf(prompt);
        } catch (Exception e) {
            System.err.println("Invalid input, try again.");
            return getInt(getString());
        }
    }

    public double getInt(double min, double max){
        double userInput = getInt(getString());
        if (userInput >= max || userInput <= min){
            System.err.println("This is an invalid number outside the range. Try again.");
            return getInt(min, max);
        } else {
            return userInput;
        }
    }


    public double getDouble(){
        this.scan = new Scanner(System.in);
        return scan.nextDouble();
    }

    public double getDouble(String prompt) {
        try {
            return Double.valueOf(prompt);
        } catch (Exception e) {
            System.err.println("Invalid input, try again.");
            return getDouble(getString());
        }
    }

    public double getDouble(double min, double max){
        double userInput = getDouble(getString());
        if (userInput >= max || userInput <= min){
            System.err.println("This is an invalid number outside the range. Try again.");
            return getDouble(min, max);
        } else {
            return userInput;
        }
    }

//    public static void main(String[] args) {
//        Input userInput = new Input();
//        userInput.getString();
//        userInput.yesNo();
//        userInput.getInt(1, 100);
//        userInput.getDouble(1, 100);
//    }

}
