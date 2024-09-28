package io.github.ixico.chesstournament.api.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Value;

@Value
public class TournamentCreateRequest {

    @NotNull
    String name;

    @NotNull
    @Positive
    Integer rounds;

}
