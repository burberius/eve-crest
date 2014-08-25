package net.troja.eve.crest.industry.specialities;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IndustrySpecialitiesParserTest {
    public static final String LIVE_DATA = "src/test/resources/IndustrySpecialities.json";

    @Test
    public void testGetData() {
	final IndustrySpecialitiesParser parser = new IndustrySpecialitiesParser();
	parser.setDummyDataFile(LIVE_DATA);
	final IndustrySpecialities data = parser.getData();
	assertEquals(142, data.getTotalCount());
	assertEquals(data.getTotalCount(), data.getItems().size());
    }
}
