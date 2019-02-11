import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.staticFileLocation;

public class Controller {
    public static void main(String[] args) {
        staticFileLocation("/public");
        VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();

        get("/", (request, response) -> {
            HashMap<String, Object> model = new HashMap<>();
            model.put("template", "templates/home.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);

        post("/reverse", (request, response) -> {
            String input = request.queryParams("numInput");
            int number = Integer.parseInt(input);
            HashMap<String, Object> model = new HashMap<>();
            model.put("reverse", NumericalOperations.reverse(number));
            model.put("template", "templates/reverse.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);
    }
}
