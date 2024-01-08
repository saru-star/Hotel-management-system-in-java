import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.util.regex.Pattern;
import project.InsertUpdateDelete;
public class SignUp extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField1;
	private JPasswordField passwordField;
	private JTextField textField2;
	private JTextField textField3;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox ;

	public static void main(String[] args) {
		try {
			SignUp frame = new SignUp();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public SignUp() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1297, 735);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton button1 = new JButton("");
		button1.setIcon(new ImageIcon("C:\\Users\\saparna\\Downloads\\Hotel Images & Icon\\Hotel Images & Icon\\close.png"));
		button1.setBounds(1241, 11, 32, 23);
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=JOptionPane.showConfirmDialog(null, "Do you really want to close Application","select",JOptionPane.YES_NO_OPTION);
				if(a==0)
					System.exit(0);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(button1);
		
		JLabel txtlabel = new JLabel("      Sign up");
		txtlabel.setForeground(new Color(255, 255, 255));
		txtlabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		txtlabel.setBounds(639, 154, 192, 43);
		contentPane.add(txtlabel);
		
		JLabel txtLabel1 = new JLabel("Name");
		txtLabel1.setForeground(new Color(255, 255, 255));
		txtLabel1.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtLabel1.setBounds(456, 208, 49, 37);
		contentPane.add(txtLabel1);
		
		JLabel txtLabel2 = new JLabel("Email");
		txtLabel2.setForeground(new Color(255, 255, 255));
		txtLabel2.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtLabel2.setBounds(456, 256, 49, 35);
		contentPane.add(txtLabel2);
		
		JLabel txtLabel3 = new JLabel("Password");
		txtLabel3.setForeground(new Color(255, 255, 255));
		txtLabel3.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtLabel3.setBounds(456, 302, 103, 37);
		contentPane.add(txtLabel3);
		
		textField = new JTextField();
		textField.setBounds(625, 208, 339, 37);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField1 = new JTextField();
		textField1.setBounds(625, 256, 339, 37);
		contentPane.add(textField1);
		textField1.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(625, 304, 339, 37);
		contentPane.add(passwordField);
		
		JLabel txtLabel4 = new JLabel("Security Question");
		txtLabel4.setForeground(new Color(255, 255, 255));
		txtLabel4.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtLabel4.setBounds(456, 352, 157, 37);
		contentPane.add(txtLabel4);
		
		JLabel txtLabel5 = new JLabel("Answer");
		txtLabel5.setForeground(new Color(255, 255, 255));
		txtLabel5.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtLabel5.setBounds(456, 400, 132, 37);
		contentPane.add(txtLabel5);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"What is the name of your first pet?", "What was your first car?", "What elementary school did you attend?", "What is the name of the town where you were born?"}));
		comboBox.setBounds(625, 352, 339, 37);
		contentPane.add(comboBox);
		
		JLabel txtLabel6 = new JLabel("Address");
		txtLabel6.setForeground(new Color(255, 255, 255));
		txtLabel6.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtLabel6.setBounds(456, 448, 103, 37);
		contentPane.add(txtLabel6);
		
		textField2 = new JTextField();
		textField2.setBounds(625, 400, 339, 37);
		contentPane.add(textField2);
		textField2.setColumns(10);
		
		textField3 = new JTextField();
		textField3.setBounds(625, 448, 339, 37);
		contentPane.add(textField3);
		textField3.setColumns(10);
		
		JButton button = new JButton("Sign Up");
		button.setBackground(new Color(128, 0, 64));
		button.setForeground(new Color(0, 0, 0));
		button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=textField.getText();
				String email=textField1.getText();
				String password=passwordField.getText();
				String securityQuestion=(String)comboBox.getSelectedItem();
				String answer=textField2.getText();
				String address=textField3.getText();
				if(name.equals("")||email.equals("")||password.equals("")||answer.equals("")||address.equals("")) {
				     JOptionPane.showMessageDialog(null, "Every Field is Required");
				     return;
				    }
				    if(! (Pattern.matches("^[a-z A-Z]+$",name))) {
				     JOptionPane.showMessageDialog(null,"Name should contain only alphabets");
				     return;
				    }
				    if(! (Pattern.matches("[a-z0-9]+@[a-z]+\\.[a-z]{2,3}",email))) {
				     JOptionPane.showMessageDialog(null,"Enter email correctly \nExample:example@gmail.com");
				     return;
				    }
				    if(! (Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()�[{}]:;',?/*~$^+=<>]).{8,20}$",password))) {
				     JOptionPane.showMessageDialog(null,"Password should contain alteast 8 characters (an uppercase letter, a lowercase letter, a special character, a number)");
				     return;
				    }
				    if(! (Pattern.matches("^[a-z A-Z]+$",answer))) {
				     JOptionPane.showMessageDialog(null,"Answer should contain only alphabets");
				     return;
				    }
				    String query;
				    query="insert into users values('"+name+"','"+email+"','"+password+"','"+securityQuestion+"','"+answer+"','"+address+"','false')";
				    InsertUpdateDelete.setData(query, "Registered succesfully");
				    setVisible(false);
				    new SignUp().setVisible(true);
				    
				   }
		});
		button.setBounds(454, 506, 118, 37);
		contentPane.add(button);
		
		JButton button2 = new JButton("Login");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Login().setVisible(true);
			}
		});
		button2.setBackground(new Color(128, 0, 64));
		button2.setForeground(new Color(0, 0, 0));
		button2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button2.setBounds(635, 506, 103, 37);
		contentPane.add(button2);
		
		JButton button3 = new JButton("Forgot Password ?");
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new ForgotPassword().setVisible(true);
				
			}
		});
		button3.setBackground(new Color(128, 0, 64));
		button3.setForeground(new Color(0, 0, 0));
		button3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button3.setBounds(772, 506, 192, 37);
		contentPane.add(button3);
		
		JLabel txtLabel7 = new JLabel("New label");
		txtLabel7.setIcon(new ImageIcon("C:\\Users\\saparna\\Downloads\\Hotel Images & Icon\\Hotel Images & Icon\\SignUp.PNG"));
		txtLabel7.setBounds(0, 0, 1283, 723);
		contentPane.add(txtLabel7);
	}
}
