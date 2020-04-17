package com.demo.api.services;

import com.demo.api.entity.EntityWithUUID;
import lombok.SneakyThrows;
import org.jeasy.random.EasyRandom;
import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

@Service
public class DataFillerService {
    @Autowired
    private Map<String, CrudRepository> repositories;

    @SneakyThrows
    @PostConstruct
    @Transactional
    public void fillData() {
        Reflections reflections = new Reflections("com.demo.api");
        Set<Class<? extends EntityWithUUID>> entityClasses = reflections.getSubTypesOf(EntityWithUUID.class);
        EasyRandom easyRandom = new EasyRandom();

        ArrayList<String> entityNames = new ArrayList<>();

        for(Class<? extends EntityWithUUID> obj : entityClasses) {
            entityNames.add(obj.getSimpleName().toLowerCase());
        }

        for(Class<? extends EntityWithUUID> obj : entityClasses) {
            String repoName = obj.getSimpleName().toLowerCase().concat("Repository");
            if (repositories.containsKey(repoName)) {
                for (int i = 0; i < 10; i++) {
                    ArrayList<String> entityFields = getEntityField(obj.getDeclaredFields(), entityNames);

                    EntityWithUUID tempObj = easyRandom.nextObject(obj);

                    if(entityFields.size() > 0){
                        for(String fld : entityFields){
                            Field entityField = tempObj.getClass().getDeclaredField(fld);
                            entityField.setAccessible(true);
                            repositories.get(fld + "Repository").save(entityField.get(tempObj));
                        }
                    }

                    repositories.get(repoName).save(tempObj);
                }
            }
        }
    }

    private ArrayList<String> getEntityField(Field[] declaredFields, ArrayList<String> entityNames) {
        ArrayList<String> entityFields = new ArrayList<>();
        for(Field fld: declaredFields){
            if(entityNames.contains(fld.getName())){
                entityFields.add(fld.getName());
            }
        }
        return entityFields;
    }
}
