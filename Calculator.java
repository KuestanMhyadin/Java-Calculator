package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

	JFrame frame;
	JTextField textField;
	JButton numberButton[] = new JButton[10];
	JButton functionButton[] = new JButton[9];
	JButton addButton, subButton, mulButton, divButton;
	JButton decButton, equButton, clrButton, delButton, negButton;
	JPanel panel;
	Font font = new Font("Times new Roman", Font.BOLD, 25);

	double num1 = 0, num2 = 0, sum = 0;
	char operator = 'b';

	public Calculator(){
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(390, 510);
		frame.setResizable(false);
		frame.setLayout(null);

		textField = new JTextField();
		textField.setBounds(50, 25, 300, 50);
		textField.setFont(font);
		textField.setEditable(false);



		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton("Del");
		clrButton = new JButton("Clr");
		negButton = new JButton("-");

		functionButton[0] = addButton;
		functionButton[1] = subButton;
		functionButton[2] = mulButton;
		functionButton[3] = divButton;
		functionButton[4] = decButton;
		functionButton[5] = equButton;
		functionButton[6] = delButton;
		functionButton[7] = clrButton;
		functionButton[8] = negButton;

		for(int i = 0; i<9; i++) {
			functionButton[i].addActionListener(this);
			functionButton[i].setFont(font);
			functionButton[i].setFocusable(false);
		}

		for(int i = 0; i<10; i++) {
			numberButton[i] = new JButton(String.valueOf(i));
			numberButton[i].addActionListener(this);
			numberButton[i].setFont(font);
			numberButton[i].setFocusable(false);
		}

		negButton.setBounds(50, 430, 70, 30);
		delButton.setBounds(150, 430, 70, 30);
		clrButton.setBounds(250, 430, 70, 30);

		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4,4,10,10));

		panel.add(numberButton[1]);
		panel.add(numberButton[2]);
		panel.add(numberButton[3]);
		panel.add(addButton);
		panel.add(numberButton[4]);
		panel.add(numberButton[5]);
		panel.add(numberButton[6]);
		panel.add(subButton);
		panel.add(numberButton[7]);
		panel.add(numberButton[8]);
		panel.add(numberButton[9]);
		panel.add(mulButton);
		panel.add(decButton);
		panel.add(numberButton[0]);
		panel.add(equButton);
		panel.add(divButton);

		panel.setBackground(Color.GRAY);

		frame.add(panel);
		frame.add(negButton);
		frame.add(delButton);
		frame.add(clrButton);
		frame.add(textField);
		frame.setVisible(true);

		frame.setBackground(Color.GRAY);
	}

	public static void main(String[] args) {

		Calculator calc = new Calculator();

	}


	public double add(double num1, double num2) {
		return num1+num2;
	}

	public double sub(double num1, double num2) {
		return num1-num2;
	}

	public double mul(double num1, double num2) {
		return num1*num2;
	}

	public double div(double num1, double num2) {
		return num1/num2;
	}

	public void calculate() {
		switch(operator) {
			case'+':
				sum = add(num1, num2);
				break;
			case'-':
				sum = sub(num1, num2);
				break;
			case'*':
				sum = mul(num1, num2);
				break;
			case'/':
				sum = div(num1, num2);
				break;
		}
		textField.setText(String.valueOf(sum));
		num1 = sum;
	}

	public void clear() {
		textField.setText("");
		operator = 'b';
		num1 = 0;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		for(int i = 0; i<10; i++) {
			if(e.getSource() == numberButton[i]) {
				textField.setText(textField.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource() == decButton) {
			textField.setText(textField.getText().concat("."));
		}
		if(e.getSource() == addButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = '+';
			textField.setText("");
		}
		if(e.getSource() == subButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = '-';
			textField.setText("");
		}
		if(e.getSource() == mulButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = '*';
			textField.setText("");
		}
		if(e.getSource() == divButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = '/';
			textField.setText("");
		}
		if(e.getSource() == equButton) {
			num2 = Double.parseDouble(textField.getText());
			calculate();

		}
		if(e.getSource() == clrButton) {
			clear();
		}
		if(e.getSource() == delButton) {
			del();

		}
		if(e.getSource() == negButton) {
			neg();
		}
	}

	public void del() {
		String string = textField.getText();
		textField.setText("");
		for(int i = 0; i<string.length()-1; i++) {
			textField.setText(textField.getText()+string.charAt(i));
		}
	}

	public void neg() {
		double temp = Double.parseDouble(textField.getText());
		temp*=-1;
		textField.setText(String.valueOf(temp));
	}

	public JTextField getTextField() {
		return textField;
	}


}