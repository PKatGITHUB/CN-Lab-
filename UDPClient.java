/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udpclient;
import java.net.*;
import java.io.*;
/**
 *
 * @author bit
 */
public class UDPClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            BufferedReader inp =new BufferedReader(new InputStreamReader(System.in));
            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress ip = InetAddress.getByName("localhost");
            byte[] sendData = new byte[1024];
            byte[] receiveData = new byte[1024];
            String sentence ="Client 1 Sends : " +  inp.readLine();
            sendData = sentence.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ip, 4321);
            clientSocket.send(sendPacket);
            if(sentence.contains("Date?")){
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);
            String modifiedSentence = new String(receivePacket.getData());
            System.out.println(modifiedSentence);
            }
            /*
            DatagramPacket receivePacket2 = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket2);
            modifiedSentence = new String(receivePacket2.getData());
            System.out.println(modifiedSentence);
            */
            clientSocket.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
