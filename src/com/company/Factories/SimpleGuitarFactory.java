package com.company.Factories;

import com.company.EntityImpl.SimpleGuitar;
import com.company.Interfaces.Guitar;
import com.company.Interfaces.GuitarFactory;

public class SimpleGuitarFactory implements GuitarFactory {
    @Override
    public Guitar createInstance() {
        return new SimpleGuitar();
    }
}
