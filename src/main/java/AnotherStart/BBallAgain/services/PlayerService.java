package AnotherStart.BBallAgain.services;

import AnotherStart.BBallAgain.dto.Player;
import AnotherStart.BBallAgain.dao.PlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public List<Player> getAllPlayers(){
        return playerRepository.findAll();
    }
}
