package hk.jud.app.lyo.service;

import hk.jud.app.lyo.dto.GuestDto;
import hk.jud.app.lyo.dto.GuestQrCodeDto;
import hk.jud.app.lyo.entity.Guest;
import hk.jud.app.lyo.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Service
public class GuestService {

	private static final Logger logger = LoggerFactory.getLogger(GuestService.class);
	
    private final GuestRepository guestRepository;

    @Autowired
    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public GuestDto findGuestByEmail(String email) {
        Optional<Guest> guest = guestRepository.findByEmail(email);
        if (guest.isEmpty()) {
            throw new EntityNotFoundException("Guest not found with email: " + email);
        }
        GuestDto dto = new GuestDto();
        dto.setName(guest.get().getName());
        dto.setEmailAddr(guest.get().getEmailAddr());
        return dto;
    }
    
    
    public GuestDto getGuestByUid(String uid) {
    	logger.info("Fetching guest with UID: {}", uid);
    	
    	
        Guest guest = guestRepository.findByUid(uid)
                .orElseThrow(() -> new EntityNotFoundException("Guest not found with UID: " + uid));

        GuestQrCodeDto qrCodeDto = null;
        if (guest.getGuestQrCode() != null) {
            qrCodeDto = new GuestQrCodeDto(
                    guest.getGuestQrCode().getQrCode(),
                    guest.getGuestQrCode().getQrCode2(),
                    guest.getGuestQrCode().getActiveInd()
            );
        }

        return new GuestDto(
                guest.getUid(),
                guest.getName(),
                guest.getEmailAddr(),
                guest.getRsvpType(),
                guest.getLastUpdateId(),
                guest.getLastUpdateTime(),
                qrCodeDto
        );
    }
}