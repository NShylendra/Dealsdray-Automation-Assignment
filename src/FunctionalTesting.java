import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import recordingTest.ScreenRecorderUtil;

public class FunctionalTesting {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		ScreenRecorderUtil.startRecord("main");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		//URL
		driver.get("https://demo.dealsdray.com/");
		
		//user name
		driver.findElement(By.cssSelector("input[name='username']")).sendKeys("prexo.mis@dealsdray.com");
		//Password
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("prexo.mis@dealsdray.com");
		//login
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.xpath("//button[contains(@class,'has-submenu')]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[2]/div[1]/div[2]/div/div[1]/a/button")).click();
		
		driver.findElement(By.xpath("//button[@align='right']")).click();
		
		driver.findElement(By.cssSelector("input[type='file']")).sendKeys("C:\\Users\\nshyl\\Downloads\\demo-data.xlsx");
		
		driver.findElement(By.xpath("//button[contains(@class,'6aomwy')]")).click();
		
		driver.findElement(By.xpath("//button[contains(@class,'6aomwy')]")).click();
		
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		File src = ts.getScreenshotAs(OutputType.FILE);
	
		FileUtils.copyFile(src, new File("screenShot//result.png"));
		
		driver.quit();
		
		ScreenRecorderUtil.stopRecord();
		
	
		
		
		

	}

}
