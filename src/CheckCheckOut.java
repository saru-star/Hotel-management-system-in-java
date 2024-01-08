import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import project.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class CheckCheckOut extends JFrame {

private JPanel contentPane;
private JTable table;
private JTextField textField;
private JTextField textField1;
private JTextField textField2;
private JTextField textField3;
private JTextField textField4;
private JTextField textField5;
private JTextField textField6;
private JTextField textField7;
private JTextField textField8;

public static void main(String[] args) {
	try {
		CheckCheckOut frame = new CheckCheckOut ();
		frame.setVisible(true);
	} catch (Exception e) {
		e.printStackTrace();
	}
}
int id=0;
String query;
String roomType;
String bed;
String roomNo;

public CheckCheckOut() {
	addComponentListener(new ComponentAdapter() {
		@Override
		public void componentShown(ComponentEvent e) {
			ResultSet rs=Select.getData("select * from customer where checkout is NULL");
			DefaultTableModel md=(DefaultTableModel)table.getModel();
			try {
				while(rs.next()) {
					md.addRow(new Object[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13)});
					
				}
				rs.close();
			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(null, ex);
			}

		}
	});
setUndecorated(true);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 1267, 700);
contentPane = new JPanel();
contentPane.setSize(new Dimension(1366, 700));
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

setContentPane(contentPane);
contentPane.setLayout(null);

JLabel txtlabel = new JLabel("CUSTOMER CHECKOUT");
txtlabel.setBounds(37, 41, 310, 35);
txtlabel.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 30));
contentPane.add(txtlabel);

JLabel txtLabel1 = new JLabel("Customer Name");
txtLabel1.setFont(new Font("Tahoma", Font.PLAIN, 14));
txtLabel1.setBounds(37, 92, 127, 28);
contentPane.add(txtLabel1);

JScrollPane scrollPane = new JScrollPane();
scrollPane.setFont(new Font("Tahoma", Font.BOLD, 14));
scrollPane.setBounds(0, 381, 1266, 319);
contentPane.add(scrollPane);

table = new JTable();
table.setFont(new Font("Tahoma", Font.BOLD, 14));
table.setModel(new DefaultTableModel(
	new Object[][] {},
	new String[] {"ID", "Name", "Mobile Number", "Nationality", "Gender", "Email", "ID Proof", "Address", "CheckIn Date", "Room number", "Bed", "Room Type", "Price per Day"}
));
scrollPane.setViewportView(table);

textField = new JTextField();
textField.setBounds(37, 130, 127, 19);
contentPane.add(textField);
textField.setColumns(10);

JLabel txtLabel2 = new JLabel("CheckIn Date");
txtLabel2.setFont(new Font("Tahoma", Font.PLAIN, 14));
txtLabel2.setBounds(270, 100, 114, 13);
contentPane.add(txtLabel2);

textField1 = new JTextField();
textField1.setBounds(270, 130, 114, 19);
contentPane.add(textField1);
textField1.setColumns(10);

JLabel txtLabel3 = new JLabel("Check Out Date (Today)");
txtLabel3.setFont(new Font("Tahoma", Font.PLAIN, 14));
txtLabel3.setBounds(495, 100, 190, 13);
contentPane.add(txtLabel3);

textField2 = new JTextField();
textField2.setBounds(495, 130, 114, 19);
contentPane.add(textField2);
textField2.setColumns(10);

JLabel txtLabel4 = new JLabel("Mobile Number");
txtLabel4.setFont(new Font("Tahoma", Font.PLAIN, 14));
txtLabel4.setBounds(722, 100, 127, 13);
contentPane.add(txtLabel4);

textField3 = new JTextField();
textField3.setBounds(722, 130, 114, 19);
contentPane.add(textField3);
textField3.setColumns(10);

JLabel txtLabel5 = new JLabel("Price per Day");
txtLabel5.setFont(new Font("Tahoma", Font.PLAIN, 14));
txtLabel5.setBounds(37, 242, 127, 13);
contentPane.add(txtLabel5);

textField4 = new JTextField();
textField4.setBounds(37, 282, 127, 19);
contentPane.add(textField4);
textField4.setColumns(10);

JLabel txtLabel6 = new JLabel("Number Of Days Stay");
txtLabel6.setFont(new Font("Tahoma", Font.PLAIN, 14));
txtLabel6.setBounds(270, 242, 148, 13);
contentPane.add(txtLabel6);

textField5 = new JTextField();
textField5.setBounds(270, 282, 114, 19);
contentPane.add(textField5);
textField5.setColumns(10);

JLabel txtLabel7 = new JLabel("Total Price");
txtLabel7.setFont(new Font("Tahoma", Font.PLAIN, 14));
txtLabel7.setBounds(495, 242, 114, 13);
contentPane.add(txtLabel7);

textField6 = new JTextField();
textField6.setBounds(495, 282, 114, 19);
contentPane.add(textField6);
textField6.setColumns(10);

JLabel txtLabel8 = new JLabel("Email");
txtLabel8.setFont(new Font("Tahoma", Font.PLAIN, 14));
txtLabel8.setBounds(722, 242, 45, 13);
contentPane.add(txtLabel8);

textField7 = new JTextField();
textField7.setBounds(722, 282, 114, 19);
contentPane.add(textField7);
textField7.setColumns(10);

JLabel txtLabel9 = new JLabel("Room Number");
txtLabel9.setFont(new Font("Tahoma", Font.PLAIN, 14));
txtLabel9.setBounds(722, 49, 105, 29);
contentPane.add(txtLabel9);

textField8 = new JTextField();
textField8.setBounds(856, 48, 127, 35);
contentPane.add(textField8);
textField8.setColumns(10);

JButton button = new JButton("Search");
button.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
	String roomNo=textField8.getText();
	try {
		ResultSet rs=Select.getData("select * from customer where roomNo='"+roomNo+"' and checkout is NULL");
		if(rs.next()) {
			textField8.setEditable(false);
			id=rs.getInt(1);
			textField.setText(rs.getString(2));
			textField1.setText(rs.getString(9));
			textField3.setText(rs.getString(3));
			textField4.setText(rs.getString(13));
			
			SimpleDateFormat myFormat=new SimpleDateFormat("yyyy/MM/dd");
			Calendar cal=Calendar.getInstance();
			textField2.setText(myFormat.format(cal.getTime()));
			String dateBeforeString=rs.getString(9);
			java.util.Date dateBefore=myFormat.parse(dateBeforeString);
			
			String dateAfterString=myFormat.format(cal.getTime());
			java.util.Date dateAfter=myFormat.parse(dateAfterString);
			long difference=dateAfter.getTime()-dateBefore.getTime();
			int noOfDayStay=(int)(difference/1000*60*60*24);
			if(noOfDayStay==0)
				noOfDayStay=1;
			
			textField5.setText(String.valueOf(noOfDayStay));
			float price=Float.parseFloat(textField4.getText());
			textField6.setText(String.valueOf(noOfDayStay*price));
			textField7.setText(rs.getString(6));
			roomType=rs.getString(12);
			bed=rs.getString(11);
			
			
		}
		else {
			JOptionPane.showMessageDialog(null,"Room number is not Booked or Room Number does not exist");
		}
	}
	catch(Exception ex) {
		JOptionPane.showMessageDialog(null, ex);
	}
}
});
button.setFont(new Font("Tahoma", Font.PLAIN, 14));
button.setBounds(1024, 46, 85, 35);
contentPane.add(button);
JButton button1 = new JButton("Check Out");
button1.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		String checkout=textField2.getText();
		String numberOfDay=textField5.getText();
		String tot=textField6.getText();
		roomNo=textField8.getText();
		query="update customer set numberOfDaysStay='"+numberOfDay+"',totalAmount='"+tot+"',checkOut='"+checkout+"'where id='"+id+"'";
		InsertUpdateDelete.setData(query, "");
		query="update room set Status='Not Booked' where roomNo='"+roomNo+"'";
		InsertUpdateDelete.setData(query, "");
	}
});
button1.setBounds(37, 332, 127, 23);
contentPane.add(button1);
JButton button2 = new JButton("Clear");
button2.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		new CheckCheckOut().setVisible(true);
	}
});
button2.setBounds(270, 332, 114, 23);
contentPane.add(button2);
JLabel txtLabel10 = new JLabel("");
txtLabel10.addMouseListener(new MouseAdapter() {
	@Override
	public void mouseClicked(MouseEvent e) {
		setVisible(false);
		
	}
	
});
txtLabel10.setIcon(new ImageIcon("C:\\Users\\saparna\\Downloads\\Hotel Images & Icon\\Hotel Images & Icon\\all pages background.png"));
txtLabel10.setBounds(0, 0, 1402, 415);
contentPane.add(txtLabel10);
JButton button4 = new JButton("New button");
button4.setIcon(new ImageIcon("C:\\Users\\saparna\\Downloads\\Hotel Images & Icon\\Hotel Images & Icon\\close.png"));
button4.setBounds(1007, 12, 32, 23);
contentPane.add(button4);
textField.setEditable(false);
textField1.setEditable(false);
textField2.setEditable(false);
textField3.setEditable(false);
textField4.setEditable(false);
textField5.setEditable(false);
textField6.setEditable(false);
textField7.setEditable(false);

}
}
