package source;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InstagramControrlPage implements ActionListener {

	private JFrame page2;
	private JPanel MainPanel;
	private JPanel SubPanel;
	private JButton Select_users;
	private JButton Find_User;
	private JTextField UserName;
	private JTextField Password;
	private JTextField Status;
	private JButton LogIn;
	private Font myFont;
	private String UserNameSelected;
	private String PassordSelected;
	private InstagramProducerInformation InstagramProducer;
	private InstagramStatus ShowIfLoggedInInstagram ; 
	
	InstagramControrlPage()
	{
		this.SetIpInstegram();
	}
	
	private void SetIpInstegram()
	{
		ShowIfLoggedInInstagram=InstagramStatus.Unvalid;
		UserNameSelected="";
		PassordSelected="";
		page2=new JFrame("Instegram");
		page2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		page2.setSize(420,550);
		page2.setLayout(null);
		myFont=new Font("Ink Free",Font.BOLD,30);
		Select_users=new JButton("Select user");
		LogIn=new JButton("Log In to First");
		Find_User=new JButton("Find User By name");
		MainPanel=new JPanel();
		MainPanel.setBounds(100,150,150,150);
		MainPanel.setLayout(new GridLayout(5,5,20,20));
		Select_users.addActionListener(this);
		LogIn.addActionListener(this);
		Find_User.addActionListener(this);
		Status=new JTextField("No Selected User Yet");
		Status.setBounds(70,300,300,100);
		Status.setFont(myFont);
		Status.setEditable(false);
		MainPanel.add(Find_User);
		MainPanel.add(LogIn);
		MainPanel.add(Select_users);
		page2.add(Status);
		page2.add(MainPanel);
		page2.setVisible(true);
	}
	
	
	

	
	private void SetSubPanel()
	{
		UserName=new JTextField(10);
		Password=new JTextField(10);
		SubPanel=new JPanel();
		SubPanel.add(new JLabel("UserName"));
		SubPanel.add(UserName);
		SubPanel.add(Box.createHorizontalStrut(15)); 
		SubPanel.add(new JLabel("Password"));
		SubPanel.add(Password);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==Select_users)
		{
			this.SetSubPanel();
			int result = JOptionPane.showConfirmDialog(null, SubPanel, 
		               "Please Enter UserName Password", JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION) {
				UserNameSelected = UserName.getText();
				PassordSelected = Password.getText();
				Status.setText("Have "+ 1 + " User Connected");
		      }
			
		}
		if(e.getSource()==LogIn)
		{
			if(UserNameSelected.isEmpty()==false)
				{
				InstagramProducer=new InstagramProducerInformation(UserNameSelected,PassordSelected);
				ShowIfLoggedInInstagram=InstagramProducer.GetInstagramStatus();
				switch(ShowIfLoggedInInstagram)
				{
					case Valid:
						ShowIfLoggedInInstagram=InstagramStatus.Valid;
						break;
					case Unvalid:
						ShowIfLoggedInInstagram=InstagramStatus.Unvalid;
						JOptionPane.showMessageDialog(page2, "User Is Unvalid try agian ");
						break;
				}
				}
			else
			{
				JOptionPane.showMessageDialog(page2, "Pick user first");
			}
		}
		if(e.getSource()==Find_User) 
		{
			if(ShowIfLoggedInInstagram==InstagramStatus.Valid)
			{
				String Name = JOptionPane.showInputDialog("Please give us the name");
				InstagramProducer.SearchByName(Name);
			}
			else
			{
				JOptionPane.showMessageDialog(page2, "You have to Select_user first");
			}
		}
	
	}

}
