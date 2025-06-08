package com.excusas.estrategia;

import com.excusas.excusa.IExcusa;
import com.excusas.empleado.encargado.EncargadoBase;

public class Productivo implements IModoResolucion {
    @Override
    public void resolver(EncargadoBase encargado, IExcusa excusa) {
        encargado.procesar(excusa); // siempre procesa
    }
}
