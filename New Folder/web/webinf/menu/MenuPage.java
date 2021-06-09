/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.webinf.menu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import web.webinf.admin.AdminPanelPage;
import web.webinf.admin.ListBuyersPage;
import web.webinf.guest.ShowLoginFormPage;


/**
 *
 * @author artur
 */

public class MenuPage  {
    protected WebDriver driver;
    private final By infoBy = By.id("info");
    private final By showLoginFormBy = By.id("showLoginForm");
    private final By adminPanelBy = By.id("adminPanel");
    private final By listBuyersBy = By.id("adminPanel");
    private final By logoutBy = By.id("logout");
    public MenuPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public String getMessageInfo(){
        return driver.findElement(infoBy).getText();
    }
    
    public ShowLoginFormPage getShowLoginFormPage() {
        driver.findElement(showLoginFormBy).click(); //делает вход
        return new ShowLoginFormPage(driver);
    }

    public AdminPanelPage getAdminPanelPage() {
        driver.findElement(adminPanelBy).click();
        return new AdminPanelPage(driver);
    }
    
    public ListBuyersPage getListBuyersPage() {
        driver.findElement(listBuyersBy).click();
        return new ListBuyersPage(driver);
    }

    public void logout() {
        driver.findElement(logoutBy).click();
    }
    
    
}
