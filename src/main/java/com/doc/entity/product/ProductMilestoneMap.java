package com.doc.entity.product;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product_milestone_map")
@Getter
@Setter
@NoArgsConstructor
public class ProductMilestoneMap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "milestone_id")
    private MilestoneType milestoneType;

    @Column(name = "step_order")
    private int order; // 1 = First, 2 = Second, etc.

    @Column(name = "tat_override")
    private Integer customTatInDays;

}
