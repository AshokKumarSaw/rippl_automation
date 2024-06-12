package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_objects.BuildFromScratchPage;
import page_objects.ShopifyLandingPage;
import page_objects.Rippl_RewardsPage;
import page_objects.ShopifyLoginPage;

public class BuildFromScratch {
	ShopifyLoginPage shopifyLoginPage = new ShopifyLoginPage(Hook.driver);
	ShopifyLandingPage shopifyLandinPage = new ShopifyLandingPage(Hook.driver);
	Rippl_RewardsPage rippl_RewardsPage = new Rippl_RewardsPage(Hook.driver);
	BuildFromScratchPage buildFromScratchPage = new BuildFromScratchPage(Hook.driver);

	@Given("user is on shopify dashboard {string}, {string}")
	public void user_is_on_shopify_dashboard(String shopify_email, String shopify_password) {
		shopifyLoginPage.loginShopify(shopify_email, shopify_password);
	}

	@When("user selects the store {string}")
	public void user_selects_the_store(String string) {
	}

	@When("selects the Rippl Reward staging extension")
	public void selects_the_rippl_reward_staging_extension() {
	}

	@When("navigates to Add Ways to Earn - Build From Scratch")
	public void navigates_to_add_ways_to_earn_build_from_scratch() {
	}

	@When("fills up the build from scratch form with appropriate data {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
	public void fills_up_the_build_from_scratch_form_with_appropriate_data(String string, String string2,
			String string3, String string4, String string5, String string6, String string7, String string8,
			String string9, String string10, String string11, String string12, String string13, String string14) {

	}

	@When("uploads banner image and publishes the challenge")
	public void uploads_banner_image_and_publishes_the_challenge() {
	}

	@Then("verify created challenge is displayed in Ways to Earn challenges list")
	public void verify_created_challenge_is_displayed_in_ways_to_earn_challenges_list() {
	}

	@Then("verify created challenge contains exactly the same details filled in the form during creation  {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
	public void verify_created_challenge_contains_exactly_the_same_details_filled_in_the_form_during_creation(
			String string, String string2, String string3, String string4, String string5, String string6,
			String string7, String string8, String string9, String string10, String string11, String string12,
			String string13, String string14) {
	}

}
