package com.doruvarga.springpostgresql.Controller;


import com.doruvarga.springpostgresql.Ex.ExceptieMissingElm;
import com.doruvarga.springpostgresql.Model.Outfit;
import com.doruvarga.springpostgresql.Model.Shoe;
import com.doruvarga.springpostgresql.Repository.OutfitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class OutfitController {

    @Autowired
    private OutfitRepository outfitRepository;

    @GetMapping("/Outfits")
    public List<Outfit> getAllTheOutfits() {

        return this.outfitRepository.findAll();

    }

  
    @GetMapping("/Outfits/{id}")
    public ResponseEntity<Outfit> getOutfitsById(@PathVariable(value = "id") int outfitsId) throws ExceptieMissingElm {

        Outfit outfit = outfitRepository.findById(outfitsId).orElseThrow(() -> new ExceptieMissingElm("Outfit not found for this id : " + outfitsId));

        return ResponseEntity.ok().body(outfit);
    }


    
    @PostMapping("Outfits")
    
    public Outfit createOutfits(@RequestBody Outfit outfits) {

        return outfitRepository.save(outfits);
    }


    @PutMapping("/Outfits/{id}")
    public ResponseEntity<Outfit> updateOutfits(@PathVariable(value = "id") int outfitId,
                                            @Valid @RequestBody Map<String, String> outfitDetails)
            throws ExceptieMissingElm {


        Outfit outfits = outfitRepository.findById(outfitId)
                .orElseThrow(() -> new ExceptieMissingElm("Outfit not found for this id :: " + outfitId));

        outfits.setTshirt(outfitDetails.get("tshirt"));


        return ResponseEntity.ok(this.outfitRepository.save(outfits));

    }

    @DeleteMapping("/Outfits/{id}")
    public Map<String, Boolean> deleteShoe(@PathVariable(value = "id") int outfitId) throws ExceptieMissingElm {

        Outfit outfits = outfitRepository.findById(outfitId)
                .orElseThrow(() -> new ExceptieMissingElm("Outfit not found for this id :" + outfitId));

        this.outfitRepository.delete(outfits);

        Map<String, Boolean> responce = new HashMap<String, Boolean>();
        responce.put("delete", Boolean.TRUE);

        return responce;


    }

}
