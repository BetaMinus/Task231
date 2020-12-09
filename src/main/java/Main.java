
import config.SpringConfig;
import model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.UserService;

public class Main {
    public static void main(String[] args) {

        System.out.println("TEST CRUD");
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = context.getBean(UserService.class);

        userService.create("user1", 11, "user1@mail");
        userService.create("user2", 22, "user2@mail");
        userService.create("user3", 33, "user3@mail");
        userService.create("user4", 44, "user4@mail");
        userService.create("user5", 55, "user5@mail");
    }
}
