package com.example.polynomialsetup;

import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        //Initialize a new polynomial, and parse the given string
        polynomial p = new polynomial("5x^9 + 5x^7 - 2x^2");
        polynomial x = new polynomial("5x^2 + 7x^2 + 7x^7");
        //Print the resulting polynomial
        System.out.println(p);
        System.out.println(x);
        //Check the terms of the polynomial, and condense them
        p.add(x.getList());
        //Print the resulting polynomial
        System.out.println(p);
        boolean done = false;
        String choice = "";
        int termChoice = -1;
        int partChoice = -1;
        int number = -1;
        while (!done){
            System.out.println("First polynomial: " + p + "\nSecond polynomial: " + x);
            System.out.println("Choose from the list below:\n1. Edit polynomial 1\n2. Edit polynomial 2\n3. Add polynomials 1 and 2\n4. Exit the program");
            keyboard = new Scanner(System.in);
            choice = keyboard.nextLine();
            switch(choice){
                case "1":
                    System.out.println("Please type the number of the term you wish to modify: ");
                    ArrayList<polynomialTerm> pList = p.getList();
                    for (int i = 0; i < pList.size(); i++){
                        System.out.println(i+1 + ": " + pList.get(i));
                    }
                    termChoice = keyboard.nextInt();
                    System.out.println("Now modifying the term: " + pList.get(termChoice-1) + "\nPlease choose from the list below:\n1. Edit the coefficient\n2. Edit the exponent");
                    partChoice = keyboard.nextInt();
                    switch (partChoice){
                        case 1:
                            System.out.println("Please enter the value of the coefficient: ");
                            number = keyboard.nextInt();
                            pList.get(termChoice-1).setCoefficient(number);
                            System.out.println("Polynomial 1 succesfully modified.");
                            continue;
                        case 2:
                            System.out.println("Please enter the value of the exponent: ");
                            number = keyboard.nextInt();
                            pList.get(termChoice-1).setExponent(number);
                            System.out.println("Polynomial 1 succesfully modified.");
                            continue;
                        default:
                            System.out.println("Invalid input, please try again.");
                            continue;
                    }
                case "2":
                    System.out.println("Please type the number of the term you wish to modify: ");
                    ArrayList<polynomialTerm> xList = x.getList();
                    for (int i = 0; i < xList.size(); i++){
                        System.out.println(i+1 + ": " + xList.get(i));
                    }
                    termChoice = keyboard.nextInt();
                    System.out.println("Now modifying the term: " + xList.get(termChoice-1) + "\nPlease choose from the list below:\n1. Edit the coefficient\n2. Edit the exponent");
                    partChoice = keyboard.nextInt();
                    switch (partChoice) {
                        case 1:
                            System.out.println("Please enter the value of the coefficient: ");
                            number = keyboard.nextInt();
                            xList.get(termChoice - 1).setCoefficient(number);
                            System.out.println("Polynomial 2 succesfully modified.");
                            continue;
                        case 2:
                            System.out.println("Please enter the value of the exponent: ");
                            number = keyboard.nextInt();
                            xList.get(termChoice - 1).setExponent(number);
                            System.out.println("Polynomial 2 succesfully modified.");
                            continue;
                        default:
                            System.out.println("Invalid input, please try again.");
                            continue;
                    }
                case "3":
                    ArrayList<polynomialTerm> temp = new ArrayList<>();
                    for (int i = 0; i < p.getList().size(); i ++){
                        temp.add(new polynomialTerm((polynomialTerm) p.getList().get(i)));
                    }
                    System.out.println("Now adding polynomials 1 and 2:\nPolynomial 1 + polynomial 2 = " + p.add(x.getList()));
                    System.out.println("Operation complete.");
                    p.setList(temp);
                    continue;
                case "4":
                    done = true;
                    break;
                default:
                    System.out.println("Invalid input, please try again.");
                    continue;
            }
        }
    }
}