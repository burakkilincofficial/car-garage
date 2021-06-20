package com.vodafone.garage.entity;

import com.vodafone.garage.entity.abstracts.model.VehicleType;
import com.vodafone.garage.entity.concretes.Vehicle;
import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Field;

@RunWith(SpringJUnit4ClassRunner.class)
class VehicleTest extends TestCase {
    private static final int ID = 1;
    private static final int year = 1992;
    private static final String LICENSE_NUMBER = "669-7788";
    private static final VehicleType VEHICLE_TYPE = VehicleType.CAR;
    private static final String FIELDS_NOT_MATCH = "Fields did not match";
    private static final String FIELDS_WAS_NOT_RETRIEVED = "field was not retrieved properly";
    Vehicle pojo;

    @BeforeEach
    public void setUp() {
        pojo = new Vehicle();
    }

    @Test
    void getId() throws NoSuchFieldException, IllegalAccessException {
        final Field field = pojo.getClass().getDeclaredField("id");
        field.setAccessible(true);
        field.set(pojo, ID);

        //when
        final int result = pojo.getId();

        //then
        assertEquals(FIELDS_WAS_NOT_RETRIEVED, result, ID);
    }

    @Test
    void setId() throws NoSuchFieldException, IllegalAccessException {
        //when
        pojo.setId(ID);

        //then
        final Field field = pojo.getClass().getDeclaredField("id");
        field.setAccessible(true);
        assertEquals(FIELDS_NOT_MATCH, field.get(pojo), ID);
    }

}
