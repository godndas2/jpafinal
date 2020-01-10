package org.jpa.study.entity.zipcode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Column(name = "zip_code", nullable = false)
    private String zipCode;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;
}
