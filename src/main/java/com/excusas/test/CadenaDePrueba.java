package com.excusas.test;

import com.excusas.empleado.Empleado;
import com.excusas.empleado.encargado.*;
import com.excusas.estrategia.Normal;
import com.excusas.excusa.IExcusa;
import com.excusas.excusa.motivo.*;
import com.excusas.servicio.EmailSenderImpl;

public class CadenaDePrueba {

    public static void main(String[] args) {
        // EmailSender compartido
        EmailSenderImpl emailSender = new EmailSenderImpl();

        // Encargados
        IEncargado rechazador = new Rechazador(emailSender);
        CEO ceo = new CEO("Romina", "laRomi@mail.com", 4, new Normal(), emailSender);
        GerenteRRHH gerente = new GerenteRRHH("Roberto", "robertito05@mail.com", 3, new Normal(), emailSender);
        SupervisorArea supervisor = new SupervisorArea("Luis", "luisito@mail.com", 2, new Normal(), emailSender);
        Recepcionista recepcionista = new Recepcionista("Jeremias", "jeremiadiaz@mail.com", 1, new Normal(), emailSender);

        // Cadena de encargados
        recepcionista.setSiguiente(supervisor);
        supervisor.setSiguiente(gerente);
        gerente.setSiguiente(ceo);
        ceo.setSiguiente(rechazador);

        // Empleado que genera excusas
        Empleado empleado = new Empleado("Lucía", "lucia@mail.com", 102);

        // 1. Excusa trivial (la procesa el recepcionista)
        System.out.println("\n--- Probando excusa trivial ---");
        IExcusa excusa1 = empleado.generarExcusa(new Trivial());
        recepcionista.manejarExcusa(excusa1);

        // 2. Excusa moderada (corte de luz)
        System.out.println("\n--- Probando excusa moderada (Corte de Luz) ---");
        IExcusa excusa2 = empleado.generarExcusa(new CorteLuz());
        recepcionista.manejarExcusa(excusa2);

        // 3. Excusa inverosímil (increíble)
        System.out.println("\n--- Probando excusa inverosímil ---");
        IExcusa excusa3 = empleado.generarExcusa(new Inverosimil());
        recepcionista.manejarExcusa(excusa3);
    }
}
