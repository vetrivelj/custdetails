package customer_info;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import java.util.ArrayList;

import java.util.Properties;

import javax.swing.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import oracle.adf.model.*;
import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.*;

import oracle.jbo.uicli.binding.*;
import oracle.jbo.uicli.controls.*;
import oracle.jbo.uicli.jui.*;

import oracle.jdeveloper.layout.*;


public class CustomerDetails extends JPanel  {

    
    private JTextField jTextName = new JTextField();
    private JTextField jTextAddr1 = new JTextField();
    private JTextField jTextAddr2 = new JTextField();
    private JLabel jLblName = new JLabel();
    private JLabel jLblAddr1 = new JLabel();
    private JLabel jLblAddr2 = new JLabel();
    private JButton jBtnSave = new JButton();
    private JButton jBtnCancel = new JButton();
    
     Properties props=new Properties();
    private JButton jBtnClear = new JButton();


    /**The default constructor for panel
     */
    public CustomerDetails() {

        try {
            jbInit();
        } catch (Exception e) {
        }
    }

    /**the JbInit method
     */
    public void jbInit() throws Exception {
        this.setLayout(null);
        this.setSize(new Dimension(667, 300));
        jTextName.setBounds(new Rectangle(290, 30, 245, 20));
        jTextAddr1.setBounds(new Rectangle(290, 75, 305, 20));
        jTextAddr2.setBounds(new Rectangle(290, 120, 305, 20));
        jLblName.setText("Name");
        jLblName.setBounds(new Rectangle(145, 30, 100, 20));
        jLblAddr1.setText("Address 1");
        jLblAddr1.setBounds(new Rectangle(145, 75, 65, 20));
        jLblAddr2.setText("Address 2");
        jLblAddr2.setBounds(new Rectangle(145, 120, 60, 25));
        jBtnSave.setText("Save");
        jBtnSave.setBounds(new Rectangle(170, 185, 75, 21));
        jBtnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jBtnSave_actionPerformed(e);
            }
        });
        jBtnCancel.setText("Cancel");
        jBtnCancel.setBounds(new Rectangle(435, 185, 75, 21));
        jBtnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jBtnCancel_actionPerformed(e);
            }
        });
        jBtnClear.setText("Clear");
        jBtnClear.setBounds(new Rectangle(305, 185, 75, 21));
        jBtnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jBtnClear_actionPerformed(e);
            }
        });
        this.add(jBtnClear, null);
        this.add(jBtnCancel, null);
        this.add(jBtnSave, null);
        this.add(jLblAddr2, null);
        this.add(jLblAddr1, null);
        this.add(jLblName, null);
        this.add(jTextAddr2, null);
        this.add(jTextAddr1, null);
        this.add(jTextName, null);
    }

    private void jBtnCancel_actionPerformed(ActionEvent e) {
        //setVisible(false);
        System.exit(0);
    }

    private void jBtnSave_actionPerformed(ActionEvent e) {
        
        String name = jTextName.getText();  
        
        
       // if(  name != null || !(name.equals(""))) {
            
            if( !(name.equals(""))) {
        
        //String name = jTextName.getText();        
        String address1 = jTextAddr1.getText();
        String address2 = jTextAddr2.getText();
        
        
        String MasterMDataFile="files\\Customers\\"+name+".xml";
        
        try {
        
        props.setProperty("Name", name);
          
        props.setProperty("Address2", address2);
        props.setProperty("Address1", address1);        
        
        
        
        OutputStream os;                        
        os = new FileOutputStream(MasterMDataFile);
        props.storeToXML(os, name,"UTF-8");            
          
        JOptionPane.showMessageDialog(null, "Record Created in Folder files\\Customers\\");
        //System.out.println("XMl File Created");
            
            jTextName.setText("");
            jTextAddr1.setText("");
            jTextAddr2.setText("");
        
                   
        } catch (FileNotFoundException f) {
        } catch (IOException f) {
        }

       
        } else {
            
            JOptionPane.showMessageDialog(null, " Name is missing ....Enter the name");
          
        }
        
        
    }

    private void jBtnClear_actionPerformed(ActionEvent e) {
        
        jTextName.setText("");
        jTextAddr1.setText("");
        jTextAddr2.setText("");
    }
}


