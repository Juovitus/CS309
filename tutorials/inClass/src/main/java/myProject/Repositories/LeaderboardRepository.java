package myProject.Repositories;


import myProject.Models.Leaderboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Interface for Leaderboard
 * @author Thomas McCoy & Noah Hoss
 *
 */
@Repository
public interface LeaderboardRepository extends JpaRepository<Leaderboard, Integer> {

}
