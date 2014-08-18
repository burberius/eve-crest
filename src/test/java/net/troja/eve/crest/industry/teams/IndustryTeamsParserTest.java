package net.troja.eve.crest.industry.teams;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class IndustryTeamsParserTest {
    @Test
    public void testGetData() {
	final IndustryTeamsParser parser = new IndustryTeamsParser();
	final IndustryTeams data = parser.getData();
	assertTrue(data.getTotalCount() > 0);
	assertEquals(data.getTotalCount(), data.getItems().size());
    }
}
