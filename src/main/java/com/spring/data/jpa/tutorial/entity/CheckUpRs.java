package com.spring.data.jpa.tutorial.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.util.Date;
import javax.persistence.*;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)

public class CheckUpRs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Temporal(TemporalType.DATE)
    @CreatedDate
    protected Date create_at;

    @Column(name= "created_by")
    @CreatedBy
    protected String created_by;

    @Temporal(TemporalType.DATE)
    @LastModifiedDate
    @Column(name= "updated_at")
    protected Date updated_at;

}
