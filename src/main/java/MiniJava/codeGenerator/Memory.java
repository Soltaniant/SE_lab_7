package MiniJava.codeGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

/**
 * Created by mohammad hosein on 6/27/2015.
 */
public class Memory {


    private ArrayList<_3AddressCode> codeBlock;
    private int lastTempIndex;
    private int lastDataAddress;
    private final int stratTempMemoryAddress = 500;
    private final int stratDataMemoryAddress = 200;
    private final int dataSize = 4;
    private final int tempSize = 4;

    public Memory() {
        codeBlock = new ArrayList<_3AddressCode>();
        lastTempIndex = stratTempMemoryAddress;
        lastDataAddress = stratDataMemoryAddress;
    }

    ArrayList<_3AddressCode> getCodeBlock() {
        return codeBlock;
    }

    public int getTemp() {
        return lastTempIndex;
    }

    public void updateTempIndex() {
        lastTempIndex += tempSize;
    }

    public int getDateAddress() {
        return lastDataAddress;
    }

    public void updateDataAddress() {
        lastDataAddress += dataSize;
    }

    public int saveMemory() {
        getCodeBlock().add(new _3AddressCode());
        return getCodeBlock().size() - 1;
    }

    public void add3AddressCode(Operation op, Address opr1, Address opr2, Address opr3) {
        getCodeBlock().add(new _3AddressCode(op, opr1, opr2, opr3));
    }

    public void add3AddressCode(int i, Operation op, Address opr1, Address opr2, Address opr3) {
        getCodeBlock().remove(i);
        getCodeBlock().add(i, new _3AddressCode(op, opr1, opr2, opr3));
    }

    public int getCurrentCodeBlockAddress() {
        return getCodeBlock().size();
    }

    public void pintCodeBlock() {
        System.out.println("Code Block");
        for (int i = 0; i < getCodeBlock().size(); i++) {
            System.out.println(i + " : " + getCodeBlock().get(i).toString());
        }
    }

    @Getter
    @NoArgsConstructor
    class _3AddressCode {
        private Operation operation;
        private Address Operand1;
        private Address Operand2;
        private Address Operand3;

        public _3AddressCode(Operation op, Address opr1, Address opr2, Address opr3) {
            operation = op;
            Operand1 = opr1;
            Operand2 = opr2;
            Operand3 = opr3;
        }

        public String toString() {
            if (operation == null) return "";
            StringBuffer res = new StringBuffer("(");
            res.append(operation.toString()).append(",");
            if (getOperand1() != null) res.append(getOperand1());
            res.append(",");
            if (getOperand2() != null) res.append(getOperand2());
            res.append(",");
            if (getOperand3() != null) res.append(getOperand3());
            res.append(")");

            return res.toString();
        }
    }

}
