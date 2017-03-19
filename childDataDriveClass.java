package Bank;

import java.io.IOException;

import org.testng.annotations.Test;

public class childDataDriveClass extends AppTest {

	@Test
	public void childClass() throws IOException{
		System.out.println("Child class called");
		loginDetails();
	}
}
