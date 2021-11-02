package com.company;
import java.util.Arrays;
import java.util.Objects;
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
        while(!input.hasNextInt()) {
            System.out.println("Incorrect type!");
            input.next();
        }
        if(input.hasNextInt()) lenght = input.nextInt();
        if(lenght<=0) System.out.print("Incorrect number!");
        else {
            arr = new float[lenght];
            for (int i = 0; i < lenght; i++) {
                System.out.print("Enter " + (i + 1) + " element : ");
                while(!input.hasNextInt()) {
                    System.out.println("Incorrect type!");
                    input.next();
                }
                if(input.hasNextInt()) arr[i] = input.nextFloat();
            }
        }
    }
    /**
     *The method of copying the main array to an additional array, used in the elementadd, elementdell.
     */
    public void copy(float[] arr, float[] sarr, int l)
    {
        for(int i=0; i<l; i++) sarr[i]=arr[i];
    }
    /**
     * A method that returns the number of element in the container.
     * @return the number of element in the container.
     */
    public int getlenght()
    {
        if (lenght==0) {
            System.out.print("Container is empty! Code:");
            return -1;
        }
        else return lenght;
    }
    /**
     * A method that returns an element by requesting its position.
     * @return container element.
     */
    public float getelem(int number) {
        if (number < 0 || number > lenght) {
            System.out.print("Incorrect position! Code: ");
            return 1.0f;
        }
        else return arr[number - 1];
    }
    /**
     * The method for adding an element.
     * Requests the value of an element from the user.
     * Then asks for the position that this element will be at.
     */
    public void elementadd(float newelement, int number)
    {
        float [] sarr;
        sarr = new float[lenght];
        copy(arr, sarr, lenght);
        lenght=lenght+1;
        arr = new float[lenght];
        if (number < 0 || number > lenght) System.out.print("Incorrect position!");
        else if (number == 1) {
            arr[0] = newelement;
            for (int i = 0; i < lenght - 1; i++) arr[i] = sarr[i + 1];
        } else if (number == 0) {
            for (int i = 0; i < lenght - 1; i++) arr[i] = sarr[i];
            arr[lenght - 1] = newelement;
        } else {
            for (int i = 0; i < number - 1; i++) arr[i] = sarr[i];
            arr[number - 1] = newelement;
            for (int i = number - 1; i < lenght - 1; i++) arr[i + 1] = sarr[i];
        }
    }

    /**
     * The method to delete an element.
     */
    public void elementdell(int number)
    {
        if(lenght==0) System.out.print("Cannot delete: container is empty");
        else {
            float [] sarr;
            sarr= new float[lenght];
            copy(arr, sarr, lenght);
            lenght=lenght-1;
            arr=new float[lenght];
            if (number < 0 || number > lenght) System.out.print("Incorrect position!");
            else if (number == 1) {
                for (int i = 0; i < lenght; i++) arr[i] = sarr[i + 1];
            } else if (number == 0) {
                for (int i = 0; i < lenght; i++) arr[i] = sarr[i];
            } else {
                for (int i = 0; i < number; i++) arr[i] = sarr[i];
                for (int i = number - 1; i < lenght; i++) arr[i] = sarr[i + 1];
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
    public String toString() {
        String result = new String(" ");
        if (getlenght() == 0) {
            return result;
        }
        for (int i = 0; i < getlenght(); i++) {
            String t = null;
            try {
                t = Float.toString(getelem(i));
            } catch (Exception e) {
                e.printStackTrace();
            }
            result += t.toString() + " ";
        }
        result = result.substring(0, result.length() - 1);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Container container = (Container) o;
        return lenght == container.lenght && Arrays.equals(arr, container.arr);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(lenght);
        result = 31 * result + Arrays.hashCode(arr);
        return result;
    }
}
