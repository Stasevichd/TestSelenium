import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class First {
  ChromeDriver wd;
  public String login = "admin";
  public String pass = "secret";
  public  String[] validUser= {"Bond","James", "007"};

  @BeforeTest
  public void startWd () throws Exception{
    System.setProperty("webdriver.chrome.driver", "C:\\Projects\\tools\\chromedriver.exe");
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    wd.get("http://localhost:8080/addressbook/");
    wd.manage().window().maximize();
    login(login,pass);
  }
  @AfterTest
  public void stopWd(){
    wd.quit();
    System.out.println("Good");

  }


  public void login(String login, String pass){
    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys(login);
    wd.findElement(By.name("pass")).click();
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys(pass);
    wd.findElement(By.xpath("//input[@value='Login']")).click();
  }

  @Test
  public void createUser(){
    wd.findElement(By.xpath("//a[@href='edit.php']")).click();
    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).sendKeys(validUser[0]);
    wd.findElement(By.name("lastname")).click();
    wd.findElement(By.name("lastname")).sendKeys(validUser[1]);
    wd.findElement(By.name("nickname")).click();
    wd.findElement(By.name("nickname")).sendKeys(validUser[2]);
    wd.findElement(By.name("submit")).click();
  }
}



