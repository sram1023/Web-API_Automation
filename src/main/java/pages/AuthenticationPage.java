package pages;

import org.openqa.selenium.By;
import steps.WaitSteps;

public class AuthenticationPage extends WaitSteps {

    public AuthenticationPage() {
        webElementPath.put("EmailAddressTextBox", By.cssSelector("[id$='email_create']"));
        webElementPath.put("CreateAccountButton", By.id("SubmitCreate"));
        webElementPath.put("TitleMrRadio", By.id("id_gender1"));
        webElementPath.put("TitleMrsRadio", By.id("uniform-id_gender2"));
        webElementPath.put("FirstNameTextBox", By.id("customer_firstname"));
        webElementPath.put("LastNameTextBox", By.id("customer_lastname"));
        webElementPath.put("PersonalInfoLabel", By.xpath("//h3[contains(text(),'Your personal information')]"));
    }
}
