package exam;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex01 {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

		Message message = ctx.getBean(Message.class);
		message.send("메세지!!!");

		ctx.close();
		System.out.println("므아아아");
	}
}
