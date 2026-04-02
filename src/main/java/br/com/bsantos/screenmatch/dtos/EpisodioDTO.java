package br.com.bsantos.screenmatch.dtos;

import br.com.bsantos.screenmatch.models.Episodio;

public record EpisodioDTO(
        Integer temporada,
        Integer numeroEpisodio,
        String titulo
) {

    public EpisodioDTO(Episodio episodio) {
        this(episodio.getTemporada(), episodio.getNumeroEpisodio(), episodio.getTitulo());
    }
}
