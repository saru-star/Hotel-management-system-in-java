import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import project.InsertUpdateDelete;
import project.Select;

import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.ActionEvent;

public class CustomerCheckIn extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField4;
	private JTextField textField3;
	private JTextField textField5;
	private JTextField textField6;
	private JTextField textField7;
	JComboBox dropdown3;
	JComboBox dropdown4 ;
	JComboBox dropdown2;
	String bed;
	String roomType;
	String roomNo;
	String price;

	public static void main(String[] args) {
		try {
			CustomerCheckIn frame = new CustomerCheckIn();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public CustomerCheckIn() {
		
		setLocation(new Point(50, 118));
		setUndecorated(true);
		setPreferredSize(new Dimension(1266, 600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1266, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel txtlabel = new JLabel("Customer CheckIn");
		txtlabel.setForeground(new Color(128, 0, 64));
		txtlabel.setFont(new Font("Algerian", Font.BOLD, 12));
		txtlabel.setIcon(new ImageIcon("C:\\Users\\saparna\\Downloads\\Hotel Images & Icon\\Hotel Images & Icon\\Customer Registration & Check IN.png"));
		txtlabel.setBounds(33, 36, 210, 67);
		contentPane.add(txtlabel);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		button.setIcon(new ImageIcon("C:\\Users\\saparna\\Downloads\\Hotel Images & Icon\\Hotel Images & Icon\\close.png"));
		button.setBounds(1009, 93, 25, 33);
		contentPane.add(button);
		
		JLabel txtLabel1 = new JLabel("Name");
		txtLabel1.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtLabel1.setBounds(33, 166, 70, 25);
		contentPane.add(txtLabel1);
		
		textField = new JTextField();
		textField.setBounds(33, 202, 320, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel txtLabel2 = new JLabel("Mobile Number");
		txtLabel2.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtLabel2.setBounds(33, 239, 107, 14);
		contentPane.add(txtLabel2);
		
		textField1 = new JTextField();
		textField1.setBounds(33, 278, 320, 20);
		contentPane.add(textField1);
		textField1.setColumns(10);
		
		JLabel txtLabel3 = new JLabel("Nationality");
		txtLabel3.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtLabel3.setBounds(33, 317, 89, 14);
		contentPane.add(txtLabel3);
		
		textField2 = new JTextField();
		textField2.setBounds(33, 355, 320, 20);
		contentPane.add(textField2);
		textField2.setColumns(10);
		
		JLabel txtLabel4 = new JLabel("Gender");
		txtLabel4.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtLabel4.setBounds(33, 400, 49, 14);
		contentPane.add(txtLabel4);
		
		JLabel txtLabel5 = new JLabel("Email");
		txtLabel5.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtLabel5.setBounds(33, 493, 49, 14);
		contentPane.add(txtLabel5);
		
		textField4 = new JTextField();
		textField4.setBounds(33, 529, 320, 20);
		contentPane.add(textField4);
		textField4.setColumns(10);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female", "Others"}));
		comboBox.setBounds(33, 440, 320, 22);
		contentPane.add(comboBox);
		
		JLabel txtLabel6 = new JLabel("ID Proof");
		txtLabel6.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtLabel6.setBounds(449, 172, 95, 14);
		contentPane.add(txtLabel6);
		
		textField3 = new JTextField();
		textField3.setBounds(449, 202, 226, 20);
		contentPane.add(textField3);
		textField3.setColumns(10);
		
		JLabel txtLabel7 = new JLabel("Address");
		txtLabel7.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtLabel7.setBounds(449, 240, 49, 14);
		contentPane.add(txtLabel7);
		
		textField5 = new JTextField();
		textField5.setBounds(449, 278, 226, 20);
		contentPane.add(textField5);
		textField5.setColumns(10);
		
		JLabel txtLabel8 = new JLabel("Check In Date(Today)");
		txtLabel8.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtLabel8.setBounds(449, 318, 128, 14);
		contentPane.add(txtLabel8);
		
		textField6 = new JTextField();
		textField6.setBounds(449, 355, 226, 20);
		contentPane.add(textField6);
		textField6.setColumns(10);
		
		JLabel txtLabel9 = new JLabel("Bed");
		txtLabel9.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtLabel9.setBounds(749, 172, 49, 14);
		contentPane.add(txtLabel9);
		
		final JComboBox dropdown4 = new JComboBox();
		
		dropdown4.setModel(new DefaultComboBoxModel(new String[] {"Single", "Double", "Triple"}));
		dropdown4.setBounds(749, 201, 226, 22);
		contentPane.add(dropdown4);
		
		JLabel txtLabel10 = new JLabel("Room Type");
		txtLabel10.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtLabel10.setBounds(749, 240, 107, 14);
		contentPane.add(txtLabel10);
		dropdown3 = new JComboBox();
		final JComboBox dropdown2 = new JComboBox();
		dropdown2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dropdown3.removeAllItems();
				textField7.setText("");
				bed=(String)dropdown4.getSelectedItem();
				roomType=(String)dropdown2.getSelectedItem();
				try {
					System.out.print(bed+" "+roomType);
					ResultSet rs=Select.getData("select * from room where bed='"+bed+"' and roomType='"+roomType+"' and status='Not Booked'");
					while(rs.next())
					{
						dropdown3.addItem(rs.getString(1));
					}
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null,ex);
					
				}
				
			}
		});
		dropdown2.setModel(new DefaultComboBoxModel(new String[] {"AC", "Non-AC"}));
		dropdown2.setBounds(749, 277, 226, 22);
		contentPane.add(dropdown2);
		
		JLabel txtLabel11 = new JLabel("Room Number");
		txtLabel11.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtLabel11.setBounds(749, 318, 107, 14);
		contentPane.add(txtLabel11);
		
		dropdown3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				roomNo=(String)dropdown3.getSelectedItem();
				try {
					ResultSet rs=Select.getData("select * from room where roomNo='"+roomNo+"'");
					while(rs.next()) {
						textField7.setText(rs.getString(4));
					}
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		dropdown3.setBounds(749, 354, 226, 22);
		contentPane.add(dropdown3);
		
		JLabel txtLabel12 = new JLabel("Price");
		txtLabel12.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtLabel12.setBounds(749, 401, 49, 14);
		contentPane.add(txtLabel12);
		
		textField7 = new JTextField();
		textField7.setBounds(749, 441, 226, 20);
		contentPane.add(textField7);
		textField7.setColumns(10);
		textField6.setEditable(false); 
		textField7.setEditable(false);
		SimpleDateFormat myFormat=new SimpleDateFormat("yyyy/MM/dd");
		Calendar cal=Calendar.getInstance();
		textField6.setText(myFormat.format(cal.getTime()));
		
		JButton button1 = new JButton("Clear");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new CustomerCheckIn().setVisible(true);
			}
		});
		button1.setBackground(new Color(128, 0, 64));
		button1.setFont(new Font("Tahoma", Font.BOLD, 12));
		button1.setBounds(749, 528, 145, 23);
		contentPane.add(button1);
		
		JButton button2 = new JButton("Allot Room");
		button2.setBackground(new Color(128, 0, 64));
		button2.setFont(new Font("Tahoma", Font.BOLD, 12));
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id=1;
				String name=textField.getText();
				String mobileNumber=textField1.getText();
				String nationality=textField2.getText();
				String gender=(String)comboBox.getSelectedItem();
				String email=textField4.getText();
				String idProof=textField3.getText();
				String address=textField5.getText();
				String checkIN=textField6.getText();
				String bed=(String)dropdown4.getSelectedItem();
				String price=textField7.getText();
				String query="select max(id) from customer";
				if(textField.getText().equals("")||textField1.getText().equals("")||textField2.getText().equals("")||textField4.getText().equals("")||textField3.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Every Field is Required");
					return;
				}
				if(! (Pattern.matches("^[a-z A-Z]+$",textField.getText()))) {
					JOptionPane.showMessageDialog(null,"Name should contain only alphabets");
					return;
				}
				if(! (Pattern.matches("[6789]{1}[0-9]{9}",textField1.getText()))) {
					JOptionPane.showMessageDialog(null,"Phone number should contain only 10 numbers");
					return;
				}
				if(! (Pattern.matches("^[a-z A-Z]+$",textField2.getText()))) {
					JOptionPane.showMessageDialog(null,"Nationality should contain only alphabets");
					return;
				}
				if(! (Pattern.matches("[a-z0-9]+@[a-z]+\\.[a-z]{2,3}",textField4.getText()))) {
					JOptionPane.showMessageDialog(null,"Enter email correctly \nExample:example@gmail.com");
					return;
				}
				if(! (Pattern.matches("^[a-z A-Z 0-9]+$",textField3.getText()))) {
					JOptionPane.showMessageDialog(null,"ID should contain only alphabets and numbers");
					return;
				}
				try {
					ResultSet rs=Select.getData(query);
					while(rs.next()) 
						id=rs.getInt(1);
					id=id+1;
					if(!price.equals("")) {
						query="update room set status='Booked' where roomNo='"+roomNo+"'";
						InsertUpdateDelete.setData(query, "");
						query="insert into customer(id,Name,mobileNumber,nationality,gender,email,idProof,address,checkIn,roomNo,bed,roomType,pricePerDay) values('"+id+"','"+name+"','"+mobileNumber+"','"+nationality+"','"+gender+"','"+email+"','"+idProof+"','"+address+"','"+checkIN+"','"+roomNo+"','"+bed+"','"+roomType+"','"+price+"')";
						InsertUpdateDelete.setData(query,"Customer Check In Successfully");
						setVisible(false);
						new CustomerCheckIn().setVisible(true);
					}
					
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null,ex);
					
				}
				
			}
			
		});
		button2.setBounds(749, 490, 145, 23);
		contentPane.add(button2);
		
		JLabel txtLabel13 = new JLabel("");
		txtLabel13.setIcon(new ImageIcon("C:\\Users\\saparna\\Downloads\\Hotel Images & Icon\\Hotel Images & Icon\\all pages background.png"));
		txtLabel13.setBounds(0, 0, 1266, 600);
		contentPane.add(txtLabel13);
		
	}	
	
	public void roomDetails() {
		dropdown3.removeAllItems();
		textField7.setText("");
		bed=(String)dropdown4.getSelectedItem();
		roomType=(String)dropdown2.getSelectedItem();
		try {
			System.out.print(bed+" "+roomType);
			ResultSet rs=Select.getData("select * from room where bed='"+bed+"' and roomType='"+roomType+"' and status='Not Booked'");
			while(rs.next())
			{
				dropdown3.addItem(rs.getString(1));
			}
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null,ex);
			
		}
	
	}
}