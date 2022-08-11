package com.example.try2.Entities;

import jakarta.persistence.*;

@Entity
public class ContactDetails {
    private int id;
    private String phonenumber;
    private String phonetype;

    private int contact_id;

    private Contact contact;

    public ContactDetails(String s, String home, int i) {
        this.contact_id = i;
        this.phonenumber = s;
        this.phonetype = home;
    }

    @Column(name = "contact_id_fk", nullable = false, updatable = false, insertable = false)  // we will add a foreign key on this col
    public int getContact_id() {
        return contact_id;
    }

    public void setContact_id(int contact_id) {
        this.contact_id = contact_id;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @OneToOne
    @JoinColumn(name = "contact_id_fk", referencedColumnName = "conId")
    public Contact getContact() {
        return contact;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "phone")
    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    @Column(name = "phone_type")
    public String getPhonetype() {
        return phonetype;
    }

    public void setPhonetype(String phonetype) {
        this.phonetype = phonetype;
    }
}
