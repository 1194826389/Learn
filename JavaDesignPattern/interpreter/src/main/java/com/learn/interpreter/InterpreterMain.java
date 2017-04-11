package com.learn.interpreter;

/**
 * Created by hechao on 2017/4/10.
 */
public class InterpreterMain {
    public static void main(String arg[]) {
        PlayContext context = new PlayContext();

        System.out.println("上海滩：");
        context.setPlayText(" O 2 E 0.5 G 0.5 ");// 输出：中音 3 5
        Expression expression = null;
        try {
            while (context.getPlayText().length() > 0) {
                String string = context.getPlayText().substring(0,1);
                switch (string) {
                    case "O" :
                        expression = new Scale();
                        break;
                    case "C" :
                    case "D" :
                    case "E" :
                    case "F" :
                    case "G" :
                    case "A" :
                    case "B" :
                        expression = new Note();
                        break;
                }
                if (expression != null) {
                    expression.Interpret(context);
                } else {
                    context.setPlayText(context.getPlayText().substring(1));
                }

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }


    }
}
