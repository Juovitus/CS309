package myProject.Repositories;


import myProject.Models.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Interface for Tournament
 * @author Thomas McCoy 
 *
 */
@Repository
public interface TournamentRepository extends JpaRepository<Tournament, Integer> {

}
