package UA.QA.FIRST.TESTS;

import UA.QA.FIRST.APPMANAGER.ApplicationManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {

  protected final ApplicationManager app = new ApplicationManager();

  @BeforeTest
  public void startWd() throws Exception {
    app.init();
  }

  @AfterTest
  public void stopWd() {
    app.stop();
  }


}
