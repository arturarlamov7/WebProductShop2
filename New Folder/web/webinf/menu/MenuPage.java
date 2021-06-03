/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.webinf.menu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import web.webinf.guest.ShowLoginFormPage;


/**
 *
 * @author artur
 */

public class MenuPage  {
    protected WebDriver driver;

    public MenuPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public ShowLoginFormPage getShowLoginFormPage() {
        driver.findElement(By.id("showLoginForm")).click(); //делает вход
        return new ShowLoginFormPage(driver);
    }
    
    
}
