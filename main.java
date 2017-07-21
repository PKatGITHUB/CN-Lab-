/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;
import java.net.*;
import java.util.Scanner;
/**
 *
 * @author bit
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            InetAddress ip=InetAddress.getLocalHost();
            System.out.println("localhost name : " + ip.getHostName());
            System.out.println("localhost address : " + ip.getHostAddress());
            Scanner sc=new Scanner(System.in);
            String S=new String();
            
            System.out.println("\nËnter the remote host address : ");
            S=sc.nextLine();
            ip=InetAddress.getByName(S);
            System.out.println("remotehost name : " + ip.getHostName());
            
            System.out.println("\nËnter the hostname : ");
            S=sc.nextLine();
            ip=InetAddress.getByName(S);
            System.out.println("remote host address : " + ip.getHostAddress());  
            
            System.out.println("\nMac address of localhost : ");
            ip = InetAddress.getLocalHost();
            NetworkInterface ni = NetworkInterface.getByInetAddress(ip);
            byte[] mac = ni.getHardwareAddress();
            for (int i = 0; i < mac.length; i++) {
                System.out.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : "");
            }
            
            
        }catch(Exception e){
            System.out.print(e);
        }
        
    }
    
}
