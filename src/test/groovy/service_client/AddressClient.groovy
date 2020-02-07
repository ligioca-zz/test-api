package service_client

import groovy.json.JsonSlurper
import groovyx.net.http.HttpResponseDecorator
import groovyx.net.http.RESTClient
import models.BillingAddress
import models.ShippingAddress

class AddressClient {

    def apiService = new RESTClient("")

    def getDefaultAddresses(String customerId, String token){
        apiService.get(path: "",
                headers: ['Accept-Version': '1.0.0', 'X-Auth-Token': "${token}"])
    }
}
