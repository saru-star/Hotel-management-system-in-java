import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Point;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;

import project.*;
import java.sql.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
public class ManageRoom extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTable table;
	private JTextField textField;
	private JTextField textField1;

	public static void main(String[] args) {
		try {
			ManageRoom frame = new ManageRoom();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ManageRoom() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				ResultSet rs=Select.getData("select * from room");
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				try {
					while(rs.next()) {
					model.addRow(new Object[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)});}
					rs.close();
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null,ex);
				}
			}
		});
		setLocation(new Point(50, 96));
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1265, 555);
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(1265, 600));
		contentPane.setSize(new Dimension(1366, 712));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Manage room");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\saparna\\Downloads\\Hotel Images & Icon\\Hotel Images & Icon\\manage room.png"));
		lblNewLabel.setBounds(27, 22, 190, 73);
		lblNewLabel.setForeground(new Color(128, 0, 64));
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 14));
		contentPane.add(lblNewLabel);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Login().setVisible(true);
			}
		});
		button.setIcon(new ImageIcon("C:\\Users\\saparna\\Downloads\\Hotel Images & Icon\\Hotel Images & Icon\\close.png"));
		button.setBounds(1133, 50, 33, 33);
		contentPane.add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 90, 780, 410);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {"Room Number", "Room Type", "Bed", "Price", "Status"}
		));
		table.getColumnModel().getColumn(4).setResizable(false);
		
		JLabel txtLabel1 = new JLabel("Room Number");
		txtLabel1.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtLabel1.setBounds(850, 121, 201, 20);
		contentPane.add(txtLabel1);
		
		textField = new JTextField();
		textField.setBounds(850, 167, 280, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel txtLabel2 = new JLabel("Room Type");
		txtLabel2.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtLabel2.setBounds(850, 222, 121, 14);
		contentPane.add(txtLabel2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"AC", "Non-Ac"}));
		comboBox.setBounds(850, 266, 280, 22);
		contentPane.add(comboBox);
		
		JLabel txtLabel3 = new JLabel("Bed");
		txtLabel3.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtLabel3.setBounds(850, 315, 49, 14);
		contentPane.add(txtLabel3);
		
		JComboBox dropdown1 = new JComboBox();
		dropdown1.setModel(new DefaultComboBoxModel(new String[] {"Double", "Single", "Triple"}));
		dropdown1.setBounds(850, 358, 280, 22);
		contentPane.add(dropdown1);
		
		JLabel txtLabel4 = new JLabel("Price");
		txtLabel4.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtLabel4.setBounds(850, 405, 49, 14);
		contentPane.add(txtLabel4);
		
		textField1 = new JTextField();
		textField1.setBounds(850, 430, 280, 20);
		contentPane.add(textField1);
		textField1.setColumns(10);
		
		JButton button1 = new JButton("Add Room");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String roomNo=textField.getText();
				String roomType=(String)comboBox.getSelectedItem();
				String bed=(String)dropdown1.getSelectedItem();
				String price=textField1.getText();
				String query="insert into room values('"+roomNo+"','"+roomType+"','"+bed+"','"+price+"','Not Booked')";
				InsertUpdateDelete.setData(query,"Succesfully updated");
				setVisible(false);
				new ManageRoom().setVisible(true);
				
				
			}
		});
		button1.setForeground(new Color(255, 255, 255));
		button1.setFont(new Font("Tahoma", Font.BOLD, 12));
		button1.setBackground(new Color(128, 0, 64));
		button1.setBounds(849, 477, 135, 23);
		contentPane.add(button1);
		
		JLabel txtLabel5 = new JLabel("New label");
		txtLabel5.setIcon(new ImageIcon("C:\\Users\\saparna\\Downloads\\Hotel Images & Icon\\Hotel Images & Icon\\all pages background.png"));
		txtLabel5.setBounds(0, 0, 1265, 555);
		contentPane.add(txtLabel5);
	}
}
