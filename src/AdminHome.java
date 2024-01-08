import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;
import project.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class AdminHome extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTable table_1;

	public static void main(String[] args) {
		try {
			AdminHome frame = new AdminHome();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public AdminHome() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				ResultSet rs=Select.getData("select * from users");
				DefaultTableModel model=(DefaultTableModel)table_1.getModel();
				model.setRowCount(0);
				try {
					while(rs.next()) {
						model.addRow(new Object[] {rs.getString(1),rs.getString(2),rs.getString(4),rs.getString(6),rs.getString(7)});
					}
					rs.close();
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
				
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 718);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel txtlabel = new JLabel("Welcome Admin !");
		txtlabel.setBounds(29, 41, 512, 132);
		txtlabel.setForeground(new Color(128, 0, 64));
		txtlabel.setFont(new Font("Algerian", Font.BOLD, 48));
		contentPane.add(txtlabel);
		
		JButton button = new JButton("     LOGOUT");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=JOptionPane.showConfirmDialog(null, "Do you really want to Logout","select",JOptionPane.YES_NO_OPTION);
				if(a==0)
				{
					setVisible(false);
					new Login().setVisible(true);
				}
			}
		});
		button.setBounds(658, 66, 186, 83);
		button.setForeground(new Color(128, 0, 64));
		button.setIcon(new ImageIcon("C:\\Users\\saparna\\Downloads\\Hotel Images & Icon\\Hotel Images & Icon\\logout.png"));
		button.setFont(new Font("Algerian", Font.BOLD, 15));
		contentPane.add(button);
		
		JButton button1 = new JButton("    EXIT");
		button1.setBounds(900, 66, 163, 83);
		button1.setForeground(new Color(128, 0, 64));
		button1.setIcon(new ImageIcon("C:\\Users\\saparna\\Downloads\\Hotel Images & Icon\\Hotel Images & Icon\\exit.png"));
		button1.setFont(new Font("Algerian", Font.BOLD, 15));
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=JOptionPane.showConfirmDialog(null, "Do you really want to close Application","select",JOptionPane.YES_NO_OPTION);
				if(a==0)
				{
					System.exit(0);
				}
			}
		});
		contentPane.add(button1);
		
		JLabel txtLabel1 = new JLabel("Search By Name Or Email");
		txtLabel1.setBounds(289, 249, 201, 29);
		txtLabel1.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(txtLabel1);
		
		textField = new JTextField();
		textField.setBounds(465, 246, 296, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton button2 = new JButton("Search");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nameorEmail=textField.getText();
				
				ResultSet rs=Select.getData("select * from users where name like '%"+nameorEmail+"%'or email like '%"+nameorEmail+"%'");
				DefaultTableModel model=(DefaultTableModel)table_1.getModel();
				model.setRowCount(0);
				try {
					while(rs.next()) {
						model.addRow(new Object[] {rs.getString(1),rs.getString(2),rs.getString(4),rs.getString(6),rs.getString(7)});
					}
					rs.close();
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
			}
			
		});
		button2.setBounds(812, 248, 89, 31);
		button2.setBackground(new Color(128, 0, 64));
		button2.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(button2);
		
		JButton button3 = new JButton("Clear");
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new AdminHome().setVisible(true);
			}
		});
		button3.setBounds(1112, 248, 89, 31);
		button3.setBackground(new Color(128, 0, 64));
		button3.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(button3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(733, 377, -421, 183);
		contentPane.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(65, 354, 1136, 302);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index=table_1.getSelectedRow();
				TableModel model=table_1.getModel();
				String email=model.getValueAt(index, 1).toString();
				String status=model.getValueAt(index, 4).toString();
				if(status.equals("true"))
					status="false";
				else
					status="true";
				try {
					int a=JOptionPane.showConfirmDialog(null, "Do you really want to change the status of "+email+"","Select",JOptionPane.YES_NO_OPTION);
					if(a==0) {
						InsertUpdateDelete.setData("update users set status='"+status+"' where email='"+email+"'","Status Changed Successfully");
						setVisible(false);
						new AdminHome().setVisible(true);
					}
				}
				catch(Exception ex) {
					
				}
			}
		});
		table_1.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {"Name", "Email", "Security Question", "Address", "Status"}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_1.setViewportView(table_1);
		
		JLabel txtLabel2 = new JLabel("New label");
		txtLabel2.setIcon(new ImageIcon("C:\\Users\\saparna\\Downloads\\Hotel Images & Icon\\Hotel Images & Icon\\admin Home.png"));
		txtLabel2.setBounds(0, 0, 1283, 692);
		contentPane.add(txtLabel2);
		
		

	}
}
