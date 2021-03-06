package com.churcher.churchplatform.model;

import com.churcher.churchplatform.enums.ChurchStatus;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Church {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "church")
    private List<NormalDayMassTime> normalChurchDayList;
    @OneToMany(mappedBy = "church")
    private List<HolidayMassTime> holidayChurchDayList;
    private Integer maxNumNormalChurchDayIntentions;
    private Integer maxNumHolidayChurchDayIntentions;
    private String churchName;
    private String parsonName;
    @Enumerated(EnumType.STRING)
    private ChurchStatus churchStatus;
    private String officeOpenHours;
    private String churchToken;
    @OneToOne
    @Cascade(org.hibernate.annotations.CascadeType.PERSIST)
    @JoinColumn(name = "ADDRESS_ID")
    private Address address;
    @OneToMany(mappedBy = "church")
    private List<User> userList ;
    @OneToMany(mappedBy = "church")
    private List<ChurchDay> churchDayList;
    @OneToMany(mappedBy = "church")
    private List<Priest> priestList;
    private BigDecimal minIntencionCost;

    public Long getId() {
        return id;
    }

    public List<NormalDayMassTime> getNormalChurchDayList() {
        return normalChurchDayList;
    }

    public void setNormalChurchDayList(List<NormalDayMassTime> normalChurchDayList) {
        this.normalChurchDayList = normalChurchDayList;
    }

    public List<HolidayMassTime> getHolidayChurchDayList() {
        return holidayChurchDayList;
    }

    public void setHolidayChurchDayList(List<HolidayMassTime> holidayChurchDayList) {
        this.holidayChurchDayList = holidayChurchDayList;
    }

    public String getChurchToken() {
        return churchToken;
    }

    public void setChurchToken(String churchToken) {
        this.churchToken = churchToken;
    }

    public int getMaxNumNormalChurchDayIntentions() {
        return maxNumNormalChurchDayIntentions;
    }

    public void setMaxNumNormalChurchDayIntentions(int maxNumNormalChurchDayIntentions) {
        this.maxNumNormalChurchDayIntentions = maxNumNormalChurchDayIntentions;
    }

    public int getMaxNumHolidayChurchDayIntentions() {
        return maxNumHolidayChurchDayIntentions;
    }

    public void setMaxNumHolidayChurchDayIntentions(int maxNumHolidayChurchDayIntentions) {
        this.maxNumHolidayChurchDayIntentions = maxNumHolidayChurchDayIntentions;
    }

    public String getChurchName() {
        return churchName;
    }

    public void setChurchName(String churchName) {
        this.churchName = churchName;
    }

    public String getParsonName() {
        return parsonName;
    }

    public void setParsonName(String parsonName) {
        this.parsonName = parsonName;
    }

    public String getOfficeOpenHours() {
        return officeOpenHours;
    }

    public void setOfficeOpenHours(String officeOpenHours) {
        this.officeOpenHours = officeOpenHours;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public ChurchStatus getChurchStatus() {
        return churchStatus;
    }

    public void setChurchStatus(ChurchStatus churchStatus) {
        this.churchStatus = churchStatus;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<ChurchDay> getChurchDayList() {
        return churchDayList;
    }

    public void setChurchDayList(List<ChurchDay> churchDayList) {
        this.churchDayList = churchDayList;
    }

    public BigDecimal getMinIntencionCost() {
        return minIntencionCost;
    }

    public void setMinIntencionCost(BigDecimal minIntencionCost) {
        this.minIntencionCost = minIntencionCost;
    }

    public List<Priest> getPriestList() {
        return priestList;
    }

    public void setPriestList(List<Priest> priestList) {
        this.priestList = priestList;
    }
}
