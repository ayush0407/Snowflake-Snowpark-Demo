package com.snowpark.demo;

import com.snowflake.snowpark.DataFrame;
import com.snowflake.snowpark.Row;
import com.snowflake.snowpark.Session;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

import org.springframework.stereotype.Service;

@Service
public class SnowflakeService {

    private final Session session = Session.builder().configFile(Application.class.getResource("/application.properties").toURI().getPath()).create();

    public SnowflakeService() throws URISyntaxException {
        System.out.println(runProcedure().toString());
    }

    public List<Row> runProcedure() throws URISyntaxException {
        String query = "CALL employee_added_per_month()";
        DataFrame df = this.session.sql(query.toString());
        System.out.println(Arrays.toString(df.collect()));
        return Arrays.asList(df.collect());
    }

    public void close() {
        this.session.close();
    }


}
