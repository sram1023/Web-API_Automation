package pages;

import org.openqa.selenium.By;
import steps.WaitSteps;

public class HomePage extends WaitSteps {

    public HomePage() {

        webElementPath.put("SignInButton", By.xpath("//a[contains(text(),'Sign in')]"));
    }
}
