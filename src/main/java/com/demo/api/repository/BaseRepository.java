package com.demo.api.repository;

import com.demo.api.entity.BaseEntity;
import com.demo.api.tools.ConfigPropertyHelper;

public interface BaseRepository<T extends BaseEntity> {
    default T testFunction(){
        ConfigPropertyHelper.getProperty("endpoints.mocked");
        System.out.println("Here");
        return null;
    }
}
