package com.doc.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * Represents a required document for a product based on region (state/central/international).
 */
@Entity
@Table(name = "corp_reqdoc")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequiredDocuments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rdid")
    private Long id;

    @Column(name = "nm", nullable = false)
    private String name;

    @Column(name = "desc", length = 1000)
    private String description;

    @Column(name = "tp", nullable = false)
    private String type;

    @Column(name = "ctry")
    private String country; // For International

    @Column(name = "cname")
    private String centralName; // For Central Govt level

    @Column(name = "sname")
    private String stateName; // For State level

    @Column(name = "isd", nullable = false)
    private boolean isDeleted = false;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "cdt", updatable = false)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "udt")
    private Date updatedDate;





}
