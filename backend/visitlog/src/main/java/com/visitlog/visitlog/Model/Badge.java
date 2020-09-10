package com.visitlog.visitlog.Model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
@SequenceGenerator(
        name = "BadgeId_GEN",
        sequenceName = "BadgeId",
        initialValue = 1
)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Badge {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "BadgeId_GEN")
    private long id;

    private String url;

    private long count;
}