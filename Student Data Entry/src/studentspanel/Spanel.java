//Creating the class for Scientist implemented as another pane 
//included under the studentspanel package

package studentspanel;
//required classes
import java.awt.EventQueue;
import java.io.*;
import javax.swing.JOptionPane;
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


public class Spanel extends JPanel{//create as a subclass of the JPane
	private static JTextField name;
	private static JTextField roll;
	private static JTextField course;
	private static JTextField dept;	
	private static JTextField area;

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
			File file = new File("datas\\scientist.txt");//create new/ open the scientist.txt file in the folder: datas
			boolean result = file.createNewFile();//create new if not exist
			FileOutputStream fos = new FileOutputStream("datas\\scientist.txt",true);//file output stream for writing bytes into the file
			//check for unfilled entries
			if((name.getText().equals(""))||(roll.getText().equals(""))||(course.getText().equals(""))||(dept.getText().equals(""))||(area.getText().equals(""))){
				JOptionPane.showMessageDialog(null,"Please fill all the details");//message is shown if all the fields are not filled
			}
			else{//write the data as a string in a single line in the file with data separator as "||"
				String str = name.getText()+"||"+roll.getText()+"||"+course.getText()+"||"+dept.getText()+"||"+area.getText()+"\n";
				byte[] bytesdata = str.getBytes();
				
				JOptionPane.showMessageDialog(null,"Data is saved");//message dialog box showing success
				fos.write(bytesdata);//appending to the file
				//empty all the text fields
				name.setText("");
				roll.setText("");
				course.setText("");
				dept.setText("");
				area.setText("");


			}
			fos.close();
		}
		catch(Exception e){//print error message
			System.out.println("Failed to write data into file");
		}
	}

	public static void resetAll(){//empty all fields 
		name.setText("");
		roll.setText("");
		course.setText("");
		dept.setText("");
		area.setText("");		
	}
	public Spanel() {//constructor
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(95, 158, 160));
		setLayout(null);
		
		//all the java swing objects required in this case.
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
		
		JLabel arealabel = new JLabel("Area:");
		arealabel.setHorizontalAlignment(SwingConstants.TRAILING);
		arealabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		arealabel.setBounds(88, 225, 97, 36);
		add(arealabel);
	
		
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
		
		area = new JTextField();
		area.setFont(new Font("Arial", Font.PLAIN, 16));
		area.setBounds(195, 225, 317, 36);
		add(area);
		area.setColumns(10);
		//submit and reset button
		
		submit = new JButton("Submit");
		submit.setBackground(new Color(211, 211, 211));
		submit.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		submit.setBounds(88, 288, 219, 40);
		add(submit);
		
		reset = new JButton("Reset");
		reset.setBackground(new Color(211, 211, 211));
		reset.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		reset.setBounds(362, 288, 207, 40);
		add(reset);
	}	
}
//end of file