package hk.jud.app.lyo.controller.publicapi;

import hk.jud.app.lyo.dto.GuestDto;
import hk.jud.app.lyo.service.GuestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/public/guests")
@RequiredArgsConstructor
public class GuestController {

    private final GuestService guestService;



    @GetMapping("/{uid}")
    public ResponseEntity<GuestDto> getGuestByUid(@PathVariable String uid) {
        try {
            GuestDto guestDto = guestService.getGuestByUid(uid);
            return ResponseEntity.ok(guestDto);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/email/{email}")
    public ResponseEntity<GuestDto> getGuestByEmail(@PathVariable String email) {
        try {
            GuestDto guestDto = guestService.findGuestByEmail(email);
            return ResponseEntity.ok(guestDto);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}