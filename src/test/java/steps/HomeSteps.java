package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.HomePage;

public class HomeSteps {


    private HomePage homePage;

    public HomeSteps(HomePage homePage) {
        this.homePage = homePage;
    }

    @Given("User is on homepage")
    public void userIsOnHomepage() {
        homePage.waitForAppLoading();
    }

    @Given("User is on search bar")
    public void userIsOnSearchBar() {
        homePage.clickOnSearchBar();
    }

    @When("User enter a {string} in search bar")
    public void userEnterProductFind(String element) { homePage.makeSearch(element);}

    @And("User validate his choice")
    public void userValidateHisChoice() {
        homePage.launch();
    }

    @Then("User should see some results under the searchbar with the word {string}")
    public void resultsFoundNumber(String element) {
        Assert.assertTrue(homePage.verifyFoundResult(element));
    }

//    @Then("User should see suggestions appear")
//    public void suggestionsAppear() {
//        Assert.assertEquals(homePage.verifySuggestions(),true);
//    }

//    @Then("User should see message about no result found")
//    public void noResultFound() { Assert.assertEquals(homePage.verifyNotFoundResult(),true);}

//    @Given("User is on category menu")
//    public void categoryMenuPage() { homePage.getOnCategory();}

    @Given("User is on selected {string}")
    public void selectCategory(String category) {
        homePage.selectCategory(category);
    }

    @When("User selected {string}")
    public void selectSubCategory(String subcategory) {
        homePage.selectSubcategory(subcategory);
    }

//    @Then("User should see {string} title display")
//    public void titleOfDisplay(String title) {
//        Assert.assertEquals(homePage.verifyViewTitle(title),true);
//    }

    @When("User enter a {string}")
    public void parfumProductPage(String element) { homePage.makeSearch(element);}


    @And("User press on search button")
    public void userPressOnSearchButton() {
        homePage.clickOnSearchBtn();
    }

    @Given("User is on login page")
    public void userAccessToLoginPage() {
        homePage.accesToLoginPage();
    }

    @When("User enter a {string} and {string}")
    public void userEnterAAnd(String cellphone_number, String password) {
        homePage.login(cellphone_number, password);
    }

    @And("User press on login button")
    public void userPressOnLoginButton() {
        homePage.clickOnLoginBtn();
    }

    @Then("User should be in the application as a logged user")
    public void userShouldBeInTheApplicationAsALoggedUser() {
        Assert.assertTrue(homePage.verifyLoggedIn());
    }

    @Then("User should see suggestions appear")
    public void userShouldSeeSuggestionsAppear() {
       Assert.assertTrue(homePage.verifySearchPreview());
    }

    @Then("User should see message about no result found")
    public void userShouldSeeMessageAboutNoResultFound() {
        Assert.assertTrue(homePage.verifySearchNoResultImg());

    }

    @And("User scroll and press on \"Offres du jour\"")
    public void userScrollAndPressOn() {
        homePage.verifySearchPreview(); }

    @When("User press on a product")
    public void userPressOnAProduct() {
    }

    @Then("User should be able to see choosen product info")
    public void userShouldBeAbleToSeeChoosenProductInfo() {
    }
}
