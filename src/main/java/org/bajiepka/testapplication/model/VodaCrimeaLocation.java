package org.bajiepka.testapplication.model;

public enum VodaCrimeaLocation {
    KERCH("lead-kerch");

    String siteLocationId;

    VodaCrimeaLocation(String location) {
        this.siteLocationId = location;
    }

    public String getSiteLocationId() {
        return siteLocationId;
    }
}
