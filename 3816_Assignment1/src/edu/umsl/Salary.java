/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.umsl;

/**
 *
 * @author ebyrd
 */
public class Salary extends Employee
{
   @Override 
   public void computeGross()
   {
       gross = rate;
       
   }
}
