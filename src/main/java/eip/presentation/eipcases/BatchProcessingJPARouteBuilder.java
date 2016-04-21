package eip.presentation.eipcases;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.BindyType;

/**
 * Created by ilievi on 21.04.2016.
 */
public class BatchProcessingJPARouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:data?charset=utf-8&doneFileName=${file:name}.done&move=.done&moveFailed=.error")
                .unmarshal()
                .bindy(BindyType.Csv, AddressCsvEntity.class)
                .to("jpa:eip.presentation.eipcases.AddressCsvEntity");
    }
}
