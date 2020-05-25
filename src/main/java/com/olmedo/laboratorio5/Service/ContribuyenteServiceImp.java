package com.olmedo.laboratorio5.Service;


import com.olmedo.laboratorio5.Dao.ContribuyenteDAO;
import com.olmedo.laboratorio5.Domain.Contribuyente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
       // DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        //LocalDateTime now = LocalDateTime.now();
        //System.out.println(dtf.format(now));

        contribuyente.setF_fecha_ingreso(new Date());
        contribuyenteDAO.insertarContribuyente(contribuyente);
    }
    public List<Contribuyente> findAll() throws DataAccessException{
        return contribuyenteDAO.findAll();
    }
}
