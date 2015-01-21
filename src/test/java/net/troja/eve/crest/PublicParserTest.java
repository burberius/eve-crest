package net.troja.eve.crest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PublicParserTest {
    @SuppressWarnings("rawtypes")
    private final PublicContainerParser<?,?> classToTest = new PublicContainerParser() {

	@Override
	protected String getPath() {
	    return "/";
	}
    };

    @Test
    public void testCaching() {
	classToTest.cachedAt = System.currentTimeMillis() - (60 * 60 * 1000) - 5;
	assertTrue(classToTest.isOutdated());
    }
}
