import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Add extends JFrame{
Container c;
JLabel labRno,labName,labMarks1,labMarks2,labMarks3;
JTextField txtRno,txtName,txtMarks1,txtMarks2,txtMarks3;
JButton btnAdd,btnBack;

	Add(){
		c = getContentPane();
		c.setLayout(new FlowLayout());

		
		labRno = new JLabel("Enter rno");
		txtRno = new JTextField(15);
		labName =  new JLabel("Enter name");
		txtName = new JTextField(15);
		labMarks1 =  new JLabel("Enter marks of subject 1");
		txtMarks1 = new JTextField(15);
		labMarks2 = new JLabel("Enter marks of subject 2");
		txtMarks2 = new JTextField(15);
 		labMarks3 = new JLabel("Enter marks of subject 3");
		txtMarks3 =	new JTextField(15);
		btnAdd = new JButton("Add Student");
		btnBack = new JButton("Back");



		Font f = new Font("Arial",Font.BOLD,30);
		labRno.setFont(f);
		txtRno.setFont(f);
		labName.setFont(f);
		txtName.setFont(f);
		labMarks1.setFont(f);
		txtMarks1.setFont(f);
		labMarks2.setFont(f);
		txtMarks2.setFont(f);
 		labMarks3.setFont(f);
		txtMarks3.setFont(f);
		btnAdd.setFont(f);
		btnBack.setFont(f);



		c.add(labRno);
		c.add(txtRno);
		c.add(labName);
		c.add(txtName);
		c.add(labMarks1);
		c.add(txtMarks1);
		c.add(labMarks2);
		c.add(txtMarks2);
		c.add(labMarks3);
		c.add(txtMarks3);
		c.add(btnAdd);
		c.add(btnBack);


		ActionListener a = (ae) ->{
		try{
			int rno = Integer.parseInt(txtRno.getText());
			int mrks1 = Integer.parseInt(txtMarks1.getText());
			int mrks2 = Integer.parseInt(txtMarks2.getText());
			int mrks3 = Integer.parseInt(txtMarks3.getText());
			String name = txtName.getText();


			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url = "jdbc:mysql://localhost:3306/sms_26july25";
			Connection con = DriverManager.getConnection(url,"root","{your_password}");
	
			String sql = "insert into student values(?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1,rno);
			pst.setString(2,name);	
			pst.setInt(3,mrks1);	
			pst.setInt(4,mrks2);	
			pst.setInt(5,mrks3);	
			pst.executeUpdate();
			JOptionPane.showMessageDialog(c,"Record Created");
			txtRno.setText("");
			txtName.setText("");
			txtMarks1.setText("");
			txtMarks2.setText("");
			txtMarks3.setText("");
			txtRno.requestFocus();

			con.close();


		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(c,"Enter marks or roll no properly");
		}catch(SQLIntegrityConstraintViolationException e){
			JOptionPane.showMessageDialog(c,"Roll no already present");
		}catch(Exception e){
			JOptionPane.showMessageDialog(c,"issue: "+e);
		}
		};btnAdd.addActionListener(a);

		ActionListener b = (ae) ->{
		Home h = new Home();
		this.dispose();				
		};btnBack.addActionListener(b);


		setVisible(true);
		setSize(500,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Add Student");

	}


}


