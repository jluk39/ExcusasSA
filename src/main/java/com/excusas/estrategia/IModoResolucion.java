package com.excusas.estrategia;

import com.excusas.excusa.IExcusa;
import com.excusas.empleado.encargado.IEncargado;

public interface IModoResolucion {
    void resolver(IExcusa excusa, IEncargado actual, IEncargado siguiente);
}
