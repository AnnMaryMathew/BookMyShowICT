import DataProviders.ParametrizationClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import java.io.IOException;

public class BookMyShow {
    private WebDriver driver;

    @Parameters({"chromebrowser","url"})

    @BeforeMethod
    public void openBrowser(String browser, String url) throws Exception {
        driver = Browser.openBrowser(browser, url);
    }

    @Test(dataProviderClass = ParametrizationClass.class, dataProvider = "common")
//    TestCase 01 & 02 : Search Movie Positive & Negative TestCase
    public void movieSearch(String MovieName, String ReportSearch) throws IOException {
        Reports.createTest("ReportSearch");
        TestCase_1_2 TC01_02 = new TestCase_1_2(driver);
        TC01_02.searchMovie(MovieName);
    }

    @Test(priority = 1, dataProviderClass = ParametrizationClass.class, dataProvider = "common")
//     TestCase 03 & 04: Search for Cast and Crew - Positive & Negative TestCase
    public void castCrew(String ActorName, String CrewName, String MovieName, String ReportCrew) throws IOException {
        Reports.createTest("ReportCrew");
        TestCase_3_4 TC03_04 = new TestCase_3_4(driver);
        TC03_04.crewCast(ActorName, CrewName, MovieName);
    }

    @Test(priority = 2)
    //TestCase 05 : List Your Show-What can you Host
    public void showHost() throws IOException {
        Reports.createTest("TestCase 05/List Your Show-What can you Host");
        TestCase_5 TC05 = new TestCase_5(driver);
        TC05.hostShow();
    }

    @Test(priority = 3)
    //TestCase 06 : List Your Show-What are the services we offer
    public void serviceOffer() throws IOException {
        Reports.createTest("TestCase 06/List Your Show-What are the services we offer");
        TestCase_6 TC06 = new TestCase_6(driver);
        TC06.offerService();
    }

    @Test(priority = 4)
    //TestCase 07 : List Your Show-Reports & Business insights details
    public void showReports() throws IOException {
        Reports.createTest("TestCase 07/List Your Show-Reports & Business insights details");
        TestCase_7 TC07 = new TestCase_7(driver);
        TC07.reportShow();
    }

    @Test(priority = 5)
    //TestCase 08 : Check Offers
    public void checkOffer() throws IOException {
        Reports.createTest("TestCase 08/Check Offers");
        TestCase_8 TC08 = new TestCase_8(driver);
        TC08.offersCheck();
    }

    @Test(priority = 6, dataProviderClass = ParametrizationClass.class, dataProvider = "common")
    //TestCase 09: Search Offers-Positive & Negative TestCase
    public void searchOffer(String Offer, String ReportOffer) {
        Reports.createTest("ReportOffer");
        TestCase_9_10 TC09_10 = new TestCase_9_10(driver);
        TC09_10.searchOffer(Offer);
    }

    @Test(priority = 7)
    //TestCase 11 : Footer Text Validation
    public void footer() throws IOException {
        Reports.createTest("TestCase 11/Footer Text Validation");
        TestCase_11 TestCase_11 = new TestCase_11(driver);
        TestCase_11.footerText();
    }

    @Test(priority = 8)
    //TestCase 12 : Validate Menu
    public void validateMenu() throws IOException {
        Reports.createTest("TestCase 12/Validate Menu");
        TestCase_12 TestCase_12 = new TestCase_12(driver);
        TestCase_12.menuValidate();
    }

    @Parameters({"City"})
    @Test(priority = 9)
    //TestCase 13 : Choose City
    public void chooseCity(@Optional("Goa") String City) throws IOException {
        Reports.createTest("TestCase 13/ Choose City");
        TestCase_13 TestCase_13 = new TestCase_13(driver);
        TestCase_13.verifyCity(City);
    }

    @Test(priority = 10)
    //TestCase 14 : Validate Sorted Product
    public void validateSort() throws IOException {
        Reports.createTest("TestCase 14/Validate Sorted Product");
        TestCase_14 TestCase_14 = new TestCase_14(driver);
        TestCase_14.sortValidate();
    }

    @Test(priority = 11)
    //TestCase 15 : Validate Filter by Price Doubts
    public void validateFilter() throws IOException {
        Reports.createTest("TestCase 15/Validate Filter by Price");
        TestCase_15 TestCase_15 = new TestCase_15(driver);
        TestCase_15.filterValidate();
    }

    @AfterMethod
    public void closeBrowser() {
        Browser.closeBrowser(driver);
    }
}
