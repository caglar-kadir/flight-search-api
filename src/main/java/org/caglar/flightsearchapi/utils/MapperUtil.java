package org.caglar.flightsearchapi.utils;

import org.modelmapper.ModelMapper;

public class MapperUtil {
    private MapperUtil(){}

    public static MapperUtil instance(){
        return new MapperUtil();
    }
    ModelMapper mapper = new ModelMapper();

    public <T> T map(Object obj, Class<T> target){
        return this.mapper.map(obj, target);
    }
}
