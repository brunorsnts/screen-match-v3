package br.com.bsantos.screenmatch;

import br.com.bsantos.screenmatch.dtos.SerieDTO;
import br.com.bsantos.screenmatch.repositories.SerieRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SerieController {

    private final SerieRepository repository;

    public SerieController(SerieRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/series")
    public List<SerieDTO> obtemSeries() {
        return repository.findAll().stream()
                .map(SerieDTO::new)
                .collect(Collectors.toList());
    }
}
