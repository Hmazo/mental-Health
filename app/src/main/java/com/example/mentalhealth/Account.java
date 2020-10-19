package com.example.mentalhealth;

public class Account{
    String role;
    private String name;
    private String email;
    private String date;
    private String password;

    //Constructor for Account
    public Account(String aName, String aDate, String aPassword, String aEmail){
        name = aName;
        date=aDate;
        password=aPassword;
        email=aEmail.replace(".",",");;
        role = "Customer";
    }
    //changes the name to a new name
    public void setName(String newName){
        name=newName;}

    //changes the date to a new date
    public void setDate(String newDate){
        date = newDate;}

    //sets the password to a new password
    public void setPassword(String newPassword){
        password = newPassword;}

    //sets the email to a new email
    public void setEmail(String newEmail){
        email = newEmail;}
    //returns the name
    public String getName(){
        return name;
    }
    //returns the date
    public String getDate(){
        return date;
    }
    //returns the password
    public String getPassword(){
        return password;
    }
    //returns the email
    public String getEmail(){
        return email;
    }
    //returns true if the account belongs to a customer
    public String getRole() {return role;}
}