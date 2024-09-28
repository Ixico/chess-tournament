package io.github.ixico.chesstournament.service.db.repository;

import io.github.ixico.chesstournament.api.exception.ResourceNotFoundException;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.lang.NonNull;

import java.util.UUID;

@NoRepositoryBean
public interface CommonRepository<T> extends JpaRepository<T, UUID> {

    @NonNull
    default T getById(@NotNull @NonNull UUID id) {
        return findById(id).orElseThrow(() -> ResourceNotFoundException.withId(id));
    }

}
