package com.excusas.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class ObservableBase implements IObservable {
    private final List<IObserver> observers = new ArrayList<>();

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
        for (IObserver o : observers) {
            o.actualizar();
        }
    }
}
