package me.abel.sfdc.timecard.service;

import me.abel.sfdc.timecard.dto.TimeCardDto;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

import java.io.File;

/**
 * @description:
 * @author: able.li
 * @create: 2018/12/29 14:00
 */
public class TimeCardService {

    private static WebDriver driver = null;

    {
        System.setProperty("webdriver.chrome.driver", "D:/selenium/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "D:/selenium/geckodriver.exe");

//        driver = new ChromeDriver();
        File pathBinary = new File("");
        FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
        FirefoxProfile firefoxProfile = new FirefoxProfile();

        ProfilesIni pi = new ProfilesIni();
        firefoxProfile = pi.getProfile("default");

        //20180713 取消旧写法，改用新写法
        //WebDriver driver = new FirefoxDriver(firefoxBinary, firefoxProfile);
        FirefoxOptions options = new FirefoxOptions().setBinary(firefoxBinary).setProfile(firefoxProfile);
        driver = new FirefoxDriver();
    }

    public void setTimecard(String userName, String pwd, TimeCardDto dto){

    }

}
