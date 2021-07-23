package UA.QA.FIRST;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestBase {
  public String login = "admin";
  public String pass = "secret";
  public String[] validUser = {"Bond", "James", "007"};
  public String[] testValidGroup = {"TestGroup", "TestFooter", "TestHeader"};
  ChromeDriver wd;

  @BeforeTest
  public void startWd() throws Exception {
    System.setProperty("webdriver.chrome.driver", "C:\\Projects\\tools\\chromedriver.exe");
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    wd.get("http://localhost:8080/addressbook/");
    wd.manage().window().maximize();
    login(login, pass);
  }

  @AfterTest
  public void stopWd() {
    wd.quit();
    System.out.println("Good");
  }

  public void login(String login, String pass) {
    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys(login);
    wd.findElement(By.name("pass")).click();
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys(pass);
    wd.findElement(By.xpath("//input[@value='Login']")).click();
  }

  //@Test
  public void createNewUser() {
    gotoUserCreate();
    fillUserFormCreate(new UserDate(validUser[0], validUser[1], validUser[2]));
    createUserConfirm();
  }

  public void inutGroupCreation() {
    wd.findElement((By.name("new"))).click();
  }

  public void gotoGroupPage() {
    wd.findElement(By.linkText("groups")).click();
  }

  public void submintGroupCreation() {
    wd.findElement(By.name("submit")).click();
  }

  public void fillGroupForm(GroupDate groupDate) {
    wd.findElement(By.xpath("//input[@name='group_name']")).click();
    wd.findElement(By.xpath("//input[@name='group_name']")).clear();
    wd.findElement(By.xpath("//input[@name='group_name']")).sendKeys(groupDate.getGroupName());
    wd.findElement(By.xpath("//textarea[@name='group_header']")).click();
    wd.findElement(By.xpath("//textarea[@name='group_header']")).clear();
    wd.findElement(By.xpath("//textarea[@name='group_header']")).sendKeys(groupDate.getGroupHeader());
    wd.findElement(By.xpath("//textarea[@name='group_footer']")).click();
    wd.findElement(By.xpath("//textarea[@name='group_footer']")).clear();
    wd.findElement(By.xpath("//textarea[@name='group_footer']")).sendKeys(groupDate.getGroupFooter());
  }

  public void createUserConfirm() {
    wd.findElement(By.name("submit")).click();
  }

  public void fillUserFormCreate(UserDate userDate) {
    gotoUserCreate();
    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).clear();
    wd.findElement(By.name("firstname")).sendKeys(userDate.getFirstName(), userDate.getLastName(), userDate.getNickName());
    wd.findElement(By.name("lastname")).click();
    wd.findElement(By.name("lastname")).clear();
    wd.findElement(By.name("lastname")).sendKeys(validUser[1]);
    wd.findElement(By.name("nickname")).click();
    wd.findElement(By.name("nickname")).clear();
    wd.findElement(By.name("nickname")).sendKeys(validUser[2]);
  }

  public void gotoUserCreate() {
    wd.findElement(By.xpath("//a[@href='edit.php']")).click();
  }

  public void deleteSelectedGroup() {
    wd.findElement(By.xpath("//input[@name='delete']")).click();
  }

  public void selectGroup() {
    wd.findElement(By.name("selected[]")).click();
  }



  }
