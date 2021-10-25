package Week4.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/pages/table.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// step 1 : find the table
		WebElement webTable = driver.findElement(By.id("table_id"));
		// step 2: Get all the rows
		List<WebElement> tableRow = webTable.findElements(By.tagName("tr"));
		// get the number of rows in the table
		System.out.println("No. of rows :"+ tableRow.size());
		// get the number of columns
		WebElement firstRow = tableRow.get(1);
		List<WebElement> tableCol = firstRow.findElements(By.tagName("td"));
		System.out.println("No. of Columns :" +tableCol.size());
		// print all the contents of the table
		for (WebElement eachRowEle : tableRow) {
			System.out.println(eachRowEle.getText());
			}
		// print the contents of column 2 alone
		for (int i = 1; i < tableRow.size(); i++) {
			WebElement row = tableRow.get(i);
			List<WebElement> col = row.findElements(By.tagName("td"));
			String colText = col.get(1).getText();
			System.out.println(colText);
			
		}
		
	}

}
