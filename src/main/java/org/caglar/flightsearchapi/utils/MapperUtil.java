package org.caglar.flightsearchapi.utils;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.record.RecordModule;

public class MapperUtil {
    private MapperUtil(){}
    static ModelMapper mapper;

    static {
        mapper = new ModelMapper().registerModule(new RecordModule());
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
    }

    public static  <T> T map(Object obj, Class<T> target){
        return mapper.map(obj, target);
    }
}
