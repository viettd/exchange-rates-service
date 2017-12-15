package com.github.viettd.exchange_rates.controller;

import com.github.viettd.exchange_rates.bean.Response;
import com.github.viettd.exchange_rates.common.Constant;
import com.github.viettd.exchange_rates.utils.Utils;
import com.google.gson.GsonBuilder;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ExchangeRatesServlet extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(ExchangeRatesServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        handle(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        handle(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        handle(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        handle(req, resp);
    }

    private void handle(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        long startTime = System.currentTimeMillis();
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");
        Response response = new Response();
        StringBuilder log = new StringBuilder();


        Utils.appendLog(log, String.format("%s %s %s", Utils.getClientIp(req), req.getMethod(), Utils.getUrl(req)));
        try {

        } catch (Exception e) {
            response = new Response(Constant.CODE_ERROR, e.getMessage());
            Utils.appendExceptionLog(log, "handle", e);
        }
        PrintWriter out = resp.getWriter();
        GsonBuilder builder = new GsonBuilder();
        builder.setDateFormat(Constant.DATE_TIME_FORMAT);
        out.print(builder.create().toJson(response));
        Utils.appendLog(log, (System.currentTimeMillis() - startTime) + "ms");
        LOGGER.info(log);
    }

}