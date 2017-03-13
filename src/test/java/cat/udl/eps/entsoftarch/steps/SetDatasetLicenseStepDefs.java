package cat.udl.eps.entsoftarch.steps;

import cat.udl.eps.entsoftarch.domain.ClosedLicense;
import cat.udl.eps.entsoftarch.domain.Dataset;
import cat.udl.eps.entsoftarch.domain.OpenLicense;
import cat.udl.eps.entsoftarch.repository.ClosedLicenseRepository;
import cat.udl.eps.entsoftarch.repository.DatasetRepository;
import cat.udl.eps.entsoftarch.repository.OpenLicenseRepository;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;

import org.springframework.beans.factory.annotation.Autowired;



/**
 * Created by Sergi on 8/3/17.
 */
public class SetDatasetLicenseStepDefs {

    @Autowired
    private OpenLicenseRepository openLicenseRepository;
    @Autowired
    private ClosedLicenseRepository closedLicenseRepository;
    @Autowired
    private DatasetRepository datasetRepository;


    /*OPEN LICENSE*/

    @When("^I set the open license with text \"([^\"]*)\" to dataset with title \"([^\"]*)\"$")
    public void setOpenLicenseToDataset(String text, String title) throws Throwable {
        OpenLicense openLicense = openLicenseRepository.findByText(text).get(0);
        Dataset dataset = datasetRepository.findByTitle(title).get(0);
        dataset.setOpenLicense(openLicense);
    }

    @Then("^The dataset with title \"([^\"]*)\" has a open license with text \"([^\"]*)\"$")
    public void theDatasetWithTitleHasAOpenLicenseWithText(String title, String text) throws Throwable {
        Dataset dataset = datasetRepository.findByTitle(title).get(0);
        OpenLicense openLicense = dataset.getOpenLicense();
        assertEquals(openLicense.getText(),text);
    }

    /*CLOSED LICENSE*/
    @When("^I set the closed license with text \"([^\"]*)\" and price (\\d+) to dataset with title \"([^\"]*)\"$")
    public void iSetTheClosedLicenseWithTextAndPriceToDatasetWithTitle(String text, int count, String title) throws Throwable {
        ClosedLicense closedLicense = closedLicenseRepository.findByText(text).get(0);
        Dataset dataset = datasetRepository.findByTitle(title).get(0);
        dataset.setClosedLicense(closedLicense);
    }

    @Then("^The dataset with title \"([^\"]*)\" has a closed license with text \"([^\"]*)\" and price (\\d+)$")
    public void theDatasetWithTitleHasAClosedLicenseWithTextAndPrice(String title, String text, int count) throws Throwable {
        Dataset dataset = datasetRepository.findByTitle(title).get(0);
        ClosedLicense closedLicense = dataset.getClosedLicense();
        assertEquals(closedLicense.getText(),text);
    }
}
