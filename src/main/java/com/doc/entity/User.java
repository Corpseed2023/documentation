package com.doc.entity;

import com.doc.entity.product.Product;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
@Entity
@Table(name = "corp_usr")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fn", nullable = false)
    private String fullName;

    @Column(name = "em", nullable = false, unique = true)
    private String email;

    @Column(name = "mob", length = 20)
    private String contactNo;

    @Column(name = "desg", nullable = false)
    private String designation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usrdid")
    private Designation userDesignation;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_department_map",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "dept_id", referencedColumnName = "id")
    )
    private List<Department> departments;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_product_map",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id")
    )
    private List<Product> userProducts;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "cdt", updatable = false)
    private Date createdDate = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "udt")
    private Date updatedDate;

    @Column(name = "isd", nullable = false)
    private boolean isDeleted = false;
}