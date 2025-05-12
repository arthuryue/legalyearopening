package hk.jud.app.lyo.repository;

import hk.jud.app.lyo.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GuestRepository extends JpaRepository<Guest, UUID> {
	Optional<Guest> findById(UUID id);
	Optional<Guest> findByUid(String uid);
	Optional<Guest> findByEmailAddr(String email);
	@Query("SELECT g FROM Guest g WHERE LOWER(g.name) LIKE LOWER(CONCAT('%', :query, '%')) OR LOWER(g.emailAddr) LIKE LOWER(CONCAT('%', :query, '%'))")
	List<Guest> searchGuests(@Param("query") String query);
}