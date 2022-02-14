import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//li/a[text()='Multiple Windows']")).click();
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		String parentWin = itr.next();
		String childWin = itr.next();
		driver.switchTo().window(childWin);
		String secondwindowText = driver.findElement(By.cssSelector(".example")).getText();
        System.out.println(secondwindowText);
		driver.switchTo().window(parentWin);
		String firstWindowText = driver.findElement(By.xpath("//div[@class='example']/h3")).getText();
        System.out.println(firstWindowText);


	}

}
