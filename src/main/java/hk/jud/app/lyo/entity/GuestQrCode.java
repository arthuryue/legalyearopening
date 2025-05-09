package hk.jud.app.lyo.entity;
// Entity: guest_qr_code

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "guest_qr_code")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
// CONSTRAINT `check_not_null` CHECK (((`guest_int_seq` is not null) or (`reply_personal_guest_int_seq` is not null)))
public class GuestQrCode {


	@Id
	@Column(name = "guest_qr_code_int_seq")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guestQrCodeIntSeq;

	@NotNull
	@Column(name = "qr_code", nullable = false)
	private String qrCode;


	@Column(name = "qr_code2")
	private String qrCode2;
	@NotNull
	@Column(name = "active_ind", nullable = false)
	private String activeInd;

	@OneToOne
	@JoinColumn(name = "guest_int_seq", unique = true)
	private Guest guest;

	@OneToOne
	@JoinColumn(name = "reply_personal_guest_int_seq", unique = true)
	private ReplyPersonalGuest replyPersonalGuest;
	
	@NotNull
	@Column(name = "last_update_id", nullable = false)
	private String lastUpdateId;

	@NotNull
	@Column(name = "last_update_time", nullable = false,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private LocalDateTime lastUpdateTime;
}
