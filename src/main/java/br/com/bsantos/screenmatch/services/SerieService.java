package br.com.bsantos.screenmatch.services;

import br.com.bsantos.screenmatch.dtos.SerieDTO;
import br.com.bsantos.screenmatch.models.Serie;
import br.com.bsantos.screenmatch.repositories.SerieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SerieService {

    private final SerieRepository repository;

    public SerieService(SerieRepository repository) {
        this.repository = repository;
    }

    public List<SerieDTO> buscaTodasAsSeries() {
        return converteDados(repository.findAll());
    }

    public List<SerieDTO> obtemTop5Series() {
        return converteDados(repository.findTop5ByOrderByAvaliacaoDesc());
    }

    public List<SerieDTO> obtemLancamentos() {
        return converteDados(repository.findTop5ByOrderByEpisodiosDataLancamentoDesc());
    }

    public SerieDTO buscaPorId(Long id) {
        Optional<Serie> serie = repository.findById(id);

        if (serie.isPresent()) {
            Serie entidade = serie.get();
            return new SerieDTO(entidade);
        }

        return null;
    }

    private List<SerieDTO> converteDados(List<Serie> series) {
        return series.stream()
                .map(SerieDTO::new)
                .toList();
    }
}
