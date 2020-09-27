package com.visitlog.visitlog.Model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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
public class Total {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "BadgeId_GEN")
    private long id;

    private String url;

    private long count;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTime;

    @OneToMany(mappedBy = "total",fetch = FetchType.LAZY)
    List<Today> todayList;

}