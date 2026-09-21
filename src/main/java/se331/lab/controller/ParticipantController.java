package se331.lab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import se331.lab.entity.Participant;
import se331.lab.service.ParticipantService;
import se331.lab.util.LabMapper;

@RestController
@RequiredArgsConstructor
public class ParticipantController {
    final ParticipantService participantService;

    @GetMapping("/participants")
    public ResponseEntity<?> getParticipants() {
        return ResponseEntity.ok(LabMapper.INSTANCE
                .getParticipantWithEventsDTO(participantService.getAllParticipant()));
    }

    @GetMapping("/participants/{id}")
    public ResponseEntity<?> getParticipant(@PathVariable("id") Long id) {
        Participant output = participantService.getParticipant(id);
        if (output != null) {
            return ResponseEntity.ok(LabMapper.INSTANCE.getParticipantWithEventsDTO(output));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }
}
