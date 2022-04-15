package AnotherStart.BBallAgain.dao;

import AnotherStart.BBallAgain.dto.Player;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PlayerRepository extends MongoRepository<Player, String> {
    Optional<Player> findPlayerByName(String name);

}
