package com.example.service;

import com.example.repository.PlayerRepository;
import com.example.model.Player;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    private PlayerRepository repository;

    public PlayerService(PlayerRepository repository) {
        this.repository = repository;
    }

    public Player create(Player player) {
        return repository.save(player);
    }

    public Player get(Integer playerId) {
        Optional<Player> optionalPlayer = repository.findById(playerId);
        return optionalPlayer.get();
    }

    public List<Player> getAll() {
        List<Player> players = null;
        players = repository.findAll();
//        try {
//            players = repository.findAll();
//        } catch (Exception e) {
//            System.out.println("Caught an Exception....");
//            players = new ArrayList<>();
//        }
        return players;
    }

    public Player update(Integer playerId, Player player) {
        Optional<Player> playerOptional = repository.findById(playerId);
        return repository.save(player);
    }
}
