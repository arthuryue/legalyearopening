package hk.jud.app.lyo.repository;

import hk.jud.app.lyo.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GuestRepository extends JpaRepository<Guest, Long> {
	Optional<Guest> findByUid(String uid);
}