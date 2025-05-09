package hk.jud.app.lyo.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GuestDto {

    private String uid;
    private String name;
    private String emailAddr;
    private String rsvpType;
    private String lastUpdateId;
    private LocalDateTime lastUpdateTime;
    private GuestQrCodeDto guestQrCode;
}