package io.github.ixico.chesstournament.service.db.repository;

import io.github.ixico.chesstournament.service.db.model.Tournament;
import jakarta.validation.constraints.NotNull;

public interface TournamentRepository extends CommonRepository<Tournament> {

    boolean existsByName(@NotNull String name);

}
