package hk.jud.app.lyo.entity;
// Entity: reply_personal_guest_uid

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//Entity for reply_personal_guest_uid table
@Entity
@Table(name = "reply_personal_guest_uid")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReplyPersonalGuestUid {


	@Id
	@Column(name = "reply_personal_guest_int_seq")
	private Long replyPersonalGuestIntSeq;


	@NotNull
	@Column(name = "reply_personal_guest_uid", unique= true, nullable = false)
	private String replyPersonalGuestUid;


	@NotNull
	@Column(name = "last_update_id", nullable = false)
	private String lastUpdateId;


	@NotNull
	@Column(name = "last_update_time", nullable = false,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private LocalDateTime lastUpdateTime;


	@NotNull
	@OneToOne
	@JoinColumn(name = "reply_personal_guest_int_seq", unique = true, nullable = false)
	private ReplyPersonalGuest replyPersonalGuest;
}
