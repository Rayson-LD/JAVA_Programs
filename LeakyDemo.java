/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

/**
 *
 * @author HP
 */
import java.util.Scanner;
import java.util.Random;
public class LeakyDemo
{
public static void main(String[] args)
    {
        int bcktsize,flow,oprate,iter,total=0,rem_bytes;
        int pkt[] = new int[25];
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the flow rate");
        flow = in.nextInt();
        System.out.println("Enter the no . of iterations");
        iter = in.nextInt();
        System.out.println("Enter the bucketsize and operation rate");
          bcktsize = in.nextInt();
        oprate = in.nextInt();
        for (int i=0;i<=iter;i++)
        {
            Random rand = new Random();
            System.out.println("Iteration :" +(i+1));
          for (int j=0;j<=flow;j++)
          {
              rand.setSeed(System.nanoTime());
              pkt[j] = rand.nextInt(500);
              total += pkt[j];
              if(total <= bcktsize)
              {
                  System.out.println("for the flow"+(j+1)+"the number of packets flown with packet size "+pkt[j]+"has been added to the bucket with bucketsize"+total);
                  
              }
              else
              {
                  total -= pkt[j];
                  System.out.println("for the flow"+(j+1)+"the number of packets flown with packet size "+pkt[j]+"has been discarded to the bucket with bucketsize"+total);
                  
              }
          }
          if (oprate >= total)
          {
              rem_bytes = total;
              total = 0;
              System.out.println("The operation rate is" +oprate);
              System.out.println("The toatl number of packets re=maining in the bucket is" +rem_bytes);
                      
          }
          else
          {
              total -= oprate;
              System.out.println("The operation rate is" +oprate);
              System.out.println("The toatl number of packets re=maining in the bucket is" +total);
          }
        }
              
    }
    
}
