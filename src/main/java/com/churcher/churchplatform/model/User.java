package com.churcher.churchplatform.model;

import com.churcher.churchplatform.enums.UserStatus;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String secondName;
    private String phoneNumber;
    private String mail;
    private String login;
    private String password;
    private String token;
    @Enumerated
    private UserStatus userStatus;
    @OneToOne
    @Cascade(org.hibernate.annotations.CascadeType.PERSIST)
    @JoinColumn(name = "USERADDRESS_ID")
    private UserAddress userAddress;
    @OneToMany(mappedBy = "user")
    private List<UserDay> userDayList;
    @ManyToOne
    @JoinColumn(name = "CHURCH_ID")
    private Church church;
}
