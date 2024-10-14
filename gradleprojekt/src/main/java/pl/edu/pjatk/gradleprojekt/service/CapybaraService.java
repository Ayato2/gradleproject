package pl.edu.pjatk.gradleprojekt.service;

import org.springframework.stereotype.Component;
import pl.edu.pjatk.gradleprojekt.model.Capybara;
import pl.edu.pjatk.gradleprojekt.repository.CapybaraRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class CapybaraService {
    List<Capybara> capybaraList = new ArrayList<>();

    private CapybaraRepository repository;

    public CapybaraService(CapybaraRepository repository) {
        this.repository = repository;
        this.repository.save(new Capybara("Capybara1", "brown"));
        this.repository.save(new Capybara("Capybara2", "black"));
        this.repository.save(new Capybara("Capybara3", "white"));
    }

    public List<Capybara> getCapybaraByName(String name) {
        return this.repository.findByName(name);
    }

    public List<Capybara> getCapybaraList() {
        return this.capybaraList;
    }
    public Capybara getCapybara(Integer id) {
        return this.capybaraList.get(id);
    }

    public void add(Capybara capybara) {
        this.capybaraList.add(capybara);
    }

    public void delete(int id) {this.capybaraList.remove(id);}
}
