package net.troja.eve.crest.industry.systems;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IndustrySystemsParseTest {
    @Test
    public void testGetData() {
	final IndustrySystemsParser parser = new IndustrySystemsParser();
	final IndustrySystems data = parser.getData();
	assertEquals(5431, data.getTotalCount());
	assertEquals(data.getTotalCount(), data.getItems().size());
    }
}
