package com.excusas.test;

import com.excusas.empleado.encargado.*;
import com.excusas.estrategia.Normal;
import com.excusas.excusa.Excusa;
import com.excusas.excusa.IExcusa;
import com.excusas.excusa.motivo.*;
import com.excusas.servicio.EmailSenderImpl;

public class CadenaDePrueba {

    public static void main(String[] args) {
        // EmailSender compartido
        EmailSenderImpl emailSender = new EmailSenderImpl();

        // encargados
        IEncargado rechazador = new Rechazador(emailSender);
        CEO ceo = new CEO("Romina", "laRomi@mail.com", 4, new Normal(), emailSender);
        GerenteRRHH gerente = new GerenteRRHH("Roberto", "robertito05@mail.com", 3, new Normal(), emailSender);
        SupervisorArea supervisor = new SupervisorArea("Luis", "luisito@mail.com", 2, new Normal(), emailSender);
        Recepcionista recepcionista = new Recepcionista("Jeremias", "jeremiadiaz@mail.com", 1, new Normal(), emailSender);

        // cdena de encargados
        recepcionista.setSiguiente(supervisor);
        supervisor.setSiguiente(gerente);
        gerente.setSiguiente(ceo);
        ceo.setSiguiente(rechazador);

        // 1. excusa trivial (la procesa el recepcionista)
        System.out.println("\n--- Probando excusa trivial ---");
        Excusa excusa1 = new Excusa(new Trivial(), recepcionista);
        recepcionista.manejarExcusa(excusa1);

        // 2. excusa moderada (corte de luz)
        System.out.println("\n--- Probando excusa moderada (Corte de Luz) ---");
        Excusa excusa2 = new Excusa(new CorteLuz(), recepcionista);
        recepcionista.manejarExcusa(excusa2);

        // 3. excusa inverosímil (increíble)
        System.out.println("\n--- Probando excusa inverosímil ---");
        Excusa excusa3 = new Excusa(new Inverosimil(), recepcionista);
        recepcionista.manejarExcusa(excusa3);
    }
}
