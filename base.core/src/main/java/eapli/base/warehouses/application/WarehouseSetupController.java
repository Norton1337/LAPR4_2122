package eapli.base.warehouses.application;

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
import eapli.base.warehouses.domain.square.Accessibility;
import eapli.base.warehouses.domain.square.Length;
import eapli.base.warehouses.domain.square.SquareBuilder;
import eapli.base.warehouses.domain.square.Width;
import eapli.base.warehouses.domain.warehouse.*;
import eapli.base.warehouses.dto.WarehouseDTO;
import eapli.base.warehouses.repositories.WarehouseRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class WarehouseSetupController {

    private Warehouse warehouse;
    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    private final WarehouseRepository warehouseRepository = eapli.base.infrastructure.persistence.PersistenceContext.repositories().warehouse();

    private static final ObjectMapper objectMapper = new ObjectMapper();


    public static JsonNode parse(String src) throws JsonMappingException, JsonProcessingException {

        return objectMapper.readTree(src);
    }


    public WarehouseSetupController(){}

    public WarehouseIdentification getWarehouseAddress(WarehouseDTO dto) throws IOException {
        warehouse= new Warehouse(dto);
        return warehouse.identity();
    }

    public void setupWarehouse(String jsonFile) throws IOException {
        String file;
        String userDirectory = new File("").getAbsolutePath();
        if(jsonFile.isBlank())
            file = userDirectory+"/base.core/src/main/resources/jsonFile.json";
        else
            file=jsonFile;

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

            warehouseRepository.save(warehouse);

            List<Warehouse> warehouses = warehouseRepository.findAll();
            if(!warehouses.isEmpty())
                System.out.println(warehouses.get(0).identity());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


    }

}
