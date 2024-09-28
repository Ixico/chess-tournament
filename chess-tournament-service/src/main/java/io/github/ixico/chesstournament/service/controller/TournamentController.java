package io.github.ixico.chesstournament.service.controller;

import io.github.ixico.chesstournament.api.dto.tournament.TournamentDto;
import io.github.ixico.chesstournament.api.dto.tournament.TournamentDtoLite;
import io.github.ixico.chesstournament.api.http.TournamentApi;
import io.github.ixico.chesstournament.api.request.TournamentCreateRequest;
import io.github.ixico.chesstournament.service.service.TournamentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(TournamentApi.BASE_PATH)
@RequiredArgsConstructor
public class TournamentController implements TournamentApi {

    private final TournamentService tournamentService;

    @Override
    public List<TournamentDtoLite> list() {
        return tournamentService.list();
    }

    @Override
    public TournamentDto getById(UUID id) {
        return tournamentService.getById(id);
    }

    @Override
    public TournamentDto create(TournamentCreateRequest request) {
        return tournamentService.create(request);
    }

}
