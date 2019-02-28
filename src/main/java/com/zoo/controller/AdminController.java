package com.zoo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/admin/", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminController {
    // puts, deletes, post

}
