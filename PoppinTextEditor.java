import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

class PoppinTextEditor{
    public static void main(String[] args){
        JFrame frame = new JFrame("PoppinTextEditor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);   

        JEditorPane editor = new JEditorPane();
        editor.setContentType("text/plain");
        editor.setText("Hello World");
        frame.add(new JScrollPane(editor), BorderLayout.CENTER);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem newItem = new JMenuItem("New");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem saveAsItem = new JMenuItem("Save As");
        JMenuItem exitItem = new JMenuItem("Exit");
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(saveAsItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);
        
        newItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                editor.setText("");
            }
        });
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