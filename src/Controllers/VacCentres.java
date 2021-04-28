package Controllers;

import javafx.beans.property.SimpleStringProperty;

public class VacCentres {
    private SimpleStringProperty county, siteName, siteAddress;

    public VacCentres(String county, String siteName, String siteAddress) {
        this.county = new SimpleStringProperty (county);
        this.siteName = new SimpleStringProperty (siteName);
        this.siteAddress = new SimpleStringProperty (siteAddress);
    }

    public String getCounty() {
        return county.get();
    }

    public void setCounty(SimpleStringProperty county) {
        this.county = county;
    }

    public String getSiteName() {
        return siteName.get();
    }

    public void setSiteName(SimpleStringProperty siteName) {
        this.siteName = siteName;
    }

    public String getSiteAddress() {
        return siteAddress.get();
    }

    public void setSiteAddress(SimpleStringProperty siteAddress) {
        this.siteAddress = siteAddress;
    }  
}
