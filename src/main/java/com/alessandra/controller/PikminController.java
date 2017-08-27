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
    public String process() {
        pikminRepository.save(new Pikmin(PikminQuality.FIRE, "Red", 10));
        return "Done";
    }

    @RequestMapping("/find/{id}")
    @Transactional
    public String find(@PathVariable("id") Integer id) {
        Pikmin pikmin = pikminRepository.findById(id);
        return String.format("%s: %s %s %s", pikmin.getId(), pikmin.getColor(), pikmin.getQuality(), pikmin.getTossDistance());
    }

}
