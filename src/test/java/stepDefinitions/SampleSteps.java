package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SampleSteps {
    private WebDriver driver;

    public SampleSteps() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on the home page$")
    public void iAmOnTheHomePage() throws Throwable {
        driver.get("https://kristinek.github.io/site");
    }

    @Then("^I should see home page header$")
    public void iShouldSeeHomePageHeader() throws Throwable {
        assertEquals("This is a home page",
                driver.findElement(By.cssSelector("h1")).getText());
    }

    @And("^I should see home page description$")
    public void iShouldSeeHomePageDescription() throws Throwable {
        assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                driver.findElement(By.cssSelector("p")).getText());
    }

    @When("^I enter name: \"([^\"]*)\"$")
    public void iEnterName(String name) throws Throwable {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
    }

    @And("^I enter age: (\\d+)$")
    public void iEnterAge(int age) throws Throwable {
        driver.findElement(By.id("age")).sendKeys(String.valueOf(age));
    }

    @Given("^I (?:am on|open) age page$")
    public void iAmOnAgePage() throws Throwable {
        driver.get("https://kristinek.github.io/site/examples/age");
    }

    @And("^I click submit age$")
    public void iClickSubmitAge() throws Throwable {
        driver.findElement(By.id("submit")).click();
    }

    @Then("^I see message: \"([^\"]*)\"$")
    public void iSeeMessage(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("message")).getText());
    }

    @When("^I enter values:$")
    public void iEnterValues(Map<String, String> valuesToEnter) throws Throwable {
        for (Map.Entry<String, String> e : valuesToEnter.entrySet()) {
            driver.findElement(By.id(e.getKey())).clear();
            driver.findElement(By.id(e.getKey())).sendKeys(e.getValue());
            System.out.println("key is " + e.getKey());
            System.out.println("value is " + e.getValue());
        }
    }

    @And("^I should see menu$")
    public void iShouldSeeMenu() throws Throwable {
        assertTrue(driver.findElement(By.className("w3-navbar")).isDisplayed());
    }

    @And("^I click the result checkbox button$")
    public void iClickTheResultCheckboxButton() throws Throwable {
        driver.findElement(By.id("result_button_checkbox")).click();
    }

    @When("^I clicked on checkboxes:$")
    public void iClickedOnCheckboxes(List<String> values) throws Throwable {
        for (String value : values) {
            driver.findElement(By.cssSelector("[value='" + value + "']")).click();
        }
    }

    @Then("^message for checkboxes \"([^\"]*)\" is seen$")
    public void messageForCheckboxesIsSeen(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("result_checkbox")).getText());
    }

    @Given("^I am on action page$")
    public void iAmOnActionPage() {
        driver.get("https://kristinek.github.io/site/examples/actions");
    }

    @Given("^I navigate to url \"([^\"]*)\"$")
    public void iNavigateToUrl(String url) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://www.google.com/");
    }


    @When("^I have agreed to conditions$")
    public void iHaveAgreedToConditions() {
        WebElement popUp = driver.findElement(By.cssSelector("iframe[src*='https://consent.google.com?hl=lv&origin=https://www.google.com&continue=https://www.google.com/&if=1&m=0&pc=s&wp=-1&gl=LV']"));
        driver.switchTo().frame(popUp);
        driver.findElement(By.xpath("//*[@id=\"introAgreeButton\"]/span/span")).click();
    }

    @Then("^I should see \"([^\"]*)\" button$")
    public void iShouldSeeButton(String lucky) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^I am on 'Enter a Number' Page$")
    public void iAmOnEnterANumberPage() {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @When("^I enter \"([^\"]*)\"$")
    public void iEnter(String arg0) throws Throwable {
        WebElement numberField = driver.findElement(By.id("numb"));
        numberField.click();
        numberField.sendKeys (arg0);
    }

    @And("^I click submit$")
    public void iClickSubmit() {
        WebElement button = driver.findElement(By.tagName("button"));
        button.click();
    }

    @Then("^I see a \"([^\"]*)\"$")
    public void iSeeA(String result) throws Throwable  {
        // Write code here that turns the phrase above into concrete actions
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        assertEquals( result,alert.getText());
        alert.accept();
    }


    @Then("^I see an error \"([^\"]*)\"$")
    public void iSeeAnError(String message) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(message, driver.findElement(By.id("ch1_error")).getText());
    }

    @Given("^I open \"([^\"]*)\" page$")
    public void iOpenPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/list_of_people.html");

    }

    @And("^I click add$")
    public void iClickAdd() {
        WebElement button = driver.findElement(By.tagName("modal_button"));
        button.click();
    }

    @When("^I click Add Person$")
    public void iClickAddPerson() {
        WebElement button = driver.findElement(By.tagName("addPersonBtn"));
        button.click();

    }

    @Then("^I can see new Person in the list$")
    public void iCanSeeNewPersonInTheList() {
        assertTrue(driver.findElement(By.cssSelector("#person3 > div")).isDisplayed());

    }
}

