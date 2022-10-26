package io.github.tibetteixeira.api.v1.controller;

import io.github.tibetteixeira.api.v1.domain.model.Unit;
import io.github.tibetteixeira.api.v1.domain.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/unit")
public class UnitController {

    @Autowired
    private UnitService service;

    @PostMapping(path = "/save")
    public void save(@RequestBody Unit unit) {
        service.save(unit);
    }

    @PutMapping(path = "/update/{abbr}")
    public void update(@PathVariable String abbr, @RequestBody Unit unit) {
        service.update(abbr, unit);
    }

    @DeleteMapping(path = "/delete/{abbr}")
    public void delete(@PathVariable String abbr) {
        service.delete(abbr);
    }

    @GetMapping(path = "/findByAbbr/{abbr}")
    public Unit findByAbbr(@PathVariable String abbr) {
        return service.findById(abbr);
    }

    @GetMapping(path = "/findAll")
    public List<Unit> findAll() {
        return service.findAll();
    }

    @GetMapping(path = "/findByDescription/{description}")
    public List<Unit> findByDescription(@PathVariable String description) {
        return service.findByDescription(description);
    }
}
