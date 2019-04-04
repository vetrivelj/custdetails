package customer_info;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainClass { 
    
    private JFrame mainFrame ;
    
    private CustomerDetails customerDtPanel = new CustomerDetails();


    public MainClass() {
        prepareGUI();
    }
    
    void prepareGUI(){
    
    
    mainFrame = new JFrame("Customer Details");
    
 
    mainFrame.setResizable(false);
    mainFrame.setSize(1000, 500);
    mainFrame.setLocationRelativeTo(null);
    mainFrame.getContentPane().setBackground(new Color(221,235,247));
    mainFrame.setLayout(null);
    //  mainFrame.getContentPane().add(()));
    
    System.out.println("Frame Created");
    
    mainFrame.addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent windowEvent) {
           
            System.exit(0);
        }
    });
    
        mainFrame.setVisible(true);
        mainFrame.repaint();
        
        
        customerDtPanel.setLocation(120,80);
        mainFrame.add(customerDtPanel);
        
        //mainFrame.add(customerDtPanel,100);
    
    }
    

    public static void main(String[] args) {
        
        MainClass mainClass = new MainClass();       
        
        
       // Customer_Details customer_Details = new Customer_Details();
        //customer_Details.ok();
        
        
    }
}
