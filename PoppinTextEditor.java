import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

class PoppinTextEditor{
    public static void main(String[] args){
        //Initial JFrame
        JFrame frame = new JFrame("PoppinTextEditor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set Default Size
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);   

        //Intial Editor Frame
        JEditorPane editor = new JEditorPane();
        editor.setContentType("text/plain");
        //Default Text upon Opening Program
        editor.setText("Hello World");
        //add editor to mainframe
        frame.add(new JScrollPane(editor), BorderLayout.CENTER);

        //Menu Bar
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem newItem = new JMenuItem("New");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem saveAsItem = new JMenuItem("Save As");
        JMenuItem exitItem = new JMenuItem("Exit");

        //Add Menu Items to Menu Bar
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(saveAsItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);
        
        //Action Listeners
        //Clears current editor
        newItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                editor.setText("");
            }
        });
        //Opens File
        openItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JFileChooser chooser = new JFileChooser();
                int result = chooser.showOpenDialog(frame);
                if(result == JFileChooser.APPROVE_OPTION){
                    //open file here
                    File file = chooser.getSelectedFile();
                    try{
                        Scanner input = new Scanner(file);
                        String text = "";
                        while(input.hasNext()){
                            text += input.nextLine() + "\n";
                        }
                        editor.setText(text);
                    }catch(FileNotFoundException ex){
                        ex.printStackTrace();
                    }

                }
            }
        });
        //Saves File
        saveItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JFileChooser chooser = new JFileChooser();
                int result = chooser.showSaveDialog(frame);
                if(result == JFileChooser.APPROVE_OPTION){
                    //save file here
                    File file = chooser.getSelectedFile();
                    try{
                        PrintWriter output = new PrintWriter(file);
                        output.println(editor.getText());
                        output.close();
                    }catch(FileNotFoundException ex){
                        ex.printStackTrace();
                    }
                }
            }
        });
        //Saves File As
        saveAsItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JFileChooser chooser = new JFileChooser();
                int result = chooser.showSaveDialog(frame);
                if(result == JFileChooser.APPROVE_OPTION){
                    //save file here
                    File file = chooser.getSelectedFile();
                    try{
                        PrintWriter output = new PrintWriter(file);
                        output.println(editor.getText());
                        output.close();
                    }catch(FileNotFoundException ex){
                        ex.printStackTrace();
                    }
                }
            }
        });
        //Exits Program
        exitItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });

        //set content to editor
        frame.setContentPane(editor);
        //set menu bar to frame
        frame.setJMenuBar(menuBar);
        //set frame to visible
        frame.setVisible(true);

    }
}