import com.codeborne.selenide.Selenide;
import config.BaseTestConfig;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.fasttrackit.DemoQaHomePage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class BannerImageHomePageTest extends BaseTestConfig {
    DemoQaHomePage page;

    @Test
    @Feature("Banner image")
    @Severity(SeverityLevel.NORMAL)
    @Description("When clicking on the banner image, a new page is opened.")
    public void banner_image_redirects_to_registration_page() {
        page = new DemoQaHomePage();
        page.openDemoQaApp();
        DemoQaHomePage bannerImage = new DemoQaHomePage();
        bannerImage.clickOnBannerImage();
        Selenide.switchTo().window("Tools QA - Selenium Training");
        assertTrue(bannerImage.checkToolsQaPageTitlePresence(), "When clicking on the banner image ftom home page, a new page is opened.");
    }
}

