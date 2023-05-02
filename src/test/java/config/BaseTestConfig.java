package config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class BaseTestConfig {
    @BeforeClass
    static void setupAllureReports() {
        Configuration.browser = "Chrome";
    }

    @AfterTest
     public void closeBrowser() {
        Selenide.closeWindow();
        Selenide.closeWebDriver();
    }
}


