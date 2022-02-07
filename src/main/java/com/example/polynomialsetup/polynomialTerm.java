package com.example.polynomialsetup;

public class polynomialTerm {

    //Private instance variables
    private String var;
    private int exponent, coefficient;

    //Contructors
    //Full constructor, takes and sets all instance variables
    polynomialTerm(String var, int exponent, int coefficient){
        this.var = var;
        this.exponent = exponent;
        this.coefficient = coefficient;
    }
    polynomialTerm(polynomialTerm p){
        var = p.getVar();
        exponent = p.getExponent();
        coefficient = p.getCoefficient();
    }
    //Empty constructor, takes in no data and sets all instance variables to default values
    polynomialTerm(){
        var = "";
        exponent = 0;
        coefficient = 0;
    }

    //Setter methods
    //Takes in a string, representing the variable, and sets the instance variable 'var' to it
    public void setVar(String var){
        this.var = var;
    }
    //Takes in an int, and sets the instance variable 'exponent' to it
    public void setExponent(int exponent){
        this.exponent = exponent;
    }
    //Takes in an int, and sets the instance varaible 'coefficient' to it
    public void setCoefficient(int coefficient){
        this.coefficient = coefficient;
    }

    //Getter methods
    //Returns the value of the instance variable 'var'
    public String getVar(){
        return var;
    }
    //Returns the value of the instance variable 'exponent'
    public int getExponent(){
        return exponent;
    }
    //Returns the value of the instance variable 'coefficient'
    public int getCoefficient(){
        return coefficient;
    }

    //Overridden methods
    //To string, converts the instance variables into a string of text
    @Override
    public String toString(){
        if (var != ""){
            if (exponent != 0){
                return coefficient + var + "^" + exponent;
            }
            else if (exponent == 0){
                return coefficient + var;
            }
        }
        return coefficient + "";

    }
}
