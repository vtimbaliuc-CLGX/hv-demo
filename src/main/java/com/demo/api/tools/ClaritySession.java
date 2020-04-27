package com.demo.api.tools;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import com.gargoylesoftware.htmlunit.util.Cookie;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Set;

@Component
public class ClaritySession {
    public static String currToken;

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

    @Scheduled(cron="* * */1 * * *")
    private void updateToken() throws IOException {
        ClaritySession.currToken = ClaritySession.generate();
    }

}
