
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.testng.Assert;

public class LoginTest {

	LoginPage lp = new LoginPage();
	DataFile df = new DataFile();
		
	@Before
	public void setUp() throws Exception {
		lp.openBrowser();
		lp.openGmail();
	}

	@After
	public void tearDown() throws Exception {
		lp.closeBrowser();
	}

	@Test
	public void verifylLoginWithInvalidPassword() throws InterruptedException {
		lp.enterEmail(df.validEmail);
		lp.enterPassword(df.invalidPassword);

		String actualErrMsg = lp.readPasswordErrMsg();
		String expectedErrMsg = "Wrong password. Try again or click Forgot password to reset it.";
		
		System.out.println("Invalid Password Error Message : " + actualErrMsg);
		
		Assert.assertEquals(actualErrMsg, expectedErrMsg);
	}
	
	@Test
	public void verifylLoginWithInvalidEmail() throws InterruptedException {
		lp.enterEmail(df.invalidEmail);
		
		String actualErrMsg = lp.readEmailErrMsg();
		String expectedErrMsg = "Couldn't find your Google Account";
		
		System.out.println("Invalid Email Error Message : " + actualErrMsg);
		
		Assert.assertEquals(actualErrMsg, expectedErrMsg);
		
	}

}
