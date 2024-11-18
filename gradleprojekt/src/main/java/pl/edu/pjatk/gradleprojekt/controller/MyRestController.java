package pl.edu.pjatk.gradleprojekt.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pl.edu.pjatk.gradleprojekt.model.Capybara;
import pl.edu.pjatk.gradleprojekt.service.CapybaraService;
import pl.edu.pjatk.gradleprojekt.service.PDFService;

import java.util.List;

@RestController

public class MyRestController {

    private CapybaraService capybaraService;
    private PDFService pdfService;

    @Autowired
    public MyRestController(CapybaraService capybaraService) {
        this.capybaraService = capybaraService;
    }
    @GetMapping("capybara/all")
    public List<Capybara> getAll(){
        return this.capybaraService.getCapybaraList();
    }
    @GetMapping("capybara/name/{name}")
    public List<Capybara> getCapybaraByName(@PathVariable String name){
        return this.capybaraService.getCapybaraByName(name);
    }
    @GetMapping("capybara/{id}")
    public Capybara get(@PathVariable Integer id){
        return this.capybaraService.getCapybara(id);
    }

    @PostMapping("capybara")
    public void addCapybara(@RequestBody Capybara capybara) {

        this.capybaraService.add(capybara);

    }
    @DeleteMapping("capybara/{id}")
    public void deleteCapybara(@PathVariable int id){
        this.capybaraService.delete(id);
    }



}
