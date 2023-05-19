/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.ActionController;
import controller.BranchController;
import controller.RequestController;
import controller.exception.SpaceException;
import controller.sd.exception.EmptyException;
import controller.sd.exception.IndexException;
import controller.sd.exception.TopException;
import controller.sd.list.MyLinkedList;
import controller.util.Util;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import model.MonthEnum;

/**
 *
 * @author miguel
 */
public class Main {

//. Registrar la informacion de las ventas por mes de cada una de las sucursales. Done
//. Mostrar en pantalla el resumen de ventas de cada sucursal. Done
//. Mostrar cual fue el total de ventas en el año de cualquier sucursal. Done
//. Mostrar el promedio de ventas en cualquier mes. done
//. Mostrar el numero de la sucursal que tuvo mayores ventas en cualquier mes. done (maybe)
//. Indicar en que mes se registraron las menores ventas del año, considerando todas las sucursales. done
//. Guardar el historial de acciones usadas en el sistema con las fechas(20).
//. Crear un módulo de peticiones para usuarios(reclamos), en el cual se deberá borrar pasado 1 hora.
    
    public static void main(String[] args) throws EmptyException, IndexException, SpaceException, TopException {
        BranchController controller = new BranchController();
        ActionController history = new ActionController();

        controller.getBranch().setName("Nro 1");
        controller.register();
        history.getAction().setDescription("Registered branch " + controller.getBranch().getName());
        controller.setBranch(null);
        history.register();

        controller.getBranch().setName("Nro 2");
        controller.register();
        history.getAction().setDescription("Registered branch " + controller.getBranch().getName());
        controller.setBranch(null);
        history.register();

        controller.getBranch().setName("Nro 3");
        controller.register();
        history.getAction().setDescription("Registered branch " + controller.getBranch().getName());
        controller.setBranch(null);
        history.register();

        controller.getBranch().setName("Nro 4");
        controller.register();
        history.getAction().setDescription("Registered branch " + controller.getBranch().getName());
        controller.setBranch(null);
        history.register();

//        Util.printStruct(controller.getBranches());
        controller.setBranch(controller.getBranches().get(0));
        controller.setSale(controller.getBranch().getSales().get(3));
        controller.saveSale(3, 140);
        history.getAction().setDescription("Saved " + controller.getSale() + " in branch " + controller.getBranch().getName());
        controller.setSale(null);
        history.register();

        controller.setBranch(controller.getBranches().get(1));
        controller.setSale(controller.getBranch().getSales().get(3));
        controller.saveSale(3, 330);
        history.getAction().setDescription("Save " + controller.getSale() + " in branch " + controller.getBranch().getName());
        controller.setSale(null);
        history.register();

        controller.setBranch(controller.getBranches().get(2));
        controller.setSale(controller.getBranch().getSales().get(3));
        controller.saveSale(3, 230);
        history.getAction().setDescription("Save " + controller.getSale() + " in branch " + controller.getBranch().getName());
        controller.setSale(null);
        history.register();

        controller.setBranch(controller.getBranches().get(3));
        controller.setSale(controller.getBranch().getSales().get(3));
        controller.saveSale(3, 430);
        history.getAction().setDescription("Save " + controller.getSale() + " in branch " + controller.getBranch().getName());
        controller.setSale(null);
        history.register();

//        history.getHistory().print();
        
        RequestController pr = new RequestController();
        
        pr.getRequest().setRequest("In this case i going to say, why.. why, i'm broke ;c");
        
        pr.register();
        
        pr.update();
        
    }
}
