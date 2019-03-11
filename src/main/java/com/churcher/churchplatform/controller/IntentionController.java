package com.churcher.churchplatform.controller;

import com.churcher.churchplatform.enums.DayType;
import com.churcher.churchplatform.model.ChurchDay;
import com.churcher.churchplatform.model.Intention;
import com.churcher.churchplatform.model.Mass;
import com.churcher.churchplatform.service.ChurchDayService;
import com.churcher.churchplatform.service.IntentionService;
import com.churcher.churchplatform.service.MassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.time.LocalTime;

@Controller
public class IntentionController {

    private ChurchDayService churchDayService;
    private MassService massService;
    private IntentionService intentionService;

    @Autowired
    public IntentionController(ChurchDayService churchDayService, MassService massService, IntentionService intentionService) {
        this.churchDayService = churchDayService;
        this.massService = massService;
        this.intentionService = intentionService;
    }

    @PostMapping("/saveIntention")
    public String saveIntention(@ModelAttribute ChurchDay churchDay, @RequestParam LocalTime time,
                                @RequestParam String intentionText, @RequestParam BigDecimal intentionCost){
        churchDayService.save(churchDay);
        Mass mass = massService.createMass(time, churchDay.getId());

        DayType dayType = churchDay.getDayType();
        int maxIntentionNumber = dayType == DayType.NORMAL ? churchDay.getChurch().getMaxNumNormalChurchDayIntentions() :
                churchDay.getChurch().getMaxNumHolidayChurchDayIntentions();
        mass.setMaxIntesionNum(maxIntentionNumber);

        massService.save(mass);
        Intention intention = intentionService.createIntention(intentionText, intentionCost);
        intention.setMass(mass);
        intentionService.save(intention);
        return "redirect:/calendar";
    }

}
