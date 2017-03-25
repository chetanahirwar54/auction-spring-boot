package com.example.lots;

import com.example.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Yurii on 21.03.2017.
 */
@RestController
public class LotController {



    @Autowired
    private LotService lotService;


    /*get all lots for one seller*/
    @RequestMapping("/users/{username}/lots")
    public List<Lot> getAllUserLots(@PathVariable String username){
        return lotService.getAllUserLots(username);
    }


    /*get all lots from DB*/
    @RequestMapping("/lots")
    public List<Lot> getAllLots(){
        return lotService.getAllLots();
    }

    /*get all lots from DB in sorted by price*/
    @RequestMapping("/lots/sort")
    public List<Lot> getAllSortedLots(){
        return lotService.getAllSortedLots();
    }



    /*get all lots from DB by topic*/
    @RequestMapping("/lots/{topicName}")
    public List<Lot> getAllLotsByTopic(@PathVariable String topicName){
        return lotService.getAllLotsByTopic(topicName);
    }



    /*get one lot for one seller*/
    @RequestMapping("/users/{username}/lots/{id}")
    public Lot getLot(@PathVariable String id){
        return lotService.getLot(id);
    }


    @RequestMapping(method= RequestMethod.POST, value = "/users/{username}/lots")
    public void addLot(@RequestBody Lot lot, @PathVariable String username){
        lot.setSeller(new User(username,"","", "",0));
        lotService.addLot(lot);
    }


    @RequestMapping(method= RequestMethod.PUT, value = "/users/{username}/lots/{id}")
    public void updateLot(@RequestBody Lot lot, @PathVariable String username,@PathVariable String id){
        lot.setSeller(new User(username,"","", "",0));
        lotService.updateLot(lot);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{username}/lots/{id}")
    public void  deleteLot(@PathVariable String id){
        lotService.deleteLot(id);
    }

}
