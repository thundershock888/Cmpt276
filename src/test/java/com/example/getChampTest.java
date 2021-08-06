package com.example;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;


public class getChampTest {
    String id ="Aatrox";
    ChampionRead championRead = new ChampionRead();
    

    @BeforeAll
  static void set(){
  }

    @Test
    public void champTest(){
        ChampionRead.getChampion(championRead, id);
        assertEquals("Aatrox",championRead.getId());
        assertEquals("Aatrox",championRead.getName());
        assertEquals("the Darkin Blade", championRead.getTitle());
        assertNotNull(championRead.getLore());
        assertEquals(8, championRead.getInfoAttack());
        assertEquals(4,championRead.getInfoDefense());
        assertEquals(3, championRead.getInfoMagic());
        assertEquals(4,championRead.getInfoDifficulty());
        assertEquals("Blood Well",championRead.getPartype());
        assertEquals("Aatrox.png",championRead.getImage());
        assertNotNull(championRead.getTags());
        }
}
