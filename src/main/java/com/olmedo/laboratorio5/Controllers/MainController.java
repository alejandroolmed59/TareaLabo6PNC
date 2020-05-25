package com.olmedo.laboratorio5.Controllers;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


import com.olmedo.laboratorio5.Dao.EstudianteDAO;
import com.olmedo.laboratorio5.Domain.Contribuyente;
import com.olmedo.laboratorio5.Domain.Estudiante;
import com.olmedo.laboratorio5.Domain.Importancia;
import com.olmedo.laboratorio5.Service.ContribuyenteService;
import com.olmedo.laboratorio5.Service.EstudianteService;
import com.olmedo.laboratorio5.Service.EstudianteServiceImp;
import com.olmedo.laboratorio5.Service.ImportanciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@Controller
public class MainController {
    @Autowired
    private EstudianteService estudianteService;

    @Autowired
    private ImportanciaService importanciaService;

    @Autowired
    private ContribuyenteService contribuyenteService;

    @RequestMapping("/listado")
    public ModelAndView listado() {
        return auxVerLista();
    }

    @RequestMapping("/inicio")
    public ModelAndView inicio(){
        ModelAndView mav = new ModelAndView();
        List<Importancia> importanciaList = new ArrayList<>();
        try{
            importanciaList = importanciaService.findAll();
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        mav.addObject("contribuyente",new Contribuyente());
        mav.addObject("importanciaList", importanciaList);
        mav.setViewName("index");
        return mav;
    }
    @RequestMapping("/form")
    public ModelAndView form(@Valid @ModelAttribute Contribuyente contribuyente, BindingResult result){
        ModelAndView mav = new ModelAndView();
        try {
            contribuyenteService.insertarContribuyente(contribuyente);
            mav.setViewName("exito");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }


    public ModelAndView auxVerLista(){
        ModelAndView mav = new ModelAndView();
        List<Contribuyente> contribuyentes = null;
        List<String> fechas = null;
        try{
            contribuyentes = contribuyenteService.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        //  for (Contribuyente c: contribuyentes){
          //  fechas.add(formatter.format(c.getF_fecha_ingreso()));
        //}
        //mav.addObject("fechas", fechas);
        mav.addObject("contribuyentes", contribuyentes);
        mav.setViewName("listado");
        return mav;
    }

}