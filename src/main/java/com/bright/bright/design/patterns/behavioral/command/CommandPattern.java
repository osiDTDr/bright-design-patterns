package com.bright.bright.design.patterns.behavioral.command;

/**
 * 命令者模式
 *
 * @author zhengyuan
 * @since 2020/12/06
 */
public class CommandPattern {
    public static void main(String[] args) {
        Command cmd = new ConcreteCommand();
        Invoker ir = new Invoker(cmd);
        System.out.println("客户访问调用者的call()方法...");
        ir.call();
    }
}

/**
 * 调用者
 */
class Invoker {
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void call() {
        System.out.println("调用者执行命令command...");
        command.execute();
    }
}

/**
 * 抽象命令
 */
interface Command {
    void execute();
}

/**
 * 具体命令
 */
class ConcreteCommand implements Command {

    ConcreteCommand() {
    }

    public void execute() {
        System.out.println("接收者的action()方法被调用...");
    }
}

