package br.com.bsantos.screenmatch.dtos;

import br.com.bsantos.screenmatch.models.Categoria;
import br.com.bsantos.screenmatch.models.Serie;

public record SerieDTO(
        Long id,
        String titulo,
        Integer totalTemporadas,
        Double avaliacao,
        Categoria genero,
        String atores,
        String poster,
        String sinopse
) {

    public SerieDTO(Serie serie) {
        this(serie.getId(), serie.getTitulo(), serie.getTotalTemporadas(), serie.getAvaliacao(), serie.getGenero(), serie.getAtores(), serie.getPoster(), serie.getSinopse());
    }
}
