package hk.jud.app.lyo.entity;
// Entity: reply_transport

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
public class ReplyTransport {


	@Id
	@Column(name = "reply_transport_int_seq")
	private Long replyTransportIntSeq;


	@Column(name = "from_opt")
	private String fromOpt;


	@Column(name = "away_opt")
	private String awayOpt;


	@Column(name = "car_registration_no")
	private String carRegistrationNo;


	@Column(name = "own_arrangement")
	private String ownArrangement;


	@NotNull
	@OneToOne
	@JoinColumn(name = "reply_int_seq", unique = true, nullable = false)
	private Reply reply;


	@NotNull
	@Column(name = "last_update_id", nullable = false)
	private String lastUpdateId;


	@NotNull
	@Column(name = "last_update_time", nullable = false,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private LocalDateTime lastUpdateTime;
}
