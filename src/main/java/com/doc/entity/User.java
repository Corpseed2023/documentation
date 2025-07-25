package com.doc.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Date;
import java.util.List;

/**
 * Represents an internal user with roles, departments, and product access.
 */
@Entity
@Table(name = "corp_usr")
@Data
@NoArgsConstructor(force = true)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid")
    private Long id;

    //

    @Column(name = "fn", nullable = false)
    private String fullName;

    @NonNull
    @Column(name = "em", nullable = false, unique = true)
    private String email;

    @Column(name = "mob", length = 20)
    private String contactNo;

    @Lob
    @Column(name = "pp")
    private String profilePhoto;

    @NonNull
    @Column(name = "desg", nullable = false)
    private String designation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usrdid")
    private Designation userDesignation;

    @NonNull
    @Column(name = "dept", nullable = false)
    private String department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usrdeptid")
    private Department userDepartment;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "corp_usr_role",
            joinColumns = @JoinColumn(name = "usrid", referencedColumnName = "uid"),
            inverseJoinColumns = @JoinColumn(name = "rid", referencedColumnName = "rid")
    )
    private List<Role> userRole;

    @Column(name = "eid", unique = true)
    private String employeeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mid")
    private User manager;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "corp_usr_prd",
            joinColumns = @JoinColumn(name = "usrid", referencedColumnName = "uid"),
            inverseJoinColumns = @JoinColumn(name = "prid", referencedColumnName = "id")
    )
    private List<Product> userProduct;

    @Column(name = "isd", nullable = false)
    private boolean isDeleted = false;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "cdt", updatable = false)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "udt")
    private Date updatedDate;

}
