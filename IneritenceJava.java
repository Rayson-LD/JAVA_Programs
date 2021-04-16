/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labprogram;

/**
 *
 * @author HP
 */
class teacher
{
    void teach()
    {
        
        System.out.println("Teaching subjects");
    }
}
class students extends teacher
{
    void listen()
    {
        System.out.println("Listening to teacher");
    }
}
public class IneritenceJava 
{
 public static void main(String args[])
 {
     students s1 = new students();
     s1.teach();
     s1.listen();
 }
}
