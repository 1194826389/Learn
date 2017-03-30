/**
 * Created by hechao on 2017/3/30.
 */
public class DecoratorMain {
    public static void main(String arg[]) {

        // ConcretComponent 属于核心功能类
        ConcretComponent c = new ConcretComponent();

        // ConcreteDecoratorA 和 ConcreteDecoratorB 属于修饰类
        ConcreteDecoratorA d1 = new ConcreteDecoratorA();
        ConcreteDecoratorB d2 = new ConcreteDecoratorB();

        d1.setComponent(c);
        d2.setComponent(d1);
        d2.Operation();
    }
}
