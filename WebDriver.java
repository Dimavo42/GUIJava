package source;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;




public class WebDriver {
	protected ChromeDriver driver;
	private ChromeOptions options;
	WebDriver(){
		this.setOptions();
	}
	private void setOptions()
	{
		options = new ChromeOptions();
		options.addArguments("--disable-blink-features");
		options.addArguments("--disable-blink-features=AutomationControlled");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("source", "Object.defineProperty(navigator, 'webdriver', { get: () => undefined })");
		this.driver = new ChromeDriver(options);
		driver.executeCdpCommand("Page.addScriptToEvaluateOnNewDocument", params);
	}
	
	
	
}
