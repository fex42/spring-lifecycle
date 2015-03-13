package lcdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.StaticApplicationContext;

public class Main {
    public static void main(String[] args) {
        Main app = new Main();
        app.run();
    }

    private void run() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        FirstBean first = ctx.getBean(FirstBean.class);
        SecondBean second = ctx.getBean(SecondBean.class);
        System.out.println(first);
        first.stop();
    }
}
