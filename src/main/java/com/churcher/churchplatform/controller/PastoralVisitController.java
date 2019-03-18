package com.churcher.churchplatform.controller;

import com.churcher.churchplatform.service.PastoralVisitService;
import com.sun.javafx.collections.MappingChange;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.RequestWrapper;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Controller
public class PastoralVisitController {

    private PastoralVisitService pastoralVisitService;

    @Autowired
    public PastoralVisitController(PastoralVisitService pastoralVisitService) {
        this.pastoralVisitService = pastoralVisitService;
    }

    @GetMapping("/setPastoralVisit")
    public String pastoralVisitEditPage(){

//        PastoralVisit pastoralVisit =
        return "setPastoralVisit";
    }

    @GetMapping("/json")
    public String jsonTest(){
        return "test";
    }

    @PostMapping("/json2")
    public String addNewWorker(@RequestParam(name = "pastoralVisit") String name, Model model) {
        Map<LocalDate, Set<String>> pastoral = new HashMap<>();
        try {
            JSONObject object = new JSONObject(name);
            JSONArray array = object.getJSONArray("dates");
            for(int i = 0; i < array.length(); i++){
                JSONObject jsob = array.getJSONObject(i);
                String stringDate = jsob.get("date").toString();
                LocalDate date = LocalDate.of(Integer.valueOf(stringDate.substring(0,4)), Integer.valueOf(stringDate.substring(5,7)), Integer.valueOf(stringDate.substring(8,10)));
                JSONArray ar = jsob.getJSONArray("streets");
                for(int j = 0; j < ar.length(); j++){
                    Set<String> set = new HashSet<>();
                    set
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return "json2";
    }


//    @PostMapping("/savePastoralVisit")
//    public String savePastoralVisit{
//        pastoralVisitService.save();
//    }

}
