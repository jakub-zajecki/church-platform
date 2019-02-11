package com.churcher.churchplatform.controller;

import com.churcher.churchplatform.enums.DayType;
import com.churcher.churchplatform.model.Church;
import com.churcher.churchplatform.service.ChurchService;
import com.churcher.churchplatform.service.HolidayMassTimeService;
import com.churcher.churchplatform.service.NormalDayMassTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalTime;

@Controller
public class ChurchMassController {

    private ChurchService churchService;
    private NormalDayMassTimeService normalDayMassTimeService;
    private HolidayMassTimeService holidayMassTimeService;


    @Autowired
    public ChurchMassController(ChurchService churchService,NormalDayMassTimeService normalDayMassTimeService,HolidayMassTimeService holidayMassTimeService ) {
        this.churchService = churchService;
        this.normalDayMassTimeService = normalDayMassTimeService;
        this.holidayMassTimeService = holidayMassTimeService;
    }


    @GetMapping("/church-setmass")
    public String showChurchGeneralMassSettings(Model model){


        model.addAttribute("church",churchService.findChurchById(1L));
        model.addAttribute("masslistNormal",churchService.findChurchById(1L).getNormalChurchDayList());
        model.addAttribute("masslistHoliday",churchService.findChurchById(1L).getHolidayChurchDayList());

    return "church-setmass";
    }

    @PostMapping("/save-mass")
    public String saveMassInfo(@ModelAttribute Church church){

        Church church1 = churchService.findChurchById(1L);
        church1.setMaxNumHolidayChurchDayIntentions(church.getMaxNumHolidayChurchDayIntentions());
        church1.setMaxNumNormalChurchDayIntentions(church.getMaxNumNormalChurchDayIntentions());

        churchService.saveChurch(church1);


        return "church-setmass";
    }

    @PostMapping("/delate-masshournormal")
    public String delateMassHourNormalDay(@RequestParam(name = "id") Long id){


    normalDayMassTimeService.delateNormalDayMassTime(id);

        return "redirect:/church-setmass";
    }

    @PostMapping("/delate-masshourholiday")
    public String delateMassHourHoliday(@RequestParam(name = "id") Long id){


        holidayMassTimeService.delateHolidayMassTime(id);

        return "redirect:/church-setmass";
    }

    @PostMapping("/add-massTime")
    public String addMassHourHoliday(@RequestParam DayType dayType, @RequestParam LocalTime localTime){

        if(dayType == DayType.HOLIDAY){
            holidayMassTimeService.saveHolidayTimeMass(holidayMassTimeService.createHolidayMassTime(localTime,churchService.findChurchById(1L)));
        }else {
            normalDayMassTimeService.saveNormalDayMassTime(normalDayMassTimeService.createNormalDayMassTime(localTime,churchService.findChurchById(1L)));
        }


        return "redirect:/church-setmass";
    }
}
