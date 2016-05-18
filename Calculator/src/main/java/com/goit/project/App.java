package com.goit.project;

import static spark.Spark.*;

import java.util.HashMap;

import com.goit.project.arithmetic.Compute;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.freemarker.FreeMarkerEngine;
import freemarker.template.Configuration;

public class App {
    public static void main(String[] args) {

        port(2345);
        staticFileLocation("/public");

        Configuration viewDir = new Configuration();
        Compute compute = new Compute();
        viewDir.setClassForTemplateLoading(App.class, "/views");

        get("/Calculator", (request, response) -> {
            HashMap<String, Object> model = new HashMap<>();
            String item = (String) request.queryParams("expression");
            String result = "";
            try {
                result = compute.computeStringExpression(item);
            } catch (Exception e) {}
            model.put("result", result);

            return new ModelAndView(model, "calculator.ftl");
        }, new FreeMarkerEngine(viewDir));

        post("/Calculator", new Route() {
            @Override
            public Object handle(Request request, Response response) {
                String stringExpression = request.queryParams("expression");

                String result = "";
                try {
                    result = compute.computeStringExpression(stringExpression);
                } catch (Exception e) {}

                response.status(200);
                response.type("application/text");
                String responseJson = "{\"result\":\""+result+"\"}";
                response.body(responseJson);

                return responseJson;
            }
        });
    }


}
