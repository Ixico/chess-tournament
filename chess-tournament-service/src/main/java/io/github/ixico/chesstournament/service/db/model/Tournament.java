package io.github.ixico.chesstournament.service.db.model;

import io.github.ixico.chesstournament.api.dto.tournament.TournamentDto;
import io.github.ixico.chesstournament.api.dto.tournament.TournamentDtoLite;
import io.github.ixico.chesstournament.api.dto.tournament.TournamentStatus;
import io.github.ixico.chesstournament.api.request.TournamentCreateRequest;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tournament {

    @Id
    @GeneratedValue
    private UUID id;

    @NotNull
    private String name;

    @NotNull
    private Integer rounds;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TournamentStatus status;

    public static Tournament of(@NotNull @Valid TournamentCreateRequest request) {
        return Tournament.builder()
                .name(request.getName())
                .rounds(request.getRounds())
                .status(TournamentStatus.SCHEDULED)
                .build();
    }

    public TournamentDto toDto() {
        return TournamentDto.builder()
                .id(id)
                .name(name)
                .rounds(rounds)
                .status(status)
                .build();
    }

    public TournamentDtoLite toDtoLite() {
        return TournamentDtoLite.builder()
                .id(id)
                .name(name)
                .rounds(rounds)
                .status(status)
                .build();
    }

}
