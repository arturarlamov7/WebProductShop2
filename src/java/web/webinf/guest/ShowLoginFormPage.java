/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.webinf.guest;

import org.openqa.selenium.WebDriver;
import web.IndexPage;



/**
 *
 * @author artur
 */
public class ShowLoginFormPage  {
    protected WebDriver driver;

    public ShowLoginFormPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public IndexPage loginValidUser(String login, String password) {
        //driver.findElements(By.id("login")).sendKeys(login);
        return new IndexPage(driver);
    }

}
