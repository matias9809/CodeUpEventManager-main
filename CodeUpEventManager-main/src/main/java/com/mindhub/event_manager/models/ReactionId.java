package com.mindhub.event_manager.models;

import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
@Getter
public class ReactionId implements Serializable {

    private UUID customerId;
    private UUID eventId;

    // Constructor vacío necesario para JPA
    public ReactionId() {
    }

    public ReactionId(UUID customerId, UUID eventId) {
        this.customerId = customerId;
        this.eventId = eventId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReactionId that = (ReactionId) o;
        return Objects.equals(customerId, that.customerId) &&
                Objects.equals(eventId, that.eventId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, eventId);
    }
}
