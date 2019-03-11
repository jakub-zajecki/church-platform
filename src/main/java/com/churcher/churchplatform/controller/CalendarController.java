package com.churcher.churchplatform.controller;

import com.churcher.churchplatform.converter.DefaultMassTimeConverter;
import com.churcher.churchplatform.dto.MassTimeDto;
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
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Controller
public class CalendarController {

    private CalendarService calendarService;
    private ChurchDayService churchDayService;
    private ChurchService churchService;
    private DefaultMassTimeConverter defaultMassTimeConverter;

    @Autowired
    public CalendarController(CalendarService calendarService, ChurchDayService churchDayService, ChurchService churchService, DefaultMassTimeConverter defaultMassTimeConverter) {
        this.calendarService = calendarService;
        this.churchDayService = churchDayService;
        this.churchService = churchService;
        this.defaultMassTimeConverter = defaultMassTimeConverter;
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

        List<MassTimeDto> massTimeDtos = new ArrayList<>();

        timelist.forEach(time -> massTimeDtos.add(defaultMassTimeConverter.defaultMassTimeToMassTimeDto(time, day.getId(), dayType)));
        massTimeDtos.sort(Comparator.comparing(MassTimeDto::getMassTime));

        model.addAttribute("church", church);
        model.addAttribute("minIntentionCost", church.getMinIntencionCost());
        model.addAttribute("churchDay", day);
        model.addAttribute("timeList", massTimeDtos);
        return "dayPage";
    }
}