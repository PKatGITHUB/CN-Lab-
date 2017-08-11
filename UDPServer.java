/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udpserver;
import java.net.*;
import java.io.*;
import java.text.*;
import java.util.*;
/**
 *
 * @author bit
 */
public class UDPServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{    
            DatagramSocket serverSocket = new DatagramSocket(4321);
            byte[] receiveData = new byte[1024];
            byte[] sendData = new byte[1024];
            
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            String sentence = new String( receivePacket.getData());
            System.out.println(sentence);
            
            InetAddress ip = receivePacket.getAddress();
            String ipadd=ip.getHostAddress();
            int port=receivePacket.getPort();
            System.out.println("Port : " + port);
            System.out.println("IP : " + ipadd);
            /*
            String reply = "Msg Recieved";
            sendData = reply.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ip, port);
            serverSocket.send(sendPacket);
            */
            /*for(int i=0;i<sentence.length();i++){
                System.out.println(sentence.charAt(i)+" ");
            }
            */
            if(sentence.contains("Date?")){
            DateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date=new Date();
            String d = dateFormat.format(date);
            sendData = d.getBytes();
            DatagramPacket sendPacket2 = new DatagramPacket(sendData, sendData.length, ip, port);
            serverSocket.send(sendPacket2);
            }
            //serverSocket.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
