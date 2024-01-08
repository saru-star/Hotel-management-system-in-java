import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import project.*;
import java.sql.*;
import javax.swing.JPasswordField;
public class ForgotPassword extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField1;
	private JTextField textField2;
	private JPasswordField passwordField;

	public static void main(String[] args) {
		try {
			ForgotPassword frame = new ForgotPassword();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public ForgotPassword() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1364, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel txtlabel = new JLabel("                 Forgot Password ?");
		txtlabel.setForeground(new Color(255, 255, 255));
		txtlabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtlabel.setBounds(568, 144, 292, 62);
		contentPane.add(txtlabel);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=JOptionPane.showConfirmDialog(null, "Do you really want to close Application","select",JOptionPane.YES_NO_OPTION);
				if(a==0)
					System.exit(0);
				
			}
		});
		button.setIcon(new ImageIcon("C:\\Users\\saparna\\Downloads\\Hotel Images & Icon\\Hotel Images & Icon\\close.png"));
		button.setBounds(1232, 22, 28, 23);
		contentPane.add(button);
		
		JLabel txtLabel1 = new JLabel("Email");
		txtLabel1.setForeground(new Color(255, 255, 255));
		txtLabel1.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtLabel1.setBounds(413, 201, 49, 23);
		contentPane.add(txtLabel1);
		
		JLabel txtLabel2 = new JLabel("Security Question");
		txtLabel2.setForeground(new Color(255, 255, 255));
		txtLabel2.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtLabel2.setBounds(413, 251, 112, 27);
		contentPane.add(txtLabel2);
		
		JLabel txtLabel3 = new JLabel("Answer");
		txtLabel3.setForeground(new Color(255, 255, 255));
		txtLabel3.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtLabel3.setBounds(413, 303, 49, 27);
		contentPane.add(txtLabel3);
		
		JLabel txtLabel4 = new JLabel("New Password");
		txtLabel4.setForeground(new Color(255, 255, 255));
		txtLabel4.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtLabel4.setBounds(413, 362, 112, 14);
		contentPane.add(txtLabel4);
		
		textField = new JTextField();
		textField.setBounds(578, 199, 297, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton button1 = new JButton("Search");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int check=0;
				String email;
				email=textField.getText();
				if(email.equals("")) {
					check=1;
					JOptionPane.showMessageDialog(null, "Email is Required");
				}
				else {
					ResultSet rs=Select.getData("select * from users where email='"+email+"'");
					try {
						if(rs.next()) {
							check=1;
							textField.setEditable(false);
							textField1.setEditable(false);
							textField1.setText(rs.getString(4));
						}
						
					}
					catch(Exception ex) {
						JOptionPane.showMessageDialog(null, ex);
					}
				}
				if(check==0) {
					JOptionPane.showMessageDialog(null, "Incorrect Email");
				}
			}
		});
		button1.setBackground(new Color(128, 0, 64));
		button1.setFont(new Font("Tahoma", Font.BOLD, 12));
		button1.setBounds(885, 201, 99, 23);
		contentPane.add(button1);
		
		textField1 = new JTextField();
		textField1.setBounds(578, 251, 297, 29);
		contentPane.add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setBounds(578, 303, 297, 29);
		contentPane.add(textField2);
		textField2.setColumns(10);
		
		JButton button2 = new JButton("Save");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int check=0;
				String email=textField.getText();
				String securityQuestion=textField1.getText();
				String answer=textField2.getText();
				String newPassword=passwordField.getText();
				if(answer.equals("")||newPassword.equals("")) {
					check=1;
					JOptionPane.showMessageDialog(null, "All field is required");
				}
				else {
					ResultSet rs=Select.getData("select * from users where email='"+email+"' and securityQuestion='"+securityQuestion+"' and answer='"+answer+"'");
					try {
						if(rs.next()) {
							check=1;
							InsertUpdateDelete.setData("update users set password='"+newPassword+"' where email='"+email+"'","Password set successfully");
							setVisible(false);
							new ForgotPassword().setVisible(true);
						}
					}
					catch(Exception ez) {
						JOptionPane.showMessageDialog(null, ez);
					}
				}
				if(check==0) {
					JOptionPane.showMessageDialog(null,"Incorrect answer");
				}
				
				
			}
		});
		button2.setBackground(new Color(128, 0, 64));
		button2.setForeground(new Color(0, 0, 0));
		button2.setFont(new Font("Tahoma", Font.BOLD, 12));
		button2.setBounds(578, 425, 89, 23);
		contentPane.add(button2);
		
		JButton button3 = new JButton("Sign Up");
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new SignUp().setVisible(true);
			}
			
		});
		button3.setBackground(new Color(128, 0, 64));
		button3.setForeground(new Color(0, 0, 0));
		button3.setFont(new Font("Tahoma", Font.BOLD, 12));
		button3.setBounds(677, 425, 89, 23);
		contentPane.add(button3);
		
		JButton button4 = new JButton("Login");
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Login().setVisible(true);
			}
		});
		button4.setBackground(new Color(128, 0, 64));
		button4.setFont(new Font("Tahoma", Font.BOLD, 12));
		button4.setBounds(786, 425, 89, 23);
		contentPane.add(button4);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(578, 360, 297, 29);
		contentPane.add(passwordField);
		
		JLabel txtLabel5 = new JLabel("New label");
		txtLabel5.setIcon(new ImageIcon("C:\\Users\\saparna\\Downloads\\Hotel Images & Icon\\Hotel Images & Icon\\forgot password.PNG"));
		txtLabel5.setBounds(0, 0, 1362, 711);
		contentPane.add(txtLabel5);
	}

}
