package UA.QA.FIRST;

import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase{

  @Test
  public void testGroupdeletion()  {
    gotoGroupPage();
    selectGroup();
    deleteSelectedGroup();
    gotoGroupPage();
  }



}


