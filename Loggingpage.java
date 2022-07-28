package source;

import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Loggingpage implements ActionListener {
	//What parameters
	private JFrame LoggingFrame;
	private JButton loggingbutton;
	private JButton reset;
	private JTextField UserFild;
	private JPasswordField PasswordFild;
	private JLabel UserIDLable;
	private JLabel PasswordLable;
	private JLabel message;
	private HashMap<String,String>loginginfo;
	
	Loggingpage()
	{
		this.SetUpPage();
	}
	private void SetUpPage()
	{
		LoggingFrame=new JFrame();
		loggingbutton=new JButton("Logging");
		reset=new JButton("Reset");
		UserFild=new JTextField();
		PasswordFild=new JPasswordField();
		UserIDLable=new JLabel("UserID:");
		PasswordLable=new JLabel("Password:");
		message=new JLabel();
		loginginfo=new HashMap<String,String>();
		UserIDLable.setBounds(50, 100, 75, 25);
		UserFild.setBounds(100, 100, 200, 25);
		PasswordLable.setBounds(50, 150, 75, 25);
		PasswordFild.setBounds(115, 150, 200, 25);
		message.setBounds(125, 250, 250, 35);
		loggingbutton.setBounds(125,200,100,25);
		reset.setBounds(225,200,100,25);
		message.setFont(new Font("Ink Free",Font.BOLD,30));
		LoggingFrame.add(PasswordFild);
		LoggingFrame.add(UserFild);
		LoggingFrame.add(message);
		LoggingFrame.add(message);
		LoggingFrame.add(UserIDLable);
		LoggingFrame.add(PasswordLable);
		LoggingFrame.add(loggingbutton);
		LoggingFrame.add(reset);
		loggingbutton.addActionListener(this);
		reset.addActionListener(this);
		LoggingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		LoggingFrame.setSize(420,420);
		LoggingFrame.setLayout(null);
		LoggingFrame.setVisible(true);
	}
	
	private void LogIn()
	{
		loginginfo=(new PasswordUsername()).GetInfo();//Like call from set db to get the info
		String UserID=UserFild.getText();
		String Password=String.valueOf(PasswordFild.getPassword());
		if(loginginfo.containsKey(UserID))
		{
			String test=loginginfo.get(UserID);
			if( loginginfo.get(UserID).equals(Password) )
			{
				message.setText("Approved");
				LoggingFrame.dispose();
				MainPage Page=new MainPage();
			}
			else
			{
				message.setText("No such password");
			}
			
		}
		else
		{
			message.setText("No Such User");
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==reset)
		{
			this.UserFild.setText("");
			this.PasswordFild.setText("");
		}
		if(e.getSource()==loggingbutton)
		{
			this.LogIn();
		}
		
		
	}
		
	
	
	
	
	
	}
	
	

