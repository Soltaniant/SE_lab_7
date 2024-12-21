package MiniJava.codeGenerator.operator;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.reflections.Reflections;

public class OperatorRegistry {

    private static final Map<Integer, Operator> operatorMap;

    static {
        operatorMap = new HashMap<>();
        registerOperators();
    }

    private static void registerOperators() {
        Reflections reflections = new Reflections(OperatorRegistry.class);

        Set<Class<? extends Operator>> operatorClasses = reflections.getSubTypesOf(Operator.class);

        for (Class<? extends Operator> operatorClass : operatorClasses) {
            try {
                Operator operator = operatorClass.getDeclaredConstructor().newInstance();
                int functionCode = operator.getFunctionCode();
                operatorMap.put(functionCode, operator);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
    }

    public static Operator getOperator(int code) {
        return operatorMap.get(code);
    }
}
