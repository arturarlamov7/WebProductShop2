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
import web.webinf.admin.AdminPanelPage;
import web.webinf.guest.ShowLoginFormPage;
import web.webinf.menu.MenuPage;

/**
 *
 * @author user
 */
public class GeneralTest {
    static private WebDriver driver;
    private final MenuPage menuPage = new MenuPage(driver);
    
    public GeneralTest() {
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


   @Test
    public void lostOfControlTest() {     //потеря управляемости

        MenuPage menuPage = new MenuPage(driver);
        ShowLoginFormPage showLoginFormPage = menuPage.getShowLoginFormPage();  //получаем из меню страницу входа
        IndexPage indexPage = showLoginFormPage.loginValidUser("admin", "12345"); //ввод данных в инпуты
        
        if (!"You Sign Up! ".equals(indexPage.getMessageInfo())) {
           Assert.fail("Нет такого пользователя или неправильный пароль");       
        }
       
        AdminPanelPage adminPanelPage = menuPage.getAdminPanelPage();
        String massage = adminPanelPage.validLostAccess();
        Assert.assertEquals("Изменить роль невозможно", massage);
        
   }
    
    @Test
    
    public void logoutTest() {
        
        System.out.println("logoutTest: ");
        menuPage.logout();
        String result = menuPage.getMessageInfo();
        String expected = "Вы вышли";
        System.out.println("    Waiting: "+ expected );
        System.out.println("    Printing: " + result );
        Assert.assertEquals(result, expected);
    }
    
    
//        public void changeUserProfile(String login, boolean allowed){
//            System.out.println("changeUserProfile("+login+","+allowed+"): ");
//            menuPage.getListBuyersPage().getEditUserPage(login).changeUserProfile();
//            String result = menuPage.getMessageInfo();
//            String expected = "Данные пользователя изменены";
//            System.out.println("    Expected: "+ expected);
//            System.out.println("    Result: " + result);
//            if(allowed){ 
//                System.out.println("Expected и Result должны совпадать");
//                Assert.assertEquals(result, expected);
//            }else{
//                System.out.println("Expected и Result должны несовпадать");
//                Assert.assertNotEquals(result, expected);
//            }
//        }
    
    
   
      
    
    
}
