import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Home extends JFrame{
Container c;
JButton btnAdd,btnView,btnUpdate,btnDelete;

	Home(){
		c = getContentPane();
		c.setLayout(new FlowLayout());

		btnAdd = new JButton("Add Student");
		btnView = new JButton("View Student");
		btnUpdate = new JButton("Update Student");
		btnDelete = new JButton("Delete Student");

		Font f = new Font("Arial",Font.BOLD,30);
		btnAdd.setFont(f);
		btnView.setFont(f);
		btnUpdate.setFont(f);
		btnDelete.setFont(f);

		c.add(btnAdd);
		c.add(btnView);
		c.add(btnUpdate);
		c.add(btnDelete);

		ActionListener a = (ae) ->{
		Add ad = new Add();
		this.dispose();				
		};btnAdd.addActionListener(a);

		ActionListener b = (ae) ->{
		View v = new View();
		this.dispose();				
		};btnView.addActionListener(b);

		ActionListener c = (ae) ->{
		Update u = new Update();
		this.dispose();				
		};btnUpdate.addActionListener(c);

		ActionListener d = (ae) ->{
		Delete de = new Delete();
		this.dispose();				
		};btnDelete.addActionListener(d);

		setVisible(true);
		setSize(450,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Student Management System");

	}


}


