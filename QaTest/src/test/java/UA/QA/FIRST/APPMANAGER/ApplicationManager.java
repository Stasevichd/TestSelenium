package UA.QA.FIRST.APPMANAGER;

import UA.QA.FIRST.MODEL.UserDate;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  ChromeDriver wd;

  private  GroupHelper groupHelper;


  public String login = "admin";
  public String pass = "secret";
  public String[] validUser = {"Bond", "James", "007"};
  public String[] testValidGroup = {"TestGroup", "TestFooter", "TestHeader"};

  public void init() {
    System.setProperty("webdriver.chrome.driver", "C:\\Projects\\tools\\chromedriver.exe");
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    wd.get("http://localhost:8080/addressbook/");
    wd.manage().window().maximize();
     final GroupHelper groupHelper = new GroupHelper(wd);
    login(login, pass);
  }

  public void stop() {
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

  public void gotoGroupPage() {
    wd.findElement(By.linkText("groups")).click();
  }

  public void createUserConfirm() {
    groupHelper.submintGroupCreation();
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

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }
}
