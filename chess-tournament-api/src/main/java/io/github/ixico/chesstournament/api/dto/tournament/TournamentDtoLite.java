package io.github.ixico.chesstournament.api.dto.tournament;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class TournamentDtoLite {

    UUID id;

    String name;

    Integer rounds;

    TournamentStatus status;

}
