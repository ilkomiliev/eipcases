package eip.presentation.eipcases;

/**
 * Created by ilievi on 21.04.2016.
 */
public class AddressCsvEntityToSqlTransformer {

    public static String map(AddressCsvEntity entity) {
        StringBuilder sql = new StringBuilder("insert into APP.ADDRESS(PLZ," +
                "GKZ," +
                "STR," +
                "NRV," +
                "NRB," +
                "STG," +
                "TOP," +
                "ORT," +
                "POL) values (");
        String s = entity.getPlz();append(s, sql);
        s = entity.getGkz();append(s, sql);
        s = entity.getStr();append(s, sql);
        s = entity.getNrv();append(s, sql);
        s = entity.getNrb();append(s, sql);
        s = entity.getStg();append(s, sql);
        s = entity.getTop();append(s, sql);
        s = entity.getOrt();append(s, sql);
        s = entity.getPol();append(s, sql);
        sql.deleteCharAt(sql.length() - 1);
        sql.append(")");

        return sql.toString();
    }

    private static void append(String s, StringBuilder sql) {
        if (s != null) {
            sql.append("'").append(s).append("',");
        }
        else {
            sql.append("null,");
        }
    }
}
