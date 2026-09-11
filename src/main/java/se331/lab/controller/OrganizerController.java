package se331.lab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import se331.lab.entity.Organizer;
import se331.lab.service.OrganizerService;


import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrganizerController {
    final OrganizerService organizerService;
    @GetMapping("organizers")
    public ResponseEntity<?> getOrganizerLists(@RequestParam(value = "_limit", required = false)Integer perPage
            ,@RequestParam(value = "_page", required = false)Integer page) {
        List<Organizer> output = null;
        Integer organizeSize = organizerService.getOrgSize();
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(organizeSize));
        try {
            output = organizerService.getOrg(perPage, page);
            return ResponseEntity.ok().headers(responseHeader).body(output);
        }catch (IndexOutOfBoundsException ex){
            return  ResponseEntity.ok().headers(responseHeader).body(output);
        }


    }


    @GetMapping("organizers/{id}")
    public ResponseEntity<?> getOrganize(@PathVariable("id") Long id) {
        Organizer output = organizerService.getOrg(id);
        if (output != null ){
            return ResponseEntity.ok(output);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The given id is not found");
        }
    }


}



