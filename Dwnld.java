/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dwnld;
import java.net.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
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
                final byte data[] = new byte[1];
                final byte size[] = new byte[102400000];
                int count,sz,i=0;
                sz=in.read(size, 0, 102400000);
                System.out.println(sz + "Downloading ");
                while ((count = in.read(data, 0, 1)) != -1) {
                    
                    fout.write(data, 0, count);
                    Thread.sleep(100);
                    System.out.println(i);
                    i++;
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
// http://cdn6.bigcommerce.com/s-2sxhiat0li/product_images/theme_images/moltenusa_homepage-basketball4__05239.jpg
