

package components;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.*;

public class WordsMain extends JPanel
                             implements ActionListener {
    static private final String newline = "\n";
    JButton openButton;
   // JTextArea log;
    JFileChooser fc;
 static String[] pathf= new String[100];
    public WordsMain() {
        super(new BorderLayout());

        
        
       // log = new JTextArea(0,30);
        //log.setMargin(new Insets(1,1,1,1));
        //log.setEditable(false);
        
      //  JScrollPane logScrollPane = new JScrollPane(log);

        
        fc = new JFileChooser();
        fc.setMultiSelectionEnabled(true);
        
        openButton = new JButton("Select Lyrics...",
                                 createImageIcon("images/Open16.gif"));
        openButton.addActionListener(this);

       
       
     
  
        JPanel buttonPanel = new JPanel(); 
        buttonPanel.add(openButton);
       

      
        add(buttonPanel, BorderLayout.PAGE_START);
      //  add(logScrollPane, BorderLayout.CENTER);
    }

   

public void actionPerformed(ActionEvent e) {

        //Handle open button action.
        if (e.getSource() == openButton) {
            int returnVal = fc.showOpenDialog(WordsMain.this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                
                File[] file = fc.getSelectedFiles();
                int cont=1;
                int cont2=0;
                int nmusic=file.length;
                WriterSub WRITEZ = new WriterSub();
              
                while(cont2<nmusic){
                   
                pathf[cont]=file[cont2].getPath();
                
                cont++;
                cont2++;
                }
               
              
                //JOptionPane.showMessageDialog(null, "Files Opened");
                
                {
                	try {
						maine(nmusic);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                }
               
            } else {
            //    log.append("Open command cancelled by user." + newline);
            }
           // log.setCaretPosition(log.getDocument().getLength());
        }
}

    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = WordsMain.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
    	
        
        JFrame frame = new JFrame("Words");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        
        frame.add(new WordsMain());
        
       
        frame.pack();
        frame.setSize(400, 100);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    	
    }

    public static void main(String[] args) throws IOException {
        
    	
    	  	
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
          
                UIManager.put("swing.boldMetal", Boolean.FALSE); 
                
                boolean c=true;
                createAndShowGUI();
            
            
            
            
            
            }
        });
        
        

    }
    
    public void maine(int nmusic) throws IOException {
    	String documentsPath = System.getProperty("user.home") + "/Documents/WordsOutput";
    	documentsPath=documentsPath.replace("\\", "/");
        
                Scanner read = new Scanner(System.in);

        //DECLARATIONS
        ReaderSub READZ = new ReaderSub();
        WriterSub WRITEZ = new WriterSub();
        String[] message;
        String message2;
        
        
        
       
      //CREATINGS FILES AND FOLDERS
        File diretorio = new File(documentsPath);
        diretorio.mkdir();
        
        boolean exists = (new File(documentsPath+"/Process.txt")).exists();
        if (exists) {
        	
        	 File f = new File(documentsPath+"/Process.txt");
             f.createNewFile();
             f.delete();
        } else {
        	
        	 File f = new File(documentsPath+"/Process.txt");
             f.createNewFile();
        }
        
      
        
        
        String findOutput = documentsPath+"/Process.txt";
       
        //LOGIC
       
            int cont = 1;
            while (pathf[cont] != null) {

                try {
                    READZ.read(pathf[cont]);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                message = READZ.mafs();
                try {
                    WRITEZ.writing(message);
                } catch (IOException e) {

                    e.printStackTrace();
                }
                cont++;
            }

            //END OUTPUT
            try {
                READZ.read2(findOutput);
            } catch (IOException e) {
                e.printStackTrace();
            }

            //CONVERTE E ESCREVE
            message2 = READZ.mafs2();
            try {
                WRITEZ.writing2(message2,nmusic);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    	
    }
    
