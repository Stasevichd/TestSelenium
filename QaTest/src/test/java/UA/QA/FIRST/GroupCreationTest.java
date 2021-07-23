package UA.QA.FIRST;

import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase  {


@Test
  public void testGroupCreate(){
    gotoGroupPage();
    inutGroupCreation();
    fillGroupForm(new GroupDate(testValidGroup[0], testValidGroup[1], testValidGroup[2]));
    submintGroupCreation();
    gotoGroupPage();
  }


}



