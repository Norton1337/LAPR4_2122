package eapli.base.clientusermanagement.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import eapli.base.warehouses.domain.agvDocks.AgvDockIdentification;
import eapli.base.warehouses.domain.agvDocks.AgvDocks;
import eapli.base.warehouses.domain.agvDocks.AgvDocksBuilder;
import eapli.base.warehouses.domain.aisles.Aisles;
import eapli.base.warehouses.domain.aisles.AislesBuilder;
import eapli.base.warehouses.domain.rows.Rows;
import eapli.base.warehouses.domain.rows.RowsBuilder;
import eapli.base.warehouses.domain.square.*;
import eapli.base.warehouses.domain.warehouse.*;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class WarehouseTest {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private static ObjectMapper getDefaultObjectMapper() {

        ObjectMapper defaultObjectMapper = new ObjectMapper();
        return defaultObjectMapper;
    }

    public static JsonNode parse(String src) throws JsonMappingException, JsonProcessingException {

        return objectMapper.readTree(src);
    }

    @Test
    public void warehouseTest() throws IOException {
        String file = "src/main/resources/jsonFile.json";
        String jsonSource = new String(Files.readAllBytes(Paths.get(file)));

        try {
            JsonNode node = parse(jsonSource);


            ArrayList<Aisles> aisles = new ArrayList<>();
            for (JsonNode aisleJson : node.get("Aisles")) {

                ArrayList<Rows> rows = new ArrayList<>();
                for (JsonNode rowJson : aisleJson.get("rows")) {

                    Rows row = new RowsBuilder()
                            .ofID(rowJson.get("Id").asInt())
                            .ofBegin(
                                    new SquareBuilder()
                                            .ofLength(new Length(rowJson.get("begin").get("lsquare").asInt()))
                                            .ofWidth(new Width(rowJson.get("begin").get("wsquare").asInt()))
                                            .build())
                            .ofEnd(
                                    new SquareBuilder()
                                            .ofLength(new Length(rowJson.get("end").get("lsquare").asInt()))
                                            .ofWidth(new Width(rowJson.get("end").get("wsquare").asInt()))
                                            .build())
                            .withShelvesAmount(rowJson.get("shelves").asInt())
                            .build();

                    rows.add(row);
                }

                Aisles aisle = new AislesBuilder()
                        .ofID(aisleJson.get("Id").asInt())
                        .ofBegin( new SquareBuilder()
                                    .ofLength(new Length(aisleJson.get("begin").get("lsquare").asInt()))
                                    .ofWidth(new Width(aisleJson.get("begin").get("wsquare").asInt()))
                                    .build())
                        .ofEnd(new SquareBuilder()
                                    .ofLength(new Length(aisleJson.get("end").get("lsquare").asInt()))
                                    .ofWidth(new Width(aisleJson.get("end").get("wsquare").asInt()))
                                    .build())
                        .ofDepth(new SquareBuilder()
                                    .ofLength(new Length(aisleJson.get("depth").get("lsquare").asInt()))
                                    .ofWidth(new Width(aisleJson.get("depth").get("wsquare").asInt()))
                                    .build())
                        .accessibleBy(new Accessibility(aisleJson.get("accessibility").asText()))
                        .withRows(rows)
                        .build();

                aisles.add(aisle);
            }
            ArrayList<AgvDocks> agvDocks = new ArrayList<>();
            for (JsonNode agvDocksJson : node.get("AGVDocks")) {
                AgvDocks agvDock = new AgvDocksBuilder()
                        .ofId(new AgvDockIdentification(agvDocksJson.get("Id").asText()))
                        .ofBegin( new SquareBuilder()
                                .ofLength(new Length(agvDocksJson.get("begin").get("lsquare").asInt()))
                                .ofWidth(new Width(agvDocksJson.get("begin").get("wsquare").asInt()))
                                .build())
                        .ofEnd(new SquareBuilder()
                                .ofLength(new Length(agvDocksJson.get("end").get("lsquare").asInt()))
                                .ofWidth(new Width(agvDocksJson.get("end").get("wsquare").asInt()))
                                .build())
                        .ofDepth(new SquareBuilder()
                                .ofLength(new Length(agvDocksJson.get("depth").get("lsquare").asInt()))
                                .ofWidth(new Width(agvDocksJson.get("depth").get("wsquare").asInt()))
                                .build())
                        .accessibleBy(new Accessibility(agvDocksJson.get("accessibility").asText()))
                        .build();


                agvDocks.add(agvDock);

            }
            Warehouse warehouse = new WarehouseBuilder()
                    .ofAddress( new WarehouseIdentification(node.get("Warehouse").asText()))
                    .ofLength( new WarehouseLength(node.get("Length").asDouble()))
                    .ofWidth( new WarehouseWidth(node.get("Width").asDouble()))
                    .withSquare( new WarehouseSquare(node.get("Square").asDouble()))
                    .ofUnit(new WarehouseUnit(node.get("Unit").asText()))
                    .withAisles(aisles)
                    .withAgvDocks(agvDocks)
                    .build();

            System.out.println(warehouse.toString());
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }





}
