package eapli.base.warehouses.domain.warehouse;
import eapli.base.warehouses.dto.WarehouseDTO;
import eapli.base.warehouses.domain.aisles.Aisles;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import eapli.base.warehouses.domain.agvDocks.AgvDocks;
import eapli.base.warehouses.domain.square.Accessibility;
import eapli.base.warehouses.domain.square.Length;
import eapli.base.warehouses.domain.square.Square;
import eapli.base.warehouses.domain.square.Width;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;

@Entity
public class Warehouse implements AggregateRoot<WarehouseIdentification> {
    @Id
    @GeneratedValue
    private int id;
    @Version
    private long version;
    @Embedded
    private WarehouseIdentification warehouse;
    @Embedded
    private WarehouseLength warehouseLength;
    @Embedded
    private WarehouseWidth warehouseWidth;
    @Embedded
    private WarehouseSquare warehouseSquare;
    @Embedded
    private WarehouseUnit warehouseUnit;

    @OneToMany
    private Set<Aisles> aisles;
    @OneToMany
    private Set<AgvDocks> agvDocks;




    public Warehouse(WarehouseIdentification warehouse, WarehouseLength warehouseLength, WarehouseWidth warehouseWidth,
                     WarehouseSquare warehouseSquare, WarehouseUnit warehouseUnit, List<Aisles> aisles, List<AgvDocks> agvDocks) throws IOException {
        Preconditions.nonEmpty(aisles);
        Preconditions.nonEmpty(agvDocks);
        this.warehouse = warehouse;
        this.warehouseLength = warehouseLength;
        this.warehouseWidth = warehouseWidth;
        this.warehouseSquare = warehouseSquare;
        this.warehouseUnit = warehouseUnit;
        /*
        this.aisles = new HashSet<Aisles>();
        this.agvDocks = new HashSet<AgvDocks>();

        for (Aisles aisle: aisles) {
            addAisles(aisle);
        }

        for (AgvDocks agvDock: agvDocks) {
            addAgvDock(agvDock);

        }
*/
    }

    public Warehouse(WarehouseDTO dto) throws IOException {
        this(
            new WarehouseIdentification(dto.warehouse),
                new WarehouseLength(dto.warehouseLength),
                new WarehouseWidth(dto.warehouseWidth),
                new WarehouseSquare(dto.warehouseSquare),
                new WarehouseUnit(dto.warehouseUnit),
                dto.aisles,
                dto.agvDocks

        );
    }

    @Deprecated
    public Warehouse() {
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "id=" + id +
                ", warehouseIdentification=" + warehouse +
                ", warehouseLength=" + warehouseLength +
                ", warehouseWidth=" + warehouseWidth +
                ", warehouseSquare=" + warehouseSquare +
                ", warehouseUnit=" + warehouseUnit +
                ", aisles=" + aisles +
                ", agvDocks=" + agvDocks +
                '}';
    }

    public static Warehouse valueOf(WarehouseIdentification warehouseIdentification, WarehouseLength warehouseLength, WarehouseWidth warehouseWidth,
                                    WarehouseSquare warehouseSquare, WarehouseUnit warehouseUnit, List<Aisles> aisles, List<AgvDocks> agvDocks) throws IOException {
        return new Warehouse(warehouseIdentification,warehouseLength,warehouseWidth,warehouseSquare,warehouseUnit,aisles,agvDocks);
    }

    public Set<AgvDocks> allAGVDocks(){
        return this.agvDocks;
    }

    private Boolean checkAccessibility(Aisles aisle){
        Square begin = aisle.getBegin();
        Square end = aisle.getEnd();
        Square depth = aisle.getDepth();
        return checkAccessibility(begin, end, depth, aisle.getAccessibility());
    }

    private Boolean checkAccessibility(AgvDocks dock){
        Square begin = dock.getBegin();
        Square end = dock.getEnd();
        Square depth = dock.getDepth();
        return checkAccessibility(begin, end, depth, dock.getAccessibility());
    }

    private Boolean checkAccessibility(Square newBegin, Square newEnd, Square newDepth, Accessibility accessibility){

        Boolean isAccessible = true;
        Square accessibilitySquareBegin = newBegin;
        Square accessibilitySquareEnd = newEnd;
        String accessibilityString = accessibility.toString();
        Width newWidthBegin = newBegin.width();
        Width newWidthEnd = newEnd.width();
        Length newLengthBegin = newBegin.length();
        Length newLengthEnd = newEnd.length();
        if(accessibilityString.charAt(0)=='w'){
            if(accessibilityString.charAt(1)=='-'){
                newWidthBegin = new Width(newBegin.width().value()-1);
                newWidthEnd = new Width(newEnd.width().value()-1);
            }else if(accessibilityString.charAt(1)=='+'){
                newWidthBegin = new Width(newBegin.width().value()+1);
                newWidthEnd = new Width(newEnd.width().value()+1);
            }else{
                isAccessible=false;
            }
        }else if (accessibilityString.charAt(0)=='l'){
            if(accessibilityString.charAt(1)=='-'){

                newLengthBegin = new Length(newBegin.length().value()-1);
                newLengthEnd = new Length(newEnd.length().value()-1);
            }else if(accessibilityString.charAt(1)=='+'){
                newLengthBegin = new Length(newBegin.length().value()+1);
                newLengthEnd = new Length(newEnd.length().value()+1);
            }else{
                isAccessible=false;
            }
        }

        if(isAccessible) {
            accessibilitySquareBegin = new Square(newLengthBegin,newWidthBegin);
            accessibilitySquareEnd = new Square(newLengthEnd,newWidthEnd);

            if (Boolean.TRUE.equals(checkCollision(accessibilitySquareBegin, accessibilitySquareEnd, newDepth)))
                isAccessible = false;


            if (Boolean.FALSE.equals(checkInBounds(accessibilitySquareBegin, accessibilitySquareEnd, newDepth)))
                isAccessible = false;

        }

        return isAccessible;
    }


    private Boolean checkCollision(Aisles aisle){
        Square begin = aisle.getBegin();
        Square end = aisle.getEnd();
        Square depth = aisle.getDepth();

        return checkCollision(begin, end, depth);

    }

    private Boolean checkCollision(AgvDocks agvDock){
        Square begin = agvDock.getBegin();
        Square end = agvDock.getEnd();
        Square depth = agvDock.getDepth();

        return checkCollision(begin, end, depth);

    }

    private Boolean checkCollision(Square newBegin, Square newEnd, Square newDepth){
        Boolean collides = false;

        if(Boolean.TRUE.equals(checkInBounds(newBegin, newEnd, newDepth))){

            for (Aisles aisle : this.aisles) {
                collides = intersects(aisle.getBegin(), aisle.getEnd(), aisle.getDepth(), newBegin, newEnd, newDepth);

            }

            for (AgvDocks agvDock : this.agvDocks) {
                collides = intersects(agvDock.getBegin(), agvDock.getEnd(), agvDock.getDepth(), newBegin, newEnd, newDepth);
            }
        }else{
            collides=true;
        }
        return collides;
    }

    private Boolean intersects(Square oldBegin, Square oldEnd, Square oldDepth,Square newBegin, Square newEnd, Square newDepth){
        Boolean doesIntersects = true;

        if(oldBegin.length().value()>=newEnd.length().value() || newBegin.length().value() >= oldEnd.length().value())
            doesIntersects = false;

        else if(oldBegin.width().value()>=newDepth.width().value() || newBegin.width().value() >=oldDepth.width().value())
            doesIntersects = false;

        return doesIntersects;

    }

    private Boolean checkInBounds(Square newBegin, Square newEnd, Square newDepth){
        Boolean inBounds = true;
        double squareLengthAmount = this.warehouseLength.value()/this.warehouseSquare.value();
        double squareWidthAmount = this.warehouseWidth.value()/this.warehouseSquare.value();

        if(newBegin.length().value()>squareLengthAmount ||  newEnd.length().value()>squareLengthAmount || newDepth.length().value()>squareLengthAmount){
            inBounds = false;
        }
        if(newBegin.width().value()>squareWidthAmount ||  newEnd.width().value()>squareWidthAmount || newDepth.width().value()>squareWidthAmount){
            inBounds = false;
        }
        if(newBegin.length().value()<1 ||  newEnd.length().value()<1 || newDepth.length().value()<1){
            inBounds = false;
        }
        if(newBegin.width().value()<1 ||  newEnd.width().value()<1 || newDepth.width().value()<1){
            inBounds = false;
        }

        return inBounds;
    }

    public void addAisles(Aisles newAisle) throws IOException {
        if(Boolean.FALSE.equals(checkAccessibility(newAisle)))
            throw new IOException("aisle is not accessible");
        if(Boolean.TRUE.equals(checkCollision(newAisle)))
            throw new IOException("aisle is colliding");
        this.aisles.add(newAisle);
    }

    public void addAgvDock(AgvDocks newDock) throws IOException{
        if(Boolean.FALSE.equals(checkAccessibility(newDock)))
            throw new IOException("dock is not accessible");
        if(Boolean.TRUE.equals(checkCollision(newDock))) {
            throw new IOException("dock is colliding or out of bounds");
        }
        this.agvDocks.add(newDock);
    }


    @Override
    public boolean sameAs(Object other) {
        return false;
    }


    @Override
    public WarehouseIdentification identity() {
        return this.warehouse;
    }
}
