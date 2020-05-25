package com.olmedo.laboratorio5.Dao;


import com.olmedo.laboratorio5.Domain.Importancia;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ImportanciaDao {
    public List<Importancia> findAll() throws DataAccessException;
}
