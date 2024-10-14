package pl.edu.pjatk.gradleprojekt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pjatk.gradleprojekt.model.Capybara;

import java.util.List;

@Repository
public interface CapybaraRepository extends CrudRepository<Capybara, Long> {
    public List<Capybara> findByName(String name);
}
