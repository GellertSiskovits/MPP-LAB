package controller;

import model.Proba;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.IProbaService;
import service.ProbaService;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    private IProbaService probaService;

    //add new
    @PostMapping("/proba")
    public ResponseEntity<?> save(@RequestBody Proba proba){
        long id = probaService.save(proba);
        return ResponseEntity.ok().body("New Concurent added to proba");
    }

    //get by probaname
    @GetMapping("/proba/{probaName}")
    public ResponseEntity<Proba> get(@PathVariable("probaName") String probaName){
        Proba proba = probaService.get(probaName);
        return ResponseEntity.ok().body(proba);
    }

    //get all
    @GetMapping("/proba")
    public ResponseEntity<List<Proba>> list(){
        List<Proba> probe = probaService.list();
        return ResponseEntity.ok().body(probe);
    }

    //update
    @PutMapping("/probe/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Proba proba){
        probaService.update(id,proba);
        return ResponseEntity.ok().body("Proba has been updated successfully.");
    }

    //delete
    @DeleteMapping("/probe/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        probaService.deleter(id);
        return ResponseEntity.ok().body("Proba has been deleted successfully.");
    }

}
