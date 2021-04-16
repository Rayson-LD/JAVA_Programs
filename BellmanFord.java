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
public class BellmanFord {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args)
    {
        int V,E=1,checkNegative=0;
        int w[][] = new int[20][20];
        int edge[][] = new int[45][45];
        
        System.out.println("Enter the number of vertices");
        V = in.nextInt();
        System.out.println("Enter the weight matrix");
                for(int i=1;i<=V;i++)
                {
                    for(int j=1;j<=V;j++)
                    {
                        w[i][j] = in.nextInt();
                    
                    if(w[i][j] != 0)
                    {
                        edge[E][0] = i;
                        edge[E++][1] = j;
                    }
                    }
                }
                checkNegative = bellmanford(w,E,V,edge);
                if(checkNegative == 1)
                {
                    System.out.println("No negative weight cycle exists");
                }
                else
                {
                    System.out.println("negative weight cycle exists");
                }
    }
    public static int bellmanford(int w[][],int E,int V,int edge[][])
    {
        int S,u=0,v=0,flag=1;
        int distance[] = new int[25];
        int parent[] = new int[25];
        for(int i=1;i<=V;i++)
        {
            distance[i]= 999;
            parent[i]= -1;
        }
        System.out.println("Enter the Source vertex");
        S =in.nextInt();
        distance[S]=0;
        for(int i=1;i<=V-1;i++)
        {
            for(int K=1;K<=E;K++)
            {
                u = edge[K][0];
                v = edge[K][1];
            
            if(distance[u] + w[u][v] < distance[v])
            {
                distance[v] = distance[u] + w[u][v];
                parent[v] = u;
            }
        }
        }
        for(int K=1;K<=E;K++)
        {
            u = edge[K][0];
                v = edge[K][1];
            if(distance[u] + w[u][v] < distance[v])
            {
                flag = 0;
                
            }
        }
        
        if(flag == 1)
        
            for(int i=1;i<=V;i++)
        
            System.out.println("Vertex" +V+ "parent - >" +parent[i]+ "distance - >" +distance[i]);
             return flag;
    }
}
