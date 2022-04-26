package AnotherStart.BBallAgain.controllers;

import AnotherStart.BBallAgain.dto.Player;
import AnotherStart.BBallAgain.services.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/players")
@AllArgsConstructor
public class PlayerController {

    private final PlayerService playerService;

    @GetMapping
    public List<Player> fetchAllPlayers() {
        return playerService.getAllPlayers();
    }
    @GetMapping(value = "/byId/{playerId}", produces = "application/json")
    public Player fetchPlayerbyId(@PathVariable("playerId") String playerId){
        return playerService.findPlayerById(playerId);

    }

    @GetMapping(value = "/byName/{name}", produces = "application/json")
    public Optional<Player> fetchPlayerByName(@PathVariable("name") String name){
        return playerService.findPlayerByName(name);
    }

    @PostMapping(value = "/addPlayer", produces = "application/json")
    public ResponseEntity<?> addPlayer(@RequestBody Player player) {
        playerService.insertPlayer(player);
        return ResponseEntity.ok().build();
    }
}
