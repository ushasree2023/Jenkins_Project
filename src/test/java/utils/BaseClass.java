package utils;

import java.io.IOException;
import java.time.Duration;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass{

	public static WebDriver driver;
	public static Logger logger;

	@Parameters("browser")
	@BeforeTest
	public void setup(@Optional("chrome") String br) throws Exception {

		logger = Logger.getLogger("Wynisco");
		PropertyConfigurator.configure("log4j.properties");

		if (br.equals("chrome")) {

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			// options.addArguments("--headless");
			options.addArguments("--remote-allow-origins=*");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);

		} else if (br.equals("firefox")) {
			FirefoxOptions options = new FirefoxOptions();

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(options);

		} else if (br.equals("edge")) {
			EdgeOptions options = new EdgeOptions();

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(options);

		}
		driver.manage().window().maximize();
	//	driver.get(URL);

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(6));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		logger.info("Page Title :- " + driver.getTitle());
	//	MyScreenRecording.startRecording("Ninja_Register");

	}

	@AfterTest
	public void tearDown() throws Exception {
	//	MyScreenRecording.stopRecording();
		driver.quit();
	}

}
