package com.backend.bart.controllers;

import com.backend.bart.dao.GlassDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BartController {

    @Autowired
    private GlassDao glassDao;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "api/glass/{qi}/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Map> getGlass(@PathVariable Long qi, @PathVariable Long id){
        Map<String, ArrayList<List>> map = new HashMap<String, ArrayList<List>>();
        ArrayList<List> msg = new ArrayList<>();
        ArrayList<String> text = new ArrayList<>();
        List<Map> lista = new ArrayList<>();
        if(id<=0 || id>5){
            text.add("El id de pila esta fuera de rango");
            msg.add(text);
            map.put("Error",msg);
            lista.add(map);
            return lista;
        }else{
            map = glassDao.getGlass(qi,id);
            lista.add(map);
            return lista;
        }

    }

}
