package ca.shaw.bs.game;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ca.shaw.bs.game.Game;
import ca.shaw.bs.player.Player;

@SpringBootApplication
public class BattleShip {
    public static void main(String[] args) throws IOException {
    	
		SpringApplication.run(BattleShip.class);
        Game game = new Game();
        game.play();
    }
}
