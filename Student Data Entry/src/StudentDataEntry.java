//This is the main application file which aggregated the classes into a single java class file
//which is directly executable by java compiler.

// some necessary modules/Classes for GUI using swing
import java.awt.EventQueue;
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

//Panels categirized into class files:- to be inserted into JTabbedPane
import studentspanel.Bpanel;
import studentspanel.Mpanel;
import studentspanel.Ppanel;
import studentspanel.Spanel;

//main class
public class StudentDataEntry {

	private JFrame frame;
	//instances of required classes
	Bpanel bpanel = new Bpanel();
	Mpanel mpanel = new Mpanel();
	Ppanel ppanel = new Ppanel();
	Spanel spanel = new Spanel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentDataEntry window = new StudentDataEntry();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});


	
	}


	/**
	 * Create the application.
	 */
	public StudentDataEntry() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//Main window frame
		frame = new JFrame();
		frame.setTitle("Student Data Entry(GUI)");
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.getContentPane().setBackground(new Color(95, 158, 160));
		frame.getContentPane().setLayout(null);
		//Main label
		JLabel mainlabel = new JLabel("Student  Data  Entry (Ver - 3(GUI) )");
		mainlabel.setForeground(new Color(0, 0, 0));
		mainlabel.setBackground(new Color(95, 158, 160));
		mainlabel.setFont(new Font("Microsoft JhengHei", Font.BOLD, 37));
		mainlabel.setHorizontalAlignment(SwingConstants.CENTER);
		mainlabel.setBounds(20, 10, 669, 65);
		frame.getContentPane().add(mainlabel);
		
		//tabbed pane initialization
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(new Color(255, 0, 0));
		tabbedPane.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		tabbedPane.setBackground(new Color(128, 128, 128));
		tabbedPane.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 18));
		tabbedPane.setBounds(20, 101, 669, 433);
		//add pane to frame
		frame.getContentPane().add(tabbedPane);
		
		//Adding the necessary panes successively in the tabbed pane
		
		tabbedPane.addTab("Bachelor", null, bpanel, "");
		tabbedPane.setEnabledAt(0, true);
		tabbedPane.setBackgroundAt(0, new Color(95, 158, 160));
		tabbedPane.setForegroundAt(0, new Color(0, 0, 0));
		

		tabbedPane.addTab("Masters", null, mpanel, null);
		tabbedPane.setBackgroundAt(1, new Color(95, 158, 160));
		tabbedPane.setForegroundAt(1, new Color(0, 0, 0));


		tabbedPane.addTab("Phd", null, ppanel, null);
		tabbedPane.setBackgroundAt(2, new Color(95, 158, 160));
		tabbedPane.setForegroundAt(2, new Color(0, 0, 0));
		

		tabbedPane.addTab("Scientist", null, spanel, null);
		tabbedPane.setBackgroundAt(3, new Color(95, 158, 160));
		tabbedPane.setForegroundAt(3, new Color(0, 0, 0));

		//seperator(visual content)
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(139, 0, 0));
		separator.setBounds(0, 85, 710, 6);
		frame.getContentPane().add(separator);
		frame.setBounds(100, 100, 724, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//handling submit and reset events 
		submitListenEvents();
		resetListenEvents();
	}

	public void submitListenEvents(){//action listener for button: submit
		bpanel.submit.addActionListener(new ActionListener(){ //bachelor panel submit button
			public void actionPerformed(ActionEvent e){
				bpanel.readAndSave();
			}
		});
		mpanel.submit.addActionListener(new ActionListener(){//master panel submit button
			public void actionPerformed(ActionEvent e){
				mpanel.readAndSave();
			}
		});

		ppanel.submit.addActionListener(new ActionListener(){//phd panel submit button
			public void actionPerformed(ActionEvent e){
				ppanel.readAndSave();
			}
		});

		spanel.submit.addActionListener(new ActionListener(){//scientist panel submit button
			public void actionPerformed(ActionEvent e){
				spanel.readAndSave();
			}
		});			
	}
	public void resetListenEvents(){//action listener for button: reset
		bpanel.reset.addActionListener(new ActionListener(){//bachelor panel reset button
			public void actionPerformed(ActionEvent e){
				bpanel.resetAll();
			}
		});
		mpanel.reset.addActionListener(new ActionListener(){//master panel reset button
			public void actionPerformed(ActionEvent e){
				mpanel.resetAll();
			}
		});

		ppanel.reset.addActionListener(new ActionListener(){//phd panel reset button
			public void actionPerformed(ActionEvent e){
				ppanel.resetAll();
			}
		});

		spanel.reset.addActionListener(new ActionListener(){//scientist panel reset button
			public void actionPerformed(ActionEvent e){
				spanel.resetAll();
			}
		});			
	}	
}

// end of program



