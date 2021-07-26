package UA.QA.FIRST.TESTS;

import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase{

  @Test
  public void testGroupdeletion()  {
    app.gotoGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroup();
    app.gotoGroupPage();
  }



}


