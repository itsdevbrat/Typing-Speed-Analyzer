import javax.swing.*;
import java.text.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;

class Type
{
	static int flag=0;
	static int correctwords=0;
	static int correctcount=0;
	static int incorrectcount=0;
	static String []s = {"<html>When My Teacher Scolded Me Scolding is something common in student life. Being a naughty boy, I am always scolded by my parents. But one day I was severely scolded by my English teacher. She infect teaches well. But that day, I could not resist the temptation that an adventure of Nancy Drew offered. While she was teaching, I was completely engrossed in reading that book. Nancy Drew was caught in the trap laid by some smugglers and it was then when I felt a light tap on my bent head. The teacher had caught me red handed. She scolded me then and there and insulted me in front of the whole class. I was embarrassed. My cheeks burned being guilty conscious. When the class was over, I went to the teacher to apologize. When she saw that I had realized my mistake, she cooled down and then told me in a very kind manner how disheartening it was when she found any student not paying attention. I was genuinely sorry and promised to myself never to commit such a mistake again.</html>","<html>Delhi is the traditional and present day capital of India. It is the third largest city of the world. It is also the second largest metropolis after Mumbai with a population of over 13 million. Delhi is also one of the oldest continually inhabited cities of India. Delhi stands in a triangle formed by the Yamuna river in the east and spurs from the Aravalli range in the west and south. It is surrounded by Haryana on all sides except east where it borders with Uttar Pradesh, Delhi has a semi-arid climate with high variation between summer and winter temperature.</html>","<html>The system of annual inspection by private agencies was soon found to be unsatisfactory since the interested firms/manufacturers were not found to give a wholly correct and impartial picture of the condition of water works plants.  In 1916, the U.P. Municipalities Act was enacted. In this Act public duties of the Municipal Boards were defined and detailed procedure was laid down giving effect to various matters of public interest. Sources of raising Board's revenues were also prescribed.</html>","<html>Studying is the main source of knowledge. Books are indeed never failing friends of man. For a mature mind, reading is the greatest source of pleasure and solace to distressed minds. The study of good books ennobles us and broadens our outlook. Therefore, the habit of reading should be cultivated. A student should never confine himself to his schoolbooks only. He should not miss the pleasure locked in the classics, poetry, drama, history, philosophy etc. We can derive benefit from others experiences with the help of books. The various sufferings, endurance and joy described in books enable us to have a closer look at human life. They also inspire us to face the hardships of life courageously. Nowadays there are innumerable books and time is scarce.</html>"};
	static String []a = {"When My Teacher Scolded Me Scolding is something common in student life. Being a naughty boy, I am always scolded by my parents. But one day I was severely scolded by my English teacher. She infect teaches well. But that day, I could not resist the temptation that an adventure of Nancy Drew offered. While she was teaching, I was completely engrossed in reading that book. Nancy Drew was caught in the trap laid by some smugglers and it was then when I felt a light tap on my bent head. The teacher had caught me red handed. She scolded me then and there and insulted me in front of the whole class. I was embarrassed. My cheeks burned being guilty conscious. When the class was over, I went to the teacher to apologize. When she saw that I had realized my mistake, she cooled down and then told me in a very kind manner how disheartening it was when she found any student not paying attention. I was genuinely sorry and promised to myself never to commit such a mistake again.","Delhi is the traditional and present day capital of India. It is the third largest city of the world. It is also the second largest metropolis after Mumbai with a population of over 13 million. Delhi is also one of the oldest continually inhabited cities of India. Delhi stands in a triangle formed by the Yamuna river in the east and spurs from the Aravalli range in the west and south. It is surrounded by Haryana on all sides except east where it borders with Uttar Pradesh, Delhi has a semi-arid climate with high variation between summer and winter temperature.","The system of annual inspection by private agencies was soon found to be unsatisfactory since the interested firms/manufacturers were not found to give a wholly correct and impartial picture of the condition of water works plants.  In 1916, the U.P. Municipalities Act was enacted. In this Act public duties of the Municipal Boards were defined and detailed procedure was laid down giving effect to various matters of public interest. Sources of raising Board's revenues were also prescribed.","Studying is the main source of knowledge. Books are indeed never failing friends of man. For a mature mind, reading is the greatest source of pleasure and solace to distressed minds. The study of good books ennobles us and broadens our outlook. Therefore, the habit of reading should be cultivated. A student should never confine himself to his schoolbooks only. He should not miss the pleasure locked in the classics, poetry, drama, history, philosophy etc. We can derive benefit from others experiences with the help of books. The various sufferings, endurance and joy described in books enable us to have a closer look at human life. They also inspire us to face the hardships of life courageously. Nowadays there are innumerable books and time is scarce."};
	static JTextArea textArea;
	static JLabel timerlabel;
	static JButton submit;
	static javax.swing.Timer timer;
	static int itimer=0;
	static int paraNo;
	static JLabel label;
	static JFrame frame2;
	static JFrame frame3;
	
	void type()
	{	
		//MainFrame
		frame2 = new JFrame();
		frame2.setVisible(true);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame2.setTitle("Typing Speed Analyzer");
		ImageIcon icon = new ImageIcon("logo1.jpg");
		frame2.setIconImage(icon.getImage());
		frame2.setLayout(null);
		frame2.setBackground(Color.BLACK);
		
		//ParagraphLabel
		label = new JLabel();
		frame2.add(label);
		Random random = new Random();
		paraNo = random.nextInt(3);
		label.setText(s[paraNo]);
		label.setBounds(100,114,1160,200); 
		label.setFont(new Font("PTSerif",Font.BOLD,18));
		label.setForeground(Color.CYAN);
		
		//TimerLabel
		timerlabel = new JLabel("Time Elapsed : 0 secs");
		frame2.add(timerlabel);
		timerlabel.setBounds(540,344,240,30);
		timerlabel.setFont(new Font("PTSerif",Font.BOLD,20));
		timerlabel.setForeground(Color.CYAN);
		
		//Buttons
		JButton start = new JButton("Start");
		start.setFont(new Font("Times New Roman",Font.BOLD,20));
		start.setBackground(new Color(0,0,60));
		start.setForeground(Color.WHITE);
		frame2.add(start);
		start.setBounds(100,344,200,33);
		
		submit = new JButton("Submit");
		submit.setFont(new Font("Times New Roman",Font.BOLD,20));
		submit.setBackground(new Color(0,0,60));
		submit.setForeground(Color.WHITE);
		frame2.add(submit);
		submit.setBounds(1060,344,200,33);
		
		JButton back = new JButton(new ImageIcon("back.png"));
		frame2.add(back);
		back.setBounds(100,50,40,40);
		back.setBackground(Color.BLACK);
		
		
		//TextArea
		textArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		frame2.add(scrollPane);
		textArea.setBounds(100,400,1160,250);
		scrollPane.setBounds(100,400,1160,250);
		textArea.setLineWrap(true); 					//So that typed text gets ont new line when it reaches to borders
		textArea.setBackground(Color.WHITE);
		textArea.setFont(new Font("PTSerif",Font.BOLD,18));
		textArea.setEditable(false);
		textArea.setToolTipText("PRESS ENTER TO SUBMIT");
		
		//Background 
		JLabel background = new JLabel(new ImageIcon("pattern4.jpg"));
		background.setBounds(0,0,1360,768);
		frame2.add(background);
		
		// || ------------------------------ EVENT HANDLING   ---------------------------------------- ||
		
		start.addActionListener(new StartTimer());
		
		//Submit Buttons eventhandler
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				submitButtonClicked(e);
			}
		});	
		
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				TypingSpeedAnalyzer.frame.setVisible(true);
				TypingSpeedAnalyzer.frame.setResizable(true);
				frame2.setVisible(false);
			}
		});
		
		//Text Area Key Listener
		textArea.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {}		//Additional feature
			public void keyReleased(KeyEvent e) 
			{
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
					submit.doClick();
			}
		});
	}
	
		
		static void submitButtonClicked(ActionEvent e)
		{
			timer.stop();

			int incorrectwords=0;
			String input = textArea.getText(); 
		
			for(int i=0;i<input.length() && i<a[paraNo].length() && input.charAt(i)!='\n';i++)
			{
				if(input.charAt(i)==a[paraNo].charAt(i))
				{	
					correctcount++;
				}
				else
				{
					incorrectwords++;
					incorrectcount++;
				}
				if(incorrectwords==0 && a[paraNo].charAt(i)==' ')
				{
					correctwords++;
					incorrectwords=0;
				}
				
			}	
		System.out.println(correctwords);
			displayresult();
		
			//Change paragraphs after submittting and various fixes
			if(paraNo==3)
				label.setText(s[0]);
			else
				label.setText(s[++paraNo]);
		
			textArea.setEditable(false);
			itimer=0;
			textArea.setText("");
			correctcount=0;
			incorrectcount=0;
			flag=0;
			correctwords=0;
			timer.stop();
		}
	
		//Handles start button's action event
		class StartTimer implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				if(flag==0)
				{
					textArea.setEditable(true);
					timer = new javax.swing.Timer(1000,new timer());
					timer.start();
					textArea.requestFocus();
					flag=1;
				}
			}
		}
	
		//Class to handle actionevents fired by javax.swing.timer class
		class timer implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				timerlabel.setText("Time Elapsed : "+(++itimer)+" secs");
			}
		}
		
		//Function called in submit buttons event handler
		
	
		static void displayresult()
		{
			DecimalFormat df2 = new DecimalFormat(".##");		//Displaying only two digits after decimal for efficiency(.##)
			
			
			double minutes = (double)itimer/60.0;
			double apm = (double)correctcount/minutes;
			double wpm = (double)correctwords/minutes;
			double eff = ((double)(correctcount)/(double)(correctcount+incorrectcount))*100;
			
			frame3 = new JFrame();
			frame3.setTitle("Typing Speed Analyzer");
			ImageIcon icon = new ImageIcon("logo1.jpg");
			frame3.setIconImage(icon.getImage());
			frame3.setLayout(null);
			frame3.setBackground(Color.BLACK);
			frame3.setVisible(true);
			frame2.setVisible(false);
			frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame3.setExtendedState(JFrame.MAXIMIZED_BOTH);
			
			
			JLabel resultpic = new JLabel(new ImageIcon("result.jpg"));
			frame3.add(resultpic);
			resultpic.setBounds(507,170,366,183);
			JLabel quote = new JLabel();
			frame3.add(quote);
			quote.setBounds(430,104,1160,30); 
			quote.setFont(new Font("Didot",Font.BOLD,25));
			quote.setForeground(Color.CYAN);
			quote.setText("<html><pre>' Type Type till you Achieve the best '</pre></html>");
			JLabel label1 = new JLabel();
			frame3.add(label1);
			label1.setBounds(420,317,1160,303); 
			label1.setFont(new Font("Didot",Font.BOLD,25));
			label1.setForeground(Color.CYAN);
			label1.setText("<html><pre>Time Elapsed = "+itimer+" seconds <br>Number of correct alphabets typed = "+correctcount+"<br>Number of Incorrect alphabets typed = "+incorrectcount+"<br>Your Typing speed in APM is = "+(int)apm+"<br>Your Typing speed in WPM is = "+(int)wpm+"<br>Your Efficiency in Typing is : "+df2.format(eff)+" %</pre></html>");
			JLabel background = new JLabel(new ImageIcon("pattern4.jpg"));
			background.setBounds(0,0,1360,768);
			frame3.add(background);
			
			JButton tryagain = new JButton("Try Again");
			tryagain.setBounds(600,620,210,40);
			tryagain.setFont(new Font("Times New Roman",Font.BOLD,20));
			tryagain.setBackground(Color.CYAN);
			frame3.add(tryagain);
			
			tryagain.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					tryAgain();
				}
			});
		}
			
		static void tryAgain()
		{
			frame2.setVisible(true);
			frame3.setVisible(false);
		}
}



public class TypingSpeedAnalyzer
{
	static JTextField Id;
	static JPasswordField Password;
	static JFrame frame;
	static JButton login;
	public static void main(String args[])
	{	
		//Login Frame
		frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setTitle("Typing Speed Analyzer");
		ImageIcon icon = new ImageIcon("logo1.jpg");
		frame.setIconImage(icon.getImage());
		frame.setLayout(null);
		frame.getContentPane().setBackground(new Color(0,0,0));
		frame.setResizable(false);
		
		login = new JButton("Login");
		Id = new JTextField();
		JLabel id = new JLabel("Enter User ID");
		Password = new JPasswordField();
		JLabel password = new JLabel("Enter Password");
		JLabel welcome1 = new JLabel(new ImageIcon("logo.jpg"));
		JLabel user = new JLabel(new ImageIcon("user.jpg"));
		
		frame.add(id);
		frame.add(Password);
		frame.add(Id);
		frame.add(password);
		frame.add(login);
		frame.add(welcome1);
		frame.add(user);
		
		user.setBounds(860,84,250,250);
		id.setBounds(760,394,225,30);
		Id.setBounds(985,394,250,30);
		password.setBounds(760,454,225,30);
		Password.setBounds(985,454,250,30);
		login.setBounds(870,524,250,40);
		welcome1.setBounds(186,297,388,173);		
		
		login.setBackground(new Color(120,0,0));
		login.setForeground(Color.CYAN);
		Font font = new Font("AbrilFatface",Font.BOLD,18);
		id.setFont(font);
		password.setFont(font);
		Id.setFont(font);
		Id.requestFocus();
		id.setForeground(Color.WHITE);
		password.setForeground(Color.WHITE);
		
		Password.addKeyListener(new enterPressed());
		
		Id.addKeyListener(new idEnterPressed());
		
		login.addActionListener(new next());
	
	}
	
	static class enterPressed implements KeyListener
	{
		public void keyTyped(KeyEvent e) {}
		public void keyPressed(KeyEvent e) {}
		public void keyReleased(KeyEvent e) {
			if(e.getKeyCode()==KeyEvent.VK_ENTER)
			login.doClick();
		}
	}
	
	static class idEnterPressed implements KeyListener
	{
		public void keyTyped(KeyEvent e) {}
		public void keyPressed(KeyEvent e) {}
		public void keyReleased(KeyEvent e) {
			if(e.getKeyCode()==KeyEvent.VK_ENTER)
			Password.requestFocus();
		}
	}
	
	static class next implements ActionListener
	{
		Connection conn ;
		Statement s;
		public void actionPerformed(ActionEvent e)
		{
			try
			{	
				String sql = "CREATE TABLE if not exists TypeUsers " +
                        "(ID			VARCHAR(30)	 NOT NULL," +
                        " PASSWORD      VARCHAR(30) NOT NULL);"; 
				String ID=Id.getText();
				String PASSWORD=Password.getText();
				
				//Establishing connection
				Class.forName("org.sqlite.JDBC");
				conn = DriverManager.getConnection("jdbc:sqlite:login.sqlite");
				
				//Noramal Statement fetching
				s = conn.createStatement();
				
				//created table
				s.executeUpdate(sql);	
				
				String query="select * from TypeUsers where ID= ? and PASSWORD=?";
				PreparedStatement pst=conn.prepareStatement(query);
				pst.setString(1,ID);
				pst.setString(2, PASSWORD);
				
				//execute query
				ResultSet rs=pst.executeQuery(); //in rs result is stoed
				
				int count=0;
				while(rs.next()) 
				{
					count=count+1;
				}
				
				System.out.println(count);
				
				if(count!=1) 
				{	
					String sql1 = "INSERT INTO TypeUsers(ID,PASSWORD) VALUES(?,?)";
 
					PreparedStatement pstmt = conn.prepareStatement(sql1); 
					pstmt.setString(1, ID);
					pstmt.setString(2, PASSWORD);
					pstmt.executeUpdate();
				}					
				
				//Vital :: Connection closed
				s.close();
				conn.close();
				
			}catch(Exception ex)
				{
					ex.printStackTrace();
				}
			
			frame.setVisible(false);
				Type i = new Type();
				i.type();
			}
	}
}








