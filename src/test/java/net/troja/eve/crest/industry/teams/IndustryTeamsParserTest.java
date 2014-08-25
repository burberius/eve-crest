package net.troja.eve.crest.industry.teams;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IndustryTeamsParserTest {
    public static final String LIVE_DATA = "src/test/resources/IndustryTeams.json";

    @Test
    public void testGetData() {
	final IndustryTeamsParser parser = new IndustryTeamsParser();
	parser.setDummyDataFile(LIVE_DATA);
	final IndustryTeams data = parser.getData();
	assertEquals(4742, data.getTotalCount());
	assertEquals(data.getTotalCount(), data.getItems().size());
    }
}
