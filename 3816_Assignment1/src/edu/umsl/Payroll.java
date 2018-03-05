/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.umsl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;


/**
 *
 * @author ebyrd
 */
public class Payroll
{
    Employee[] earray = new Employee[3];
    boolean loadaccount = false;
    
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException
    {
        Payroll pay = new Payroll();
        pay.menu();
    }
    public void menu() throws IOException, FileNotFoundException, ClassNotFoundException
    {
        int input;
        Scanner sc = new Scanner(System.in);
                     
        do
        {
        System.out.println("1) Populate Employees ");
        System.out.println("2) Select Employees ");
        System.out.println("3) Save Employees ");
        System.out.println("4) Load Employees ");
        System.out.println("5) Exit ");
        
        input = sc.nextInt();
        
        if(input == 1)
        {
             populateEmployee();   
        }
        else if(input==2)
        {
            selectEmployee();
        }
        else if(input==3)
        {
            saveEmployee();
        }        
        else if(input==4)
        {
            loadEmployee();
        }
        else if(input==5)
        {
            exit();
        }
        }while(input != 5);
        
    }
    public void populateEmployee()
    {
        {
                //String id_holdinput;
		if (loadaccount == false){
                Scanner sc = new Scanner(System.in);

		for(int i=0; i<earray.length; i++)
                {
      
                        System.out.println("Please enter if you are a [H]ourly,[S]alary,[C]ommission ");
                        
                        String input = sc.next();
                    
			if(input.equalsIgnoreCase("H"))
                        {
                            
                            earray[i] = new Hourly();
                            int hours;
                            float rate;
                            System.out.println("Please give your hours: ");
                            hours = sc.nextInt();
                            earray[i].setHours(hours);
                            System.out.println("Please give your rate: ");
                            rate = sc.nextFloat();
                            earray[i].setRate(rate);
                            
                            //System.out.println("Please enter your id number[first name and last initial]: ");
                            //String local_id = sc.next();
                            //earray[i].setID(local_id);
                        }
                        else if(input.equalsIgnoreCase("S"))
                        {
                            earray[i] = new Salary();  
                            String position;
                            System.out.println("Are you [S]taff or [E]xecutive: ");
                            position = sc.next();
                            if (position.equalsIgnoreCase("S"))
                            {
                                float rate = 50000;
                                earray[i].setRate(rate);
                            }
                            else if(position.equalsIgnoreCase("E"))
                            {
                                float rate = 100000;
                                earray[i].setRate(rate);
                            }
                            
                             
                            //System.out.println("Please enter your id number[first name and last initial]: ");
                            //String local_id = sc.next();
                            //earray[i].setID(local_id);
                        } 
                        else if(input.equalsIgnoreCase("C"))
                        {
                            earray[i] = new Commission();
                            int numSold;
                            float unitPrice;
                            System.out.println("How many items did you sell: ");
                            
                            numSold = sc.nextInt();
                            earray[i].setHours(numSold);
                            System.out.println("How much was the total price: ");
                            unitPrice = sc.nextFloat();
                            earray[i].setRate(unitPrice);
                                    
                           // System.out.println("Please enter your id number[first name and last initial]: ");
                            //String local_id = sc.next();
                            //earray[i].setID(local_id);
                        }
//                        else
//                        {
//                            sarray[i] = new Student();
//                            System.out.println("Please enter your id number[first name and last initial]: ");
//                            String local_id = sc.next();
//                            sarray[i].setID(local_id);
//                        }
		}}else
                {
                    System.out.println("Accounts already populated from load file");
                }
                
        }
    }
    public void selectEmployee()
    {
        Scanner sc = new Scanner(System.in);
        int choose;
        System.out.println("Please select and employee[0,1,2] ");
        choose = sc.nextInt();
        switch (choose)
        {
            case 0:
            {
                earray[choose].menu();
                break;
            }
            case 1:
            {
                earray[choose].menu();
                break;
            }
            case 2:
            {
                earray[choose].menu();
            }
                    
        }
        
    }

    public void saveEmployee() throws FileNotFoundException, IOException
    {
        FileOutputStream outstream = new FileOutputStream("C:/temp/test.txt");
        ObjectOutputStream os = new ObjectOutputStream(outstream);
        os.writeObject(earray);
        os.flush();
        os.close();

    }
    public void loadEmployee() throws FileNotFoundException, IOException, ClassNotFoundException
    {
        FileInputStream instream = new FileInputStream("C:/temp/test.txt");
        ObjectInputStream in = new ObjectInputStream(instream);
        earray = (Employee[])in.readObject();
        in.close();
        loadaccount = true;
        
    }
    public void exit() throws IOException
    {
        saveEmployee();
        System.out.println("Your data has been saved!");
        System.exit(0);
    }
    
}
