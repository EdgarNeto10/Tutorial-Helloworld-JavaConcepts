package pt.iade.helloword.controllers;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.helloword.models.Unit;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.ArrayList;

@RestController

@RequestMapping(path="/api/units")

public class UnitsController {
private final Logger logger = LoggerFactory.getLogger(GretterController.class);
 @GetMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
 public ArrayList<Unit> getUnits() {
    logger.info("Sending all units");
    return units; // Está a retornar as units do save
 }


 @GetMapping(path = "{id}",
 produces= APPLICATION_JSON_VALUE)
 public String getUnit(@PathVariable("id") final String id) {
        logger.info("Sending unit with id: "+id);
        return "Unit "+ id;
 }

 private final ArrayList<Unit> units = new ArrayList<Unit>();
 @PostMapping(path = "/units/")
 public Unit saveUnit(@RequestBody final Unit unit) {
        logger.info("Added unit "+unit.getName());
        units.add(unit);
        return unit;
 }


}