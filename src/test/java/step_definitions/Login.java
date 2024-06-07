package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_objects.AddWaystoEarnActionPage;
import page_objects.LandingPage;
import page_objects.LoginPage;
import page_objects.Rippl_RewardsPage;
import utilities.ActionUtil;

public class Login {
	LoginPage loginPage = new LoginPage(Hook.driver);
	LandingPage landinPage = new LandingPage(Hook.driver);
	Rippl_RewardsPage rippl_RewardsPage = new Rippl_RewardsPage(Hook.driver);
	AddWaystoEarnActionPage addWaystoEarnActionPage=new AddWaystoEarnActionPage(Hook.driver);

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
	public void user_is_on_shopify_dashboard()  {
		landinPage.ShopifyDashboard();

	}

	@When("user selects the store Staging May two Test Store one")
	public void user_selects_the_store_staging_may_two_test_store_one() {
		landinPage.selectStore();
	}

	@When("clicks on Rippl Reward staging")
	public void clicks_on_rippl_reward_staging() {
		landinPage.ripplRewardStaging();
	}

	@When("navigates to the program-points-Add Ways to Earn-Build From Scratch")
	public void navigates_to_the_program_points_add_ways_to_earn_build_from_scratch() {
		rippl_RewardsPage.navigateToBuildFromScratchTemplate();
	}

	@When("enters valid data in {string} and {string} fields")
	public void enters_valid_data_in_and_fields(String name, String short_description) {
		addWaystoEarnActionPage.nameShortDescription(name, short_description);
	}

	@When("enters {string}")
	public void enters(String action_description) {
		addWaystoEarnActionPage.actionDescription(action_description);
	}

	@When("selects  {string}, {string},{string},{string}")
	public void selects(String startdate, String enddate, String cusTags, String imgTrckngTyp) {
		addWaystoEarnActionPage.startEndDate_fltrByCusTags_imgTrackingTyp(startdate, enddate, cusTags, imgTrckngTyp);
	}

	@When("enters {string} and impact details {string},{string},{string}")
	public void enters_and_impact_details(String reward_points, String water_saved, String plastic_saved, String Trees_planted) {
		addWaystoEarnActionPage.rewardPoints_impactDetails(reward_points, water_saved, plastic_saved, Trees_planted);
	}

	@When("enters {string} and details of {string},{string}")
	public void enters_and_details_of(String optional_email_settings, String content, String correlated_task) {
		addWaystoEarnActionPage.emailSettings_Content_CorrelatedTask(optional_email_settings, content, correlated_task);
	}

	@When("uploads the banner image and click on publish button")
	public void uploads_the_banner_image_and_click_on_publish_button() {
		addWaystoEarnActionPage.uploadBannerImgPublish();
	}

	@Then("ways to earn program is created successfully using build from scratch feature")
	public void ways_to_earn_program_is_created_successfully_using_build_from_scratch_feature() {
       //Validation is required
	}

}
