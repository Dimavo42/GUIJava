package source;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainPage implements ActionListener {
	private JFrame MainPage1;
	private JButton CalcButton;
	private JButton Instegram;
	private JPanel panel;
	MainPage()
	{
		this.SetUpMainPage();
	}
	private void SetUpMainPage()
	{
		MainPage1=new JFrame();
		MainPage1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainPage1.setSize(420,420);
		MainPage1.setLayout(null);
		CalcButton=new JButton("Calcultator");
		Instegram=new JButton("Instegram");
		panel=new JPanel();
		panel.setBounds(50,100,150,150);
		panel.setLayout(new GridLayout(2,2,5,5));
		CalcButton.addActionListener(this);
		Instegram.addActionListener(this);
		panel.add(CalcButton);
		panel.add(Instegram);
		MainPage1.add(panel);
		MainPage1.setVisible(true);
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==CalcButton)
		{
			
			Calcultor CalcultorPage=new Calcultor();
		}
		if(e.getSource()==Instegram)
		{
			
			InstagramControrlPage InstegramPage=new InstagramControrlPage();
		}
		
	}

}
