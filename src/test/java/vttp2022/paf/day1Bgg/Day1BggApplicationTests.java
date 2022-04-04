package vttp2022.paf.day1Bgg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.webservices.server.AutoConfigureWebServiceServer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

import vttp2022.paf.day1Bgg.model.Comment;
import vttp2022.paf.day1Bgg.model.Game;
import vttp2022.paf.day1Bgg.repositories.GameRepository;

@SpringBootTest
class Day1BggApplicationTests {

	
	@Autowired
	private GameRepository gameRepo;

	@Test
	void shouldReturnAGame() {

		Optional<Game> opt = gameRepo.getGameByGid(10);

		assertTrue(opt.isPresent(), "gid = 10");
		//If it's not true, throws an AssertionError with the msg "gid=10";
	}

	@Test
	void shouldReturnEmpty(){
		Optional<Game> opt = gameRepo.getGameByGid(10000);
		assertFalse(opt.isPresent(), "gid = 10000");
	}

	@Test
	public void shouldReturn42Comments(){
		List<Comment> results = gameRepo.getCommentsByGid(10);
		assertEquals(42, results.size(), "number of comments for gid=10 is 42");
	}

}
