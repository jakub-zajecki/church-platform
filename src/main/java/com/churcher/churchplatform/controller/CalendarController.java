package com.churcher.churchplatform.controller;

import com.churcher.churchplatform.service.CalendarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class CalendarController {

    private CalendarService calendarService;

    public CalendarController(CalendarService calendarService) {
        this.calendarService = calendarService;
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
}
