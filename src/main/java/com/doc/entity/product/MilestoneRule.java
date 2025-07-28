
package com.doc.entity.product;

import com.doc.entity.Department;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "milestone_rule")
@Getter
@Setter
@NoArgsConstructor
public class MilestoneRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "milestone_id")
    private MilestoneType milestoneType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_id")
    private Department department;

    @Column(name = "tat_hours")
    private int tatHours; // SLA deadline in hours

    @Column(name = "strict_approval")
    private boolean strictApproval; // true if approval is mandatory

    @Column(name = "allow_rollback")
    private boolean allowRollback;

    @Column(name = "max_attempts")
    private int maxAttempts; // max retry for disapproval

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", updatable = false)
    private Date createdDate = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_date")
    private Date updatedDate;
}