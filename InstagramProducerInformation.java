package source;
import java.time.Duration;
import java.lang.Thread;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class InstagramProducerInformation extends WebDriver {
	private String UserName;
	private String PassWord;
	private InstagramStatus LogingStatus;
	InstagramProducerInformation(String UserName ,String PassWord)
	{
		super();
		this.UserName=UserName;
		this.PassWord=PassWord;
		this.GetInstegram();
		this.LoggingPage();
	}
	private void GetInstegram()
	{
		driver.get("https://www.instagram.com/");
	}

	
	private void LoggingPage()
	{
		new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name='username']")));
		driver.findElement(By.cssSelector("input[name='username']")).sendKeys(this.UserName);
		new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name='password']")));
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys(this.PassWord);
		try {
			Thread.sleep(3000);
		}
		catch(InterruptedException ie){}
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		try {
			Thread.sleep(1000);
		}
		catch(InterruptedException ie){}
		if(!driver.findElements(By.cssSelector("p[role='alert']")).isEmpty())
		{
			LogingStatus=InstagramStatus.Unvalid;
		}
		else {
			LogingStatus=InstagramStatus.Valid;
			
		}
	}
		
		
	
	
	public void SearchByName(String Name)
	{
		new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[aria-label='Search Input']")));
		driver.findElement(By.cssSelector("input[aria-label='Search Input']")).sendKeys(Name);
		new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			Thread.sleep(3000);
		}
		catch(InterruptedException ie){
		}
		driver.findElement(By.cssSelector("div[role='none']")).click();
		
	}
	public InstagramStatus  GetInstagramStatus()
	{
		return this.LogingStatus;
	}
	
	
	
	
}
