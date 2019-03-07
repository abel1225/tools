package me.abel.toutiao.service;

import me.abel.utils.commons.HttpClientUtil;
import me.abel.utils.commons.exception.HttpRequestException;
import org.apache.http.HttpResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: able.li
 * @create: 2018/12/15 11:33
 */
public class ToutiaoLoginService {

    public static String doLoginTouTiao(String loginName, String password) {
//        String url = "https://mp.toutiao.com/auth/login_post/";
        String url = "https://sso.toutiao.com/account_login/";

        Map<String, String> headers = new HashMap<>();
        Map<String, String> params = new HashMap<>();
        headers.put("Host", "mp.toutiao.com");
        headers.put("Connection", "keep-alive");
        headers.put("Origin", "https://mp.toutiao.com");
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2272.118 Safari/537.36");
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        headers.put("Accept", "application/json, text/javascript, */*; q=0.01");
        headers.put("X-Requested-With", "XMLHttpRequest");
        headers.put("X-CSRFToken", "b3ebed559047fa1cacaccc6ccfb66851");
        headers.put("Referer", "https://mp.toutiao.com/login/");
//      headers.put("Accept-Encoding", "gzip, deflate");
        headers.put("Accept-Language", "zh-CN,zh;q=0.8");
//      String cookie = "uuid=\"w:0256c3403d82490abcc2c7819d48865f\"; tt_webid=3932107506; utm_source=toutiao; __utma=24953151.381297160.1435021810.1435023762.1435106245.3; __utmc=24953151; __utmz=24953151.1435106245.3.2.utmcsr=baidu|utmccn=(organic)|utmcmd=organic|utmctr=%E4%BB%8A%E6%97%A5%E5%A4%B4%E6%9D%A1; _gat=1; sessionid=249d2efbe15e67a4ff000a9ffe489c4e; csrftoken=b3ebed559047fa1cacaccc6ccfb66851; _ga=GA1.2.381297160.1435021810";
//      headers.put("Cookie", cookie);
        params.put("name_or_email", loginName);
        params.put("password", password);

//        CookieStore cookieStore = HttpClientUtil.getResponseCookieWithParamsAndHeaders(url, headers, params);
        HttpResponse response = HttpClientUtil.postParamsWithHeaders(url, headers, params);
        String cookies = HttpClientUtil.getCookies(response);
        System.out.println("cookieStr:" + cookies);
        try {
            String responseText  = HttpClientUtil.getResponseMessage(response);
            System.out.println(responseText);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        return HttpClientUtil.setCookie2String(cookies);
        return cookies;
    }

    public static String getCsrfToken(String cookie){
        return cookie.substring(cookie.indexOf("value: ") + 7, cookie.indexOf("value: ") + 7 + 64);
    }

    public static void submitComments(String cookieStr, String csrfToken, String comments) throws HttpRequestException {
        String url="http://toutiao.com/group/4560598775/post_comment/";
        Map<String,String> headers = new HashMap<>();
        Map<String, String> params = new HashMap<>();
        headers.put("Accept", "application/json, text/javascript, */*; q=0.01");
        headers.put("Accept-Language", "zh-CN,zh;q=0.8");
        headers.put("Connection", "keep-alive");
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        headers.put("Host", "toutiao.com");
        headers.put("Origin", "http://toutiao.com");
        headers.put("Referer", "http://toutiao.com/a4560598775/");
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2272.118 Safari/537.36");
        headers.put("X-CSRFToken", csrfToken);
        headers.put("X-Requested-With", "XMLHttpRequest");
//      cookieStr="uuid=\"w:0256c3403d82490abcc2c7819d48865f\"; tt_webid=3932107506; sessionid=249d2efbe15e67a4ff000a9ffe489c4e; _ga=GA1.2.381297160.1435021810; __utmt=1; utm_source=toutiao; csrftoken=382a7061c9b0b4abe3c4558ad3847df4; __utma=24953151.381297160.1435021810.1435117044.1435124287.5; __utmb=24953151.6.8.1435124301975; __utmc=24953151; __utmz=24953151.1435124287.5.3.utmcsr=baidu|utmccn=(organic)|utmcmd=organic|utmctr=%E4%BB%8A%E6%97%A5%E5%A4%B4%E6%9D%A1";
//      cookieStr="uuid=\"w:0256c3403d82490abcc2c7819d48865f\"; tt_webid=3932107506; sessionid=249d2efbe15e67a4ff000a9ffe489c4e; _ga=GA1.2.381297160.1435021810; __utmt=1; utm_source=toutiao; csrftoken=382a7061c9b0b4abe3c4558ad3847df4; __utma=24953151.381297160.1435021810.1435117044.1435124287.5; __utmb=24953151.6.8.1435124301975; __utmc=24953151; __utmz=24953151.1435124287.5.3.utmcsr=baidu|utmccn=(organic)|utmcmd=organic|utmctr=%E4%BB%8A%E6%97%A5%E5%A4%B4%E6%9D%A1";
//      cookieStr=cookieStr+"csrftoken=382a7061c9b0b4abe3c4558ad3847df4;";
        headers.put("Cookie", cookieStr);
        params.put("status", comments);
        HttpResponse response = HttpClientUtil.postParamsWithHeaders(url, headers, params);
        System.out.println(response);
        try {
            String responseText = HttpClientUtil.getResponseMessage(response);
            System.out.println(responseText);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
