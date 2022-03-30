package test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import main.MainMenu;

class MainMenuTest {

	@Test
	void testGetIntInput() {
		
		// initialize input stream
		String input = "1";
		
		// fill system input with stream
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		Scanner s = new Scanner(System.in);
		int result = MainMenu.getIntInput(s);
		
		s.close();
		
		assertEquals(1, result);
		
	}
	
	// TODO: figure out how to test getIntInput for messy input

}
