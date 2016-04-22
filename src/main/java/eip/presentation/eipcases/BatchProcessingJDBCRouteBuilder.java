package eip.presentation.eipcases;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.BindyType;

/**
 * Created by ilievi on 21.04.2016.
 */
public class BatchProcessingJDBCRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:src/data?charset=utf-8&doneFileName=${file:name}.done&move=.done&moveFailed=.error")
                .split(body().tokenize("\n"))
                .unmarshal()
                .bindy(BindyType.Csv, AddressCsvEntity.class)
                .bean(AddressCsvEntityToSqlTransformer.class)
                .to("jdbc:ds");
    }


}
