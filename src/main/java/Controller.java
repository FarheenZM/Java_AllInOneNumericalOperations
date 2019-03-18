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

        post("/", (request, response) -> {
            String input = request.queryParams("numInput");
            int number = Integer.parseInt(input);
            HashMap<String, Object> model = new HashMap<>();

            model.put("input", input);

//            model.put("test", request.queryParamOrDefault("click", "default"));
            model.put("test", request.queryParams("click"));

            if(model.get("test").equals("RReverse")) {
                model.put("reverse", NumericalOperations.reverse(number));
            }else if(model.get("test").equals("PPalindrome")) {
                model.put("palindrome", NumericalOperations.palindrome(number));
            }else if(model.get("test").equals("FFactorial")){
                model.put("factorial", NumericalOperations.factorial(number));
            }

//            if(request.queryParams("click").equals("RReverse")){
//                model.put("reverse", NumericalOperations.reverse(number));
//            }else if(request.queryParams("click").equals("PPalindrome")) {
//                model.put("palindrome", NumericalOperations.palindrome(number));
//            }
            model.put("template", "templates/home.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);

//        post("/reverse", (request, response) -> {
//            String input = request.queryParams("numInput");
//            int number = Integer.parseInt(input);
//            HashMap<String, Object> model = new HashMap<>();
//            model.put("reverse", NumericalOperations.reverse(number));
//            model.put("template", "templates/reverse.vtl");
//            return new ModelAndView(model, "templates/layout.vtl");
//        }, velocityTemplateEngine);
//
//        post("/palindrome", (request, response) -> {
//            String input = request.queryParams("numInput");
//            int number = Integer.parseInt(input);
//            HashMap<String, Object> model = new HashMap<>();
//            model.put("palindrome", NumericalOperations.palindrome(number));
//            model.put("template", "templates/palindrome.vtl");
//            return new ModelAndView(model, "templates/layout.vtl");
//        }, velocityTemplateEngine);
    }
}
