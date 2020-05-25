package com.olmedo.laboratorio5.Dao;


import com.olmedo.laboratorio5.Domain.Importancia;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ImportanciaDAOImp implements ImportanciaDao {
    @PersistenceContext(unitName = "laboratorio5")
    private EntityManager entityManager;

    @Override
    public List<Importancia> findAll() throws DataAccessException {
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT * FROM public.importancia");
        Query query = entityManager.createNativeQuery(sb.toString(), Importancia.class);
        List <Importancia> resulset = query.getResultList();
        return resulset;
    }
}
