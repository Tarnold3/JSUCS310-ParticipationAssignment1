package edu.jsu.mcis.cs310.participation1;

public class CustomerRecord {
    //Variable list for customer data with labeled array location
/*0*/    private String firstName;
/*1*/    private String middleInitial;
/*2*/    private String lastName;
/*3*/    private String streetAddress;
/*4*/    private String city;
/*5*/    private String state;
/*6*/    private String zipCode;
/*7*/    private String box;
/*8*/    private Double rate;
    
public CustomerRecord(String firstName, String middleInitial, String lastName, String streetAddress, String city, String state, String zipCode, String box, double rate){
    this.firstName = firstName;
    this.middleInitial = middleInitial;
    this.lastName = lastName;
    this.streetAddress = streetAddress;
    this.city = city;
    this.state = state;
    this.zipCode = zipCode;
    this.box = box;
    this.rate = rate;
}    
    
//Objects for the 9 types of data from CSV file    
public String getFirstName(){    
return firstName;
}
public String getMiddleInitial(){    
return middleInitial;
}
public String getLastName(){    
return lastName;
}
public String getStreetAddress(){    
return streetAddress;
}
public String getCity(){    
return city;
}
public String getState(){    
return state;
}
public String getZipCode(){    
return zipCode;
}
public String getBox(){    
return box;
}
public double getRate(){    
return rate;
}
public String toString() {
       // create a new StringBuilder and append the required data to it
       StringBuilder sb=new StringBuilder();
       sb.append(firstName + " " + middleInitial + " " + lastName + "\n" + streetAddress + "\n" + city + ", " + state
               + " " + zipCode + "\n$" + rate);
       // convert the StringBuilder to String and return it.
       return sb.toString();
   }
}
