package hk.jud.app.lyo.entity;

import com.fasterxml.jackson.databind.JsonNode;
import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "deprecated_guest_reply_form_data")
@Data
public class Deprecated_GuestReplyFormData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "guest_reply_id", nullable = false, unique = true)
    private Deprecated_GuestReply guestReply;

    @Column(name = "rsvp")
    private String rsvp;

    @Column(name = "plus_one")
    private Integer plusOne;
}