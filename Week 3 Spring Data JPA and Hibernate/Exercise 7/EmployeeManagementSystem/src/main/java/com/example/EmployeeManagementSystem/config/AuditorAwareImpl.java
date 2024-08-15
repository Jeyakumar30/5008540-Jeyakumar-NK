package com.example.EmployeeManagementSystem.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        // Return the current user's username. For now, returning a default value.
        return Optional.of("defaultUser");
    }
}