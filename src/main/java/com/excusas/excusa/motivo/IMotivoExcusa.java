package com.excusas.excusa.motivo;

import com.excusas.empleado.encargado.*;
import com.excusas.excusa.IExcusa;

public interface IMotivoExcusa {
    void procesarPor(Recepcionista r, IExcusa excusa);
    void procesarPor(SupervisorArea s, IExcusa excusa);
    void procesarPor(GerenteRRHH g, IExcusa excusa);
    void procesarPor(CEO c, IExcusa excusa);

    default boolean esTrivial() { return false; }
    default boolean esModerada() { return false; }
    default boolean esCompleja() { return false; }
    default boolean esInverosimil() { return false; }
}
