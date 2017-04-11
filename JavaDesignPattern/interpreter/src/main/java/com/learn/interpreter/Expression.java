package com.learn.interpreter;

/**
 * Created by hechao on 2017/4/10.
 */
public abstract class Expression {
    public void Interpret(PlayContext context) {
        if (context.getPlayText().length() == 0) return;

        try {

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        String playKey = context.getPlayText().substring(0,1);
        context.setPlayText(context.getPlayText().substring(2));
        double playValue = Double.parseDouble(context.getPlayText().substring(0,context.getPlayText().indexOf(" ")));
        context.setPlayText(context.getPlayText().substring(context.getPlayText().indexOf(" ") + 1));
        excute(playKey,playValue);
    }

    public abstract void excute(String key,double value);
}
