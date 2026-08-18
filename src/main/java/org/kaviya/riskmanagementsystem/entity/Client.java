package org.kaviya.riskmanagementsystem.entity;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Table(name = "clients")
@Getter
public class Client {

    @Id
    @Column(name = "client_id")
    private Long clientId;

    @Column(name = "client_name")
    private String clientName;

    @Column(name = "client_type")
    private String clientType;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
