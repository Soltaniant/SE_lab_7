package MiniJava.codeGenerator;


import java.util.ArrayList;

public class MemoryFacade {
    private Memory memory;

    // سازنده که شیء Memory را ایجاد می‌کند
    public MemoryFacade() {
        this.memory = new Memory();
    }

    // متدی برای افزودن کد سه آدرسی
    public void add3AddressCode(Operation op, Address opr1, Address opr2, Address opr3) {
        memory.add3AddressCode(op, opr1, opr2, opr3);
    }

    // متدی برای ذخیره حافظه و برگرداندن اندیس جدید
    public int saveMemory() {
        return memory.saveMemory();
    }

    // متدی برای دریافت کدهای ذخیره‌شده
    public ArrayList<Memory._3AddressCode> getCodeBlock() {
        return memory.getCodeBlock();
    }

    // متدی برای دریافت آدرس موقت
    public int getTemp() {
        return memory.getTemp();
    }

    // متدی برای به‌روزرسانی آدرس موقت
    public void updateTempIndex() {
        memory.updateTempIndex();
    }

    // متدی برای دریافت آدرس داده
    public int getDateAddress() {
        return memory.getDateAddress();
    }

    // متدی برای به‌روزرسانی آدرس داده
    public void updateDataAddress() {
        memory.updateDataAddress();
    }

    // متدی برای دریافت آدرس فعلی بلوک کد
    public int getCurrentCodeBlockAddress() {
        return memory.getCurrentCodeBlockAddress();
    }

    // متدی برای چاپ بلوک‌های کد
    public void printCodeBlock() {
        memory.pintCodeBlock();
    }
}
