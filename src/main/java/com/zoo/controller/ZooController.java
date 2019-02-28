package com.zoo.controller;

import com.zoo.model.Zoo;
import com.zoo.repository.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/zoos/", produces = MediaType.APPLICATION_JSON_VALUE)
public class ZooController {
    @Autowired
    ZooRepository zoorepos;

    @GetMapping("/zoos")
    public List<Zoo> listAllZoos() {
        return zoorepos.findAll();
    }

    @GetMapping("/id/{id}")
    public Zoo findZooById(@PathVariable long id) {
        return zoorepos.findById(id).get();
    }
}
