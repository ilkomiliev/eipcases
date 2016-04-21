package eip.presentation.eipcases;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.impl.JndiRegistry;
import org.apache.camel.model.dataformat.BindyType;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * Created by ilievi on 21.04.2016.
 */
public class AddressBindyJDBCTest extends CamelTestSupport {

    static final String TESTDATA = "APLZ,AGKZ,ASTR,ANRV,ANRB,ASTG,ATOP,AORT,APOL\n4040,40101,Jägerstraße,18,,,,Linz,Magistrat Linz";

    private static final String TRANSFORMED_SQL = "insert into APP.ADDRESS(PLZ,GKZ,STR,NRV,NRB,STG,TOP,ORT,POL) values ('4040','40101','Jägerstraße','18',null,null,null,'Linz','Magistrat Linz')";

    private JdbcTemplate jdbc;

    @Before
    public void setupDatabase() throws Exception {
        DataSource ds = context.getRegistry().lookupByNameAndType("ds", DataSource.class);
        jdbc = new JdbcTemplate(ds);
    }


    @Test
    public void testUnmarshall() throws Exception {
        MockEndpoint mockEndpoint = getMockEndpoint("mock:result");
        //mockEndpoint.expectedBodiesReceived(createTestAddressEntity());
        mockEndpoint.expectedMessageCount(1);

        Integer numOfRowsBefore = jdbc.queryForObject("select count(*) from APP.ADDRESS", Integer.class);

        template.sendBody("direct:fromCsv", TESTDATA);

        mockEndpoint.assertIsSatisfied();

        int expected = ++numOfRowsBefore;

        int actual = jdbc.queryForObject("select count(*) from APP.ADDRESS", Integer.class);

        assertEquals(expected, actual);
    }

    /*@Test
    public void testUnmarshallFails() throws Exception {
        MockEndpoint mockEndpoint = getMockEndpoint("mock:result");
        List<?> wrongReply = createWrongTestAddressEntity();
        mockEndpoint.expectedBodiesReceived(wrongReply);
        template.sendBody("direct:fromCsv", TESTDATA);
        mockEndpoint.assertIsNotSatisfied();

    }*/

    /*private List<?> createWrongTestAddressEntity() {
        AddressCsvEntity entity = makeAddessEntity();
        entity.setPol("");
        return Arrays.asList(entity);
    }

    private List<?> createTestAddressEntity() {
        Object entity = makeAddessEntity();
        return Arrays.asList(entity);
    }

    private AddressCsvEntity makeAddessEntity() {
        AddressCsvEntity entity = new AddressCsvEntity();
        entity.setPlz("4040");
        entity.setGkz("40101");
        entity.setStr("Jägerstraße");
        entity.setNrv("18");
        entity.setOrt("Linz");
        entity.setPol("Magistrat Linz");
        return entity;
    }*/

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("direct:fromCsv")
                        .unmarshal()
                        .bindy(BindyType.Csv, AddressCsvEntity.class)
                        .bean(AddressCsvEntityToSqlTransformer.class)
                        .to("jdbc:ds")
                        .to("mock:result");
            }
        };
    }

    @Override
    protected JndiRegistry createRegistry() throws Exception {
        JndiRegistry registry = super.createRegistry();

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.apache.derby.jdbc.ClientDriver");
        dataSource.setUrl("jdbc:derby://localhost:1527/eipcases");
        dataSource.setUsername("sa");
        dataSource.setPassword("sa");

        registry.bind("ds", dataSource);
        return registry;
    }
}
