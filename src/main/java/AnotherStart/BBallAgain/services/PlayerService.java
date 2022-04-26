package AnotherStart.BBallAgain.services;

import AnotherStart.BBallAgain.dto.Player;
import AnotherStart.BBallAgain.dao.PlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public List<Player> getAllPlayers(){
        return playerRepository.findAll();
    }

    public Player findPlayerById(String id){
        return playerRepository.findPlayerById(id);
    }

    public Optional<Player> findPlayerByName(String name){
        return playerRepository.findPlayerByName(name);
    }

    public void insertPlayer(Player player){
        playerRepository.insert(player);
    }
}
