package me.abel.elasticsearch.template;

import org.junit.Test;

import static org.junit.Assert.*;

public class TemplatePropertiesGetterTest {

    @Test
    public void getTemplateProperties() {
//        TemplatePropertiesGetter.getTemplates();
//        vehicleinstance_dev
//        vehicletype_dev
//        parts_dev
//        ydstore_dev
//        normalcustomer_dev
//        partssale_dev
//        maintenance_dev
        TemplatePropertiesGetter.getTemplateProperties("maintenance_dev");
    }
}