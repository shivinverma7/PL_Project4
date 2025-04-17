package simplf;

import java.util.List;


class SimplfFunction implements SimplfCallable {
    private final Stmt.Function declaration;
    private Environment closure;

    SimplfFunction(Stmt.Function declaration, Environment closure) {
        this.declaration = declaration;
        this.closure = closure;
    }

    static class Return extends RuntimeException {
        final Object value;
        Return(Object value) {
            super(null, null, false, false);
            this.value = value;
        }
    }

    public void setClosure(Environment environment) {
        this.closure = environment;
    }

    @Override
    public Object call(Interpreter interpreter, List<Object> args) {
        Environment functionEnv = new Environment(closure);

        for (int i = 0; i < declaration.params.size(); i++) {
            functionEnv.define(declaration.params.get(i).lexeme, args.get(i));
        }

        try {
            interpreter.executeBlock(declaration.body, functionEnv);
        } catch (Return returnValue) {
            return returnValue.value;
        }

        return null;
    }

    public int arity() {
        return declaration.params.size();
    }

    @Override
    public String toString() {
        return "<fn " + declaration.name.lexeme + ">";
    }
}
