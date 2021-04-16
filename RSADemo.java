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
import java.util.*;
public class RSADemo {
    public static void main(String[] args)
    {
        String msg;
        int ct[] = new int[100];
        int pt[] = new int[100];
        int z,e,d,p,q,n,y,mlen;
        Scanner in = new Scanner(System.in);
        do{
            System.out.println("Enter the 2 larg prime numbers :");
            p = in.nextInt();
            q = in.nextInt();
        }while(prime(p)==0 || prime(q)==0);
        n = p*q;
        z = (p-1)*(q-1);
        System.out.println("The values of n and z is :" +n+ "," +z);
        for(e=2;e<z;e++)
        {
            if(gcd(e,z)==1)
                break;
        }
        System.out.println("The value is e is" +e);
        System.out.println("The public key is (e,n)" +e+ "," +n);
        for(d=2;d<z;d++)
        {
            if(((e*d)%z)==1)
                break;
        }
        System.out.println("The value is d is" +d);
        System.out.println("The public key is (d,n)" +d+ "," +n);
        in.nextLine();
        System.out.println("Enter the message");
        msg = in.nextLine();
        mlen = msg.length();
        for(int i=0;i<mlen;i++)
        pt[i]= msg.charAt(i);
        System.out.println("The ASCII Values of the message is :");
        for(int i=0;i<mlen;i++)
        {
            System.out.println(pt[i]);
        }
        for(int i=0;i<mlen;i++)
        {
            ct[i] = mult(pt[i],e,n);
        }
        System.out.println("The cipher text obtained is :");
                for(int i=0;i<mlen;i++)
                    System.out.println(ct[i]);
         for(int i=0;i<mlen;i++)
        {
            pt[i] = mult(ct[i],d,n);
        }
        System.out.println("The Plain text text obtained is :");
                for(int i=0;i<mlen;i++)
                {
                    System.out.println(pt[i]+ ":" +(char)pt[i]);
                    
                }
                           
        
    }
    public static int prime(int num)
    {
        for (int i=2;i<= num/2;i++)
        {
            if(num%i == 0)
                return 0;
            
        }
        return 1;
    }
    public static int gcd(int x,int y)
    {
        if(y==0)
            return x;
        else
           return gcd(y,x%y);
    }
    public static int mult(int base , int exp,int data)
    {
        int res=1,j;
        for(j=1;j<=exp;j++)
            res = ((res*base)%data);
        return res;
    }
    
}
