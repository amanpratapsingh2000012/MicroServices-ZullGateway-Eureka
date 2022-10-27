package com.tcs.spring.OrderModel;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data  
@AllArgsConstructor  
@NoArgsConstructor
@Entity
@Table
public class Orders {
	@Id
    @Column(name="ORDER_ID")
    private int id;

    @Column(name="ORDER_NAME")
    private String name;

    @Column(name ="ORDER_DESCRIPTION")
    private String description;

    @Column(name ="ORDER_PATIENT_AGE")
    private int patientId;

    @Column(name ="ORDER_PATIENT_NAME")
    private String patientName;
}
