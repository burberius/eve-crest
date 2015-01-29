package net.troja.eve.crest.industry.systems;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IndustrySystemsParserTest {
    public static final String LIVE_DATA = "src/test/resources/IndustrySystems.json";

    @Test
    public void testGetData() {
	final IndustrySystemsParser parser = new IndustrySystemsParser();
	parser.setDummyDataFile(LIVE_DATA);
	final IndustrySystems data = parser.getData();
	assertEquals(5431, data.getTotalCount());
	assertEquals(data.getTotalCount(), data.getItems().size());
    }
}
