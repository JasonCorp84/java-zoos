package com.zoo.controller;

import com.zoo.model.Zoo;
import com.zoo.repository.AnimalRepository;
import com.zoo.repository.TelephoneRepository;
import com.zoo.repository.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.Optional;


@RestController
@RequestMapping(path = "/admin/", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminController {
    // puts, deletes, post
    @Autowired
    AnimalRepository animalrepos;

    @Autowired
    ZooRepository zoorepos;

    @Autowired
    TelephoneRepository telephonerepos;

    @PutMapping("/zoos/{zooid}")
    public Zoo changeZooById(@RequestBody Zoo newZoo, @PathVariable long zooid) throws URISyntaxException {
        Optional<Zoo> updateZoo = zoorepos.findById(zooid);
        if(updateZoo.isPresent()) {
            if (newZoo.getZooname() == null) {
                newZoo.setZooname(updateZoo.get().getZooname());
            }
            newZoo.setZooid(zooid);
            zoorepos.save(newZoo);
            return newZoo;
        } else {
            return null;
        }
    }

    @DeleteMapping("/zoos/{zooid}")
    public String deleteZooById(@PathVariable long zooid) {
        var foundZoo = zoorepos.findById(zooid);
        if(foundZoo.isPresent()) {
            zoorepos.deleteZooFromZooanimals(zooid);
            zoorepos.deleteById(zooid);

            return "{" + "\"zooid\":" + foundZoo.get().getZooid() +
                    "zoo name:" + foundZoo.get().getZooname() + "}";
        } else {
            return null;
        }
    }
}
