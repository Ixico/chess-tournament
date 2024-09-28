package io.github.ixico.chesstournament.api.http;

import io.github.ixico.chesstournament.api.dto.tournament.TournamentDto;
import io.github.ixico.chesstournament.api.dto.tournament.TournamentDtoLite;
import io.github.ixico.chesstournament.api.request.TournamentCreateRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

public interface TournamentApi {

    String BASE_PATH = "/tournament";

    @GetMapping
    List<TournamentDtoLite> list();

    @GetMapping("/{id}")
    TournamentDto getById(@PathVariable UUID id);

    @PostMapping
    TournamentDto create(@NotNull @Valid @RequestBody TournamentCreateRequest request);

}
