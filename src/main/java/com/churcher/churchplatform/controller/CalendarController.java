package com.churcher.churchplatform.controller;

import com.churcher.churchplatform.enums.DayType;
import com.churcher.churchplatform.model.Church;
import com.churcher.churchplatform.model.ChurchDay;
import com.churcher.churchplatform.model.DefaultMassTime;
import com.churcher.churchplatform.model.NormalDayMassTime;
import com.churcher.churchplatform.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CalendarController {

    private CalendarService calendarService;
    private ChurchDayService churchDayService;
    private ChurchService churchService;
    private HolidayMassTimeService holidayMassTimeService;
    private NormalDayMassTimeService normalDayMassTimeService;

    @Autowired
    public CalendarController(CalendarService calendarService, ChurchDayService churchDayService, ChurchService churchService, HolidayMassTimeService holidayMassTimeService, NormalDayMassTimeService normalDayMassTimeService) {
        this.calendarService = calendarService;
        this.churchDayService = churchDayService;
        this.churchService = churchService;
        this.holidayMassTimeService = holidayMassTimeService;
        this.normalDayMassTimeService = normalDayMassTimeService;
    }

    @GetMapping("/calendar")
    public String showMonth(Model model, @RequestParam(required = false) Integer month, @RequestParam(required = false) Integer year){
        if(month == null){
            month = LocalDate.now().getMonthValue();
        }
        if(year == null){
            year = LocalDate.now().getYear();
        }
        if(month <= 0){
            month = 12;
            year = year - 1;
        }
        if(month > 12){
            month = 1;
            year = year + 1;
        }
        model.addAttribute("month", calendarService.getMonth(month, year));
        model.addAttribute("holidays", calendarService.createHolidays(year));
        return "calendar";
    }

    @GetMapping("/dayPage")
    public String addIntentionPage(Model model, @RequestParam(name="date") String date, @RequestParam("churchId") Long churchId,
                                   @RequestParam("dayType") DayType dayType){

        LocalDate localDate = LocalDate.parse(date);
        ChurchDay day = churchDayService.churchDayBuilder(localDate, churchId, dayType);
        Church church = churchService.findChurchById(churchId);

        List<? extends DefaultMassTime> timelist;
        if(dayType == DayType.NORMAL){
            timelist = church.getNormalChurchDayList();
        } else {
            timelist = church.getHolidayChurchDayList();
        }

        model.addAttribute("church", church);
        model.addAttribute("churchDay", day);
        model.addAttribute("timeList", timelist);
        return "dayPage";
    }
}