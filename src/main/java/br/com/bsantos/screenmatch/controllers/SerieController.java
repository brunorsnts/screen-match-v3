package br.com.bsantos.screenmatch.controllers;

import br.com.bsantos.screenmatch.dtos.EpisodioDTO;
import br.com.bsantos.screenmatch.dtos.SerieDTO;
import br.com.bsantos.screenmatch.services.SerieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/series")
public class SerieController {

    private final SerieService service;

    public SerieController(SerieService service) {
        this.service = service;
    }

    @GetMapping
    public List<SerieDTO> obtemSeries() {
        return service.buscaTodasAsSeries();
    }

    @GetMapping("/top5")
    public List<SerieDTO> obtemTop5Series() {
        return service.obtemTop5Series();
    }

    @GetMapping("/lancamentos")
    public List<SerieDTO> obtemLacamentos() {
        return service.obtemLancamentos();
    }

    @GetMapping("/{id}")
    public SerieDTO buscaPorId(@PathVariable Long id) {
        return service.buscaPorId(id);
    }

    @GetMapping("{id}/temporadas/todas")
    public List<EpisodioDTO> obtemTodosOsEpisodios(@PathVariable Long id) {
        return service.obtemTodosOsEpisodios(id);
    }

    @GetMapping("{id}/temporadas/{numTemporada}")
    public List<EpisodioDTO> obtemTodosOsEpisodiosPorTemporada(@PathVariable Long id, @PathVariable int numTemporada) {
        return service.obtemTodosOsEpisodiosPorTemporada(id, numTemporada);
    }

    @GetMapping("/categoria/{genero}")
    public List<SerieDTO> obtemSeriesPorGenero(@PathVariable String genero) {
        return service.obtemSeriesPorGenero(genero);
    }
}
