package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_objects.LandingPage;
import page_objects.LoginPage;
import utilities.ActionUtil;

public class Login {
	LoginPage loginPage = new LoginPage(Hook.driver);
	LandingPage landinPage = new LandingPage(Hook.driver);

	@Given("user is on shopify home page")
	public void user_is_on_shopify_home_page() {

		loginPage.clickShopifyLoginLnk();
	}

	@When("user enters valid {string}, {string} and clicks on login button")
	public void user_enters_valid_and_clicks_on_login_button(String email, String password)
			throws InterruptedException {
		loginPage.loginIntoShopify(email, password);
	}

	@Then("user is on shopify dashboard")
	public void user_is_on_shopify_dashboard() {
		landinPage.ShopifyDashboard();
		landinPage.selectStore();
	}

	@When("user selects the store {string}")
	public void user_selects_the_store(String string) {

	}

	@When("clicks on {string}")
	public void clicks_on(String string) {

	}

	@When("navigates to the program-points-{string}-{string}")
	public void navigates_to_the_program_points(String string, String string2) {

	}

	@When("enters valid data in {string} and {string} fields")
	public void enters_valid_data_in_and_fields(String string, String string2) {

	}

	@When("enters {string}")
	public void enters(String string) {

	}

	@When("selects  {string}, {string},{string},{string}")
	public void selects(String string, String string2, String string3, String string4) {

	}

	@When("enters {string} and impact details {string},{string},{string}")
	public void enters_and_impact_details(String string, String string2, String string3, String string4) {

	}

	@When("enters {string} and details of {string},{string}")
	public void enters_and_details_of(String string, String string2, String string3) {

	}

	@When("uploads the banner image and click on publish button")
	public void uploads_the_banner_image_and_click_on_publish_button() {

	}

	@Then("ways to earn program is created successfully using build from scratch feature")
	public void ways_to_earn_program_is_created_successfully_using_build_from_scratch_feature() {

	}

}
