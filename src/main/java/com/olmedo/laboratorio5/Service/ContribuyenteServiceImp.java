package com.olmedo.laboratorio5.Service;


import com.olmedo.laboratorio5.Dao.ContribuyenteDAO;
import com.olmedo.laboratorio5.Domain.Contribuyente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class ContribuyenteServiceImp implements ContribuyenteService {
    @Autowired
    ContribuyenteDAO contribuyenteDAO;

    @Transactional
    public void insertarContribuyente(Contribuyente contribuyente) throws DataAccessException {
        Date obj = new Date();
        java.sql.Date sqlDate = new java.sql.Date(obj.getTime());
        contribuyente.setF_fecha_ingreso(sqlDate);
        contribuyenteDAO.insertarContribuyente(contribuyente);
    }
    public List<Contribuyente> findAll() throws DataAccessException{
        return contribuyenteDAO.findAll();
    }
}
