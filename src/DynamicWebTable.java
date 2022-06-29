import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DynamicWebTable {
 
	 WebDriver driver;
	
	@BeforeTest
    public void setup()
    {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Deepika\\Selenium\\chromedriver_win32\\chromedriver.exe");
    	driver=new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.get("https://demo.guru99.com/test/web-table-element.php#");	
    }
	
	// 1:: Find first row current prize
	
	@Test
	public void FindFirstRow()
	{
		driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr[1]"));
		String firstRowCurrentPrize = driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr[1]/td[4]")).getText();
		System.out.println(firstRowCurrentPrize);
	}
	
	// 2:: Count total number of columns and rows in the table
	
	@Test
	public void countRoWsAndColumn()
	{
			
		//count No of Column 
		List<WebElement> cols = driver.findElements(By.xpath("//table[@class='dataTable']/thead/tr/th"));
		System.out.println("No of Columns are : "+cols.size());
			
		//count No of Rows
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));
		System.out.println("No of Columns are : "+rows.size());
	}
	
	// 3 :: Find the maximum value from current Prize column
	
	@Test
	public void getMaxCurrentPrice()
	{
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));
		double max=0;
		for(int i=0;i<rows.size();i++)
		{
			String eachRowCurrentPrize = driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+(i+1)+"]/td[4]")).getText();
				
			double Currentprize =Double.parseDouble(eachRowCurrentPrize.toString());
			System.out.println(Currentprize);
		    
			if(Currentprize>max)
			{
				max=Currentprize;
			}			
		}
		System.out.println("Maximum current Price is " + max );
	}
		
	
	// 4:: get all the cell values of each row
		
	@Test
	public void GetAllTheValuesOfTable()
	{
		WebElement table=driver.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table"));
		List<WebElement> rows_table=driver.findElements(By.tagName("tr"));
		System.out.println("***"+rows_table.size());
			
		for(int i=0;i<rows_table.size();i++)
		{
			List<WebElement> columns_row= rows_table.get(i).findElements(By.tagName("td"));
			int columns_count=columns_row.size();
				
			System.out.println("Niumber of cells in row"+i+ "is"+columns_count);
			for(int j=0;j<columns_count;j++)
			{
				String cellText=columns_row.get(j).getText();
				System.out.println("Cell value of row number"+i+"and column number"+j+"is"+cellText);
			}
		}
	}
}
