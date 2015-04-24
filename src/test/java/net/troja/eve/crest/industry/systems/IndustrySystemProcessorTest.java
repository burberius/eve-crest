package net.troja.eve.crest.industry.systems;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import net.troja.eve.crest.CrestApiProcessorTest;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

public class IndustrySystemProcessorTest extends CrestApiProcessorTest {
    @Test
    public void testParsing() throws JsonProcessingException, IOException {
        final IndustrySystemProcessor processor = new IndustrySystemProcessor();

        final JsonNode node = loadAndParseData("IndustrySystem.json");
        final IndustrySystem industrySystem = processor.parseEntry(node);

        assertThat(industrySystem.getSolarSystemId(), equalTo(30011392));
        assertThat(industrySystem.getSolarSystemName(), equalTo("Jouvulen"));
        assertThat(industrySystem.getCopyingCostIndex(), equalTo(0.002126825019385529d));
        assertThat(industrySystem.getInventionCostIndex(), equalTo(0.002651119668210213d));
        assertThat(industrySystem.getManufacturingCostIndex(), equalTo(0.029556772662022016d));
        assertThat(industrySystem.getResearchingMaterialEfficiencyCostIndex(), equalTo(0.00098d));
        assertThat(industrySystem.getResearchingTimeEfficiencyCostIndex(), equalTo(0.00098d));
    }
}
