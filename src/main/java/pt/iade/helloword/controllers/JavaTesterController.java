package pt.iade.helloword.controllers;

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
    logger.info("Saying ");
    return "UP TO DATE";
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
    


// Calculos

 private double grades[] = {10.5, 12, 14.5};
 private String ucs[] = {"FP","POO","BD"};   

@GetMapping(path = "calcular/average", produces = MediaType.APPLICATION_JSON_VALUE)

//Calcular a média
public double med() {
    double sum = 0;
    for (int i = 0; i < grades.length; i++) {
        sum += grades[i];
    }
    double med = sum / (double) grades.length;
    return med;
}

//Calcular a maior nota
@GetMapping(path = "calcular/maiorNota", produces = MediaType.APPLICATION_JSON_VALUE)
public double maiorNota() {
    double maior = 0;
    for (int i = 1; i < grades.length; i++) {
        if (grades[i] >= maior) {
            maior= grades[i];
        }
    }
    return maior;
}

// Visualizar notas por UCs 
@GetMapping(path = "visualizar/grade", produces = MediaType.APPLICATION_JSON_VALUE)
public double Grade() {
    String uc = "FP";
    double grade = 4;
    for (int i = 0; i < ucs.length; i++) {
        if (ucs[i].equals(uc)) {
            grade = grades[i];
        }
    }
    return grade;
}

//   Limites de notas entre Ucs 

@GetMapping(path = "visualizar/LimGrade", produces = MediaType.APPLICATION_JSON_VALUE)
public double LimGrade() {
    double min = 4.6;
    double max = 11.7;
    double tot = 0;
    for (int i = 0; i < ucs.length; i++) {
        if (grades[i] >= min && grades[i] <= max) {
            tot++;
        }
    }
    return tot;
}

// Carregar toda informação
@GetMapping(path = "ucs/notas", produces = MediaType.APPLICATION_JSON_VALUE)
public String Info() {
    String info = "";
    for (int i = 0; i < ucs.length; i++) {
        info += "  (" +ucs[i] + " - " + grades[i] + ")  "; 
    }
    return info;
}

}