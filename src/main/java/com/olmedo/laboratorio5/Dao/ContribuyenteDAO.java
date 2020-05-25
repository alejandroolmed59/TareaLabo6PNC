package com.olmedo.laboratorio5.Dao;


import com.olmedo.laboratorio5.Domain.Contribuyente;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface ContribuyenteDAO {
    public void insertarContribuyente(Contribuyente contribuyente) throws DataAccessException;
    public List<Contribuyente> findAll() throws DataAccessException;

}
