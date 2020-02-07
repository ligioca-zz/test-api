package specification

import groovy.json.JsonSlurper
import helper.AddressParser
import models.BillingAddress
import models.ShippingAddress
import net.sf.json.JSONObject
import service_client.AddressClient
import spock.lang.Specification

class AddressSpec extends Specification {

    def addressClient = new AddressClient()
    def addressParser = new AddressParser()

    def "Check get default addresses"(){

        when: "Get default addresses"
        def getAddressesResponse = addressClient.getDefaultAddresses("12345678", "xxxxx")
        def addresses = addressParser.addressesParser(getAddressesResponse.getData()['payload'])
        def billingAddress = addresses.get(0)
        def shippingAddress = addresses.get(1)

        then: "Response should be 200"
        getAddressesResponse.getStatus() == 200

        and: "Body contains correct id"
        billingAddress.id == 12345678
        shippingAddress.id == 12345678

    }
}


