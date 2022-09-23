package com.spring.data.jpa.tutorial.entity;

import lombok.*;
import org.hibernate.annotations.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.transaction.Transactional;

@Getter
@Setter
@Entity
@Transactional
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "check_up")

@SQLDelete(sql = "UPDATE check_up SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
//@FilterDef(name = "deletedProductFilter", parameters = @ParamDef(name = "isDeleted", type = "boolean"))
//@Filter(name = "deletedProductFilter", condition = "deleted = :isDeleted")
public class CheckUpRq extends CheckUpRs{


    private String name;
    private String identity_number;
    private String address;
    private String complaint;
    private String phone_number;

    private Status status;
    private boolean deleted = false;


}
