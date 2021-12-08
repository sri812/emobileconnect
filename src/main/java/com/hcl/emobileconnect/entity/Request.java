package com.hcl.emobileconnect.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "request")
@Getter
@Setter
@ToString
public class Request {

    @Id
    private Integer requestId;
    private Integer customerId;
    private Integer planId;
    private Long mobileNumber;
    private String status;
    private String comments;

}
