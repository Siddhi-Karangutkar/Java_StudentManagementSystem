import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class View extends JFrame{
Container c;
TextArea taView;
JButton btnBack;

	View(){
		c = getContentPane();
		c.setLayout(new FlowLayout());

		
		taView = new TextArea(5,20);
		btnBack = new JButton("Back");


		Font f = new Font("Arial",Font.BOLD,30);
		taView.setFont(f);
		btnBack.setFont(f);


		c.add(taView);
		c.add(btnBack);



		try{

			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url = "jdbc:mysql://localhost:3306/sms_26july25";
			Connection con = DriverManager.getConnection(url,"root","root");
	
			String sql = "select * from student";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			String info = "";
			while(rs.next()){
				info += "rno: "+rs.getInt(1)+"  name: "+rs.getString(2)+"  marks1: "+rs.getInt(3)+"  marks2: "+rs.getInt(4)+"  marks3: "+rs.getInt(5)+"\n";
			}

			taView.setText(info);
			rs.close();
			con.close();


		}catch(SQLException e){
			JOptionPane.showMessageDialog(c,"issue: "+e);
		}


		ActionListener b = (ae) ->{
		Home h = new Home();
		this.dispose();				
		};btnBack.addActionListener(b);


		setVisible(true);
		setSize(500,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("View Student");

	}


}


