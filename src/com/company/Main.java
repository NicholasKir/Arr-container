package com.company;
import java.util.Scanner;

public class Main {

    /**
     * Demonstration of work by switch.
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Container ar1 = new Container();
        int c = 1;
        do {
            menu();
            while(!in.hasNextInt()) {
                System.out.println("Incorrect type!");
                in.next();
            }
            if(in.hasNextInt()) c=in.nextInt();
            switch (c) {
                case 1:
                    ar1.creatarray();
                    break;
                case 2:
                    int number=0;
                    float newelement=0;
                    System.out.print("Enter a new element : ");
                    while(!in.hasNextInt()) {
                        System.out.println("Incorrect type!");
                        in.next();
                    }
                    if(in.hasNextInt()) newelement=in.nextFloat();
                    System.out.print("Enter position (for add in end enter 0) : ");
                    while(!in.hasNextInt()) {
                        System.out.println("Incorrect type!");
                        in.next();
                    }
                    if(in.hasNextInt()) number = in.nextInt();
                    ar1.elementadd(newelement,number);
                    break;
                case 3:
                    int number1=0;
                    System.out.print("Number of element fo delete (for delete the last enter 0) : ");
                    while(!in.hasNextInt()) {
                        System.out.println("Incorrect type!");
                        in.next();
                    }
                    if(in.hasNextInt()) number1=in.nextInt();
                    ar1.elementdell(number1);
                    break;
                case 4:
                    ar1.printarray();
                    break;
                case 5:
                    System.out.print(ar1.getlenght());
                    break;
                case 6:
                    int number2=0;
                    System.out.print("Enter a number of element : ");
                    while(!in.hasNextInt()) {
                        System.out.println("Incorrect type!");
                        in.next();
                    }
                    if(in.hasNextInt()) number2=in.nextInt();
                    ar1.getelem(number2);
                case 7:
                    ar1.toString();
            }
        }while(c!=8);
        return;
    }

    /**
     * Function with set of commands, that use the methods.
     */
    public static void menu()
    {
        System.out.println();
        System.out.println("--------------------------------------");
        System.out.println("Enter the action: ");
        System.out.println("1.Create container.");
        System.out.println("2.Add element.");
        System.out.println("3.Delete element");
        System.out.println("4.Print container.");
        System.out.println("5.Get length of container.");
        System.out.println("6.Get element of container by number.");
        System.out.println("7.To string.");
        System.out.println("8.Exit.");
        System.out.println("--------------------------------------");
        System.out.print(">");
    }
}
