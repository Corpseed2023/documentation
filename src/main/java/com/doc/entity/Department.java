package com.doc.entity;

import com.doc.entity.product.DepartmentMilestoneMap;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "corp_dept")
@Getter
@Setter
@NoArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nm", nullable = false, unique = true)
    private String name;

    @Column(name = "isd", nullable = false)
    private boolean isDeleted = false;

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<DepartmentMilestoneMap> milestoneMappings;

    @ManyToMany(mappedBy = "departments", fetch = FetchType.LAZY)
    private List<User> users;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "corp_dept_desg",
            joinColumns = @JoinColumn(name = "deptid", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "desgid", referencedColumnName = "id")
    )
    private List<Designation> designations;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "cdt", updatable = false)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "udt")
    private Date updatedDate;
}