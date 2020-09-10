package com.visitlog.visitlog.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table
@SequenceGenerator(
        name = "BadgeId_GEN",
        sequenceName = "BadgeId",
        initialValue = 1
)
public class RequestBadge {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "BadgeId_GEN")
    private long id;

    private String url;

    private long count;
}