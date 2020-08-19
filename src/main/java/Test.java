import com.demoAop.config.AppConfig;
import com.demoAop.entities.Account;
import com.demoAop.service.LoginService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Test {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();
        ctx.getBean(LoginService.class).authenticateAccount(Account.builder().username("saa").password("123").build());
    }
}
