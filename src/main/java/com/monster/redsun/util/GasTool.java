package com.monster.redsun.util;

import com.monster.redsun.entity.Gas;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class GasTool {

    public static void updateMap(Gas gas, Map<String, Object> map){

        Calendar calendar = Calendar.getInstance();
        if(gas.getYear() >= calendar.get(Calendar.YEAR) && gas.getMonth() >= calendar.get(Calendar.MONTH)){
            int currentNum = (int)map.get(gas.getYear().toString());
            map.put(String.valueOf(gas.getYear()),currentNum+1);
        }else{
            int currentNum = (int)map.get("other");
            map.put("other",currentNum+1);
        }


    };

}
