package com.excusas.excusa.motivo;

import com.excusas.excusa.IExcusa;
import com.excusas.empleado.encargado.*;

public abstract class MotivoExcusa implements IMotivoExcusa {

    @Override
    public void procesarPor(Recepcionista r, IExcusa excusa) {}

    @Override
    public void procesarPor(SupervisorArea s, IExcusa excusa) {}

    @Override
    public void procesarPor(GerenteRRHH g, IExcusa excusa) {}

    @Override
    public void procesarPor(CEO c, IExcusa excusa) {}
}
