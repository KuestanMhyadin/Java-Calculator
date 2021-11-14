package calculator;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JTextField;

import org.junit.jupiter.api.Test;

class testing {

Calculator calc = new Calculator();
	
	@Test
	void add() {
		double no1 = 5, no2 = 4;
		double actual = calc.add(no1,no2);
		double expected = 5+4;
		assertEquals(expected, actual);
	}
	
	@Test
	void sub() {
		double no1= 5, no2 = 4;
		double actual = calc.sub(no1, no2);
		double expected = 5-4;
		assertEquals(expected, actual);
		
	}
	
	@Test
	void mul() {
		double no1 = 5, no2 = 4;
		double actual = calc.mul(no1,no2);
		double expected = 5*4;
		assertEquals(expected, actual);
	}
	
	@Test
	void div() {
		double no1 = 5, no2 = 4;
		double actual = calc.div(no1,no2);
		double expected = (double)5/4;
		assertEquals(expected,actual);
	}
	
	@Test
	void neg() {
		JTextField myTextField = calc.getTextField();
		double n = 3;
		myTextField.setText(n+"");
		calc.neg();
		String actual = myTextField.getText();
		double expected = n*(-1);
		assertEquals(expected+"", actual);
	}
}
