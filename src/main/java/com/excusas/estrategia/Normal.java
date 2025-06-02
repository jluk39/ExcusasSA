package com.excusas.estrategia;

import com.excusas.excusa.IExcusa;
import com.excusas.empleado.encargado.IEncargado;

public class Normal implements IModoResolucion {
    @Override
    public void resolver(IExcusa excusa, IEncargado actual, IEncargado siguiente) {
        if (actual.puedeManejar(excusa)) {
            actual.procesar(excusa);
        } else if (siguiente != null) {
            siguiente.manejarExcusa(excusa);
        }
    }
}
