package eapli.base.app.backoffice.console.presentation;

import eapli.base.warehouses.application.ConfigureAGVController;
import eapli.base.warehouses.domain.agvDocks.AgvDocks;
import eapli.base.warehouses.dto.AgvDTO;
import eapli.base.warehouses.repositories.WarehouseRepository;
import eapli.framework.io.util.Console;

import java.io.IOException;
import java.util.List;

public class ConfigureAGVUI {
    private ConfigureAGVController agvController = new ConfigureAGVController();
    private AgvDTO agvDTO = new AgvDTO();

    public boolean show(){
        String option=new String();
        System.out.println("Setup new AGV");

        agvDTO.identification = Console.readNonEmptyLine("Identificação AGV", "Não pode ser nulo");
        agvDTO.autonomy = Console.readDouble("Autonomia do AGV");
        agvDTO.maxWeight = Console.readDouble("Peso maximo do AGV");
        agvDTO.model = Console.readNonEmptyLine("Modelo do AGV", "Não pode ser nulo");
        agvDTO.shortDescription = Console.readNonEmptyLine("Descrição curta do AGV", "Não pode ser nulo");
        agvDTO.status = Console.readNonEmptyLine("Estado do AGV", "Não pode ser nulo");
        List<AgvDocks> agvDocksList = agvController.getAGVDocks();
        int i=0;
        System.out.println("\nAGVDocks: ");
        for (AgvDocks agvDock: agvDocksList) {
            System.out.println((i++)+""+agvDock.toString());
        }
        int option2 = Console.readInteger("Escolha um agvDock");
        if(option2<0 || option2 >= agvDocksList.size()){
            System.out.println("AGVDock não existe");
            return false;
        }
        agvDTO.agvDock=agvDocksList.get(option2);

        option = Console.readNonEmptyLine("Confirma os dados intrudozidos (Y/N):","Pode ser em minusculas");
        try {
            if (option.equals("Y") || option.equals(("y"))) {
                agvController.configureAGV(agvDTO);
                System.out.println("Sucesso!");
            }
        }catch (IllegalArgumentException | IOException ex){
            System.out.println(ex);
        }
        return false;
    }
}
