package com.excusas.estrategia;

import com.excusas.excusa.IExcusa;
import com.excusas.empleado.encargado.IEncargado;

public class Vago implements IModoResolucion {
    @Override
    public void resolver(IExcusa excusa, IEncargado actual, IEncargado siguiente) {
        if (siguiente != null) {
            siguiente.manejarExcusa(excusa);
        }
    }
}
