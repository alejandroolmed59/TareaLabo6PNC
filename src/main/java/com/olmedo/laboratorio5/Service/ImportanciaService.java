package com.olmedo.laboratorio5.Service;


import com.olmedo.laboratorio5.Domain.Importancia;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface ImportanciaService {
    public List<Importancia> findAll() throws DataAccessException;
}
