package page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(how = How.ID, using="header_sign_in") 
	private WebElement signInElement;
	
	@FindBy(how=How.XPATH, using= "//input[@id='emailAddress']") 
	private WebElement userNameElement;
	
	@FindBy(how=How.ID, using="password") 
	private WebElement passwordElement;
	
	@FindBy(how=How.ID ,using= "email-auth-btn") 
	private WebElement signinButtonElement;
	
	public void clickSignin() {
		signInElement.click();		
	}
	public void enterUsername(String username) {
		WebElement element = getIframeElement(By.xpath("//input[@id='emailAddress']"));		
		element.sendKeys(username);	
		driver.switchTo().parentFrame();
	}

	private WebElement getIframeElement(By by) {
		WebElement element = null;
		driver.switchTo().parentFrame();
		driver.switchTo().frame("auth-microsite-iframe");
		try {
				element = driver.findElement(by);			
			} catch (Exception ex) {
				System.out.println("element does not exists");
			}
		return element;
	}
	public void enterPassword(String password) {
		WebElement element = getIframeElement(By.xpath("//input[@id='password']"));		
		element.sendKeys(password);
		driver.switchTo().parentFrame();
	}
	public void clickSignInButton() {
		WebElement element = getIframeElement(By.xpath("//button[@id='email-auth-btn']"));		
		element.click();
		driver.switchTo().parentFrame();
	}
	
	public String errMessage() {
		driver.switchTo().parentFrame();
		new WebDriverWait(driver, 8)
		          								.until(driver -> ! getIframeElement(By.xpath("//*[@id=\"authContainer\"]/div[1]") ).getText().contains("Forgot"));
		WebElement element = getIframeElement(By.xpath("//*[@id=\"authContainer\"]/div[1]"));
		System.out.println(element.getText());
		 return element.getText();		 
	}

	       
		
	

}
