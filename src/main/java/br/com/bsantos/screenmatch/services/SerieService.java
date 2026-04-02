package br.com.bsantos.screenmatch.services;

import br.com.bsantos.screenmatch.dtos.EpisodioDTO;
import br.com.bsantos.screenmatch.dtos.SerieDTO;
import br.com.bsantos.screenmatch.models.Categoria;
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

    public List<EpisodioDTO> obtemTodosOsEpisodios(Long id) {
        Optional<Serie> serie = repository.findById(id);

        if (serie.isPresent()) {
            Serie serieEncontrada = serie.get();
            return serieEncontrada.getEpisodios().stream()
                    .map(EpisodioDTO::new)
                    .toList();
        }

        return null;
    }

    public List<EpisodioDTO> obtemTodosOsEpisodiosPorTemporada(Long id, int numTemporada) {
        return repository.buscaEpisodiosPorTemporada(id, numTemporada)
                .stream()
                .map(EpisodioDTO::new)
                .toList();
    }


    public List<SerieDTO> obtemSeriesPorGenero(String genero) {
        Categoria categoria = Categoria.fromPortugues(genero);
        return converteDados(repository.findByGenero(categoria));
    }

    private List<SerieDTO> converteDados(List<Serie> series) {
        return series.stream()
                .map(SerieDTO::new)
                .toList();
    }
}
