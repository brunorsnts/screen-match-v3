package br.com.bsantos.screenmatch.services;

import br.com.bsantos.screenmatch.dtos.SerieDTO;
import br.com.bsantos.screenmatch.repositories.SerieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieService {

    private final SerieRepository repository;

    public SerieService(SerieRepository repository) {
        this.repository = repository;
    }

    public List<SerieDTO> buscaTodasAsSeries() {
        return repository.findAll().stream()
                .map(SerieDTO::new).toList();
    }
}
