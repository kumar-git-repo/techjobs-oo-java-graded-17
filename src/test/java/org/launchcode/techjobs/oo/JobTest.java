package org.launchcode.techjobs.oo;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.testng.Assert.assertNotEquals;

public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId(), "Job IDs should be distinct");
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("Product tester", job.getName());
        assertEquals("ACME", job.getEmployer().getValue());
        assertEquals("Desert", job.getLocation().getValue());
        assertEquals("Quality control", job.getPositionType().getValue());
        assertEquals("Persistence", job.getCoreCompetency().getValue());
        assertTrue(job instanceof Job);
        assertTrue(job.getEmployer() instanceof Employer);
        assertTrue(job.getLocation() instanceof Location);
        assertTrue(job.getPositionType() instanceof PositionType);
        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(job1.equals(job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job = new Job();
        String stringJob = job.toString();
        assertTrue(stringJob.startsWith(System.lineSeparator()));
        assertTrue(stringJob.endsWith(System.lineSeparator()));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String stringJob = job.toString();
        String expected =
                System.lineSeparator()
                        + "ID: " + job.getId() + System.lineSeparator()
                        + "Name: " + job.getName() + System.lineSeparator()
                        + "Employer: " + job.getEmployer().getValue() + System.lineSeparator()
                        + "Location: " + job.getLocation().getValue() + System.lineSeparator()
                        + "Position Type: " + job.getPositionType().getValue() + System.lineSeparator()
                        + "Core Competency: " + job.getCoreCompetency().getValue() +
                        System.lineSeparator();
        assertEquals(expected, stringJob);
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location(""), new PositionType("Quality control"), new CoreCompetency(""));
        String stringJob = job.toString();
        String expected =
                System.lineSeparator()
                        + "ID: " + job.getId() + System.lineSeparator()
                        + "Name: " + job.getName() + System.lineSeparator()
                        + "Employer: " + job.getEmployer().getValue() + System.lineSeparator()
                        + "Location: " + "Data not available" + System.lineSeparator()
                        + "Position Type: " + job.getPositionType().getValue() + System.lineSeparator()
                        + "Core Competency: " + "Data is not available" +
                        System.lineSeparator();
    }
}