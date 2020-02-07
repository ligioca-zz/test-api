package helper

import groovy.json.JsonSlurper
import models.BillingAddress
import models.ShippingAddress
import net.sf.json.JSONObject

class AddressParser {

    def addressesParser(JSONObject addressesJson){
        def billingAddress = new JsonSlurper().parseText(addressesJson['billingAddress'].toString()) as BillingAddress
        def shippingAddress = new JsonSlurper().parseText(addressesJson['shippingAddress'].toString()) as ShippingAddress
        [billingAddress, shippingAddress]
    }

}
