package hk.jud.app.lyo.entity;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Type;
import com.vladmihalcea.hibernate.type.json.JsonType;

import hk.jud.app.lyo.entity.*;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "deprecated_guest_reply")
@Data
public class Deprecated_GuestReply {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "guest_id", nullable = false)
    @JsonManagedReference // Serialize this field
    private Guest guest;

    @Type(JsonType.class)
    @Column(columnDefinition = "json")
    private JsonNode jsonData;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @OneToOne(mappedBy = "guestReply", cascade = CascadeType.ALL, orphanRemoval = true)
    private Deprecated_GuestReplyFormData guestReplyFormData;
    
    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        createdAt = now;
        updatedAt = now;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}