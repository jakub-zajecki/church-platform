package com.churcher.churchplatform.controller;

import com.churcher.churchplatform.enums.DayType;
import com.churcher.churchplatform.model.Church;
import com.churcher.churchplatform.model.ChurchDay;
import com.churcher.churchplatform.model.NormalDayMassTime;
import com.churcher.churchplatform.service.CalendarService;
import com.churcher.churchplatform.service.ChurchDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CalendarController {

    private CalendarService calendarService;
    private ChurchDayService churchDayService;

    @Autowired
    public CalendarController(CalendarService calendarService, ChurchDayService churchDayService) {
        this.calendarService = calendarService;
        this.churchDayService = churchDayService;
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

        System.out.println(day.getDayType());
        System.out.println(day.getLocalDate());

        Church church = new Church();
        church.setChurchName("Parafia");
        model.addAttribute("churchName", church.getChurchName());

        List<NormalDayMassTime> list = new ArrayList<>();

        NormalDayMassTime d1 = new NormalDayMassTime();
        d1.setChurch(church);
        d1.setMassTime(LocalTime.of(10, 0));
        NormalDayMassTime d2 = new NormalDayMassTime();
        d2.setChurch(church);
        d2.setMassTime(LocalTime.of(13, 0));
        NormalDayMassTime d3 = new NormalDayMassTime();
        d3.setChurch(church);
        d3.setMassTime(LocalTime.of(17, 0));
        list.add(d1);
        list.add(d2);
        list.add(d3);

        model.addAttribute("timeList", list);
        return "dayPage";
    }
}