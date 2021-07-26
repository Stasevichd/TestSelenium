package UA.QA.FIRST.APPMANAGER;

import UA.QA.FIRST.MODEL.GroupDate;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class GroupHelper {
  private ChromeDriver wd;

  public GroupHelper(ChromeDriver wd) {
    this.wd = wd;
  }

  public void returnToGroupPage(){
    wd.findElement(By.linkText("group page")).click();

  }

  public void inutGroupCreation() {
    wd.findElement((By.name("new"))).click();
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

  public void deleteSelectedGroup() {
    wd.findElement(By.xpath("//input[@name='delete']")).click();
  }

  public void selectGroup() {
    wd.findElement(By.name("selected[]")).click();
  }
}
