package com.tw.apistackbase.controller;

import com.tw.apistackbase.entity.Prosecutor;
import com.tw.apistackbase.repository.ProsecutorRepo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class ProsecutorController {

    private ProsecutorRepo prosecutorRepo;

    public ProsecutorController(ProsecutorRepo prosecutorRepo) {
        this.prosecutorRepo = prosecutorRepo;
    }

    @GetMapping(path="/prosecutors")
    public List<Prosecutor> getAll() {
        return prosecutorRepo.findAll();
    }

    @PostMapping(path="/prosecutors",  headers = {"Content-type=application/json"})
    @ResponseStatus(code = HttpStatus.CREATED)
    public Prosecutor createProsecutor(@RequestBody Prosecutor prosecutor){
        return prosecutorRepo.save(prosecutor);
    }
}
