package ru.otus.oop.atm.impl.money.cell;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.otus.oop.atm.interfaces.MoneyCell;

import java.io.*;

public abstract class AbstractMoneyCell implements MoneyCell, Serializable {
    private int maxNumber;
    private int banknotesNumber;

    public AbstractMoneyCell(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    @JsonCreator
    @Override
    public void putMoney(@JsonProperty("banknotesNumber") int amount) {
        if (canPut(amount)) {
            banknotesNumber += amount;
        }
    }

    @Override
    public boolean canPut(int amount) {
        return maxNumber - banknotesNumber >= amount;
    }

    @Override
    public void getMoney(int amount) {
        if (canGet(amount)) {
            banknotesNumber -= amount;
        }
    }

    @Override
    public boolean canGet(int amount) {
        return banknotesNumber >= amount;
    }

    protected abstract String fileName();

    @Override
    public void saveState() {
        try (FileOutputStream fs = new FileOutputStream(fileName());
             ObjectOutputStream os = new ObjectOutputStream(fs)) {
            os.writeObject(this);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveStateAsJackson() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
            mapper.writeValue(new File(fileName()), this);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public MoneyCell deserialize() {
        try (FileInputStream fs = new FileInputStream(fileName());
             ObjectInputStream os = new ObjectInputStream(fs)) {
            Object cell = os.readObject();
            return (MoneyCell) cell;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
