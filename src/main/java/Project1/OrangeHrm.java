package Project1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OrangeHrm {
WebDriver driver;

	
	@BeforeTest
	public void method1() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\my lap\\Downloads\\eclipse-dsl-2022-09-R-win32-x86_64\\Jars\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	
	@Test(priority = 0)
	public void Login() throws Exception {
		
		WebElement username = driver.findElement(By.xpath("//*[@name='username']"));
		WebElement passwd = driver.findElement(By.xpath("//*[@name='password']"));
		username.sendKeys("Admin");
		passwd.sendKeys("admin123");

		WebElement loginbutton = driver.findElement(By.xpath("//*[@type='submit']"));
		loginbutton.click();

		System.out.println("");
		String url = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		String currenturl = driver.getCurrentUrl();

		Assert.assertEquals(url, currenturl,"User not able to login");
		System.out.println("Login successfull\n");

	}

	
	@Test(priority = 1)
	public void RecruitmentModule() throws Exception {
		

		boolean recruitmentlink = driver.findElement(By.xpath("//*[text()='Recruitment']")).isDisplayed();

		Assert.assertEquals(recruitmentlink, true);
		System.out.println("Recruitment link is available");

		WebElement Recruitment = driver.findElement(By.xpath("//*[text()='Recruitment']"));
		Recruitment.click();
		
		String url = "https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/viewCandidates";
		String currenturl = driver.getCurrentUrl();

		Assert.assertEquals(url, currenturl);
		System.out.println("Recruitment link is clickable\n");

	}

	
	@Test(priority = 2)
	public void Candidates_detailsForm() throws Exception {
		
		WebElement JobTitle = driver.findElement(By.xpath("//label[text()='Job Title']"));
        boolean A = JobTitle.isDisplayed();
		Assert.assertEquals(A, true);
		System.out.println("Job Title is available");
        WebElement JobTitle_select = driver.findElement(By.xpath("(//*[text()='-- Select --'])[1]"));
		JobTitle_select.click();
		JobTitle_select.sendKeys("Automation Tester");
		Thread.sleep(2000);
		
	}
	
		
		@Test(priority = 3)	
		public void vacancy() throws Exception {
			Thread.sleep(2000);
			WebElement Vacancy = driver.findElement(By.xpath("//label[text()='Vacancy']"));
              boolean v =  Vacancy.isDisplayed();
		       Assert.assertEquals(v, true, "vacancy field is not displayed");
		System.out.println("Vacancy field is available");
		boolean v2 =  Vacancy.isEnabled();
	       Assert.assertEquals(v2, true, "vacancy field is not enabled");
	       System.out.println("Vacancy field is Enabled\n");
		}
	@Test(priority = 4)	
	public void HiringManager() throws Exception{
		Actions a = new Actions(driver);
		// scroll down a page
		a.sendKeys(Keys.PAGE_UP).build().perform();
	Thread.sleep(2000);
		WebElement HiringManager = driver.findElement(By.xpath("//label[text()='Hiring Manager']"));
        boolean hm =   HiringManager.isDisplayed();
	       Assert.assertEquals(hm, true);
	    System.out.println("Hiring Manageris available");
	    boolean hm2 = HiringManager.isEnabled();
	       Assert.assertEquals(hm2, true, "Hiring Manager field is not enabled");
	       System.out.println("Hiring Manager field is Enabled\n");
	}
	
	
	@Test(priority = 5)
	public void Status() {
	
		WebElement Status= driver.findElement(By.xpath("//label[text()='Status']"));
    boolean S =   Status.isDisplayed();
       Assert.assertEquals(S, true);
    System.out.println("Status field is available");
WebElement Status_select = driver.findElement(By.xpath("(//*[text()='-- Select --'])[4]"));
Status_select.click();
WebElement selectStatus = driver.findElement(By.xpath("//*[text()='Application Initiated'][1]"));
selectStatus.click();
System.out.println("Status is displaying Status\n");
	}
	
	@Test(priority = 6)
public void CandidateName() {

WebElement Candidatename= driver.findElement(By.xpath("//*[text()='Candidate Name']"));
boolean cn =  Candidatename.isDisplayed();
   Assert.assertEquals(cn, true,"Candidate name field not displayed");
System.out.println("Candidate name field is available");
boolean cn2 =  Candidatename.isEnabled();
Assert.assertEquals(cn2, true,"Candidate name field not Enabled");
System.out.println("Candidate name field is Enabled");
	}
	
	
	@Test(priority = 7)
	public void Keyword() {
 WebElement Input_Keyword = driver.findElement(By.xpath("(//*[@class='oxd-input oxd-input--active'])[2]"));
 Input_Keyword.sendKeys("A");
 String kw = Input_Keyword.getAttribute("value");
 if(kw.contains("A")) {
 	System.out.println("Yes Keyword is entered");
 }else {
 	System.out.println("Text is not Entered");
 }
 
 WebElement element = driver.findElement(By.xpath("//*[@placeholder='From']"));
	
	
	element.sendKeys("2021-11-09");
	element.click();
	WebElement element2 = driver.findElement(By.xpath("//*[@placeholder='To']"));
	element2.sendKeys("2023-05-16");
	element.click();
	}
	
	@Test(priority = 8)
	public void MethodsOfApp() {
	
	WebElement MethodofApp= driver.findElement(By.xpath("//label[text()='Method of Application']"));
    boolean Mof =   MethodofApp.isDisplayed();
       Assert.assertEquals(Mof, true);
    System.out.println("Methods of Application field is available");
WebElement MethodofApp_select = driver.findElement(By.xpath("(//*[@class='oxd-select-text-input'])[5]"));
MethodofApp_select.click();
WebElement selectMethodofApp = driver.findElement(By.xpath("//*[text()='Online']"));
selectMethodofApp.click();
System.out.println("Methods of Application is displaying methods\n");
	}
	
	@Test(priority = 9)
	public void Search() {
	
WebElement SearchButton= driver.findElement(By.xpath("//label[text()='Method of Application']"));
boolean SB =   SearchButton.isDisplayed();
   Assert.assertEquals(SB, true);
System.out.println("Search Button is available");

SearchButton.click();
	
	}
	
	}


	
		
	


