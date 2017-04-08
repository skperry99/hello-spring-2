package org.launchcode.controllers;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.launchcode.models.HelloMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Sarah on 3/30/2017.
 */
@Controller
public class HelloController {
    @RequestMapping(value = "")
    @ResponseBody
    public String index(HttpServletRequest request) {

        String name = request.getParameter("name");

        if(name == null){
            name = "World";
        }

        return "Hello " + name;
    }

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    @ResponseBody
    public String hellowForm(){
        String html = "<form method='post'>" +
                "<input type='text' name='name' />" +
                "<select name='lang'>" +
                    "<option value='En' selected>English</option>" +
                    "<option value='Sp'>Spanish</option>" +
                    "<option value='Ma'>Mandarin</option>" +
                    "<option value='Ar'>Arabic</option>" +
                    "<option value='Sw'>Swahili</option>" +
                "</select>" +
                "<input type='submit' value='Greet Me!' />" +
                "</form>";

        return html;
    }

    @RequestMapping(value = "hello", method= RequestMethod.POST)
    @ResponseBody
    public String helloPost(@RequestParam String name, @RequestParam String lang){

        return HelloMessage.createMessage(name, lang);
    }

    @RequestMapping(value = "hello/{name}")
    @ResponseBody
    public String helloUrlSegment(@PathVariable String name) {

        return "Hello " + name;
    }

    @RequestMapping(value = "goodbye")
    public String goodbye() {
        return "redirect:/";
    }
}
