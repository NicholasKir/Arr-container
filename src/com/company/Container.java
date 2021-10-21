package com.company;
import java.util.Scanner;

/**
 * Main class.
 */
public class Container {
    /**
     * lenght - the field with the number of elements in the container
     * arr - the field with the number of elements in the container
     * sidearr - field containing an optional array used in the elementadd, elementdell methods.
     */
    public int lenght;

    public float[] arr;

    public float[] sidearr;

    Scanner input = new Scanner(System.in);

    /**
     * Constructor
     */
    public void Container()
    {

    }

    /**
     * The method for creating the container. Asks the user for the number of element, then the elements themselves.
     */
    public void creatarray()
    {
        System.out.print("Enter a number : ");
        lenght = input.nextInt();
        if(lenght<=0) System.out.print("Incorrect number!");
        else {
            arr = new float[lenght];
            for (int i = 0; i < lenght; i++) {
                System.out.print("Enter " + (i + 1) + " element : ");
                arr[i] = input.nextFloat();
            }
            copy();
        }
    }
    /**
     *The method of copying the main array to an additional array, used in the elementadd, elementdell.
     */
    public void copy()
    {
        sidearr=new float[lenght];
        for(int i=0; i<lenght; i++) sidearr[i]=arr[i];
    }
    public void copyin2()
    {
        sidearr=new float[lenght];
        for(int i=0; i<lenght; i++) sidearr[i]=arr[i]*2;
    }
    /**
     * A method that returns the number of element in the container.
     * @return the number of element in the container.
     */
    public int getlenght()
    {
        return lenght;
    }
    /**
     * A method that returns an element by requesting its position.
     * @return container element.
     */
    public float getelem()
    {
        int number;
        System.out.print("Enter a number of element : ");
        number=input.nextInt();
        return arr[number - 1];

    }
    /**
     * The method for adding an element.
     * Requests the value of an element from the user.
     * Then asks for the position that this element will be at.
     */
    public void elementadd()
    {
        float newelement;
        int number;
        System.out.print("Enter a new element : ");
        newelement=input.nextFloat();
        lenght=lenght+1;
            System.out.print("Enter position (for add in end enter 0) : ");
            number = input.nextInt();
            arr = new float[lenght];
            if (number < 0 || number > lenght) System.out.print("Incorrect position!");
            else if (number == 1) {
                arr[0] = newelement;
                for (int i = 0; i < lenght - 1; i++) arr[i] = sidearr[i + 1];
            } else if (number == 0) {
                for (int i = 0; i < lenght - 1; i++) arr[i] = sidearr[i];
                arr[lenght - 1] = newelement;
            } else {
                for (int i = 0; i < number - 1; i++) arr[i] = sidearr[i];
                arr[number - 1] = newelement;
                for (int i = number - 1; i < lenght - 1; i++) arr[i + 1] = sidearr[i];
            }
        copy();
    }

    /**
     * The method to delete an element.
     */
    public void elementdell()
    {
        if(lenght==0) System.out.print("Cannot delete: container is empty");
        else {
            int number;
        System.out.print("Number of element fo delete (for delete the last enter 0) : ");
        number=input.nextInt();
        lenght=lenght-1;
        arr=new float[lenght];
            if (number < 0 || number > lenght) System.out.print("Incorrect position!");
            else if (number == 1) {
                for (int i = 0; i < lenght; i++) arr[i] = sidearr[i + 1];
            } else if (number == 0) {
                for (int i = 0; i < lenght; i++) arr[i] = sidearr[i];
            } else {
                for (int i = 0; i < number; i++) arr[i] = sidearr[i];
                for (int i = number - 1; i < lenght; i++) arr[i] = sidearr[i + 1];
                copy();
            }
        }
    }

    /**
     * The method to display the entire container.
     */
    public void printarray()
    {
        for(int i=0; i<lenght; i++) System.out.print(arr[i] + "  ");
        System.out.println();
    }
}

