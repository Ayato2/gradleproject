package pl.edu.pjatk.gradleprojekt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.edu.pjatk.gradleprojekt.model.Capybara;
import pl.edu.pjatk.gradleprojekt.repository.CapybaraRepository;
import pl.edu.pjatk.gradleprojekt.service.CapybaraService;
import pl.edu.pjatk.gradleprojekt.service.StringUtilsService;

import java.util.Optional;

import static org.mockito.Mockito.when;

public class CapybaraServiceTest
{
    CapybaraService capybaraService;
    CapybaraRepository capybaraRepository;
    StringUtilsService stringUtilsService;

    @BeforeEach
    public void setup() {
        capybaraRepository = Mockito.mock(CapybaraRepository.class);
        stringUtilsService = Mockito.mock(StringUtilsService.class);
        capybaraService = new CapybaraService(capybaraRepository, stringUtilsService);
    }

    @Test
    public void getCapybaraByNameTest() {
        when(capybaraRepository.findById()).thenReturn(Optional.of(new Capybara()));


        capybaraService.getCapybara(2);
    }
}
