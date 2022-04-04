package vttp2022.paf.day1Bgg.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import vttp2022.paf.day1Bgg.model.Comment;
import vttp2022.paf.day1Bgg.model.Game;

import static vttp2022.paf.day1Bgg.repositories.Queries.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Repository
public class GameRepository {
    
    @Autowired
    private JdbcTemplate template;

    public List<Comment> getCommentsByGid(Integer gid){
        return getCommentsByGid(gid, Integer.MAX_VALUE, 0);
    }
    
    public List<Comment> getCommentsByGid(Integer gid, Integer limit){
        return getCommentsByGid(gid, limit, 0);
    }

    public List<Comment> getCommentsByGid(Integer gid, Integer limit, Integer offset) {
        
        final List<Comment> comments = new LinkedList<>();

        final SqlRowSet commentResult = template.queryForRowSet(
            SQL_SELECT_COMMENT_BY_GID, gid, limit, offset
        );

        while(commentResult.next()){
            Comment comment = Comment.create(commentResult);
            comments.add(comment);
        }
        
        return comments;
    }

    public Optional<Game> getGameByGid(Integer queryGid){
        final SqlRowSet result = template.queryForRowSet(
            SQL_SELECT_GAME_BY_GID, queryGid
        );
        //Here it's ok to add int to string as it will auto change the int to string too. 

        //If it doesn't have next, return empty. 
        if (!result.next())
            return Optional.empty();

        return Optional.of(Game.create(result));

            
        
    }
}
