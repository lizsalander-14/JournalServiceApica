package com.user.entity;

import com.user.model.UserActionType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "JOURNAL")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class Journal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ACTION_TYPE")
    @Enumerated(EnumType.STRING)
    private UserActionType actionType;

    @Column(name = "USER_DETAILS")
    private String userDetails;

    @Column(name = "CREATED_ON")
    @CreationTimestamp
    private Timestamp createdOn;
}
