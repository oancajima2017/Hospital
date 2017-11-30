/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.controlador;

import entity.Ubigeo;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Araveli Araujo
 */
@Stateless
public class UbigeoFacade extends AbstractFacade<Ubigeo> {

    @PersistenceContext(unitName = "HospitalVGPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UbigeoFacade() {
        super(Ubigeo.class);
    }
    
    public List<Ubigeo> listarDepartamentos() {
        List<Ubigeo> lista = new ArrayList<>();
        String jpql = "select u from Ubigeo u";
        Query q = em.createQuery(jpql);
        List<Ubigeo> todos = q.getResultList();
        String listaDptos = "";
        for (Ubigeo ubi : todos) {
            String nombreDpto = ubi.getDpto();
            if (listaDptos.indexOf(nombreDpto) < 0) {// No s eencuentra
                listaDptos += nombreDpto + "-";
                lista.add(ubi);
            }
        }
        return lista;
    }
    
    
      public List<Ubigeo> listarProvincias(Ubigeo dptoSeleccionado) {
        List<Ubigeo> lista = new ArrayList<>();
        String jpql = "select u from Ubigeo u "
                + "where u.dpto = :dpto";
        Query q = em.createQuery(jpql);
        q.setParameter("dpto", dptoSeleccionado.getDpto());
        List<Ubigeo> todos = q.getResultList();
        String listaProvs = "";
        for (Ubigeo ubi : todos) {
            String nombreProv = ubi.getProv();
            if (listaProvs.indexOf(nombreProv) < 0){// No s eencuentra
                listaProvs += nombreProv + "-";
                lista.add(ubi);
            }
        }
        return lista;
    }
    public List<Ubigeo> listarDistritos(Ubigeo provSeleccionada) {
        List<Ubigeo> lista = null;
        String jpql = "select u from Ubigeo u "
                + "where u.prov = :prov";
        Query q = em.createQuery(jpql);
        q.setParameter("prov", provSeleccionada.getProv());
        lista = q.getResultList();
        return lista;
    }

}
