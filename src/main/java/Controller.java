import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;

import static spark.Spark.get;
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
    }
}
