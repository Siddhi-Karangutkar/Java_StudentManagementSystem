import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Delete extends JFrame{
Container c;
JLabel labRno;
JTextField txtRno;
JButton btnDelete,btnBack;

	Delete(){
		c = getContentPane();
		c.setLayout(new FlowLayout());

		
		labRno = new JLabel("Enter rno");
		txtRno = new JTextField(15);
		btnDelete = new JButton("Delete Student");
		btnBack = new JButton("Back");


		Font f = new Font("Arial",Font.BOLD,30);
		labRno.setFont(f);
		txtRno.setFont(f);
		btnDelete.setFont(f);
		btnBack.setFont(f);


		c.add(labRno);
		c.add(txtRno);
		c.add(btnDelete);
		c.add(btnBack);


		ActionListener a = (ae) ->{
		try{
			int rno = Integer.parseInt(txtRno.getText());


			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url = "jdbc:mysql://localhost:3306/sms_26july25";
			Connection con = DriverManager.getConnection(url,"root","root");
	
			String sql = "delete from student where rno = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1,rno);
			pst.executeUpdate();

			JOptionPane.showMessageDialog(c,"Record Deleted");
			txtRno.setText("");
			txtRno.requestFocus();

			con.close();


		}catch(SQLException e){
			JOptionPane.showMessageDialog(c,"issue: "+e);
		}
		};btnDelete.addActionListener(a);

		ActionListener b = (ae) ->{
		Home h = new Home();
		this.dispose();				
		};btnBack.addActionListener(b);


		setVisible(true);
		setSize(500,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Delete student");

	}


}


