package hk.jud.app.lyo.entity;
// Entity: email_log

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//Entity for email_log table
@Entity
@Table(name = "email_log")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmailLog {


	@Id
	@Column(name = "email_log_int_seq")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long emailLogIntSeq;

	@ManyToOne
	@NotNull
	@JoinColumn(name = "guest_int_seq" , nullable = false)
	private Guest guest;

	@NotNull
	@Column(name = "sent_date", nullable = false,columnDefinition = "TIMESTAMP")
	private LocalDateTime sentDate;

	@NotNull
	@Column(name = "email_addr", nullable = false)
	private String emailAddr;

	@NotNull
	@Column(name = "email_type", nullable = false)
	private String emailType;

	@NotNull
	@Column(name = "last_update_id", nullable = false)
	private String lastUpdateId;

	@NotNull
	@Column(name = "last_update_time", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private LocalDateTime lastUpdateTime;
}
