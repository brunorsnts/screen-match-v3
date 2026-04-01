package br.com.bsantos.screenmatch.controllers;

import br.com.bsantos.screenmatch.dtos.SerieDTO;
import br.com.bsantos.screenmatch.repositories.SerieRepository;
import br.com.bsantos.screenmatch.services.SerieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

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


}
