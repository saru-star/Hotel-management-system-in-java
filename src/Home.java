import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		try {
			Home frame = new Home();
			frame.setVisible(true);
		} catch (Exception e) {
				e.printStackTrace();
		}
	}

	public Home() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1297, 736);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("Manage Room");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new ManageRoom().setVisible(true);
			}
		});
		button.setForeground(new Color(0, 0, 0));
		button.setFont(new Font("Algerian", Font.BOLD, 12));
		button.setIcon(new ImageIcon("C:\\Users\\saparna\\Downloads\\Hotel Images & Icon\\Hotel Images & Icon\\manage room.png"));
		button.setBounds(10, 11, 179, 59);
		contentPane.add(button);
		
		JButton button1 = new JButton("Customer Check In");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CustomerCheckIn().setVisible(true);
			}
		});
		button1.setFont(new Font("Algerian", Font.BOLD, 12));
		button1.setForeground(new Color(0, 0, 0));
		button1.setIcon(new ImageIcon("C:\\Users\\saparna\\Downloads\\Hotel Images & Icon\\Hotel Images & Icon\\Customer Registration & Check IN.png"));
		button1.setBounds(255, 11, 221, 59);
		contentPane.add(button1);
		
		JButton button2 = new JButton("Customer Check Out");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CheckCheckOut().setVisible(true);
			}
		});
		button2.setForeground(new Color(0, 0, 0));
		button2.setFont(new Font("Algerian", Font.BOLD, 12));
		button2.setIcon(new ImageIcon("C:\\Users\\saparna\\Downloads\\Hotel Images & Icon\\Hotel Images & Icon\\Customer Check Out.png"));
		button2.setBounds(537, 11, 230, 59);
		contentPane.add(button2);
		
		JButton button4 = new JButton("Log Out");
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=JOptionPane.showConfirmDialog(null, "Do you really want to Logout","select",JOptionPane.YES_NO_OPTION);
				if(a==0)
				{
					setVisible(false);
					new Login().setVisible(true);
				}
			}
			
		});
		button4.setForeground(new Color(0,0,0));
		button4.setFont(new Font("Algerian", Font.BOLD, 12));
		button4.setIcon(new ImageIcon("C:\\Users\\saparna\\Downloads\\Hotel Images & Icon\\Hotel Images & Icon\\logout.png"));
		button4.setBounds(817, 11, 150, 59);
		contentPane.add(button4);
		
		JButton button5 = new JButton("Exit");
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=JOptionPane.showConfirmDialog(null, "Do you really want to close Application","select",JOptionPane.YES_NO_OPTION);
				if(a==0)
					System.exit(0);
			}
		});
		button5.setForeground(new Color(0, 0, 0));
		button5.setFont(new Font("Algerian", Font.BOLD, 12));
		button5.setIcon(new ImageIcon("C:\\Users\\saparna\\Downloads\\Hotel Images & Icon\\Hotel Images & Icon\\exit.png"));
		button5.setBounds(1022, 11, 121, 59);
		contentPane.add(button5);
		
		JLabel txtlabel = new JLabel("");
		txtlabel.setIcon(new ImageIcon("C:\\Users\\saparna\\Downloads\\Hotel Images & Icon\\Hotel Images & Icon\\home.png"));
		txtlabel.setBounds(0, 0, 1293, 710);
		contentPane.add(txtlabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(152, 29, 10, 10);
		contentPane.add(panel);
	}
}
