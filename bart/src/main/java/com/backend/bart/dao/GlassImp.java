package com.backend.bart.dao;

import com.backend.bart.models.Glass;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.util.ArrayUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class GlassImp implements GlassDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Map<String, ArrayList<List>> getGlass(Long qi, Long id) {
        int[] primeNumbers = new int[]{ 2,3,5,7,11,13,17};
        ArrayList<String> b = new ArrayList<>();
        ArrayList<List> uniform = new ArrayList<>();
        ArrayList<String> data = new ArrayList<>();
        ArrayList<List> notUniform = new ArrayList<>();
        ArrayList<List> response = new ArrayList<>();
        ArrayList<List> initialArray = new ArrayList<>();
        Map<String, ArrayList<List>> map = new HashMap<String, ArrayList<List>>();
        Glass glass = entityManager.find(Glass.class,id);
        String query = "FROM Glass WHERE id = :id ";
        List<Glass> resultado = entityManager.createQuery(query)
                .setParameter("id", id)
                .getResultList();
        initialArray.add(resultado);
        Glass glass1 = resultado.get(0);
        String array = glass1.getArray();
        String[] arrayGlass = new String[6];
        arrayGlass = array.split(",");

        for(int i=0; i<qi; i++){

            for (int j=arrayGlass.length-1; j>=0; j--){
                if(Integer.parseInt(arrayGlass[j]) % primeNumbers[i] == 0){
                    b.add(arrayGlass[j]);
                }else{
                    data.add(arrayGlass[j]);
                }
            }
            arrayGlass = new String[data.size()];

            for(int n=0; n< data.size(); n++){
                arrayGlass[n]=data.get(n);
            }

            notUniform.add(data);
            uniform.add(b);
            response.add(uniform.get(i));
            data = new ArrayList<>();
            b = new ArrayList<>();

        }
        response.add(notUniform.get(notUniform.size()-1));
        map.put("A",initialArray);
        map.put("B",uniform);
        map.put("Ai", notUniform);
        map.put("respuesta", response);

        return map;

    }

}
