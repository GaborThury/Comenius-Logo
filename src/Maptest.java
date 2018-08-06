import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Maptest {
    @Test
    public void testmapGenerate() {
        Map tester = new Map(5, 5);
        tester.mapGenerate();
        assertEquals("all characters should be ◇", '◇', tester.map[1][1]);
    }
    @Test
    public void testclearMap() {
        Map tester = new Map(5, 5);
        tester.mapGenerate();
        tester.map[0][0] = '■';
        tester.clearMap();
        assertEquals("all characters should be ◇", '◇', tester.map[0][0]);
    }
    @Test
    public void testpenExamine(){
        Map tester = new Map(5,5);
        tester.penExamine();
        tester.penDown = false;
        assertEquals("pen should be up", "up", tester.penExamine());
    }
}
