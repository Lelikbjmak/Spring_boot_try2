package com.example.try2.Controllers;

import com.example.try2.Entities.Contact;
import com.example.try2.Entities.ContactDetails;
import com.example.try2.Repositories.ContactDetailRep;
import com.example.try2.Repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/Contacts")
public class ContactController {

    @Autowired
    ContactRepository contactRepository;

    @Autowired
    ContactDetailRep contactDetailRep;

    @PostMapping("add")
    public String add(@RequestBody Contact contact){
        try {
            contactRepository.save(contact);
            return "Success!";
        }catch (Exception ex){
            return "Error!";
        }
    }

    @GetMapping("all")
    public Iterable<Contact> all(){
        return contactRepository.findAll();
    }

    @GetMapping("alldetil")
    public Iterable<ContactDetails> det(){
        return contactDetailRep.findAll();
    }

    @PostMapping("addetail")
    public String adddetail(@RequestBody ContactDetails contactDetails){
        try {
            contactDetailRep.save(contactDetails);
            return "success!";
        }catch (Exception exception){
            return "error";
        }
    }

    @Transactional
    @PostMapping("op")
    public String ad(@RequestBody ContactDetails contactDetails, @RequestBody Contact contact){
        contactRepository.save(contact);
        System.out.println("Contact saved...");
        contactDetailRep.save(contactDetails);
        System.out.println("Details saved...");

        return "Success!";
    }
}
