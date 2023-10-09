
package SurveySystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Rating {
    JFrame rating=new JFrame();
    private JPanel ratingPanel;
    private JSlider slider1;
    private JTextField textField1;
    private JTextArea textArea1;
    private JButton SUBMITbutton;
    private JLabel rate;
    private JCheckBox anonymousCheckBox; // Add this field

   
    
    public Rating(){
        rating.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rating.setContentPane(ratingPanel);
        rating.pack();
        rating.setLocationRelativeTo(null);
        
        slider1.setMinimum(0);
        slider1.setMaximum(5);
        slider1.setPaintTicks(true);
        slider1.setPaintLabels(true);
        slider1.setMajorTickSpacing(1);
        
       anonymousCheckBox = new JCheckBox("Provide Anonymous Feedback");

        
        
        SUBMITbutton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                if(textField1.getText().equals("")||textArea1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please Fill The Name & Feedback");
                
                }else{
                    try {
                        String sql= "insert into rate"+"(Name,Rating,Feedback)"+"values(?,?,?)";
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/intern","root","root");
                        java.sql.PreparedStatement statement=connection.prepareStatement(sql);
                    statement.setString(1, textField1.getText());
                    statement.setString(2, String.valueOf(slider1.getValue()));
                    statement.setString(3, textArea1.getText());
                    statement.executeUpdate();
                    JOptionPane.showMessageDialog(null, "RATED SUCCESSFULLY");
                    textField1.setText("");
                    textArea1.setText("");
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                       }
                    }
                    }
                        });
                        slider1.addMouseListener(new MouseAdapter() {
                        public void mouseClicked(MouseEvent e) {
                        rate.setText(String.valueOf(slider1.getValue())+" Star");
                    }
                });
                }

                }
                
           
    
    
    

