package hello.controller;

import hello.Greeting;

import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/greeting")
public class HelloWorldController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    @RequestMapping(method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody HttpEntity<Greeting> greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, HttpServletResponse response) {
        System.out.println("==== in greeting ===="); 
        return new ResponseEntity<Greeting>(new Greeting(counter.incrementAndGet(), String.format(template, name)), HttpStatus.OK);
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public @ResponseBody Greeting saveFileds(@RequestParam(value="name", required=true, defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

}
