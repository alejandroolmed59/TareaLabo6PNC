package com.olmedo.laboratorio5.Dao;


import com.olmedo.laboratorio5.Domain.Contribuyente;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ContribuyenteDAOImp implements ContribuyenteDAO {
    @PersistenceContext(unitName = "laboratorio5")
    private EntityManager entityManager;

    @Override
    @Transactional
    public void insertarContribuyente(Contribuyente contribuyente) throws DataAccessException {
        entityManager.persist(contribuyente);
    }
    @Override
    public List<Contribuyente> findAll() throws DataAccessException {
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT * FROM public.contribuyente");
        Query query = entityManager.createNativeQuery(sb.toString(), Contribuyente.class);
        List <Contribuyente> resulset = query.getResultList();
        return resulset;
    }
}
