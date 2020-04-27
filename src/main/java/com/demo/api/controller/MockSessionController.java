package com.demo.api.controller;

import com.demo.api.tools.ClaritySession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/session")
public class MockSessionController {
    @RequestMapping(value = "/clarity", method = RequestMethod.GET)
    @ResponseBody
    public String getClaritySession(){
        return ClaritySession.currToken;
    }
}
