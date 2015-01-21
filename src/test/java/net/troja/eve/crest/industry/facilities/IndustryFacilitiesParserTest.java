package net.troja.eve.crest.industry.facilities;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IndustryFacilitiesParserTest {
    public static final String LIVE_DATA = "src/test/resources/IndustryFacilities.json";

    @Test
    public void testGetData() {
	final IndustryFacilitiesParser parser = new IndustryFacilitiesParser();
	parser.setDummyDataFile(LIVE_DATA);
	final IndustryFacilities data = parser.getData();
	assertEquals(6207, data.getTotalCount());
	assertEquals(data.getTotalCount(), data.getItems().size());
	final IndustryFacility facility = data.getItems().get(0);
	assertThat(facility.getName(), notNullValue());
	assertThat(facility.getSolarSystem(), notNullValue());
	assertThat(facility.getSolarSystem().getId(), greaterThan(0l));
	assertThat(facility.getFacilityID(), greaterThan(0l));
    }
}
