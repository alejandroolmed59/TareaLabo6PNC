package com.olmedo.laboratorio5.Service;


import com.olmedo.laboratorio5.Dao.ImportanciaDao;

import com.olmedo.laboratorio5.Domain.Importancia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImportanciaServiceImp implements ImportanciaService{
    @Autowired
    ImportanciaDao importanciaDao;

    public List<Importancia> findAll() throws DataAccessException {
        return importanciaDao.findAll();
    }
}
