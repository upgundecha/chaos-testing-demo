package com.example.controller;

import com.example.model.Player;
import com.example.service.PlayerService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/player")
@RestController
public class PlayerController {

    private PlayerService service;

    public PlayerController(PlayerService service) {
        this.service = service;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Player getPlayer(@PathVariable("id") Integer playerId) {
        return service.get(playerId);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Player updatePlayer(@PathVariable("id") Integer playerId, @RequestBody Player player) {
        return service.update(playerId, player);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Player> getAll() {
        return service.getAll();
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Player createPlayer(@RequestBody Player player) {
        Player createdPlayer = service.create(player);
        return createdPlayer;
    }
}
