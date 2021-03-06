package com.doruvarga.springpostgresql.Controller;


import com.doruvarga.springpostgresql.Ex.ExceptieMissingElm;
import com.doruvarga.springpostgresql.Model.Shoe;
import com.doruvarga.springpostgresql.Repository.ShoeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ShoeController {

    @Autowired
    private ShoeRepository shoeRepository;


    @GetMapping("/shoes")
    public List<Shoe> getAllTheShoes() {

        
        return this.shoeRepository.findAll();

    }

  
    @GetMapping("/shoes/{id}")
    public ResponseEntity<Shoe> getShoeById(@PathVariable(value = "id") int shoesId) throws ExceptieMissingElm {

        Shoe shoe = shoeRepository.findById(shoesId).orElseThrow(() -> new ExceptieMissingElm("Shoe not found for this id :: " + shoesId));

        return ResponseEntity.ok().body(shoe);
    }

   
    @PostMapping("shoes")
 
    public Shoe ceateShoe(@RequestBody Shoe shoes) {

        return shoeRepository.save(shoes);
    }

 
    @PutMapping("shoes/{id}")
    public ResponseEntity<Shoe> updateShoes(@PathVariable(value = "id") int shoesId,
                                            @Valid @RequestBody Map<String, String> shesDetails)
            throws ExceptieMissingElm {


        Shoe shoes = shoeRepository.findById(shoesId)
                .orElseThrow(() -> new ExceptieMissingElm("Shoe not found for this id : " + shoesId));

        shoes.setModelName(shesDetails.get("modelName"));
        shoes.setBrandName(shesDetails.get("brandName"));
        shoes.setTypeName(shesDetails.get("typeName"));

        return ResponseEntity.ok(this.shoeRepository.save(shoes));

    }

    @DeleteMapping("/shoes/{id}")
    public Map<String, Boolean> deleteShoe(@PathVariable(value = "id") int shoesId) throws ExceptieMissingElm {

        Shoe shoes = shoeRepository.findById(shoesId)
                .orElseThrow(() -> new ExceptieMissingElm("Shoe not found for this id :: " + shoesId));

        this.shoeRepository.delete(shoes);

        Map<String, Boolean> responce = new HashMap<String, Boolean>();
        responce.put("delete", Boolean.TRUE);

        return responce;


    }


}
