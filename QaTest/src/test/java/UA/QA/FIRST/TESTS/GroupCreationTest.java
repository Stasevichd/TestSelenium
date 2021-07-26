package UA.QA.FIRST.TESTS;

import UA.QA.FIRST.MODEL.GroupDate;
import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase  {


@Test
  public void testGroupCreate(){
    app.gotoGroupPage();
    app.getGroupHelper().inutGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupDate(app.testValidGroup[0], app.testValidGroup[1], app.testValidGroup[2]));
    app.getGroupHelper().submintGroupCreation();
    app.getGroupHelper().returnToGroupPage();

  }


}



