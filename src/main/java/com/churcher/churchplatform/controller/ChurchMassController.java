package com.churcher.churchplatform.controller;

import com.churcher.churchplatform.dto.LoggedUser;
import com.churcher.churchplatform.dto.UserDto;
import com.churcher.churchplatform.enums.DayType;
import com.churcher.churchplatform.enums.Holidays;
import com.churcher.churchplatform.model.*;
import com.churcher.churchplatform.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class ChurchMassController {

    private ChurchService churchService;
    private NormalDayMassTimeService normalDayMassTimeService;
    private HolidayMassTimeService holidayMassTimeService;
    private CalendarService calendarService;
    private PriestService priestService;
    private ChurchDayService churchDayService;


    @Autowired
    public ChurchMassController(ChurchService churchService, NormalDayMassTimeService normalDayMassTimeService, HolidayMassTimeService holidayMassTimeService, CalendarService calendarService, PriestService priestService, ChurchDayService churchDayService) {
        this.churchService = churchService;
        this.normalDayMassTimeService = normalDayMassTimeService;
        this.holidayMassTimeService = holidayMassTimeService;
        this.calendarService = calendarService;
        this.priestService = priestService;
        this.churchDayService = churchDayService;
    }





    @GetMapping("/church-setmass")
    public String showChurchGeneralMassSettings(Model model){

        model.addAttribute("church",churchService.findChurchById(1L));
        model.addAttribute("masslistNormal",churchService.findChurchById(1L).getNormalChurchDayList());
        model.addAttribute("masslistHoliday",churchService.findChurchById(1L).getHolidayChurchDayList());
        model.addAttribute("priestList",churchService.findChurchById(1L).getPriestList());
        model.addAttribute("priest",new Priest());

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

    @PostMapping("/add-priest")
    public String addPriest(@ModelAttribute Priest priest,Authentication authentication){

//        LoggedUser loggedUser = (LoggedUser) authentication.getPrincipal();
//        UserDto userDto = loggedUser.getUser();
//        Church church = userDto.getChurch();

        Church church = churchService.findChurchById(1L);
        priest.setChurch(church);
        priestService.savePriest(priest);


        return "redirect:/church-setmass";
    }

    @PostMapping("/delate-priest")
    public String delatePriest(@RequestParam Long id){

        priestService.delatePriest(id);


        return "redirect:/church-setmass";
    }

    @GetMapping("/setmass-priest")
    public String setMassLeaderPriest(Model model, Authentication authentication,@RequestParam(required = false) String prev,@RequestParam(required = false) String next){

        LocalDate localDate;

        if(next == null && prev == null){
            localDate = LocalDate.now();
        }else if(next != null){
            localDate = LocalDate.parse(next).plusDays(1);
        }else {
            localDate = LocalDate.parse(prev).minusDays(1);
        }

        Map<LocalDate, Holidays> holidaysMap = calendarService.createHolidays(localDate.getYear());

        boolean isHoliday = holidaysMap.containsKey(localDate);

        List<? extends DefaultMassTime> listDefaultMassTime = null;

        ChurchDay churchDay = churchDayService.findByLocalDateAndChurchId(localDate,1L);
        if(churchDay == null){
            if(isHoliday){
                listDefaultMassTime = churchService.findChurchById(1L).getHolidayChurchDayList();
            } else {
                listDefaultMassTime = churchService.findChurchById(1L).getNormalChurchDayList();
            }
        }

//        LoggedUser loggedUser = (LoggedUser) authentication.getPrincipal();
//        UserDto userDto = loggedUser.getUser();
//
//        List<NormalDayMassTime> listNormalMassTimeList = userDto.getChurch().getNormalChurchDayList();
//        List<HolidayMassTime> listHolidayMassTime = userDto.getChurch().getHolidayChurchDayList();

//        churchDay = new ChurchDay();
//
//        Mass mass = new Mass();
//        mass.setMassTime(LocalTime.now());
//        List<Mass> lisadsad = new ArrayList<>();
//        lisadsad.add(mass);
//
//        churchDay.setMassList(lisadsad);

        Church church = churchService.findChurchById(1L);

        model.addAttribute("priestList", church.getPriestList());
        model.addAttribute("day",localDate);
        model.addAttribute("massTimeList", listDefaultMassTime);
        model.addAttribute("churchDay", churchDay );

        return "setmass-priest";
    }


}
