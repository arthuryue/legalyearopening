package hk.jud.app.lyo.entity;
// Entity: reply_personal_guest

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "reply_personal_guest")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReplyPersonalGuest {


	@Id
	@Column(name = "reply_personal_guest_int_seq")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long replyPersonalGuestIntSeq;


	@NotNull
	@Column(name = "name", nullable = false)
	private String name;


	@NotNull
	@Column(name = "email_addr", nullable = false)
	private String emailAddr;


	@NotNull
	@ManyToOne
	@JoinColumn(name = "reply_int_seq", nullable = false)
	private Reply reply;


	@NotNull
	@Column(name = "last_update_id", nullable = false)
	private String lastUpdateId;


	@NotNull
	@Column(name = "last_update_time", nullable = false,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private LocalDateTime lastUpdateTime;


	@OneToOne(mappedBy = "replyPersonalGuest")
	private GuestQrCode guestQrCode;


	@OneToOne(mappedBy = "replyPersonalGuest")
	private ReplyPersonalGuestUid replyPersonalGuestUid;
}
