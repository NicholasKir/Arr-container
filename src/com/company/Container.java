package com.company;
import java.util.Scanner;

public class Container {
    public int lenght;

    public float[] arr;

    public float[] sidearr;

    Scanner input = new Scanner(System.in);
    public void Container()
    {

    }
    public void creatarray()
    {
        System.out.print("Enter a number : ");
        lenght = input.nextInt();
        arr=new float[lenght];
        for(int i=0; i<lenght; i++)
        {
            System.out.print("Enter " + (i+1) + " element : ");
            arr[i] = input.nextFloat();
        }
        copy();
    }
    public void copy()
    {
        sidearr=new float[lenght];
        for(int i=0; i<lenght; i++) sidearr[i]=arr[i];
    }

    public int getlenght()
    {
        return lenght;
    }
    public float getelem()
    {
        int number;
        System.out.print("Enter a number of element : ");
        number=input.nextInt();
        return arr[number];
    }
    public void elementadd()
    {
        float newelement;
        int number;
        System.out.print("Enter a new element : ");
        newelement=input.nextFloat();
        lenght=lenght+1;
        System.out.print("Enter position : ");
        number=input.nextInt();
        arr=new float[lenght];
        if(number==1)
        {
            arr[0]=newelement;
            for (int i = 0; i < lenght - 1; i++) arr[i] = sidearr[i+1];
        }
        else if (number==lenght)
        {
            for(int i=0; i<number; i++) arr[i]=sidearr[i];
            arr[number-1]=newelement;
            for(int i=number; i<lenght; i++) arr[i]=sidearr[i+1];
        }
        else
        {
            for (int i = 0; i < lenght - 1; i++) arr[i] = sidearr[i];
            arr[lenght - 1] = newelement;
        }
        copy();
    }
    public void elementdell()
    {
        int number;
        System.out.print("Number of element fo delete : ");
        number=input.nextInt();
        lenght=lenght-1;
        arr=new float[lenght];
        if(number==1)
        {
            for(int i=0; i<lenght; i++) arr[i]=sidearr[i+1];
        }
        else if(number==lenght)
    {
        for(int i=0; i<lenght; i++) arr[i]=sidearr[i];
    }
    else
    {
        for(int i=0; i<number; i++) arr[i]=sidearr[i];
        for(int i=number-1; i<lenght; i++) arr[i]=sidearr[i+1];
        copy();
    }
    }
    public void printarray()
    {
        for(int i=0; i<lenght; i++) System.out.print(arr[i] + "  ");
        System.out.println();
    }
}
