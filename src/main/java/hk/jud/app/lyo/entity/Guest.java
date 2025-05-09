package hk.jud.app.lyo.entity;

// Entity: guest

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.databind.JsonNode;
import com.vladmihalcea.hibernate.type.json.JsonType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//Entity for guest table
@Entity
@Table(name = "guest")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Guest {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "guest_int_seq")
	private Long guestIntSeq;

	@NotNull
	@Column(name = "uid", unique= true, nullable = false)
	private String uid;
	@NotNull
	@Column(name = "name", nullable = false)
	private String name;


	@Column(name = "email_addr")
	private String emailAddr;

	@NotNull
	@Column(name = "rsvp_type", nullable = false)
	private String rsvpType;
	@NotNull
	@Column(name = "last_update_id", nullable = false)
	private String lastUpdateId;

	@NotNull
	@Column(name = "last_update_time", nullable = false,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private LocalDateTime lastUpdateTime;


	@OneToOne(mappedBy = "guest")
	private GuestQrCode guestQrCode;
}

