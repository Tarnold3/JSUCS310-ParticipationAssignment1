//Author: Tucker Arnold
//CS310 Participation Assignment 1
//January 14, 2021

//Package
package edu.jsu.mcis.cs310.participation1;
//Libraries
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.io.*;          

public class ParticipationAssignment1A {
    //Setting comma as the delimiter
    public static final String delimiter = ",";
    
    //getCustomerRecords class should open CSV file
    public ArrayList<CustomerRecord> getCustomerRecords(String filepath) {
        //Making an array to store customer data
        ArrayList<CustomerRecord> records = new ArrayList<CustomerRecord>();
        try{
            //Reading through the file and using a buffer for memory
            File file = new File(filepath);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            String[]tempArr;
            double rate;
            int count = 0;
            //Keep reading until finished reading CSV file
            while ((line = br.readLine())!= null){                
                if(count == 0){
                    count += 1;
                    continue;
                }
            tempArr = line.split(delimiter);
            //If A is corresponding box rate
            if(tempArr[7].equals("A")){
                rate = Double.parseDouble(tempArr[8]);}
            //If B is corresponding box rate
            if (tempArr[7].equals("B"))
                rate = Double.parseDouble(tempArr[9]);
            //If C is corresponding box rate
            else {
                rate = Double.parseDouble(tempArr[10]);
            }
            records.add(new CustomerRecord(tempArr[0],tempArr[1],tempArr[2],tempArr[3],tempArr[4],tempArr[5],tempArr[6],tempArr[7],rate));
            }
            //Close buffer
            br.close();          
        }
        //Catch statement for previous Try statement
        catch(IOException ioe){
            ioe.printStackTrace();
        }
        return records;
    }
    
    public void printCustomerRecords(ArrayList<CustomerRecord> records, String state) {
        System.out.println("Number of Records: " + records.size());
        int count = 0;
        String str = "";
        for (CustomerRecord c: records){
            str += c + "\n";
            //If the state is AL add 1 to count
            if(c.getState().equals(state)){
                count += 1;
            }
        }
        //Printing customer data followed by number of AL addresses
        System.out.println(str);
        System.out.println("Number of" + state + "Addresses:" + count);
    }

    //Preset Code
    public static void main(String[] args) {
        
        ParticipationAssignment1A app = new ParticipationAssignment1A();
        
        String filename = "input.csv";
        String foldername = "Desktop";
        String profilepath = System.getenv("USERPROFILE"); // for Windows
        if (profilepath == null) {
            profilepath = System.getProperty("user.home"); // for Unix
        }
        String sep = File.separator;
        String fullpath = profilepath + sep + foldername + sep + filename;
        
        ArrayList<CustomerRecord> records = app.getCustomerRecords(fullpath);
        app.printCustomerRecords(records, "AL");

    }
    
}