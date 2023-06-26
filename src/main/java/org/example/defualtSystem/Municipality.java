package org.example.defualtSystem;

import org.example.interfaces.MunicipalityInterface;
import org.example.models.Character;
import org.example.models.Property;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Municipality implements MunicipalityInterface {
    private ArrayList<Property> properties;

    public  Municipality(){
        generateProperties();
    }

    private void generateProperties() {
        // Define the size of the city
        float cityWidth = 2000.0f;
        float cityHeight = 2000.0f;

        // Define the size of each cell in the grid
        float cellSize = 50.0f;

        // Create a grid of cells within the city boundaries
        int numCols = (int) Math.ceil(cityWidth / cellSize);
        int numRows = (int) Math.ceil(cityHeight / cellSize);

        // Generate a property for each cell in the grid
        properties = new ArrayList<>();
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                float[] coordinates = {col, row};
                // Generate random scales for the property
                float[] scales = {randomFloat(1.0f, 5.0f), randomFloat(1.0f, 5.0f)};

                // Create the property and add it to the list
                Property property = new Property(scales, coordinates, null);
                properties.add(property);
            }
        }
    }

    // Helper method to generate a random float within a range
    private float randomFloat(float min, float max) {
        return (float) (Math.random() * (max - min) + min);
    }
    @Override
    public Property buyProperty(Character buyer,float[] coordinate) {
        for (Property p :
                properties) {
            if (p.getCoordinate()[0] == coordinate[0] && p.getCoordinate()[1] == coordinate[1]){
                sellProperty(p);
                p.setOwner(buyer);
                return p;
            }
        }
        return null;
    }

    @Override
    public void sellProperty(Property property) {
        Character prevOwner = property.getOwner();
        //TODO
        property.setOwner(null);
    }

    @Override
    public void showProperties() {
        for (int i = 0;i<properties.size();i++){
            Property p = properties.get(i);
            System.out.println(Integer.toString(i+1)+"- at :"+p.getCoordinate()[0]+"-"+p.getCoordinate()[0]
                    +" size: "+p.getScales()[0]+" by "+p.getScales()[1]);
        }
    }

    public List<Property> getProperties(){
        return properties;
    }
}
