package com.excusas.test;

import com.excusas.empleado.Empleado;
import com.excusas.empleado.encargado.IEncargado;
import com.excusas.excusa.IExcusa;
import com.excusas.excusa.motivo.*;
import com.excusas.servicio.LineaDeEncargados;

public class CadenaDePrueba {

    public static void main(String[] args) {
        IEncargado cadena = LineaDeEncargados.crearCadena();

        // empleado que genera excusas
        Empleado empleado = new Empleado("Lucía", "lucia@mail.com", 102);

        // 1. excusa trivial (procesa el recepcionista)
        System.out.println("\n--- Probando excusa trivial ---");
        IExcusa excusa1 = empleado.generarExcusa(new Trivial());
        cadena.manejarExcusa(excusa1);

        // 2. excusa moderada (corte de luz)
        System.out.println("\n--- Probando excusa moderada (Corte de Luz) ---");
        IExcusa excusa2 = empleado.generarExcusa(new CorteLuz());
        cadena.manejarExcusa(excusa2);

        // 3. excusa inverosímil (increíble)
        System.out.println("\n--- Probando excusa inverosímil ---");
        IExcusa excusa3 = empleado.generarExcusa(new Inverosimil());
        cadena.manejarExcusa(excusa3);
    }
}
