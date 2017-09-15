package tictactoe;
import java.net.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TicTacToe {
    static boolean win=false;
    static char[][] board={{'E','E','E'},{'E','E','E'},{'E','E','E'}};
    static int recMess=0;
    static InetAddress ip;
    static server s=new server(ip,4321);
    static client c=new client(4321);

    public static void main(String[] args) {
        try {
            ip=InetAddress.getByName("localhost");
            int recMess,i,j;
            char ch;
            for(int l=0;l<3;l++){
                System.out.println(board[l]);
            }            
            while(true){                               
                System.out.println("player 1 turn : ");
                makeTurn(c,'o');
                if(Check('o')==true){
                    System.out.println("Player 1 Wins!!");
                    break;
                } 
                if(checkDraw()){
                    System.out.println("Draw!!");
                    break;
                }
                System.out.println("player 2 turn : ");
                makeTurn(c,'x');
                if(Check('x')){
                    System.out.println("Player 2 Wins!!");
                    break;
                }
                if(checkDraw()){
                    System.out.println("Draw!!");
                    break;
                }                  
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static void makeTurn(client c,char chr){
        int i,j;
        c.response();
        recMess=s.recieve();
        i=(recMess-1)/3;
        j=(recMess-1)%3;
        board[i][j]=chr;
        for(int l=0;l<3;l++){
            System.out.println(board[l]);
        }
    }
    public static boolean Check(char ch){
        for(int i=0;i<3;i++){
            int s=0;
            for(int j=0;j<3;j++){
                if(board[i][j]==ch)
                   s++; 
            }
            if(s==3)
                return true;
        }
        for(int i=0;i<3;i++){
            int s=0;
            for(int j=0;j<3;j++){
                if(board[j][i]==ch)
                   s++; 
            }
            if(s==3)
                return true;
        }
        int s=0;
        for(int i=0;i<3;i++){
            if(board[i][i]==ch)                
                s++;            
        }
        if(s==3)
            return true;
        s=0;
        for(int i=0,j=2;i<3;i++,j--){         
            if(board[i][j]==ch)
                s++;           
        }
        if(s==3)
            return true;
        return false;
    }
    public static boolean checkDraw(){
        int c=0;
        for(int l=0;l<3;l++){
            for(int m=0;m<3;m++){
            if(board[l][m]!='E')
                c++;
            }
        }
        if(c==9){
            return true;
        }
         return false;
    }
}
class server{
    DatagramSocket serverSocket;
    byte[] sendData;
    byte[] recieveData;
    InetAddress ip;
    int port;
    server(InetAddress ip,int port){
        try {
            serverSocket=new DatagramSocket(port);
            sendData=new byte[1024];
            recieveData=new byte[1024];
            this.port=port;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public int recieve(){
        try{
            DatagramPacket receivePacket = new DatagramPacket(recieveData, recieveData.length);
            serverSocket.receive(receivePacket);
            String sentence =new String(receivePacket.getData()) ;         
            int x=sentence.charAt(0)-48;
            System.out.println(x);
            return x;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return 0;
    }
}

class client{
    BufferedReader inp;
    DatagramSocket clientSocket;
    InetAddress ip;
    int port;
    byte[] sendData;
    byte[] recieveData;
    client(int port){
        try {
            inp =new BufferedReader(new InputStreamReader(System.in));
            clientSocket = new DatagramSocket();
            ip = InetAddress.getByName("localhost");
            sendData = new byte[1024];
            recieveData = new byte[1024];
            this.port=port;       
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
    public void response(){
        try {
            String sentence =inp.readLine();
            sendData = sentence.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ip, 4321);
            clientSocket.send(sendPacket);
            System.out.println("client response sent!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}