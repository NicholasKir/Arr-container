package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Container ar1 = new Container();
        int c = 1;
       do {
           menu();
           c=in.nextInt();
           switch (c) {
               case 1:
                   ar1.creatarray();
                   break;
               case 2:
                   ar1.elementadd();
                   break;
               case 3:
                   ar1.elementdell();
                   break;
               case 4:
                   ar1.printarray();
                   break;
               case 5:
                   System.out.print(ar1.getlenght());
                   break;
               case 6:
                   ar1.getelem();
           }
       }while(c!=7);
       return;
    }
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
        System.out.println("7.Exit.");
        System.out.println("--------------------------------------");
        System.out.print(">");
    }
}
