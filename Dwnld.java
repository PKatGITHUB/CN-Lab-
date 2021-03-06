package dwnld;
import java.net.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
public class Dwnld {
    public static void saveUrl(final String filename, final String urlString) {
        try{
            int len;    
            URL url=new URL(urlString);
            HttpURLConnection conn = null;
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("HEAD");
            conn.getInputStream();
            len=conn.getContentLength();
            BufferedInputStream in = null;
            FileOutputStream fout = null;
            in = new BufferedInputStream(url.openStream());
            fout = new FileOutputStream(filename);
            final byte data[] = new byte[1024];       
            int count,i=0,sz10,p=0;
            sz10=len/10240;          
            System.out.println(filename + " of size " + len + " bytes downloading... ");            
            while ((count = in.read(data, 0, 1024)) != -1) {
                i++;
                if(i==sz10){
                    p++;
                    System.out.println(p*10+"% completed... "); 
                    i=0;
                }
                fout.write(data, 0, count);
                Thread.sleep(10);
            }
            in.close();
            fout.close();
            } catch(Exception e){
                e.printStackTrace();
            }
        }
    public static void main(String[] args) {
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
