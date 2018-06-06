package Steps;

import Base.BaseUtil;
import Transformation.EmailTransform;
import Transformation.SalaryCountTransformer;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.Transform;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.gen5.api.Assertions;
import org.openqa.selenium.By;
import pages.LoginPage;
import sun.jvm.hotspot.debugger.Page;


import java.util.ArrayList;
import java.util.List;

public class LoginStep extends BaseUtil {

    private BaseUtil base;

    public LoginStep(BaseUtil base) {
        this.base = base;
    }

    @Then("^I should see the userform page$")
    public void iShouldSeeTheUserFormPage() throws Throwable {

        Assertions.assertEquals(base.Driver.findElement(By.id("FirstName")).isDisplayed(), true, "It's not displayed");
    }

    @Given("^I navigate to the login page$")
    public void iNavigateToTheLoginPage() throws Throwable {

        System.out.println("I navigate to the login page");
        base.Driver.navigate().to("http://www.executeautomation.com/demosite/Login.html");
    }

    @And("^I click login button$")
    public void iClickLoginButton() throws Throwable {

        LoginPage page = new LoginPage(base.Driver);
        page.ClickLogin();
    }

    @And("^I enter the following for login$")
    public void iEnterTheFollowingForLogin(DataTable table) throws Throwable {

            //Create an ArrayList
        List<User> users = new ArrayList<User>();
        //Store users
        users = table.asList(User.class);

        LoginPage page = new LoginPage(base.Driver);

        for (User user : users) {
            page.Login(user.username, user.password);

        }

    }

    @And("^I enter ([^\"]*) and ([^\"]*)$")
    public void iEnterUsernameAndPassword(String userName, String password) throws Throwable {
        System.out.println("Username Example is " + userName);
        System.out.println("Password Example is " + password);
    }

    @And("^I enter the users email address as Email:([^\"]*)$")
    public void iEnterTheUsersEmailAddressAsEmailAdmin(@Transform(EmailTransform.class) String email) throws Throwable {

        System.out.println("The Email address is " + email);

    }

    @And("^I verify the count of my salary digits for Rs (\\d+)$")
    public void iVerifyTheCountOfMySalaryDigitsForRs(@Transform(SalaryCountTransformer.class) int salary) throws Throwable {

        System.out.println("My salary digit count is :" + salary);
    }

        public class User {
            public String username;
            public String password;

            public User(String userName, String passWord) {
                username = userName;
                password = passWord;
            }
        }
    }

