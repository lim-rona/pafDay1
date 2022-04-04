package vttp2022.paf.day1Bgg.model;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public class Comment {
    private Integer gameId;
    private String c_id;
    private String user;
    private Integer rating;
    private String c_text;
    
    //getters and setters
    public Integer getGameId() {
        return gameId;
    }
    public String getC_text() {
        return c_text;
    }
    public void setC_text(String c_text) {
        this.c_text = c_text;
    }
    public Integer getRating() {
        return rating;
    }
    public void setRating(Integer rating) {
        this.rating = rating;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public String getC_id() {
        return c_id;
    }
    public void setC_id(String c_id) {
        this.c_id = c_id;
    }
    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public static Comment create(SqlRowSet rs){

        Comment comment = new Comment();
        comment.setC_id(rs.getString("c_id"));
        comment.setC_text(rs.getString("c_text"));
        comment.setGameId(rs.getInt("gid"));
        comment.setRating(rs.getInt("rating"));
        comment.setUser(rs.getString("user"));
        return comment;
    }
    

}
