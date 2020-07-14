package com.kamlesh.springbootswagger2.resource;

import com.kamlesh.springbootswagger2.models.Contact;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@RestController
public class AddressBookResource {

    ConcurrentHashMap<String, Contact> contacts = new ConcurrentHashMap<String, Contact>();

    @RequestMapping("/{id}")
    public Contact getContact(@PathVariable String id){
        return contacts.get(id);
    }

    @RequestMapping("/")
    public List<Contact> getAllContacts(){
        return new ArrayList<Contact>(contacts.values());
    }

    @PostMapping("/")
    public Contact addContact(@RequestBody Contact contact){
        contacts.put(contact.getId(), contact);
        return contact;
    }
}
