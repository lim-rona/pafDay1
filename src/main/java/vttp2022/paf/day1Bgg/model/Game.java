package vttp2022.paf.day1Bgg.model;

import java.util.List;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import jakarta.json.Json;

public class Game {
    private Integer gameId;
    private String name;
    private Integer year;
    private Integer ranking;
    private Integer usersRated;
    private String url;
    private String image;
    private List<Comment> comments;

    //getters and setters
    public Integer getGameId() {
        return gameId;
    }
    public List<Comment> getComments() {
        return comments;
    }
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public Integer getUsersRated() {
        return usersRated;
    }
    public void setUsersRated(Integer usersRated) {
        this.usersRated = usersRated;
    }
    public Integer getRanking() {
        return ranking;
    }
    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }
    public Integer getYear() {
        return year;
    }
    public void setYear(Integer year) {
        this.year = year;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    //make a create method
    public static Game create(SqlRowSet result){

            Game game = new Game();
            //A little long-winded here because I already pre-typed some of them
            Integer gid = result.getInt("gid");
            game.setGameId(gid);
            String name = result.getString("name");
            game.setName(name);
            Integer year = result.getInt("year");
            game.setYear(year);
            Integer ranking = result.getInt("ranking");
            game.setRanking(ranking);
            Integer users_rated = result.getInt("users_rated");
            game.setUsersRated(users_rated);
            String url = result.getString("url");
            game.setUrl(url);
            String image = result.getString("image");
            game.setImage(image);
            return game;
    }
    
    // public JsonObject toJson(){
    //     return Json.createObjectBuilder()
    //     //blabla missed out here
    // }
    
}
