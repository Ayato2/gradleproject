package pl.edu.pjatk.gradleprojekt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.edu.pjatk.gradleprojekt.model.Capybara;

@Controller
public class MyViewController {

    @GetMapping("view/all")
    public String viewAllCapybaras(Model model) {

        model.addAttribute("capybaraList", service.getCapybaraList());
        return "viewAll";
    }

    @GetMapping("addForm")
    public String displayAddForm(Model model) {

        model.addAttribute("capybaraList", new Capybara());
        return "addForm";
    }

    @PostMapping("addForm")
    public String displayAddForm(@ModelAttribute Capybara capybara) {

        this.service.add(capybara);
        return "redirect:/view/all";
    }
}
