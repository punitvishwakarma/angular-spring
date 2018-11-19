package com.punit.angular.controller;

import com.google.gson.Gson;
import com.punit.angular.domain.UserDetails;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    public List<UserDetails> userDetailsList = new ArrayList<UserDetails>();

    @RequestMapping(value = "/userdetails", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<UserDetails> GetUserdetails() {
        userDetailsList.add(new UserDetails("User1", "Mechanical"));
        userDetailsList.add(new UserDetails("User2", "Electrical"));
        System.out.println("tseststst");
        return userDetailsList;
    }

    @RequestMapping(value = "/userdetails_two", method = RequestMethod.GET)
    @ResponseBody
    public String GetUserdetailsTwo() {
        userDetailsList.add(new UserDetails("User1", "Mechanical"));
        userDetailsList.add(new UserDetails("User2", "Electrical"));
        Gson g = new Gson();
        return g.toJson(userDetailsList);
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView("UserManagement");
        System.out.println("tseststst");
        return mav;
    }

    @RequestMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public List<UserDetails> ProcessUser(@RequestBody UserDetails userDetails) {
        boolean nameExist = false;

        for (UserDetails ud : userDetailsList) {
            if (ud.getName().equals(userDetails.getName())) {
                nameExist = true;
                ud.setDepartment(userDetails.getDepartment());
                break;
            }
        }
        if (!nameExist) {
            userDetailsList.add(userDetails);
        }

        return userDetailsList;
    }

    @RequestMapping(value = "/deleteuser", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
    public ResponseEntity DeleteUser(@RequestBody UserDetails userDetails) {
        Iterator<UserDetails> it = userDetailsList.iterator();
        while (it.hasNext()) {
            UserDetails ud = (UserDetails) it.next();
            if (ud.getName().equals(userDetails.getName())) {
                it.remove();
            }
        }
        return new ResponseEntity(HttpStatus.OK);
    }
}
