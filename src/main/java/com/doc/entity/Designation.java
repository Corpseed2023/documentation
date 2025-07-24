package com.doc.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * Represents a designation or title within a department.
 */
@Entity
@Table(name = "corp_desg")
@Getter
@Setter
@NoArgsConstructor
public class Designation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nm", nullable = false, unique = true)
    private String name;

    @Column(name = "wt")
    private Long weightValue;

    @Column(name = "isd", nullable = false)
    private boolean isDeleted = false;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "cdt", updatable = false)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "udt")
    private Date updatedDate;
}
