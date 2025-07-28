package com.doc.entity.product;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "milestone_type")
@Getter
@Setter
@NoArgsConstructor
public class MilestoneType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name; // e.g., "Documentation", "Audit", etc.

    @OneToMany(mappedBy = "milestone", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<DepartmentMilestoneMap> departmentMappings;

    @OneToMany(mappedBy = "milestoneType", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MilestoneRule> rules;
}