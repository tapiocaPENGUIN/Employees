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
public class Hourly extends Employee 
{
    @Override
    public void computeGross()
    {
        int overhours;
        float orate = (float) 1.5 * rate;
        if (hours > 40)
        {
            overhours = hours - 40;
            gross = (40*rate)+(overhours*orate);
        }
        else
        {
            gross = rate * hours;
        }
    }
}
