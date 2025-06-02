package com.excusas.estrategia;

import com.excusas.excusa.IExcusa;
import com.excusas.empleado.encargado.IEncargado;

public class Productivo implements IModoResolucion {
    @Override
    public void resolver(IExcusa excusa, IEncargado actual, IEncargado siguiente) {
        actual.procesar(excusa); //  procesa sin preguntar si puede
    }
}
