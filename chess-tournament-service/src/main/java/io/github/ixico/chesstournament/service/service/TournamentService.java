package io.github.ixico.chesstournament.service.service;

import io.github.ixico.chesstournament.api.dto.tournament.TournamentDto;
import io.github.ixico.chesstournament.api.dto.tournament.TournamentDtoLite;
import io.github.ixico.chesstournament.api.request.TournamentCreateRequest;
import io.github.ixico.chesstournament.service.db.model.Tournament;
import io.github.ixico.chesstournament.service.db.repository.TournamentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class TournamentService {

    private final TournamentRepository tournamentRepository;

    public List<TournamentDtoLite> list() {
        return tournamentRepository.findAll().stream().map(Tournament::toDtoLite).toList();
    }

    public TournamentDto getById(UUID id) {
        return tournamentRepository.getById(id).toDto();
    }

    public TournamentDto create(TournamentCreateRequest request) {
        if (tournamentRepository.existsByName(request.getName())) {
            throw new RuntimeException(); // todo: custom exception
        }
        return tournamentRepository.save(Tournament.of(request)).toDto();
    }

}
