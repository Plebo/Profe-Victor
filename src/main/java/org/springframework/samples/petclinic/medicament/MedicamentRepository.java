/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.samples.petclinic.medicament;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Isaac
 */
public interface MedicamentRepository extends Repository<Medicament, Integer>{
    
    /**
     * Retrieve an {@link Medicamenr} from the data store by id.
     * @param id the id to search for
     * @return the {@link Medicament} if found
     */
    @Query("SELECT medicament FROM Medicament medicament WHERE medicament.id =:id")
    @Transactional(readOnly = true)
    Medicament findById(@Param("id") Integer id);
    
    /**
     * Save an {@link Medicament} to the data store, either inserting or updating it.
     * @param medicament the {@link Medicament} to save
     */
    void save(Medicament medicament);
}
