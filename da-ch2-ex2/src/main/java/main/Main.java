package main;

import controllers.ProductController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        try (var c = new AnnotationConfigApplicationContext(ProjectConfig.class)) {
            c.getBean(ProductController.class).saveProduct("Beer");
        }
    }

}
