/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordprocessor;

import javax.swing.event.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.awt.print.*;

//Game 1394 - Project 1(Word Processor)
public class Main extends JFrame implements ActionListener,KeyListener,Printable,MenuKeyListener{
    
    //textArea,fileField,scrollPane,panel
    private JTextArea textArea;
    private JTextField fileField;
    private JScrollPane scrollPane;
    private JPanel northPanel;
    
    //menuBar and menus
    private JMenuBar menuBar;
    private JMenu file;
    private JMenu help;
    private JMenu edit;
    private JMenu tools;
    private JMenu skins;
    private JMenu custom;
    private JMenu font;
    private JMenu sizeMenu;
    
    //menuItems
    private JMenuItem saveAs;
    private JMenuItem open;
    private JMenuItem newItem;
    private JMenuItem about;
    private JMenuItem exit;
    private JMenuItem save;
    private JMenuItem selectAll;
    private JMenuItem wordCount;
    private JMenuItem printSelection;
    private JMenuItem print;
    private JMenuItem customButtonBar;
    private JMenuItem customMenuBar;
    private JMenuItem customTextArea;
    private JMenuItem customTextColor;
    private JRadioButton font1;
    private JRadioButton font2;
    private JRadioButton font3;
    private JRadioButton font4;
    private JRadioButton font5;
    private JRadioButton font6;
    private JRadioButton font7;
    private JRadioButton font8;
    private JRadioButton font9;
    private JRadioButton font10;
    private JRadioButton size1;
    private JRadioButton size2;
    private JRadioButton size3;
    private JRadioButton size4;
    
    //radioButtons
    private JRadioButton darkSkin;
    private JRadioButton muricaSkin;
    private JRadioButton rainbowSkin;
    private JRadioButton boringDefaultSkin;
    
    //checkBoxes and buttons
    private JCheckBox wordWrap;
    private JCheckBox numberedList;
    private JButton newButton;
    private JButton openButton;
    private JButton saveButton;
    private JButton saveAsButton;
    private ButtonGroup bg;
    
    //necessary regular variables
    private boolean saved = false;
    private boolean opened = false;
    private boolean numList = false;
    private boolean t = false;
    private boolean t1 = false;
    private int num = 1;
    private int size = 12;
    
    Main()
    {
        //window settings
        setTitle("Word Processor");
        setSize(500,500);
        setLocation(500,100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //textArea and scrollPane
        textArea = new JTextArea(50,100);
        scrollPane = new JScrollPane(textArea);
        add(scrollPane,BorderLayout.CENTER);
        textArea.addKeyListener(this);
        
        //menuBar and menus
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        file = new JMenu("File");
        help = new JMenu("Help");
        edit = new JMenu("Edit");
        tools = new JMenu("Tools");
        skins = new JMenu("Skins");
        custom = new JMenu("Custom");
        font = new JMenu("Font");
        sizeMenu = new JMenu("Size");
        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(skins);
        menuBar.add(font);
        menuBar.add(tools);
        menuBar.add(help);
        
        //mnemonics for menus
        file.setMnemonic(KeyEvent.VK_F);
        edit.setMnemonic(KeyEvent.VK_E);
        help.setMnemonic(KeyEvent.VK_H);
        tools.setMnemonic(KeyEvent.VK_T);
        skins.setMnemonic(KeyEvent.VK_S);
        
        //menuItem initialization
        saveAs = new JMenuItem("Save As...");
        saveAs.addActionListener(this);
        saveAs.addMenuKeyListener(this);
        open = new JMenuItem("Open...");
        open.addActionListener(this);
        open.addMenuKeyListener(this);
        newItem = new JMenuItem("New");
        newItem.addActionListener(this);
        newItem.addMenuKeyListener(this);
        about = new JMenuItem("About...");
        about.addActionListener(this);
        about.addMenuKeyListener(this);
        exit = new JMenuItem("Exit");
        exit.addActionListener(this);
        exit.addMenuKeyListener(this);
        save = new JMenuItem("Save");
        save.addActionListener(this);
        save.addMenuKeyListener(this);
        selectAll = new JMenuItem("Select All");
        selectAll.addActionListener(this);
        selectAll.addMenuKeyListener(this);
        wordWrap = new JCheckBox("WordWrap");
        wordWrap.addActionListener(this);
        wordWrap.addKeyListener(this);
        wordCount = new JMenuItem("Word Count");
        wordCount.addActionListener(this);
        wordCount.addMenuKeyListener(this);
        numberedList = new JCheckBox("Numbered List");
        numberedList.addActionListener(this);
        numberedList.addKeyListener(this);
        printSelection = new JMenuItem("Print Selection...");
        printSelection.addActionListener(this);
        printSelection.addMenuKeyListener(this);
        print = new JMenuItem ("Print...");
        print.addActionListener(this);
        print.addMenuKeyListener(this);
        customButtonBar = new JMenuItem("Custom Button Bar...");
        customButtonBar.addActionListener(this);
        customMenuBar = new JMenuItem("Custom Menu Bar...");
        customMenuBar.addActionListener(this);
        customTextArea = new JMenuItem("Custom Text Area...");
        customTextArea.addActionListener(this);
        customTextColor = new JMenuItem("Custom Text Color...");
        customTextColor.addActionListener(this);
        
        font1 = new JRadioButton("Calibri");
        font1.addActionListener(this);
        font2 = new JRadioButton("Times New Roman");
        font2.addActionListener(this);
        font3 = new JRadioButton("Arial");
        font3.addActionListener(this);
        font4 = new JRadioButton("Vladimir Script");
        font4.addActionListener(this);
        font5 = new JRadioButton("Elephant");
        font5.addActionListener(this);
        font6 = new JRadioButton("Forte");
        font6.addActionListener(this);
        font7 = new JRadioButton("Georgia");
        font7.addActionListener(this);
        font8 = new JRadioButton("Harrington");
        font8.addActionListener(this);
        font9 = new JRadioButton("Mistral");
        font9.addActionListener(this);
        font10 = new JRadioButton("Poor Richard");
        font10.addActionListener(this);
        size1 = new JRadioButton("12");
        size1.addActionListener(this);
        size2 = new JRadioButton("16");
        size2.addActionListener(this);
        size3 = new JRadioButton("20");
        size3.addActionListener(this);
        size4 = new JRadioButton("24");
        size4.addActionListener(this);
        
        //buttonGroup stuff
        bg = new ButtonGroup();
        darkSkin = new JRadioButton("Dark Skin");
        darkSkin.addActionListener(this);
        muricaSkin = new JRadioButton("'Murica Skin");
        muricaSkin.addActionListener(this);
        rainbowSkin = new JRadioButton("Rainbow Skin");
        rainbowSkin.addActionListener(this);
        boringDefaultSkin = new JRadioButton("Boring Default Skin");
        boringDefaultSkin.addActionListener(this);
        bg.add(darkSkin);
        bg.add(muricaSkin);
        bg.add(rainbowSkin);
        bg.add(boringDefaultSkin);
        boringDefaultSkin.setSelected(true);
        
        //mnemonics for menuItems
        saveAs.setMnemonic(KeyEvent.VK_A);
        selectAll.setMnemonic(KeyEvent.VK_A);
        about.setMnemonic(KeyEvent.VK_A);
        wordCount.setMnemonic(KeyEvent.VK_C);
        newItem.setMnemonic(KeyEvent.VK_N);
        open.setMnemonic(KeyEvent.VK_O);
        print.setMnemonic(KeyEvent.VK_P);
        printSelection.setMnemonic(KeyEvent.VK_R);
        save.setMnemonic(KeyEvent.VK_S);
        exit.setMnemonic(KeyEvent.VK_X);
        numberedList.setMnemonic(KeyEvent.VK_L);
        wordWrap.setMnemonic(KeyEvent.VK_W);
        
        //adding MenuItems to menus
        file.add(newItem);
        file.addSeparator();
        file.add(open);
        file.add(save);
        file.add(saveAs);
        file.addSeparator();
        file.add(printSelection);
        file.add(print);
        file.addSeparator();
        file.add(exit);
        help.add(about);
        edit.add(selectAll);
        edit.add(wordWrap);
        tools.add(wordCount);
        tools.add(numberedList);
        skins.add(darkSkin);
        skins.add(muricaSkin);
        skins.add(rainbowSkin);
        skins.addSeparator();
        skins.add(boringDefaultSkin);
        skins.addSeparator();
        skins.add(custom);
        custom.add(customButtonBar);
        custom.add(customMenuBar);
        custom.add(customTextArea);
        custom.add(customTextColor);
        font.add(font1);
        font.add(font2);
        font.add(font3);
        font.add(font4);
        font.add(font5);
        font.add(font6);
        font.add(font7);
        font.add(font8);
        font.add(font9);
        font.add(font10);
        font.addSeparator();
        font.add(sizeMenu);
        sizeMenu.add(size1);
        sizeMenu.add(size2);
        sizeMenu.add(size3);
        sizeMenu.add(size4);
        
        //northPanel
        northPanel = new JPanel();
        newButton = new JButton("New");
        newButton.addActionListener(this);
        openButton = new JButton("Open...");
        openButton.addActionListener(this);
        saveButton = new JButton("Save");
        saveButton.addActionListener(this);
        saveAsButton = new JButton("Save As...");
        saveAsButton.addActionListener(this);
        northPanel.add(newButton);
        northPanel.add(openButton);
        northPanel.add(saveButton);
        northPanel.add(saveAsButton);
        add(northPanel,BorderLayout.NORTH);
        
        textArea.setFont(new Font("Arial",Font.PLAIN,12));
        font3.setSelected(true);
        
        fileField = new JTextField("");
        setVisible(true);
        pack();
    }
    
    public void actionPerformed(ActionEvent event)
    {
        JFileChooser fileChooser = new JFileChooser();
        AbstractButton pressedButton = (AbstractButton)event.getSource();
        PrinterJob pJob = PrinterJob.getPrinterJob();
        pJob.setPrintable(this);
        boolean ok = false;
        
        if(pressedButton == saveAs || pressedButton == saveAsButton)
        {
            String text = textArea.getText();
            try
            {
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int result = fileChooser.showSaveDialog(this);
                if(result == JFileChooser.CANCEL_OPTION)
                    fileChooser.cancelSelection();
                File fileName = fileChooser.getSelectedFile();
                fileField.setText(fileName.toString());
                PrintWriter output = new PrintWriter(fileName);
                output.println(text);
                output.close();
                saved = true;
            }
            catch(Exception e)
            {
                //System.out.print("You cancelled.");
            }
        }
        else if(pressedButton == open || pressedButton == openButton)
        {
            try
            {
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int result = fileChooser.showOpenDialog(this);
                if(result == JFileChooser.CANCEL_OPTION)
                    fileChooser.cancelSelection();
                File file = fileChooser.getSelectedFile();
                fileField.setText(file.toString());
                FileInputStream fis = new FileInputStream(file);
                byte[] str = new byte[(int)file.length()];
                fis.read(str);
                fis.close();
                String s = new String(str);
                textArea.setText(s);
                opened = true;
            }   
            catch(Exception e){}
        }
        else if(pressedButton == save|| pressedButton == saveButton)
        {
            String text = textArea.getText();
            if(saved == false && opened == false)
            {
                
            try
            {
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int result = fileChooser.showSaveDialog(this);
                if(result == JFileChooser.CANCEL_OPTION)
                    fileChooser.cancelSelection();
                File fileName = fileChooser.getSelectedFile();
                fileField.setText(fileName.toString());
                PrintWriter output = new PrintWriter(fileName);
                output.println(text);
                output.close();
                saved = true;
            }
            catch(Exception e)
            {
                //System.out.print("You cancelled.");
            }
            }
            else
            {
                try{
                File file = new File(fileField.getText());
                PrintWriter output = new PrintWriter(file);
                output.println(text);
                output.close();
                }
                catch(Exception e){}
            }
        }
        else if(pressedButton == newItem|| pressedButton == newButton)
        {
            textArea.setText("");
            fileField.setText("");
        }
        else if(pressedButton == selectAll)
        {
            textArea.setSelectionStart(0);
            textArea.setSelectionEnd(textArea.getText().length());
        }
        else if(pressedButton == wordWrap)
        {
            if(textArea.getLineWrap() == true)
                textArea.setLineWrap(false);
            else
                textArea.setLineWrap(true);
        }
        else if(pressedButton == wordCount)
        {
            int numWords = 0;
            String text = textArea.getText();
            String[] words = text.split("\\s+");
            numWords = words.length;
            if(textArea.getText().length() > 1&& !textArea.getText().startsWith(" "))
                JOptionPane.showMessageDialog(this, "Word Count: "+numWords);
            else if(textArea.getText().length() > 1 && textArea.getText().startsWith(" "))
                JOptionPane.showMessageDialog(this, "Word Count: "+(numWords - 1));
            else
                JOptionPane.showMessageDialog(this,"Word Count: 0");
        }
        else if(pressedButton == numberedList)
        {
            numList = !numList;
            num = 1;
            char[] c = textArea.getText().toCharArray();
            if(numList == true && textArea.getText().length() == 0)
            {
                textArea.insert(num + ")" , 0);
                num++;
            }
            else if(numList == false){
                try{
                if(c[0] == '1' && c[1] == ')'){
                    textArea.setText("");
                    }
                }
            catch(Exception e){}
            }
//            else if(numList == false && textArea.getText().length() == 0)
//            {
//                textArea.setText("");
//                num = 1;
//            }
        }
        else if(pressedButton == printSelection)
        {
            t = true;
            ok = pJob.printDialog();
            if(ok)
            {
                try
                {
                    pJob.print();
                }
                catch(PrinterException e){}
            }
            
        }
        else if(pressedButton == print)
        { 
            t1 = true;
            ok = pJob.printDialog();
            
            if(ok)
                {
                try
                {
                    pJob.print();
                }
                catch(PrinterException e){}
            }
                
        }
        else if(pressedButton == about)
        {
            JOptionPane.showMessageDialog(this,"Justin Wells\nWord Processor\nStarted on 2/26/2018");
        }
        else if(pressedButton == darkSkin)
        {
            Color menuColor = new Color(125,125,125);
            Color buttonColor = new Color(25,25,25);
            Color textColor = new Color(100,100,100);
            textArea.setBackground(textColor);
            menuBar.setBackground(menuColor);
            northPanel.setBackground(buttonColor);
        }
        else if(pressedButton == muricaSkin)
        {
            Color menuColor = new Color(255,0,0);
            Color buttonColor = new Color(0,0,255);
            Color textColor = new Color(255,255,255);
            textArea.setBackground(textColor);
            menuBar.setBackground(menuColor);
            northPanel.setBackground(buttonColor);
        }
        else if(pressedButton == rainbowSkin)
        {
            Color menuColor = new Color(255,0,255);
            Color buttonColor = new Color(255,255,0);
            Color textColor = new Color(50,255,50);
            textArea.setBackground(textColor);
            menuBar.setBackground(menuColor);
            northPanel.setBackground(buttonColor);
        }
        else if(pressedButton == boringDefaultSkin)
        {
            Color menuColor = new Color(238,238,238);
            Color buttonColor = new Color(238,238,238);
            Color textColor = new Color(255,255,255);
            textArea.setBackground(textColor);
            menuBar.setBackground(menuColor);
            northPanel.setBackground(buttonColor);
        }
        else if(pressedButton == customMenuBar)
        {   
            bg.clearSelection();
            Color menuColor = JColorChooser.showDialog(this,"Choose MENU color",menuBar.getBackground());
            menuBar.setBackground(menuColor);
            
        }
        else if(pressedButton == customButtonBar)
        {
            bg.clearSelection();
            Color buttonColor = JColorChooser.showDialog(this,"Choose BUTTON color",northPanel.getBackground());
            northPanel.setBackground(buttonColor);
            
        }
        else if(pressedButton == customTextArea)
        {
            bg.clearSelection();
            Color tAColor = JColorChooser.showDialog(this,"Choose TEXT AREA color",textArea.getBackground());
            textArea.setBackground(tAColor);
            
        }
        else if(pressedButton == customTextColor)
        {
            Color c = JColorChooser.showDialog(this,"Choose TEXT color",textArea.getForeground());
            textArea.setForeground(c);
        }
        else if(pressedButton == font1)
        {
            font2.setSelected(false);
            font3.setSelected(false);
            font4.setSelected(false);
            font5.setSelected(false);
            font6.setSelected(false);
            font7.setSelected(false);
            font8.setSelected(false);
            font9.setSelected(false);
            font10.setSelected(false);
            Font font1 = new Font("Calibri",Font.PLAIN,size);
            textArea.setFont(font1);
        }
        else if(pressedButton == font2)
        {
            font1.setSelected(false);
            font3.setSelected(false);
            font4.setSelected(false);
            font5.setSelected(false);
            font6.setSelected(false);
            font7.setSelected(false);
            font8.setSelected(false);
            font9.setSelected(false);
            font10.setSelected(false);
            Font font2 = new Font("Times New Roman",Font.PLAIN,size);
            textArea.setFont(font2);
        }
        else if(pressedButton == font3)
        {
            font2.setSelected(false);
            font1.setSelected(false);
            font4.setSelected(false);
            font5.setSelected(false);
            font6.setSelected(false);
            font7.setSelected(false);
            font8.setSelected(false);
            font9.setSelected(false);
            font10.setSelected(false);
            Font font3 = new Font("Arial",Font.PLAIN,size);
            textArea.setFont(font3);
        }
        else if(pressedButton == font4)
        {
            font2.setSelected(false);
            font3.setSelected(false);
            font1.setSelected(false);
            font5.setSelected(false);
            font6.setSelected(false);
            font7.setSelected(false);
            font8.setSelected(false);
            font9.setSelected(false);
            font10.setSelected(false);
            Font font4 = new Font("Vladimir Script",Font.PLAIN,size);
            textArea.setFont(font4);
        }
        else if(pressedButton == font5)
        {
            font2.setSelected(false);
            font3.setSelected(false);
            font4.setSelected(false);
            font1.setSelected(false);
            font6.setSelected(false);
            font7.setSelected(false);
            font8.setSelected(false);
            font9.setSelected(false);
            font10.setSelected(false);
            Font font5 = new Font("Elephant",Font.PLAIN,size);
            textArea.setFont(font5);
        }
        else if(pressedButton == font6)
        {
            font2.setSelected(false);
            font3.setSelected(false);
            font4.setSelected(false);
            font5.setSelected(false);
            font1.setSelected(false);
            font7.setSelected(false);
            font8.setSelected(false);
            font9.setSelected(false);
            font10.setSelected(false);
            Font font6 = new Font("Forte",Font.PLAIN,size);
            textArea.setFont(font6);
        }
        else if(pressedButton == font7)
        {
            font2.setSelected(false);
            font3.setSelected(false);
            font4.setSelected(false);
            font5.setSelected(false);
            font6.setSelected(false);
            font1.setSelected(false);
            font8.setSelected(false);
            font9.setSelected(false);
            font10.setSelected(false);
            Font font7 = new Font("Georgia",Font.PLAIN,size);
            textArea.setFont(font7);
        }
        else if(pressedButton == font8)
        {
            font2.setSelected(false);
            font3.setSelected(false);
            font4.setSelected(false);
            font5.setSelected(false);
            font6.setSelected(false);
            font7.setSelected(false);
            font1.setSelected(false);
            font9.setSelected(false);
            font10.setSelected(false);
            Font font8 = new Font("Harrington",Font.PLAIN,size);
            textArea.setFont(font8);
        }
        else if(pressedButton == font9)
        {
            font2.setSelected(false);
            font3.setSelected(false);
            font4.setSelected(false);
            font5.setSelected(false);
            font6.setSelected(false);
            font7.setSelected(false);
            font8.setSelected(false);
            font1.setSelected(false);
            font10.setSelected(false);
            Font font9 = new Font("Mistral",Font.PLAIN,size);
            textArea.setFont(font9);
        }
        else if(pressedButton == font10)
        {
            font2.setSelected(false);
            font3.setSelected(false);
            font4.setSelected(false);
            font5.setSelected(false);
            font6.setSelected(false);
            font7.setSelected(false);
            font8.setSelected(false);
            font9.setSelected(false);
            font1.setSelected(false);
            Font font10 = new Font("Poor Richard",Font.PLAIN,size);
            textArea.setFont(font10);
        }
        else if(pressedButton == size1)
        {
            size2.setSelected(false);
            size3.setSelected(false);
            size4.setSelected(false);
            textArea.setFont(textArea.getFont().deriveFont(12.0f));
            size = 12;
        }
        else if(pressedButton == size2)
        {
            size1.setSelected(false);
            size3.setSelected(false);
            size4.setSelected(false);
            textArea.setFont(textArea.getFont().deriveFont(16.0f));
            size = 16;
        }
        else if(pressedButton == size3)
        {
            size2.setSelected(false);
            size1.setSelected(false);
            size4.setSelected(false);
            textArea.setFont(textArea.getFont().deriveFont(20.0f));
            size = 20;
        }
        else if(pressedButton == size4)
        {
            size2.setSelected(false);
            size3.setSelected(false);
            size1.setSelected(false);
            textArea.setFont(textArea.getFont().deriveFont(24.0f));
            size = 24;
        }
        else if(pressedButton == exit)
        {
            String[]options = {"Sure, why not","Nah"};
            int a = -1;
            if(!saved && textArea.getText().length() > 0)
            {
                a = JOptionPane.showOptionDialog(this,"You didn't save. Do you want to now?","Save?",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,options,options[0]);
                if(a == 0)
                {
                    String text = textArea.getText();
                    try
                    {
                        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                        int result = fileChooser.showSaveDialog(this);
                        if(result == JFileChooser.CANCEL_OPTION)
                        fileChooser.cancelSelection();
                        File fileName = fileChooser.getSelectedFile();
                        fileField.setText(fileName.toString());
                        PrintWriter output = new PrintWriter(fileName);
                        output.println(text);
                        output.close();
                        saved = true;
                        System.exit(0);
                        
                    }
                    catch(Exception e)
                    {
                    }
                 }
                else if(a == 1)
                {
                    System.exit(0);
                }   
            }
            else
                System.exit(0);
        }
    }
    
    public void keyTyped(KeyEvent e) {}
    public void keyPressed(KeyEvent e) {}
    
    public void keyReleased(KeyEvent e)
    {
        int code = e.getKeyCode();
        String text = textArea.getText();
        String [] lines = text.split("\\n");
        
        if(code == KeyEvent.VK_ENTER && numList)
        { 
           textArea.append(num + ")");
           num++;
        }
        else if(!numList)
            num = 1;
    }
    public static void main(String [] args)
    {
      new Main();
    }
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException 
    {
        if(pageIndex > 0)
            return NO_SUCH_PAGE;
        String test = textArea.getSelectedText();
        String test1 = textArea.getText();
        Graphics2D g2d = (Graphics2D)graphics;
        g2d.translate(pageFormat.getImageableX(),pageFormat.getImageableY());
        if(t)
        {
            graphics.drawString(test, 100, 100);
        }
        else if(t1)
        {
            graphics.drawString(test1, 100, 100);
        }
        return PAGE_EXISTS;
    
    }
    @Override
    public void menuKeyTyped(MenuKeyEvent e) {}

    @Override
    public void menuKeyPressed(MenuKeyEvent e) {}

    @Override
    public void menuKeyReleased(MenuKeyEvent e) {}
}
