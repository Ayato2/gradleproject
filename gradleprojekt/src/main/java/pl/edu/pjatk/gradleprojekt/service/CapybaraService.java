package pl.edu.pjatk.gradleprojekt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.pjatk.gradleprojekt.model.Capybara;
import pl.edu.pjatk.gradleprojekt.repository.CapybaraRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class CapybaraService {
    private List<Capybara> capybaraList = new ArrayList<>();
    private CapybaraRepository repository;
    private StringUtilsService stringUtilsService;

    @Autowired
    public CapybaraService(CapybaraRepository repository, StringUtilsService stringUtilsService) {
        this.repository = repository;
        this.stringUtilsService = stringUtilsService;
        this.repository.save(new Capybara("Capybara1", "brown"));
        this.repository.save(new Capybara("Capybara2", "black"));
        this.repository.save(new Capybara("Capybara3", "white"));
    }

    public List<Capybara> getCapybaraByName(String name) {
        String formattedName = stringUtilsService.capitalizeFirstLetter(name);
        return this.repository.findByName(formattedName);
    }

    public List<Capybara> getCapybaraList() {
        return this.capybaraList;
    }

    public Capybara getCapybara(Integer id) {
        Capybara capybara = this.capybaraList.get(id);
        capybara.setName(stringUtilsService.capitalizeFirstLetter(capybara.getName()));
        return capybara;
    }

    public void add(Capybara capybara) {
        capybara.setName(stringUtilsService.toUpperCase(capybara.getName()));
        this.capybaraList.add(capybara);
        this.repository.save(capybara);
    }

    public void delete(int id) {
        this.capybaraList.remove(id);
    }

    public void update(Integer id, Capybara updatedCapybara) {
        if (id < 0 || id >= capybaraList.size()) {
            throw new IndexOutOfBoundsException("Invalid Capybara ID");
        }
        Capybara existingCapybara = capybaraList.get(id);
        existingCapybara.setName(stringUtilsService.toUpperCase(updatedCapybara.getName()));
        existingCapybara.setColor(updatedCapybara.getColor());
        capybaraList.set(id, existingCapybara);
        this.repository.save(existingCapybara);
    }
}
