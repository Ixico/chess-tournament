package io.github.ixico.chesstournament.api.exception;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class ResourceNotFoundException extends RuntimeException {

    public static ResourceNotFoundException withId(@NotNull UUID id) {
        return new ResourceNotFoundException();
        // todo: consider parameterized exceptions and its messages
    }
}
