package eapli.base.warehouses.application;

import eapli.base.ordermanagement.domain.OrderItem;
import eapli.base.taskmanagement.domain.Task;
import eapli.base.warehouses.domain.agvs.AGV;
import eapli.base.warehouses.domain.aisles.Aisles;
import eapli.base.warehouses.domain.rows.Bin;
import eapli.base.warehouses.domain.rows.Rows;
import eapli.base.warehouses.domain.rows.Shelves;
import eapli.base.warehouses.domain.warehouse.Warehouse;

import java.util.ArrayList;
import java.util.List;

public class RouteService implements Runnable{
    private AGV agv;
    private final Warehouse warehouse;

    public RouteService(AGV agv, Warehouse warehouse){
        this.agv=agv;
        this.warehouse=warehouse;
    }

    @Override
    public void run(){
        Task task = agv.getTask();
        List<OrderItem> orderItemList = task.getOrder().getOrderItemList();
        List<Bin> binList = new ArrayList<>();
        for (OrderItem item:orderItemList) {
            binList.add(item.product().getBin());
        }
        List<Rows> itemLocations = findLocation(binList);
        List<Rows> bestPath = calculateOptimalPath(itemLocations);
        System.out.println(agv.getAgvAddress());
        System.out.println(bestPath.size());

    }

    private List<Rows> calculateOptimalPath(List<Rows> itemLocations){
        List<Rows> optimalPath = new ArrayList<>();
        int size= itemLocations.size();
        double x1=0;
        double y1=0;
        for (int i = 0; i < size; i++) {

            if(optimalPath.isEmpty()) {
                x1 = agv.getAgvAddress().getBegin().length().value();
                y1 = agv.getAgvAddress().getBegin().width().value();
            }else{
                x1 = optimalPath.get(optimalPath.size()-1).getBegin().length().value();
                y1 = optimalPath.get(optimalPath.size()-1).getBegin().width().value();
            }
            Rows closestnow = calculateClosest(x1,y1,itemLocations);

            optimalPath.add(closestnow);
            itemLocations.remove(closestnow);
        }

        return optimalPath;
    }
    private Rows calculateClosest(double x1, double y1, List<Rows>itemLocations) {
        double closestDistance = -1.0;
        Rows closestRow = null;
        for (Rows location : itemLocations) {
            //agv (x1,y1) (length,width)
            //location (x2,y2) (length,width)
            //distance = sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1))

            double x2 = location.getBegin().length().value();
            double y2 = location.getBegin().width().value();
            double distance = Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
            if (closestDistance == -1 || closestDistance > distance) {
                closestDistance = distance;
                closestRow = location;
            }
        }
        return closestRow;
    }


    private List<Rows> findLocation(List<Bin> binList) {
        List<Aisles> aislesList = new ArrayList<>(warehouse.allAisles());
        List<Rows> rowsList = new ArrayList<>();
        List<Integer> idList = new ArrayList<>();
        for (Bin bin:binList) {
            idList.add(bin.binID());
        }
        for (Aisles aisle:aislesList) {
            List<Rows> rows = aisle.getRows();
            for (Rows row:rows) {

                List<Shelves> shelves = row.getShelves();
                for (Shelves shelf:shelves) {
                    try {
                        if (idList.contains(shelf.getBin().binID())) {
                            rowsList.add(row);
                            break;
                        }
                    }catch (Exception e){}
                }

            }
        }

        return rowsList;
    }
}
