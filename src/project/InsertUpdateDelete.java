package project;

import java.sql.Connection;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class InsertUpdateDelete {
	public static void  setData(String query,String msg) {
		Connection con=null;
		Statement st=null;
		try {
			con=ConnectionProvider.getCon();
			st=con.createStatement();
			st.executeUpdate(query);
			if(!msg.equals("")) {
				JOptionPane.showMessageDialog(null, msg);
			}
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		finally {
			try {}
			catch(Exception e) {}
		}
	}

}
