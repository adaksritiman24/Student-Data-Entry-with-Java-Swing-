//Creating the class for Bachelor implemented as a pane 
//included under the studentspanel package

package studentspanel;
//required classes
import java.awt.EventQueue;
import java.io.*;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.*;
import javax.swing.JOptionPane;

//main class
public class Bpanel extends JPanel{//we need the features of te Jpanel in our Bpanel
	//class private attributes
	private static JTextField name;
	private static JTextField roll;
	private static JTextField course;
	private static JTextField dept;
	private static JTextField branch;
	private static JTextField college;

	public static JButton submit;
	public static JButton reset;
	public static void readAndSave(){
		// System.out.println("Read and save method to be defined...");
		// System.out.println("name: "+name.getText());
		// System.out.println("roll: "+roll.getText());
		// System.out.println("course: "+course.getText());
		// System.out.println("dept: "+dept.getText());
		// System.out.println("branch: "+branch.getText());
		// System.out.println("college: "+college.getText());
		try{
			File file = new File("datas\\bachelor.txt");//create new/ open the bachelor.txt file in the folder: datas
			boolean result = file.createNewFile(); //create new file if not exist
			FileOutputStream fos = new FileOutputStream("datas\\bachelor.txt",true); //file output stream for writing bytes into the file
			//check for unfilled entries
			if((name.getText().equals(""))||(roll.getText().equals(""))||(course.getText().equals(""))||(dept.getText().equals(""))||(branch.getText().equals(""))||(college.getText().equals(""))){
				JOptionPane.showMessageDialog(null,"Please fill all the details");
			}
			else{//write the data in a single line as a string in the file with data separator as "||"
				String str = name.getText()+"||"+roll.getText()+"||"+course.getText()+"||"+dept.getText()+"||"+branch.getText()+"||"+college.getText()+"\n";
				byte[] bytesdata = str.getBytes();//convert to bytes 
				
				JOptionPane.showMessageDialog(null,"Data is saved"); // message box for success
				fos.write(bytesdata); //append into file
				name.setText("");
				roll.setText("");
				course.setText("");
				dept.setText("");
				branch.setText("");
				college.setText("");

			}
			fos.close();
		}
		catch(Exception e){//print error message
			System.out.println("Failed to write data into file");
		}
	}

	public static void resetAll(){ // empty all the text fields in this pane
		name.setText("");
		roll.setText("");
		course.setText("");
		dept.setText("");
		branch.setText("");
		college.setText("");		
	}
	public Bpanel() { //constructor
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(95, 158, 160));
		setLayout(null);
		
		//adding swing objects and designing them

		JLabel name_label = new JLabel("Name:\r\n");
		name_label.setHorizontalAlignment(SwingConstants.TRAILING);
		name_label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		name_label.setBounds(88, 41, 97, 36);
		add(name_label);
		
		JLabel roll_label = new JLabel("Roll No:");
		roll_label.setHorizontalAlignment(SwingConstants.TRAILING);
		roll_label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		roll_label.setBounds(88, 87, 97, 36);
		add(roll_label);
		
		JLabel courselabel = new JLabel("Course:");
		courselabel.setHorizontalAlignment(SwingConstants.TRAILING);
		courselabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		courselabel.setBounds(88, 133, 97, 36);
		add(courselabel);
		
		JLabel deptlabel = new JLabel("Department:");
		deptlabel.setHorizontalAlignment(SwingConstants.TRAILING);
		deptlabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		deptlabel.setBounds(88, 179, 97, 36);
		add(deptlabel);
		
		JLabel branchlabel = new JLabel("Branch:");
		branchlabel.setHorizontalAlignment(SwingConstants.TRAILING);
		branchlabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		branchlabel.setBounds(88, 225, 97, 36);
		add(branchlabel);
		
		JLabel collegelabel = new JLabel("College:");
		collegelabel.setHorizontalAlignment(SwingConstants.TRAILING);
		collegelabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		collegelabel.setBounds(88, 271, 97, 36);
		add(collegelabel);
		
		name = new JTextField();
		name.setFont(new Font("Arial", Font.PLAIN, 16));
		name.setBounds(195, 41, 317, 36);
		add(name);
		name.setColumns(10);
		
		roll = new JTextField();
		roll.setFont(new Font("Arial", Font.PLAIN, 16));
		roll.setBounds(195, 87, 317, 36);
		add(roll);
		roll.setColumns(10);
		
		course = new JTextField();
		course.setFont(new Font("Arial", Font.PLAIN, 16));
		course.setBounds(195, 133, 317, 36);
		add(course);
		course.setColumns(10);
		
		dept = new JTextField();
		dept.setFont(new Font("Arial", Font.PLAIN, 16));
		dept.setBounds(195, 179, 317, 36);
		add(dept);
		dept.setColumns(10);
		
		branch = new JTextField();
		branch.setFont(new Font("Arial", Font.PLAIN, 16));
		branch.setBounds(195, 225, 317, 36);
		add(branch);
		branch.setColumns(10);
		
		college = new JTextField();
		college.setFont(new Font("Arial", Font.PLAIN, 16));
		college.setBounds(195, 271, 317, 36);
		add(college);
		college.setColumns(10);
		
		//the reset and submit button

		submit = new JButton("Submit");
		submit.setBackground(new Color(211, 211, 211));
		submit.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		submit.setBounds(88, 344, 219, 40);
		add(submit);
		
		reset = new JButton("Reset");
		reset.setBackground(new Color(211, 211, 211));
		reset.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		reset.setBounds(362, 344, 207, 40);
		add(reset);
	}

}
//end of file