package vttp2022.paf.day1Bgg.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp2022.paf.day1Bgg.model.Game;
import vttp2022.paf.day1Bgg.repositories.GameRepository;

@Service
public class GameService {
    
    @Autowired
    private GameRepository gameRepo;

    public Optional<Game> getComments(Integer gid){
        Optional<Game> opt = gameRepo.getGameByGid(gid);
        if(opt.isEmpty())
            return Optional.empty();
        Game game = opt.get();
        game.setComments(gameRepo.getCommentsByGid(gid));
        return Optional.of(game);
    }
}
