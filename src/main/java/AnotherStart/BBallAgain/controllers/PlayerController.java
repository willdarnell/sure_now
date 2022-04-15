package AnotherStart.BBallAgain.controllers;

import AnotherStart.BBallAgain.dto.Player;
import AnotherStart.BBallAgain.services.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/players")
@AllArgsConstructor
public class PlayerController {

    private final PlayerService playerService;

    @GetMapping
    public List<Player> fetchAllPlayers() {
        return playerService.getAllPlayers();
    }
}
