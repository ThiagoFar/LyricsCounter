
package components;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class WriterSub {
	
	
    private static File path2 = new File("");
    private static File path3 = new File("");
    private int unwords=0;
    
    public void writing(String[] message) throws IOException {
    	String documentsPath = System.getProperty("user.home") + "/Documents/WordsOutput";
    	documentsPath=documentsPath.replace("\\", "/");
    	path2=new File(documentsPath+"/Process.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(path2, true));
        writer.newLine();

        for (String str : message) {
            writer.write(str + " ");
            writer.newLine();

        }

        writer.newLine();
        writer.newLine();

        writer.newLine();
        long end = System.currentTimeMillis();

        writer.flush();

        writer.close();

    }
    
    

    public void writing2(String message2,int nmusic) throws IOException {
    	int lovekit=0;
    	 Scanner read= new Scanner(System.in);
     	
     	String name=JOptionPane.showInputDialog(null, "Save As:");
        
        path3= new File("C:/Users/raven/Documents/WordsOutput/"+name+".txt");
        
        String[] message2Array;
       
        BufferedWriter writer = new BufferedWriter(new FileWriter(path3, true));
        
       
        writer.newLine();
        message2Array = message2.split("<");
        writer.write("  ");
        for (String str : message2Array) {
        	unwords++;
        	
        	//Lovekit test
        	if ((str.contains("love")||(str.contains("feeling"))||(str.contains("heart")) )) {
        		
        		String s = str;
        		Matcher matcher = Pattern.compile("\\d+").matcher(s);
        		matcher.find();
        		int i = Integer.valueOf(matcher.group());
        		
        		lovekit=lovekit+i;
        	}
        	
            writer.write(str + "");
            writer.newLine();

        }
        
        writer.flush();

        writer.close();
        
        
        JOptionPane.showMessageDialog(null, "Statistics: \n Vocabulary (average of unique words used per song): " +unwords/nmusic
        		+"\n LoveKit (number of musics the words Heart,Feeling,Love appear): "+lovekit);
     
       

      
        
        System.exit(0);
    }
}
