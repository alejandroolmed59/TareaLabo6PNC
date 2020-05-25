package com.olmedo.laboratorio5.Service;

import com.olmedo.laboratorio5.Domain.Contribuyente;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface ContribuyenteService {
    public void insertarContribuyente(Contribuyente contribuyente) throws DataAccessException;
    public List<Contribuyente> findAll() throws DataAccessException;
}
