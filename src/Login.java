import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import project.Select;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.sql.*;
public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	public static void main(String[] args) {
		try {
			Login frame = new Login();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Login() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1297, 709);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel txtlabel = new JLabel("           Login");
		txtlabel.setForeground(new Color(255, 255, 255));
		txtlabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtlabel.setBounds(599, 247, 235, 33);
		contentPane.add(txtlabel);
		
		JLabel txtLabel1 = new JLabel("Email");
		txtLabel1.setForeground(new Color(255, 255, 255));
		txtLabel1.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtLabel1.setBounds(456, 280, 65, 33);
		contentPane.add(txtLabel1);
		
		JLabel txtLabel2 = new JLabel("Password");
		txtLabel2.setForeground(new Color(255, 255, 255));
		txtLabel2.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtLabel2.setBounds(456, 346, 84, 30);
		contentPane.add(txtLabel2);
		
		textField = new JTextField();
		textField.setBounds(556, 281, 321, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(556, 346, 321, 33);
		contentPane.add(passwordField);
		
		JButton button = new JButton("Login");
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int check=0;
				String email=textField.getText();
				String password=passwordField.getText();
				if(email.equals("")||password.equals("")) {
					check=1;
					JOptionPane.showMessageDialog(null, "Every field is Required");
				}
				else if(email.equals("hms")&&password.equals("admin")) {
					check=1;
					setVisible(false);
					new AdminHome().setVisible(true);
				}
				else {
					ResultSet rs=Select.getData("select * from users where email='"+email+"'and password='"+password+"'");
					try {
						if(rs.next()) {
							check=1;
							if(rs.getString(7).equals("true")) {
								setVisible(false);
								new Home().setVisible(true);
							}
							else {
								JOptionPane.showMessageDialog(null, "Wait For Admin Approval");
							}
						}
					}
					catch(Exception ex) {
						JOptionPane.showMessageDialog(null, ex);
					}
				}
				if(check==0) {
					JOptionPane.showMessageDialog(null,"Incorrect Email or Password");
				}
			}
		});
		button.setBounds(556, 405, 72, 33);
		contentPane.add(button);
		
		JButton button1 = new JButton("Sign Up");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new SignUp().setVisible(true);
			}
		});
		button1.setFont(new Font("Tahoma", Font.BOLD, 12));
		button1.setBounds(638, 405, 84, 33);
		contentPane.add(button1);
		
		JButton button2 = new JButton("Forgot Password");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new ForgotPassword().setVisible(true);
			}
		});
		button2.setFont(new Font("Tahoma", Font.BOLD, 12));
		button2.setBounds(732, 405, 145, 33);
		contentPane.add(button2);
		
		JButton button3 = new JButton("");
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=JOptionPane.showConfirmDialog(null, "Do you really want to close Application","select",JOptionPane.YES_NO_OPTION);
				if(a==0)
					System.exit(0);
				
			}
		});
		button3.setIcon(new ImageIcon("C:\\Users\\saparna\\Downloads\\Hotel Images & Icon\\Hotel Images & Icon\\close.png"));
		button3.setBounds(1244, 11, 29, 23);
		contentPane.add(button3);
		
	}
}
