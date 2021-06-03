/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import web.webinf.menu.MenuPage;

/**
 *
 * @author user
 */
public class AdminLoginTest {
    static private WebDriver driver;
    public AdminLoginTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost:8080/WebProductShop2/");
        driver.manage().window().maximize();
    }
    
    @AfterClass
    public static void tearDownClass() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
    
    @Before
    public void setUp() {     
    }
    
    @After
    public void tearDown() {
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void login() {
        System.out.println("Admin login test");
        WebElement el = driver.findElement(By.id("showLoginForm"));
        el.click();
        
        el = driver.findElement(By.id("login"));
        el.sendKeys("admin");
        el = driver.findElement(By.id("password"));
        el.sendKeys("12345");  
        el = driver.findElement(By.id("btnSubmit"));
        el.click();
        el = driver.findElement(By.id("info"));
        String exp = "You Sign Up! ";
//        String exp = el.getText();
        System.out.println("Waiting:"+exp);
        System.out.println("Printing:"+el.getText());
        Assert.assertEquals(exp, el.getText());
        
    }

//    @Test
//    public void lostOfControlTest() { //потеря управляемости
//        MenuPage menuPage = new MenuPage(driver);
//        ShowLoginFormPage showLoginFormPage = menuPage.getShowLoginFormPage();
//        IndexPage indexPage = showLoginFormPage.loginValidUser("admin", "12345");
//       
//   }
    
    
   
      
    
    
}
