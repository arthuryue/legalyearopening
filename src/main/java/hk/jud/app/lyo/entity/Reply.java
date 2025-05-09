package hk.jud.app.lyo.entity;
// Entity: reply

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
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@Table(name = "reply")
@ToString
public class Reply {


	@Id
	@Column(name = "reply_int_seq")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long replyIntSeq;
	
	@NotNull
	@Column(name = "uid", nullable = false)
	private String uid;


	@NotNull
	@Column(name = "attend_ind", nullable = false)
	private String attendInd;


	@Column(name = "tel_no")
	private String telNo;


	@Column(name = "email_addr")
	private String emailAddr;


	@OneToOne
	@NotNull
	@JoinColumn(name = "reply_data_int_seq", unique = true, nullable = false)
	private ReplyData replyData;


	@NotNull
	@Column(name = "last_update_id", nullable = false)
	private String lastUpdateId;


	@NotNull
	@Column(name = "last_update_time", nullable = false,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private LocalDateTime lastUpdateTime;


	@OneToOne(mappedBy = "reply")
	private ReplyTransport replyTransport;


	@OneToMany(mappedBy = "reply")
	private List<ReplyPersonalGuest> replyPersonalGuests;
}
