package com.topsun.posclient.finance.webservice;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.7.4
 * 2013-06-25T14:08:35.284-07:00
 * Generated source version: 2.7.4
 * 
 */
@WebServiceClient(name = "IFinanceServiceService", wsdlLocation = "financeWebService.wsdl",targetNamespace = "http://service.pos.webservice.topsunit.com/") 
public class IFinanceServiceService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://service.pos.webservice.topsunit.com/", "IFinanceServiceService");
    public final static QName IFinanceServicePort = new QName("http://service.pos.webservice.topsunit.com/", "IFinanceServicePort");
    static {
        URL url = null;
        try {
            url = new URL("financeWebService.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(IFinanceServiceService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "financeWebService.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public IFinanceServiceService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public IFinanceServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public IFinanceServiceService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    /**
     *
     * @return
     *     returns IFinanceService
     */
    @WebEndpoint(name = "IFinanceServicePort")
    public IFinanceService getIFinanceServicePort() {
        return super.getPort(IFinanceServicePort, IFinanceService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IFinanceService
     */
    @WebEndpoint(name = "IFinanceServicePort")
    public IFinanceService getIFinanceServicePort(WebServiceFeature... features) {
        return super.getPort(IFinanceServicePort, IFinanceService.class, features);
    }

}