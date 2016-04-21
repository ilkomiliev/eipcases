package eip.presentation.eipcases;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.BindyType;
import org.apache.camel.test.junit4.CamelTestSupport;

/**
 * Created by ilievi on 21.04.2016.
 */
public class AddressBindyJPATest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("direct:fromCsv")
                        .unmarshal()
                        .bindy(BindyType.Csv, AddressCsvEntity.class)
                        .bean(AddressCsvEntityToSqlTransformer.class)
                        .to("jpa:eip.presentation.eipcases.AddressCsvEntity")
                        .to("mock:result");
            }
        };
    }
}
