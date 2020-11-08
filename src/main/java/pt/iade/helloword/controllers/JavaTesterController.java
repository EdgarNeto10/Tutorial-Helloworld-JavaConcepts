package pt.iade.helloword.controllers;

//import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping(path = "api/java")
public class JavaTesterController {
    private Logger logger = LoggerFactory.getLogger(GretterController.class);
   
    @GetMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
    public String getGreetin() {
    logger.info("Saying Hello to the world");
    return "Hello World";
    }

    @GetMapping(path = "/access/{student}/{covid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean getGreeting(@PathVariable("student") boolean isStudent, @PathVariable("covid") boolean hasCovid) {
        logger.info("A verificar");
        return isStudent && !hasCovid;
    }

    @GetMapping(path = "/required/{student}/{temperature}/{classType}", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean getRequired(@PathVariable("student") boolean isStudent, @PathVariable("temperature") double hasCovid,
            @PathVariable("classType") String type) {
        return isStudent && (hasCovid > 34.5 && hasCovid < 37.5) && (type.equals("presential"));
    }
    
    
}