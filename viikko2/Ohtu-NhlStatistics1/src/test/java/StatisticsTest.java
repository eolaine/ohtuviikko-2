/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import ohtuesimerkki.Player;
import ohtuesimerkki.PlayerReader;
import ohtuesimerkki.Reader;
import ohtuesimerkki.Statistics;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author eolaine
 */
public class StatisticsTest {
    
    Statistics stats;
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
    
    public StatisticsTest() {
        stats = new Statistics(readerStub);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void findsFirstPlayer() {
        String firstname = readerStub.getPlayers().get(0).getName();
        assertEquals(stats.search(firstname).getName(), firstname); 
    }
    
    @Test
    public void returnsNullWhenPlayerNotFound() {
        assertNull(stats.search("Granlund")); 
    }
    
    @Test
    public void findsRightTeam() {
        Player player = new Player("Lemieux", "PIT", 45, 54);
        assertEquals(stats.team("PIT").get(0).getName(), "Lemieux"); 
    }
    
    @Test
    public void scoresCorrectly() {
        assertEquals(stats.topScorers(1).get(0).getName(),"Gretzky"); 
    }
}
