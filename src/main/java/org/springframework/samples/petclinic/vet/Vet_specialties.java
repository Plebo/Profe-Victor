/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.samples.petclinic.vet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import org.springframework.samples.petclinic.model.BaseEntity;


/**
 *
 * @author Jose Pablo
 */
@Entity
@Table(name = "vet_specialties")
public class Vet_specialties extends BaseEntity{
    
//    @Column(name = "vet_id")
//    @NotEmpty    
//    private String vet_id;
//    
//    @Column(name = "specialty_id")
//    @NotEmpty    
//    private String specialty_id;
//
//    public String getVet_id() {
//        return vet_id;
//    }
//
//    public void setVet_id(String vet_id) {
//        this.vet_id = vet_id;
//    }
//
//    public String getSpecialty_id() {
//        return specialty_id;
//    }
//
//    public void setSpecialty_id(String specialty_id) {
//        this.specialty_id = specialty_id;
//    }
//    
    
}
