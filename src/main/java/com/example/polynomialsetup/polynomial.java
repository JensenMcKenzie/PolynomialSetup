package com.example.polynomialsetup;

import java.util.ArrayList;

public class polynomial {
    //Instance variables
    private ArrayList<polynomialTerm> termList;

    //Constructors
    //Full constructor, takes in a string, initializes the array list, then parsese the string
    polynomial(String s){
        termList = new ArrayList<polynomialTerm>();
        parseString(s);
    }
    //Empty constructor, this constructor will take in no data, and initialize an empty array list
    polynomial(){
        termList = new ArrayList<polynomialTerm>();
    }


    //Custom methods
    //add scans through another the termList, which contains all the terms parsed by the parseString method, and reduces the coefficients of the same exponents.
    public ArrayList<polynomialTerm> add(ArrayList<polynomialTerm> other){
        ArrayList<polynomialTerm> result = new ArrayList<>(termList);;
        //Loop through the termList
        for (int i = 0; i < result.size(); i++){
            //Loop through the termList again, checking for exponents that are the same
            for (int j = 0; j < other.size(); j++){
                //Check to see if the exponents of any two terms are equal
                if (result.get(i).getExponent() == other.get(j).getExponent() && i != j){
                    //Add the coefficients of the two terms together
                    result.get(i).setCoefficient(result.get(i).getCoefficient() + other.get(j).getCoefficient());
                }
            }
        }
        return result;
    }

    //parseString takes in a string, and turns it into polynomialTerm objects
    public void parseString(String s){
        //Loop until the string is empty
        while (s != ""){
            //Temporary variables for the storage of each part of a term
            int coefficient = 0;
            int exponent = 0;
            String var = "";

            //If we have leading spaces, eliminate them, keeping the + or - sign
            if (s.indexOf(" ") == 0){
                s = s.charAt(1) + s.substring(3);
            }

            //Check to see if the string has any x terms
            if (s.indexOf("x") != -1){
                //Set the coefficient to the first numbers in the sequence, up until the variable. This includes any + or - signs
                coefficient = Integer.valueOf(s.substring(0, s.indexOf("x")));
                //Set the variable to 'x'
                var = "x";
                //System.out.println(coefficient);
                //Check to see if there is an exponent attached to the term, and if it is not the last number in the term
                if (s.indexOf("^") == s.indexOf("x") + 1 && s.indexOf(" ") != -1){
                        //Set the exponent to the numbers that come after the '^' sign, until there is a space. This includes any + or - signs
                        exponent = Integer.valueOf(s.substring(s.indexOf("^") + 1, s.indexOf(" ")));
                        //Update the s string to eliminate the term we just processed
                        s = s.substring(s.indexOf(" "));
                }
                //Check to see if there is an exponent attached to the term, and if it is the last number in the term
                else if (s.indexOf("^") == s.indexOf("x") + 1 && s.indexOf(" ") == -1){
                    //Set the exponent to the numbers that come after the '^' sign, until the string ends. This includes any + or - signs
                    exponent = Integer.valueOf(s.substring(s.indexOf("^") + 1, s.length()));
                    //Update the s string to be empty, since we just parsed the last term
                    s = "";
                }
                //If we do not have any exponents attached to the x term, update the s string
                else{
                    //Update the s string to eliminate the term we just parsed
                    if (s.indexOf(" ") != -1) {
                        s = s.substring(s.indexOf(" "));
                    }
                    else{
                        s = "";
                    }
                }
            }
            //If the string has no x terms, we can assume there is only a coefficient, and thus it must be the last term of the polynomial
            else{
                //Set the coefficient to the numbers in the term. This includes any + or - signs
                coefficient = Integer.valueOf(s.substring(0,s.length()));
                //Update the s string to be empty, since we just parsed the last term
                s = "";
            }
            //Add the new term to the list of terms
            termList.add(new polynomialTerm(var, exponent, coefficient));
        }
    }
    //Setters
    //Sets the value of termList to a new ArrayList
    public void setList(ArrayList<polynomialTerm> newList){
        termList = newList;
    }

    //Getters
    //Returns the termList of the current object
    public ArrayList getList(){
        return this.termList;
    }
    //Overridden methods
    //To string, returns the list of terms
    @Override
    public String toString(){
        return termList.toString();
    }
}
