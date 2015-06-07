package com.giuliopulina;

import org.springframework.messaging.Message;
import org.springframework.integration.jdbc.JdbcPollingChannelAdapter;

import javax.print.attribute.IntegerSyntax;
import javax.sql.DataSource;
import java.util.Date;

//CHECKSTYLE:OFF
public class JdbcPoller extends JdbcPollingChannelAdapter {

    private ThreadLocal<Integer> numberOfPolls = new ThreadLocal<Integer>();

    public JdbcPoller(DataSource dataSource, String selectQuery) {
        super(dataSource, selectQuery);
    }

    @Override
    public Message<Object> receive() {

        Message<Object> obj = null;
        try {
            obj = super.receive();
            if (numberOfPolls.get() == null){
                numberOfPolls.set(1);
            }
            else {
                numberOfPolls.set(numberOfPolls.get() + 1);
            }

            System.out.println(Thread.currentThread().getName() + " " + new Date() + " - Poll occurred at time - number of polls " + getNumberOfPolls());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + "  Returned object = " + obj);
        return obj;
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    public Integer getNumberOfPolls() {
        return numberOfPolls.get();
    }
}