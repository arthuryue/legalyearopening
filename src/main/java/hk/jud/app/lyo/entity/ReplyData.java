package hk.jud.app.lyo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.databind.JsonNode;
import com.vladmihalcea.hibernate.type.json.JsonType;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//Entity for reply_data table
@Entity
@Table(name = "reply_data")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReplyData {


	@Id
	@Column(name = "reply_data_int_seq")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long replyDataIntSeq;


	@NotNull
    @Type(JsonType.class)
    @Column(columnDefinition = "json", nullable = false)
    private JsonNode json;

	@NotNull
	@Column(name = "last_update_id", nullable = false)
	private String lastUpdateId;


	@NotNull
	@Column(name = "last_update_time", nullable = false,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private LocalDateTime lastUpdateTime;


	@OneToOne(mappedBy = "replyData")
	private Reply reply;
}






