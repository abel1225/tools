package me.abel.toutiao.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ToutiaoLoginServiceTest {

    @Test
    public void doToutiaoComment(){
        String cookieStr = ToutiaoLoginService.doLoginTouTiao("15800621912",
                "Abel2009");
        System.out.println(cookieStr);

        String csrfToken=ToutiaoLoginService.getCsrfToken(cookieStr);
        cookieStr=cookieStr+";"+csrfToken;

        String[] ss=csrfToken.split(";");
        String s=ss[0];
        String[] tokens=s.split("=");
        String token=tokens[1];
        System.out.println(token);

        String comments = "test";
        ToutiaoLoginService.submitComments(cookieStr,token, comments);
    }
}