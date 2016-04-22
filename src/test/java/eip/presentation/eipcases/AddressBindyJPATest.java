package eip.presentation.eipcases;

import org.apache.camel.RoutesBuilder;

/**
 * Created by ilievi on 21.04.2016.
 */
public class AddressBindyJPATest extends AddressBindyJDBCTest {

    @Override
    public void testUnmarshall() throws Exception {
        Thread.sleep(2000);
    }

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        /*return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("direct:fromCsv")
                        .unmarshal()
                        .bindy(BindyType.Csv, AddressCsvEntity.class)
                        .to("jpa:eip.presentation.eipcases.AddressCsvEntity")
                        .to("mock:result");
            }
        };*/
        return new BatchProcessingJPARouteBuilder();
    }
}
