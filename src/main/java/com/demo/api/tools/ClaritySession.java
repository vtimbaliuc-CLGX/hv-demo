package com.demo.api.tools;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import com.gargoylesoftware.htmlunit.util.Cookie;

import java.io.IOException;
import java.util.Set;

public class ClaritySession {
    public static String generate() throws IOException {
        String serverUrl = "http://localhost:8080";
        WebClient client = new WebClient();
        client.getOptions().setJavaScriptEnabled(true);

        HtmlPage pageOne = client.getPage(serverUrl + "/saml/sp/select");
        HtmlAnchor linkOne = pageOne.getFirstByXPath("/html/body/div/ul/li[1]/a");
        linkOne.click();

        HtmlPage pageTwo = (HtmlPage) client.getCurrentWindow().getEnclosedPage();
        HtmlTextInput username = pageTwo.getFirstByXPath("//*[@id=\"username\"]");
        username.setValueAttribute("frontenduser1");

        HtmlPasswordInput password = pageTwo.getFirstByXPath("//*[@id=\"password\"]");
        password.setValueAttribute("homevisit777");

        HtmlButton login = pageTwo.getFirstByXPath("//*[@id=\"loginbtn\"]");
        Set<Cookie> cookies = null;
        try {
            login.click();
        } catch (Exception e){
            cookies = client.getCookieManager().getCookies();

            String minLengthCookie = client.getCookieManager().getCookie("JSESSIONID").getValue();
            for(Cookie cookie : cookies){
                System.out.println(cookie.getValue());
                if(cookie.getName().equals("JSESSIONID")){
                    if(cookie.getValue().length() < minLengthCookie.length()){
                        minLengthCookie = cookie.getValue();
                    }
                }
            }
            return minLengthCookie;
        }

        throw new IOException();
    }
}
