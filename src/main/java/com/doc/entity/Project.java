package com.doc.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import java.time.LocalDate;
import java.util.Date;

/**
 * Represents a client project entity in the documentation system.
 * Obfuscated table and column names are used to provide additional security against direct DB inspection.
 */
@Entity
@Table(name = "corp_pjx")
@Getter
@Setter
@NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pid")
    @Comment("Primary Key: Unique identifier for the project")
    private Long id;

    @Column(name = "pn_nme", nullable = false)
    @Comment("Project Name")
    private String name;

    @Column(name = "pno", nullable = false, unique = true)
    @Comment("Unique Project Number")
    private String projectNo;

    @Column(name = "amt", nullable = false)
    @Comment("Total Project Amount")
    private String amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "spid")
    @Comment("Sales Executive assigned to the project")
    private User salesPerson;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "papid")
    @Comment("User who approved payment")
    private User paymentApprovedBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prid")
    @Comment("Product associated with the project")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ctid")
    @Comment("Contact person for the project")
    private Contact contact;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmpid")
    @Comment("Company associated with the project")
    private Company company;

    @Column(name = "lid")
    @Comment("Lead ID from lead service")
    private Long leadId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "cdt", updatable = false)
    @Comment("Created Date")
    private Date createdDate;

    private LocalDate date;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "udt")
    @Comment("Updated Date")
    private Date updatedDate;

    @Column(name = "cb")
    @Comment("Created By User ID")
    private Long createdBy;

    @Column(name = "ub")
    @Comment("Updated By User ID")
    private Long updatedBy;

    @Column(name = "isd", nullable = false)
    @Comment("Is Deleted flag (soft delete)")
    private boolean isDeleted = false;

    @Column(name = "ia", nullable = false)
    @Comment("Is Active flag")
    private boolean isActive = true;

    @Column(name = "ads", length = 1000)
    @Comment("Project Address")
    private String address;

    @Column(name = "cty")
    @Comment("City")
    private String city;

    @Column(name = "st")
    @Comment("State")
    private String state;

    @Column(name = "cnt")
    @Comment("Country")
    private String country;

    @Column(name = "ppc")
    @Comment("Primary Postal Code")
    private String primaryPinCode;









}
