package com.excusas.observer;

import com.excusas.excusa.IExcusa;

import java.util.ArrayList;
import java.util.List;

public class AdministradorProntuarios implements IObservable {

    private static AdministradorProntuarios instancia;

    private final List<IObserver> observers = new ArrayList<>();
    private final List<IExcusa> prontuarios = new ArrayList<>();

    private AdministradorProntuarios() {}

    public static AdministradorProntuarios getInstancia() {
        if (instancia == null) {
            instancia = new AdministradorProntuarios();
        }
        return instancia;
    }

    public void guardarProntuario(IExcusa excusa) {
        prontuarios.add(excusa);
    }

    @Override
    public void agregarObserver(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void quitarObserver(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notificarObservers() {
        for (IObserver observer : observers) {
            observer.actualizar();
        }
    }
}
