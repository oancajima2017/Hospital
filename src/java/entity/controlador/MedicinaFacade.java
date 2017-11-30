/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.controlador;

import entity.Medicina;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Araveli Araujo
 */
@Stateless
public class MedicinaFacade extends AbstractFacade<Medicina> {

    @PersistenceContext(unitName = "HospitalVGPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MedicinaFacade() {
        super(Medicina.class);
    }
    
}
