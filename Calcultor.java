package source;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calcultor implements ActionListener  {
	private JFrame LoggingFrame;
	private JButton [] numberButton;
	private JButton [] functionButtons;
	private JButton addButton,SubButton,mulButton,divButton;
	private JButton decButton,equButton,delButton,ClrButton;
	private JTextField textfield;
	private JPanel panel;
	private Font myFont;
	private double num1,num2,result;
	private char operator;
	Calcultor()
	{
		this.SetUpCalcultor();
	}
	private void SetUpCalcultor()
	{
		numberButton=new JButton[10];
		functionButtons=new JButton[8];
		num1=num2=result=0;
		LoggingFrame=new JFrame("Calcultor");
		LoggingFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		LoggingFrame.setSize(420,550);
		LoggingFrame.setLayout(null);
		myFont=new Font("Ink Free",Font.BOLD,30);
		textfield=new JTextField();
		textfield.setBounds(50,25,300,50);
		textfield.setFont(myFont);
		textfield.setEditable(false);
		addButton=new JButton("+");
		SubButton=new JButton("-");
		mulButton=new JButton("*");
		divButton=new JButton("/");
		decButton=new JButton(".");
		equButton=new JButton("=");
		delButton=new JButton("Delete");
		ClrButton=new JButton("Clr");
		functionButtons[0]=addButton;
		functionButtons[1]=SubButton;
		functionButtons[2]=mulButton;
		functionButtons[3]=divButton;
		functionButtons[4]=decButton;
		functionButtons[5]=equButton;
		functionButtons[6]=delButton;
		functionButtons[7]=ClrButton;
		for(int i=0;i<8;i++)
		{
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false);
		}
		for(int i=0;i<10;i++)
		{
			numberButton[i]=new JButton(String.valueOf(i));
			numberButton[i].addActionListener(this);
			numberButton[i].setFont(myFont);
			numberButton[i].setFocusable(false);
		}
		
		panel=new JPanel();// creat Some where to save the buttons
		panel.setBounds(50,100,300,300);// Setting the pannel
		panel.setLayout(new GridLayout(4,4,10,10));// GridLayout matrix 4*4 space between
		panel.setBackground(Color.DARK_GRAY);
		for(int i=1;i<4;i++)
		{
			panel.add(numberButton[i]);
		}
		panel.add(addButton);
		for(int i=4;i<7;i++)
		{
			panel.add(numberButton[i]);
		}
		panel.add(SubButton);
		for(int i=7;i<10;i++)
		{
			panel.add(numberButton[i]);
		}
		panel.add(mulButton);
		panel.add(decButton);
		panel.add(numberButton[0]);
		panel.add(equButton);
		panel.add(divButton);
		delButton.setBounds(50,430,145,50);
		ClrButton.setBounds(250,430,145,50);
		LoggingFrame.add(panel);
		LoggingFrame.add(delButton);
		LoggingFrame.add(ClrButton);
		LoggingFrame.add(textfield);
		LoggingFrame.setVisible(true);
	}
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<10;i++)
		{
			if(e.getSource()==numberButton[i])
			{
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		
		if(e.getSource()==decButton)
		{
			textfield.setText(textfield.getText().concat(String.valueOf(".")));
		}
		if(e.getSource()==mulButton)
		{
			num1=Double.parseDouble(textfield.getText());
			operator='*';
			textfield.setText("");
		}
		if(e.getSource()==SubButton)
		{
			num1=Double.parseDouble(textfield.getText());
			operator='-';
			textfield.setText("");
		}
		if(e.getSource()==addButton)
		{
			num1=Double.parseDouble(textfield.getText());
			operator='+';
			textfield.setText("");
		}
		if(e.getSource()==divButton)
		{
			num1=Double.parseDouble(textfield.getText());
			operator='/';
			textfield.setText("");
		}
		if(e.getSource()==equButton)
		{
			num2=Double.parseDouble(textfield.getText());
			switch(operator)
			{
			case '+':
				result=num1+num2;
				break;
			case '-':
				result=num1-num2;
				break;
			case '*':
				result=num1*num2;
				break;
			case '/':
				result=num1/num2;
				break;
			}
			textfield.setText(String.valueOf(result));
			num1=result;
		}
		if(e.getSource()==ClrButton)
		{
			textfield.setText("");
			num1=0;
			num2=0;
			result=0;
		}
		if(e.getSource()==delButton)
		{
			String str=textfield.getText();
			textfield.setText("");
			for(int i=0;i<str.length()-1;i++)
			{
				textfield.setText(textfield.getText()+str.charAt(i));
			}
			
		}
		
		
		
	}
	

}
