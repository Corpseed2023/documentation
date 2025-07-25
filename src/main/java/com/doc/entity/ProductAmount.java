package com.doc.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * Represents the fee/amount structure for a product (e.g., Filing, Government Fee, etc.)
 */
@Entity
@Table(name = "corp_prdamt")
@Getter
@Setter
@NoArgsConstructor
public class ProductAmount {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paid")
    private Long id;

    @Column(name = "nm", nullable = false)
    private String name; // e.g., Filing Fee, Govt Fee

    @Column(name = "fee", nullable = false)
    private int fees;

    @Column(name = "hsn", length = 20)
    private String hsnNo;

    @Column(name = "isd", nullable = false)
    private boolean isDeleted = false;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "cdt", updatable = false)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "udt")
    private Date updatedDate;



}

