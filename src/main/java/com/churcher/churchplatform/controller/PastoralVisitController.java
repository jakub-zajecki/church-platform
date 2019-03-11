package com.churcher.churchplatform.controller;

import com.churcher.churchplatform.model.PastoralVisit;
import com.churcher.churchplatform.service.PastoralVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Controller
public class PastoralVisitController {

    private PastoralVisitService pastoralVisitService;

    @Autowired
    public PastoralVisitController(PastoralVisitService pastoralVisitService) {
        this.pastoralVisitService = pastoralVisitService;
    }

//    @GetMapping("/setPastoralVisit")
//    public String pastoralVisitEditPage(){
//
//        PastoralVisit pastoralVisit =
//
//        return "setPastoralVisit";
//    }
//
//    @PostMapping("/savePastoralVisit")
//    public String savePastoralVisit{
//        pastoralVisitService.save();
//    }

}
