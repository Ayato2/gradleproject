package pl.edu.pjatk.gradleprojekt.services;

import org.springframework.stereotype.Component;
import pl.edu.pjatk.gradleprojekt.model.Capybara;

import java.util.ArrayList;
import java.util.List;

@Component
public class CapybaraService {
    List<Capybara> capybaraList = new ArrayList<>();

    public CapybaraService(){
        this.capybaraList.add(new Capybara("Capybara1", "brown"));
        this.capybaraList.add(new Capybara("Capybara2", "black"));
        this.capybaraList.add(new Capybara("Capybara3", "white"));
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
}
