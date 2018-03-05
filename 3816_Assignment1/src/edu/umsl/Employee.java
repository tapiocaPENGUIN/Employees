/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.umsl;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author ebyrd
 */
public class Employee implements Serializable
{
        /*********************
	     Attributes
	*********************/
	float rate=30.0f;
	float taxrate=0.2f;
	int hours=45;
	float gross=0.0f;
	float tax=0.0f;
	float net=0.0f;
	float net_percent=0.0f;

	//End Attributes
        
        /********************
	     Constructors
	********************/
        public Employee() 
        {
            
        }
        	
	/********************
	     Methods
	********************/
        public void menu()
        {
            int input;
            Scanner sc = new Scanner(System.in);
            do
           {
               System.out.println(" 1) Calculate Gross Pay");
               System.out.println(" 2) Calculate Tax");
               System.out.println(" 3) Calculate Net Pay");
               System.out.println(" 4) Calculate Net Percent");
               System.out.println(" 5) Display Employee");
               System.out.println(" 6) Exit");
               

               input = sc.nextInt();
               if(input==1)
               {
                   computeGross();
               } 
              else if(input==2)
               {
                   computeTax();
               }
              else if(input==3)
               {
                   computeNet();
               }
              else if(input==4)
               {
                   computeNetperc();
               }
              else if(input==5)
               {
                   displayEmployee();
               }
           }while(input != 6);
        }
        public void setHours(int hours)
        {
            this.hours = hours;
        }
        public void setRate(float rate)
        {
            this.rate = rate;
        }
         
	public void computeGross()
        { 
		gross=rate*hours;
                System.out.println(gross);

	}

	protected void computeTax() 
        { 
		tax=gross*taxrate;
	}

	protected void computeNet()
        { 
		net=gross-tax;
	}

	protected void computeNetperc() 
        { 
		net_percent=(net/gross)*100;
	}
	
	protected void displayEmployee() 
{
                computeGross();
                computeTax();
                computeNet();
                computeNetperc();
		System.out.println("Hours: " + hours);
		System.out.println("Rate: " + rate);
		System.out.println("Gross: " + gross);
		System.out.println("Net: " + net);
		System.out.println("Net%: " + net_percent + "%");
	}

}
