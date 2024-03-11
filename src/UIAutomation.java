import java.io.File;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import recordingTest.ScreenRecorderUtil;

public class UIAutomation {
		
		 public static void main(String[] args) throws Exception{
			 
			 
			 ScreenRecorderUtil.startRecord("main");
		        // Set up Chrome driver
		        WebDriver chromeDriver = new ChromeDriver();
		        
		        WebDriverWait wait = new WebDriverWait(chromeDriver,Duration.ofSeconds(3));

		        // Websites to visit
		        String[] websites = {"https://www.getcalley.com/", "https://www.getcalley.com/calley-call-from-browser/", "https://www.getcalley.com/calley-pro-features/", 
		        		"https://www.getcalley.com/best-auto-dialer-app/", "https://www.getcalley.com/how-calley-auto-dialer-app-works/"};

		        // Resolutions to take screenshots
		        Dimension[] resolutions = {new Dimension(1920, 1080), new Dimension(1366, 768), new Dimension(1536, 864),new Dimension(360,640), new Dimension(414,896),new Dimension(375,667)};

		        
                
		        // Loop through websites
		        for (String website : websites) {
		            // Loop through resolutions
		            for (Dimension resolution : resolutions) {
		                // Set window size
		                chromeDriver.manage().window().setSize(resolution);

		                // Open the website
		                chromeDriver.get(website);
		                
		                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//body")));
		                
		              //generating time stamp to rename the screenshot files
		                Date currentDate = new Date();
		                String screenShotFileName = currentDate.toString().replace(" ", "-").replace(":", "-");

		                // Take screenshots
		                TakesScreenshot ts = (TakesScreenshot)chromeDriver;
		        		File src = ts.getScreenshotAs(OutputType.FILE);
		        		FileUtils.copyFile(src, new File("Chromefiles//"+screenShotFileName+".png"));
		        		
		        		
		            }
		        }
		        
		        // Close the driver
		        chromeDriver.quit();
		        
		        // Set up Firefox driver
		        WebDriver firefoxDriver = new FirefoxDriver();
		        
		        WebDriverWait wait1 = new WebDriverWait(firefoxDriver,Duration.ofSeconds(3));
		        
		        //looping through websites
		        for (String website : websites) {
		            // Loop through resolutions
		            for (Dimension resolution : resolutions) {
		            	
		                // Set window size
		                firefoxDriver.manage().window().setSize(resolution);

		                // Open the website
		                firefoxDriver.get(website);
		                
		                wait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//body")));

		              //generating time stamp to rename the screenshot files
		                Date currentDate = new Date();
		                String screenShotFileName = currentDate.toString().replace(" ", "-").replace(":", "-");

		                // Take screenshots
		                TakesScreenshot ts2 = (TakesScreenshot)firefoxDriver;
		        		File src2 = ts2.getScreenshotAs(OutputType.FILE);
		        		FileUtils.copyFile(src2, new File("Firefoxfiles//"+screenShotFileName+".png"));
		        		
		            }
		        }

		     // Close the driver
		        firefoxDriver.quit();
		        
		        EdgeDriver edgeDriver = new EdgeDriver();
		        
		        WebDriverWait wait2 = new WebDriverWait(edgeDriver,Duration.ofSeconds(3));

		        
		        //looping through websites
		        for (String website : websites) {
		            // Loop through resolutions
		            for (Dimension resolution : resolutions) {
		            	
		                // Set window size
		                edgeDriver.manage().window().setSize(resolution);

		                // Open the website
		                edgeDriver.get(website);
		                
		                wait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//body")));

		              //generating time stamp to rename the screenshot files
		                Date currentDate = new Date();
		                String screenShotFileName = currentDate.toString().replace(" ", "-").replace(":", "-");

		                // Take screenshots
		                TakesScreenshot ts3 = (TakesScreenshot)edgeDriver;
		        		File src3 = ts3.getScreenshotAs(OutputType.FILE);
		        		FileUtils.copyFile(src3, new File("Edgefiles//"+screenShotFileName+".png"));
		            }
		        }
		        		edgeDriver.quit();
		        		
		        		ScreenRecorderUtil.stopRecord();
		       }
		   }


