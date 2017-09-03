package com.alessandra.controller;

import com.alessandra.PikminQuality;
import com.alessandra.entity.Pikmin;
import com.alessandra.respository.PikminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@RequestMapping("pikmin")
public class PikminController {

    @Autowired
    private PikminRepository pikminRepository;

    @RequestMapping("/save")
    @Transactional
    public String process() {
        pikminRepository.save(new Pikmin(PikminQuality.ELECTRICITY, "Yellow", 30));
        return "Done";
    }

    @RequestMapping("/find/{id}")
    @Transactional
    public String find(@PathVariable("id") Integer id) {
        return pikminRepository.findById(id).toString();
    }

    @RequestMapping("/findAll")
    @Transactional
    public String findAll() {
        StringBuilder result = new StringBuilder();
        for (Pikmin pikmin : pikminRepository.findAll()) {
            result.append(pikmin.toString()).append("\n");
        }
        return result.toString();
    }

}
