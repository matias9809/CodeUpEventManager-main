package com.mindhub.event_manager.models;

import com.mindhub.event_manager.enums.ReactionType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class Reaction {
//@EmbeddedId
//@Setter(AccessLevel.NONE)
//private CustomerPk customerPk;
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private UUID id;

@ManyToOne
private Event event;

@ManyToOne
private Customer customer;

private ReactionType typeReaction;

public Reaction() {
    }

//public Reaction(CustomerPk customerPk, TypeReaction typeReaction) {
//    this.customerPk = customerPk;
//    this.typeReaction = typeReaction;
//}
public Reaction(ReactionType typeReaction) {

    this.typeReaction = typeReaction;
}

    public ReactionType getTypeReaction() {
        return typeReaction;
    }
}
