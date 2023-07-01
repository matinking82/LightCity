package org.example.interfaces;

import org.example.models.Character;
import org.example.models.Property;

public interface MunicipalityInterface {

//    Buy and sell property
    Property buyProperty(Character buyer, float[] coordinate);
    void sellProperty(Property property,Character buyer);
    void showProperties();
}
