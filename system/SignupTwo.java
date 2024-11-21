package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {
    JTextField pan,aadhaarTextField;
    JButton next;
    JRadioButton Syes,Sno,Eyes,Eno;
    JComboBox religion,income,Education,category,occupation;
    String formno;
    
    SignupTwo(String formno){
        
        this.formno=formno;
        
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FOEM -PAGE 2");
        
        
        JLabel additionalDetails=new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,25);
        add(additionalDetails);
        
        String valReligion[]={"Hindu","Muslim","Sikh","Christian","Others"};
        religion=new JComboBox(valReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        JLabel Religion=new JLabel("Religion:");
        Religion.setFont(new Font("Raleway",Font.BOLD,20));
        Religion.setBounds(100,140,100,30);
        add(Religion);
        
        
        JLabel Category=new JLabel("Category:");
        Category.setFont(new Font("Raleway",Font.BOLD,20));
        Category.setBounds(100,190,200,30);
        add(Category);
        
        String valcategory[]={"General","OBC","SC","ST","Other"};
        category =new JComboBox(valcategory);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.WHITE);
        add(category);
        
        JLabel Income=new JLabel("Income:");
        Income.setFont(new Font("Raleway",Font.BOLD,20));
        Income.setBounds(100,240,200,30);
        add(Income);
        
        String Incomecategory[]={"NULL","<1,50,000","<2,50,000","<5,00,000","<upto 10,00,000"};
        income =new JComboBox(Incomecategory);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.WHITE);
        add(income);
        
        JLabel education=new JLabel("Education:");
        education.setFont(new Font("Raleway",Font.BOLD,20));
        education.setBounds(100,290,200,30);
        add(education);
        
        JLabel qualification=new JLabel("Qualification:");
        qualification.setFont(new Font("Raleway",Font.BOLD,20));
        qualification.setBounds(100,315,200,30);
        add(qualification);
        
        String educationalval[]={"Non-Graduation","Graduation","Post-Graduation","Doctrate","Others"};
        Education =new JComboBox(educationalval);
        Education.setBounds(300,315,400,30);
        Education.setBackground(Color.WHITE);
        add(Education);
        
        
        JLabel Occupation=new JLabel("Occupation:");
        Occupation.setFont(new Font("Raleway",Font.BOLD,20));
        Occupation.setBounds(100,390,200,30);
        add(Occupation);
        
        String occupationalval[]={"Salaried","Self-Employed","Bussiness","Student","Retired","Others"};
        occupation =new JComboBox(occupationalval);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
        
        JLabel Pan=new JLabel("PAN No:");
        Pan.setFont(new Font("Raleway",Font.BOLD,20));
        Pan.setBounds(100,440,200,30);
        add(Pan);
        
        pan=new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,14));
        pan.setBounds(300,440,400,30);
        add(pan);
        
        JLabel city=new JLabel("Aadhaar No:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);
        
        aadhaarTextField=new JTextField();
        aadhaarTextField.setFont(new Font("Raleway",Font.BOLD,14));
        aadhaarTextField.setBounds(300,490,400,30);
        add(aadhaarTextField);
   
        JLabel senior=new JLabel("Senoir Citizen:");
        senior.setFont(new Font("Raleway",Font.BOLD,20));
        senior.setBounds(100,540,200,30);
        add(senior);
        
        Syes=new JRadioButton("Yes");
        Syes.setBounds(300,540,100,30);
        Syes.setBackground(Color.WHITE);
        add(Syes);
        
        Sno=new JRadioButton("No");
        Sno.setBounds(450,540,100,30);
        Sno.setBackground(Color.WHITE);
        add(Sno);
        
        ButtonGroup Senoir_Citizen=new ButtonGroup();
        Senoir_Citizen.add(Syes);
        Senoir_Citizen.add(Sno);
        
        JLabel Account=new JLabel("Existing Account:");
        Account.setFont(new Font("Raleway",Font.BOLD,20));
        Account.setBounds(100,590,200,30);
        add(Account);
        
        Eyes=new JRadioButton("Yes");
        Eyes.setBounds(300,590,100,30);
        Eyes.setBackground(Color.WHITE);
        add(Eyes);
        
        Eno=new JRadioButton("No");
        Eno.setBounds(450,590,100,30);
        Eno.setBackground(Color.WHITE);
        add(Eno);
        
        ButtonGroup Existing_Account=new ButtonGroup();
        Existing_Account.add(Eyes);
        Existing_Account.add(Eno);
        
        next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
        
        //getContentPane().setBackground();
        getContentPane().setBackground(new Color(255, 182, 193));
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        
        String sreligion=(String)religion.getSelectedItem();
        String scategory=(String)category.getSelectedItem();
        String sincome=(String)income.getSelectedItem();
        String seducation=(String)Education.getSelectedItem();
        String soccupation=(String)occupation.getSelectedItem();
        String seniorcitizen=null;
        if(Syes.isSelected()){
            seniorcitizen="Yes";
    }
        else if(Sno.isSelected())
                seniorcitizen="No";
       
        String existingaccount=null;
        if(Eyes.isSelected())
           existingaccount="Yes";
        else if(Eno.isSelected())
            existingaccount="No";
        
        
        String span=pan.getText();
        String saadhaar=aadhaarTextField.getText();
       
        
        try{
            
                Conn c=new Conn();
                String query="insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhaar+"','"+seniorcitizen+"','"+existingaccount+"')";
                c.s.executeUpdate(query);
               
                setVisible(false);
                new SignupThree(formno).setVisible(true);
                
        }catch(Exception e){
            System.out.print(e);
        }
    }
    public static void main(String args[]){
        new SignupTwo("");
}
}
