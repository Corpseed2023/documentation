package com.doc.entity;

import com.doc.entity.product.MilestoneType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

import org.hibernate.annotations.Comment;

import java.time.LocalDate;

/**
 * Represents a milestone in a specific project lifecycle,
 * such as Documentation, Audit, Filing, etc.
 */
@Entity
@Table(name = "corp_pjm")
@Getter
@Setter
@NoArgsConstructor
public class ProjectMilestone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("Primary key for project milestone")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pjid", nullable = false)
    @Comment("Reference to the parent project")
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mid", nullable = false)
    @Comment("Reference to milestone master (e.g. Documentation, Audit)")
    private MilestoneType milestoneType;

    @Column(name = "ord", nullable = false)
    @Comment("Order of execution for milestones (1=first, 2=second...)")
    private Integer milestoneOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assignee_id")
    @Comment("User assigned to perform this milestone")
    private User assignedTo;

    @Column(name = "tat")
    @Comment("Expected completion date (TAT)")
    private LocalDate tatDeadline;

    @Column(name = "sts")
    @Comment("Status: PENDING, IN_PROGRESS, COMPLETED, REJECTED")
    private String status = "PENDING";

    @Column(name = "rms", length = 1000)
    @Comment("Remarks or notes")
    private String remarks;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "cdt", updatable = false)
    private Date createdDate = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "udt")
    private Date updatedDate;

    @Column(name = "isd", nullable = false)
    private boolean isDeleted = false;

    public enum MilestoneStatus {
        PENDING,
        IN_PROGRESS,
        COMPLETED,
        REJECTED,
        ROLLED_BACK,
        ESCALATED
    }

}
