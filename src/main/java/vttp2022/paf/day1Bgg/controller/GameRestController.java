package vttp2022.paf.day1Bgg.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObjectBuilder;
import vttp2022.paf.day1Bgg.model.Comment;
import vttp2022.paf.day1Bgg.model.Game;
import vttp2022.paf.day1Bgg.repositories.GameRepository;
import vttp2022.paf.day1Bgg.services.GameService;

@RestController
@RequestMapping(path="/game")
public class GameRestController {
    
    @Autowired
    private GameService gameSvc;

    @GetMapping(path="/{gid}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getGameAndCommentById(@PathVariable Integer gid) {
        //why need gamesvc?
        Optional<Game> opt = gameSvc.getComments(gid);
        JsonObjectBuilder builder = Json.createObjectBuilder();
        if(opt.isEmpty())
            return ResponseEntity.status(404).body(
                builder.add("error", "not found: %s".formatted(gid))
                .build().toString()
            );

        Game game = opt.get();

        builder.add("gid", game.getGameId());
        builder.add("name", game.getName());
        JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
        for (Comment c: game.getComments())
            arrBuilder.add("/comment/%s".formatted(c.getC_id()));
        builder.add("comments", arrBuilder.build());

        return ResponseEntity.ok(builder.build().toString());
    }
}

//why my result not in JSON format one 