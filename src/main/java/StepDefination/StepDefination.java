package StepDefination;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.Color;
import Locators.locator;

import java.io.IOException;
import java.sql.Driver;
import java.util.ArrayList;

public class StepDefination {
    @Given("^user clicks on logIn button$")
    public void logIn() throws Exception {
        DriverAction.waitSec(2);
        DriverAction.click(locator.logIn, "login has been clicked");
        DriverAction.waitSec(2);
        DriverAction.click(locator.close);
        DriverAction.waitSec(2);
        GemTestReporter.addTestStep("cross button on login page","cross button on login page has been clicked",STATUS.PASS,DriverAction.takeSnapShot());
    }

    @Then("^enter (.+) and (.+)")
    public void loginPage(String Username, String Password) throws Exception {
        DriverAction.waitSec(1);
        System.out.println(DriverAction.getBrowserSize());
        GemTestReporter.addTestStep("Browser Location",""+DriverAction.getBrowserSize(),STATUS.INFO,DriverAction.takeSnapShot());
        JavascriptExecutor js=(JavascriptExecutor)DriverManager.getWebDriver();
        js.executeScript("arguments[0].click();", DriverAction.getElement(locator.logIn));
//        DriverAction.click(locator.logIn);
        DriverAction.waitSec(2);
        DriverAction.click(locator.username, "username has been clicked");
        DriverAction.waitSec(1);
        DriverAction.typeText(locator.username, Username, "username has been entered");
        DriverAction.waitSec(1);
        DriverAction.click(locator.password);
        DriverAction.waitSec(1);
        DriverAction.typeText(locator.password, Password);
        DriverAction.waitSec(1);
        GemTestReporter.addTestStep("typing password", "****", STATUS.PASS, DriverAction.takeSnapShot());
        DriverAction.waitSec(3);
        DriverAction.click(locator.eye,"eye button has been clicked");
        DriverAction.waitSec(1);
        DriverAction.click(locator.eyeclose,"eye button has been clicked again");
        DriverAction.waitSec(1);
    }

    @Then("^user navigates back after loggin in$")
    public void logout() throws Exception {
        DriverAction.waitSec(2);
        DriverAction.click(locator.LoginButton);
        DriverAction.waitSec(4);
        GemTestReporter.addTestStep("logged in", "logged in inside website", STATUS.PASS, DriverAction.takeSnapShot());
        DriverAction.navigateBack();
        DriverAction.waitSec(3);
    }

    @Given("^validating url of jewel (.+)$")
    public void jewelurl(String expectedUrl) throws Exception {
        DriverAction.waitSec(2);
        String s1 = DriverAction.getCurrentURL();
        if (s1.equals(expectedUrl)) {
            GemTestReporter.addTestStep("Url Validation", "Successful<br>Expected URL: " + expectedUrl + "<br>Actual URL: " + s1, STATUS.PASS);
        } else {
            GemTestReporter.addTestStep("Url Validation", "Unsuccessful<br>Expected URL: " + expectedUrl + "<br>Actual URL: " + s1, STATUS.PASS);
        }
    }

    @Then("^click on pricing$")
    public void pricing() throws Exception {
        DriverAction.click(locator.pricing, "pricing has been clicked");
        DriverAction.waitSec(2);
    }

    @Then("^validate pricing url (.+)$")
    public void pricingurl(String expectedPurl) throws Exception {
        DriverAction.waitSec(2);
        String s2 = DriverAction.getCurrentURL();
        if (s2.equals(expectedPurl)) {
            GemTestReporter.addTestStep("pricing Url Validation", "Successful<br>Expected URL: " + expectedPurl + "<br>Actual URL: " + s2, STATUS.PASS);
        } else {
            GemTestReporter.addTestStep("pricing Url Validation", "Unsuccessful<br>Expected URL: " + expectedPurl + "<br>Actual URL: " + s2, STATUS.FAIL);
        }
    }

    @Given("^clicking on pricing and checking for main heading (.+)$")
    public void clickpricing(String pricingHead) throws Exception {
        DriverAction.waitSec(2);
        DriverAction.click(locator.pricing);
        DriverAction.waitSec(4);
        String s3 = DriverAction.getElementText(locator.pricingheading);
        if (s3.equals(pricingHead)) {
            GemTestReporter.addTestStep("pricing heading validation", "Sucessfull<br>Expected heading1: " + pricingHead + "<br>Actual heading1 " + s3, STATUS.PASS);
        } else {
            GemTestReporter.addTestStep("pricing heading validation", "unsucessfull<br>Expected heading1: " + pricingHead + "<br>Actual heading1 " + s3, STATUS.FAIL);
        }
    }

    @Then("^checking for subheading (.+)$")
    public void subheading(String pricingSubHead) throws Exception {
        String s4 = DriverAction.getElementText(locator.pricingsubheading);
        if (s4.equals(pricingSubHead)) {
            GemTestReporter.addTestStep("pricing heading2 validation", "Sucessfull<br>Expected heading2: " + pricingSubHead + "<br>Actual heading2 " + s4, STATUS.PASS);
        } else {
            GemTestReporter.addTestStep("pricing heading2 validation", "unsucessfull<br>Expected heading2: " + pricingSubHead + "<br>Actual heading2 " + s4, STATUS.FAIL);
        }
    }

    @Then("^checking for text (.+)$")
    public void text(String Text) throws Exception {
        String s4 = DriverAction.getElementText(locator.pricingcontent);
        if (s4.equals(Text)) {
            GemTestReporter.addTestStep("pricing content validation", "Sucessfull<br>Expected content: " + Text + "<br>Actual content " + s4, STATUS.PASS);
        } else {
            GemTestReporter.addTestStep("pricing content validation", "unsucessfull<br>Expected content: " + Text + "<br>Actual content " + s4, STATUS.FAIL);
        }
    }

    @Given("^clicking on jewel again validating main heading (.+)$")
    public void jewelhead(String mainHeading) {
        DriverAction.waitSec(3);
        String s5 = DriverAction.getElementText(locator.jewelheading);
        if (s5.equals(mainHeading)) {
            GemTestReporter.addTestStep("jewel heading validation", "Sucessfull<br>Expected heading: " + mainHeading + "<br>Actual head " + s5, STATUS.PASS);
        } else {
            GemTestReporter.addTestStep("jewel heading validation", "Unsuccesfull<br>Expected heading: " + mainHeading + "<br>Actual head" + s5, STATUS.FAIL);
        }
    }

    @Then("^validating subheading of jewel (.+)$")
    public void jewelShead(String subHeading) {
        String s6 = DriverAction.getElementText(locator.jewelsubheading);
        if (s6.equals(subHeading)) {
            GemTestReporter.addTestStep("jewel content validation", "Sucessfull<br>Expected content: " + subHeading + "<br>Actual content " + s6, STATUS.PASS);
        } else {
            GemTestReporter.addTestStep("jewel content validation", "unsucessfull<br>Expected content: " + subHeading + "<br>Actual content " + s6, STATUS.FAIL);
        }
    }

    @Given("^validating whatisjewel (.+)$")
    public void whatisjewel(String whatisjewel) throws Exception {
        DriverAction.waitSec(1);
        DriverAction.pageScroll(500, 500);
        DriverAction.waitSec(3);
        GemTestReporter.addTestStep("Scrolling", "Scrolling has been done", STATUS.PASS, DriverAction.takeSnapShot());
        String s7 = DriverAction.getElementText(locator.whatisjewel);
        if (s7.equals(whatisjewel)) {
            GemTestReporter.addTestStep("what is jewel validation", "Sucessfull<br>Expected content: " + whatisjewel + "<br>Actual content " + s7, STATUS.PASS);
        } else {
            GemTestReporter.addTestStep("what is jewel validation", "unsucessfull<br>Expected content: " + whatisjewel + "<br>Actual content " + s7, STATUS.FAIL);
        }
    }

    @Then("^validating about us (.+)$")
    public void aboutus(String aboutus) {
        String s8 = DriverAction.getElementText(locator.aboutus);
        if (s8.equals(aboutus)) {
            GemTestReporter.addTestStep("about us validation", "Sucessfull<br>Expected content: " + aboutus + "<br>Actual content " + s8, STATUS.PASS);
        } else {
            GemTestReporter.addTestStep("about us validation", "unsucessfull<br>Expected content: " + aboutus + "<br>Actual content " + s8, STATUS.PASS);
        }
    }

    @Then("^validating content (.+)$")
    public void content(String content) {
        String s9 = DriverAction.getElementText(locator.content);
        if (s9.contains(content)) {
            GemTestReporter.addTestStep("content validation", "Sucessfull<br>Expected content: " + s9 + "<br>Actual content " + s9, STATUS.PASS);
        } else {
            GemTestReporter.addTestStep("content validation", "unsucessfull<br>Expected content: " + s9 + "<br>Actual content " + s9, STATUS.FAIL);
        }
    }

    @Given("^validating view report (.+)$")
    public void viewreport(String viewreport) {
        DriverAction.waitSec(1);
        DriverAction.pageScroll(500, 500);
        DriverAction.waitSec(3);
        String s10 = DriverAction.getElementText(locator.viewreport);
        if (s10.contains(viewreport)) {
            GemTestReporter.addTestStep("view report validation", "Sucessfull<br>Expected heading: " + s10 + "<br>Actual content " + s10, STATUS.PASS);
        } else {
            GemTestReporter.addTestStep("view report validation", "unsucessfull<br>Expected heading: " + s10 + "<br>Actual content " + s10, STATUS.FAIL);
        }
    }

    @Then("^validating view reportC (.+)$")
    public void viewcontent(String viewcontent) {
        String s11 = DriverAction.getElementText(locator.viewreportcontent);
        if (s11.equals(viewcontent)) {
            GemTestReporter.addTestStep("view report content validation", "Sucessfull<br>Expected content: " + s11 + "<br>Actual content " + s11, STATUS.PASS);
        } else {
            GemTestReporter.addTestStep("view report content validation", "unsucessfull<br>Expected content: " + s11 + "<br>Actual content " + s11, STATUS.FAIL);
        }
    }

    @Given("^validating run test (.+)$")
    public void runtest(String runtest) {
        DriverAction.waitSec(1);
        DriverAction.pageScroll(1000, 1000);
        DriverAction.waitSec(3);
        GemTestReporter.addTestStep("Scrolling", "Scrolling has been done", STATUS.INFO, DriverAction.takeSnapShot());
        String s12 = DriverAction.getElementText(locator.runtest);
        if (s12.equals(runtest)) {
            GemTestReporter.addTestStep("run test suite validation", "Sucessfull<br>Expected content: " + s12 + "<br>Actual content " + s12, STATUS.PASS);
        } else {
            GemTestReporter.addTestStep("run test suite validation", "Sucessfull<br>Expected content: " + s12 + "<br>Actual content " + s12, STATUS.FAIL);
        }
    }

    @Then("^validating run testC (.+)$")
    public void runsuite(String runcontentC) {
        String s13 = DriverAction.getElementText(locator.runtestc);
        if (runcontentC.contains(s13)) {
            GemTestReporter.addTestStep("run test suite content validation", "Sucessfull<br>Expected content: " + s13 + "<br>Actual content: " + s13, STATUS.PASS);
        } else {
            GemTestReporter.addTestStep("run test suite content validation", "unsucessfull<br>Expected content: " + s13 + "<br>Actual content: " + runcontentC, STATUS.FAIL);
        }
    }

    @Given("^click on facebook logo validate url (.+)$")
    public void facebook(String facebook) throws Exception {
        DriverAction.waitSec(1);
        DriverAction.pageScroll(1500, 1500);
        DriverAction.waitSec(2);
        DriverAction.click(locator.facebook);
        DriverAction.waitSec(2);
        ArrayList<String> newTb = new ArrayList<>(DriverAction.getWindowHandles());
        DriverAction.waitSec(2);
        DriverAction.switchToWindow(newTb.get(1));
        DriverAction.waitSec(4);
        GemTestReporter.addTestStep("Facebook logo click", "facebook has been clicked", STATUS.PASS, DriverAction.takeSnapShot());
        String s15 = DriverAction.getCurrentURL();
        if (s15.contains("facebook")) {
            GemTestReporter.addTestStep(" facebook Url Validation", "Successful<br>Expected URL: " + facebook + "<br>Actual URL: " + s15, STATUS.PASS);
        } else {
            GemTestReporter.addTestStep(" facebook Url Validation", "unsuccessful<br>Expected URL: " + facebook + "<br>Actual URL: " + s15, STATUS.FAIL);
        }
        DriverManager.getWebDriver().close();
//       GemTestReporter.addTestStep("Close Current tab","Successfull",STATUS.PASS);
        DriverAction.waitSec(2);
        GemTestReporter.addTestStep("Close facebook tab", "Successfull", STATUS.PASS);
        DriverAction.switchToWindow(newTb.get(0));
        DriverAction.waitSec(2);

    }

    @Given("click on twitter logo and validate url (.+)$")
    public void twitter(String twitter) throws Exception {
        DriverAction.waitSec(1);
        DriverAction.pageScroll(1500, 1500);
        DriverAction.waitSec(2);
        DriverAction.click(locator.twitter);
        ArrayList<String> newTb1 = new ArrayList<>(DriverAction.getWindowHandles());
        DriverAction.waitSec(2);
        DriverAction.switchToWindow(newTb1.get(1));
        DriverAction.waitSec(4);
        GemTestReporter.addTestStep("Twitte logo click", "twitter has been clicked", STATUS.PASS, DriverAction.takeSnapShot());
        String s16 = DriverAction.getCurrentURL();
        if (s16.equals(twitter)) {
            GemTestReporter.addTestStep(" twitter Url Validation", "Successful<br>Expected URL: " + twitter + "<br>Actual URL: " + s16, STATUS.PASS);
        } else {
            GemTestReporter.addTestStep(" twitter Url Validation", "Successful<br>Expected URL: " + twitter + "<br>Actual URL: " + s16, STATUS.FAIL);
        }
        DriverManager.getWebDriver().close();
        DriverAction.waitSec(2);
        GemTestReporter.addTestStep("Close twitter tab", "Successfull", STATUS.PASS);
        DriverAction.switchToWindow(newTb1.get(0));
        DriverAction.waitSec(2);
    }

    @Given("^click on instagram logo and validate url (.+)$")
    public void instagram(String insta) {
        DriverAction.waitSec(1);
        DriverAction.pageScroll(1500, 1500);
        DriverAction.waitSec(2);
        DriverAction.click(locator.instagram);
        ArrayList<String> newTb2 = new ArrayList<>(DriverAction.getWindowHandles());
        DriverAction.waitSec(2);
        DriverAction.switchToWindow(newTb2.get(1));
        DriverAction.waitSec(4);
        GemTestReporter.addTestStep("Instagram logo click", "Instagram has been clicked", STATUS.PASS, DriverAction.takeSnapShot());
        String s17 = DriverAction.getCurrentURL();
        if (s17.equals(insta)) {
            GemTestReporter.addTestStep(" instagram Url Validation", "Successful<br>Expected URL: " + insta + "<br>Actual URL: " + s17, STATUS.PASS);
        } else {
            GemTestReporter.addTestStep(" instagram Url Validation", "Successful<br>Expected URL: " + insta + "<br>Actual URL: " + s17, STATUS.FAIL);
        }
        DriverManager.getWebDriver().close();
        DriverAction.waitSec(2);
        GemTestReporter.addTestStep("Close instagram tab", "Successfull", STATUS.PASS);
        DriverAction.switchToWindow(newTb2.get(0));
        DriverAction.waitSec(2);
    }

    @Given("^click on linkedin logo and validate url (.+)$")
    public void linkedin(String linked) {
        DriverAction.waitSec(1);
        DriverAction.pageScroll(1500, 1500);
        DriverAction.waitSec(2);
        DriverAction.click(locator.linkedin);
        ArrayList<String> newTb3 = new ArrayList<>(DriverAction.getWindowHandles());
        DriverAction.waitSec(2);
        DriverAction.switchToWindow(newTb3.get(1));
        DriverAction.waitSec(4);
        GemTestReporter.addTestStep("linked logo click", "linkedin has been clicked", STATUS.PASS, DriverAction.takeSnapShot());
        String s18 = DriverAction.getCurrentURL();
        if (s18.contains(linked)) {
            GemTestReporter.addTestStep(" linkedin Url Validation", "Successful<br>Expected URL: " + s18 + "<br>Actual URL: " + s18, STATUS.PASS);
        } else {
            GemTestReporter.addTestStep(" linkedin Url Validation", "Successful<br>Expected URL: " + s18 + "<br>Actual URL: " + s18, STATUS.FAIL);
        }
        DriverManager.getWebDriver().close();
        DriverAction.waitSec(2);
        GemTestReporter.addTestStep("Close linkedin tab", "Successfull", STATUS.PASS);
        DriverAction.switchToWindow(newTb3.get(0));
        DriverAction.waitSec(2);
    }

    @Given("^click on jewel dashboard button$")
    public void jewelogo() throws Exception {
        DriverAction.waitSec(1);
        DriverAction.pageScroll(1500, 1500);
        DriverAction.waitSec(2);
        DriverAction.click(locator.jeweldashboard);
        DriverAction.waitSec(2);
        GemTestReporter.addTestStep("jewel dashboard button", "jewel dashboard button has been clicked", STATUS.PASS, DriverAction.takeSnapShot());
    }

    @Given("^click on gemPYP and validate url (.+)$")
    public void gempyp(String pyp) throws Exception{
        DriverAction.waitSec(1);
        DriverAction.pageScroll(1500, 1500);
        DriverAction.waitSec(2);
        DriverAction.click(locator.gempyp);
        ArrayList<String> newTb4 = new ArrayList<>(DriverAction.getWindowHandles());
        DriverAction.waitSec(2);
        DriverAction.switchToWindow(newTb4.get(1));
        DriverAction.waitSec(4);
        GemTestReporter.addTestStep("gempyp click","gempyp has been clicked",STATUS.PASS,DriverAction.takeSnapShot());
        String s19=DriverAction.getCurrentURL();
        if(s19.equals(pyp)){
            GemTestReporter.addTestStep(" gemPYP Url Validation", "Successful<br>Expected URL: " + pyp + "<br>Actual URL: " + s19, STATUS.PASS);
        }else{
            GemTestReporter.addTestStep(" gemPYP Url Validation", "unsuccessful<br>Expected URL: " + pyp + "<br>Actual URL: " + s19, STATUS.FAIL);
        }
        DriverManager.getWebDriver().close();
        DriverAction.waitSec(2);
        GemTestReporter.addTestStep("Close gemPYP tab","Successfull",STATUS.PASS);
        DriverAction.switchToWindow(newTb4.get(0));
        DriverAction.waitSec(2);
    }

    @Given("^click on gemPRF and validate url (.+)$")
    public void gemprf(String prf) throws Exception{
        DriverAction.waitSec(1);
        DriverAction.pageScroll(1500, 1500);
        DriverAction.waitSec(2);
        DriverAction.click(locator.gemprf);
        ArrayList<String> newTb5 = new ArrayList<>(DriverAction.getWindowHandles());
        DriverAction.waitSec(2);
        DriverAction.switchToWindow(newTb5.get(1));
        DriverAction.waitSec(4);
        GemTestReporter.addTestStep("gemprf click","gemprf has been clicked",STATUS.PASS,DriverAction.takeSnapShot());
        String s20=DriverAction.getCurrentURL();
        if(s20.equals(prf)){
            GemTestReporter.addTestStep(" gemPRF Url Validation", "Successful<br>Expected URL: " + prf + "<br>Actual URL: " + s20, STATUS.PASS);
        }else{
            GemTestReporter.addTestStep(" gemPRF Url Validation", "unsuccessful<br>Expected URL: " + prf + "<br>Actual URL: " + s20, STATUS.FAIL);
        }
        DriverManager.getWebDriver().close();
        DriverAction.waitSec(2);
        GemTestReporter.addTestStep("Close gemPRF tab","Successfull",STATUS.PASS);
        DriverAction.switchToWindow(newTb5.get(0));
        DriverAction.waitSec(2);
    }

    @Given("^click on gemJAR and validate url (.+)$")
    public void gemjar(String jar) throws Exception {
        DriverAction.waitSec(1);
        DriverAction.pageScroll(1500, 1500);
        DriverAction.waitSec(2);
        DriverAction.click(locator.gemjar);
        ArrayList<String> newTb6 = new ArrayList<>(DriverAction.getWindowHandles());
        DriverAction.waitSec(2);
        DriverAction.switchToWindow(newTb6.get(1));
        DriverAction.waitSec(4);
        GemTestReporter.addTestStep("gemjar click","gemjar has been clicked",STATUS.PASS,DriverAction.takeSnapShot());
        String s21=DriverAction.getCurrentURL();
        if(s21.equals(jar)){
            GemTestReporter.addTestStep(" gemJAR Url Validation", "Successful<br>Expected URL: " + jar + "<br>Actual URL: " + s21, STATUS.PASS);
        }else{
            GemTestReporter.addTestStep(" gemJAR Url Validation", "unsuccessful<br>Expected URL: " + jar + "<br>Actual URL: " + s21, STATUS.FAIL);
        }
        DriverManager.getWebDriver().close();
        DriverAction.waitSec(2);
        GemTestReporter.addTestStep("Close gemJAR tab","Successfull",STATUS.PASS);
        DriverAction.switchToWindow(newTb6.get(0));
        DriverAction.waitSec(2);
    }

    @Given("^click on pricing button$")
    public void pricingbutton() throws Exception{
        DriverAction.waitSec(1);
        DriverAction.pageScroll(1500, 1500);
        DriverAction.waitSec(2);
        DriverAction.click(locator.pricingbutton);
        DriverAction.waitSec(2);
        GemTestReporter.addTestStep("pricing button","pricing button has been clicked",STATUS.PASS,DriverAction.takeSnapShot());
    }
}





