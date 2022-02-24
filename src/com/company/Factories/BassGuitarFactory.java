package com.company.Factories;

import com.company.Classes.Statics;
import com.company.EntityImpl.BassGuitar;
import com.company.Interfaces.Guitar;
import com.company.Interfaces.GuitarFactory;

public class BassGuitarFactory implements GuitarFactory {
    @Override
    public Guitar createInstance() {
        return new BassGuitar();
    }
}
