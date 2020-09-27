package com.visitlog.visitlog.Model;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Table
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@SequenceGenerator(name = "Today_Seq",
        sequenceName = "Today_Seq_GEN",
        initialValue = 1
)
public class Today {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Today_Seq_GEN")
    private Long id;

    private String fromUrl;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @ManyToOne(cascade = CascadeType.ALL,optional = false)
    @JoinColumn(name = "total_id")
    private Total total;
}