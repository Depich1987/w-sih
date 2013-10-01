// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.depich1987.wsih.domain;

import com.depich1987.wsih.domain.WSMedecineType;
import com.depich1987.wsih.domain.WSMedecineTypeDataOnDemand;
import com.depich1987.wsih.domain.WSMedecineTypeIntegrationTest;
import java.util.Iterator;
import java.util.List;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

privileged aspect WSMedecineTypeIntegrationTest_Roo_IntegrationTest {
    
    declare @type: WSMedecineTypeIntegrationTest: @RunWith(SpringJUnit4ClassRunner.class);
    
    declare @type: WSMedecineTypeIntegrationTest: @ContextConfiguration(locations = "classpath*:/META-INF/spring/applicationContext*.xml");
    
    declare @type: WSMedecineTypeIntegrationTest: @Transactional;
    
    @Autowired
    WSMedecineTypeDataOnDemand WSMedecineTypeIntegrationTest.dod;
    
    @Test
    public void WSMedecineTypeIntegrationTest.testCountWSMedecineTypes() {
        Assert.assertNotNull("Data on demand for 'WSMedecineType' failed to initialize correctly", dod.getRandomWSMedecineType());
        long count = WSMedecineType.countWSMedecineTypes();
        Assert.assertTrue("Counter for 'WSMedecineType' incorrectly reported there were no entries", count > 0);
    }
    
    @Test
    public void WSMedecineTypeIntegrationTest.testFindWSMedecineType() {
        WSMedecineType obj = dod.getRandomWSMedecineType();
        Assert.assertNotNull("Data on demand for 'WSMedecineType' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'WSMedecineType' failed to provide an identifier", id);
        obj = WSMedecineType.findWSMedecineType(id);
        Assert.assertNotNull("Find method for 'WSMedecineType' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'WSMedecineType' returned the incorrect identifier", id, obj.getId());
    }
    
    @Test
    public void WSMedecineTypeIntegrationTest.testFindAllWSMedecineTypes() {
        Assert.assertNotNull("Data on demand for 'WSMedecineType' failed to initialize correctly", dod.getRandomWSMedecineType());
        long count = WSMedecineType.countWSMedecineTypes();
        Assert.assertTrue("Too expensive to perform a find all test for 'WSMedecineType', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<WSMedecineType> result = WSMedecineType.findAllWSMedecineTypes();
        Assert.assertNotNull("Find all method for 'WSMedecineType' illegally returned null", result);
        Assert.assertTrue("Find all method for 'WSMedecineType' failed to return any data", result.size() > 0);
    }
    
    @Test
    public void WSMedecineTypeIntegrationTest.testFindWSMedecineTypeEntries() {
        Assert.assertNotNull("Data on demand for 'WSMedecineType' failed to initialize correctly", dod.getRandomWSMedecineType());
        long count = WSMedecineType.countWSMedecineTypes();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<WSMedecineType> result = WSMedecineType.findWSMedecineTypeEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'WSMedecineType' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'WSMedecineType' returned an incorrect number of entries", count, result.size());
    }
    
    @Test
    public void WSMedecineTypeIntegrationTest.testFlush() {
        WSMedecineType obj = dod.getRandomWSMedecineType();
        Assert.assertNotNull("Data on demand for 'WSMedecineType' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'WSMedecineType' failed to provide an identifier", id);
        obj = WSMedecineType.findWSMedecineType(id);
        Assert.assertNotNull("Find method for 'WSMedecineType' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifyWSMedecineType(obj);
        Integer currentVersion = obj.getVersion();
        obj.flush();
        Assert.assertTrue("Version for 'WSMedecineType' failed to increment on flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }
    
    @Test
    public void WSMedecineTypeIntegrationTest.testMergeUpdate() {
        WSMedecineType obj = dod.getRandomWSMedecineType();
        Assert.assertNotNull("Data on demand for 'WSMedecineType' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'WSMedecineType' failed to provide an identifier", id);
        obj = WSMedecineType.findWSMedecineType(id);
        boolean modified =  dod.modifyWSMedecineType(obj);
        Integer currentVersion = obj.getVersion();
        WSMedecineType merged = obj.merge();
        obj.flush();
        Assert.assertEquals("Identifier of merged object not the same as identifier of original object", merged.getId(), id);
        Assert.assertTrue("Version for 'WSMedecineType' failed to increment on merge and flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }
    
    @Test
    public void WSMedecineTypeIntegrationTest.testPersist() {
        Assert.assertNotNull("Data on demand for 'WSMedecineType' failed to initialize correctly", dod.getRandomWSMedecineType());
        WSMedecineType obj = dod.getNewTransientWSMedecineType(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'WSMedecineType' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'WSMedecineType' identifier to be null", obj.getId());
        try {
            obj.persist();
        } catch (final ConstraintViolationException e) {
            final StringBuilder msg = new StringBuilder();
            for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                final ConstraintViolation<?> cv = iter.next();
                msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
            }
            throw new IllegalStateException(msg.toString(), e);
        }
        obj.flush();
        Assert.assertNotNull("Expected 'WSMedecineType' identifier to no longer be null", obj.getId());
    }
    
    @Test
    public void WSMedecineTypeIntegrationTest.testRemove() {
        WSMedecineType obj = dod.getRandomWSMedecineType();
        Assert.assertNotNull("Data on demand for 'WSMedecineType' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'WSMedecineType' failed to provide an identifier", id);
        obj = WSMedecineType.findWSMedecineType(id);
        obj.remove();
        obj.flush();
        Assert.assertNull("Failed to remove 'WSMedecineType' with identifier '" + id + "'", WSMedecineType.findWSMedecineType(id));
    }
    
}