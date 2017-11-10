/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dwnld;
import java.net.*;
import java.io.*;
import java.util.*;
/**
 *
 * @author bit
 */
public class Dwnld {

    /**
     * @param args the command line arguments
     */
    
    public static void saveUrl(final String filename, final String urlString) {
            BufferedInputStream in = null;
            FileOutputStream fout = null;
            try {
                in = new BufferedInputStream(new URL(urlString).openStream());
                fout = new FileOutputStream(filename);
                final byte data[] = new byte[1024];
                int count;
                while ((count = in.read(data, 0, 1024)) != -1) {
                    fout.write(data, 0, count);
                }
                in.close();
                fout.close();
            } catch(Exception e){
                e.printStackTrace();
            }
        }
    public static void main(String[] args) {
        // TODO code application logic here
        BufferedReader inp =new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the url : ");
        String S,F;
        try {
            S=inp.readLine();
            System.out.println("Enter the file name : ");
            F=inp.readLine();
            saveUrl(F,S);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}


// http://ohsaa.org/portals/0/Sports/Basketball-Boys/Schottpano.JPG