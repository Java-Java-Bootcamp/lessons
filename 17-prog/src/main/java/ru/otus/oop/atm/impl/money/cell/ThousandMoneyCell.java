package ru.otus.oop.atm.impl.money.cell;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.otus.oop.atm.dictionary.Denomination;
import ru.otus.oop.atm.interfaces.MoneyCell;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ThousandMoneyCell extends AbstractMoneyCell {
    private final Denomination denomination = Denomination.THOUSAND;
    @JsonCreator
    public ThousandMoneyCell(@JsonProperty("maxNumber") int maxNumber) {
        super(maxNumber);
    }

    @Override
    public Denomination cellDenomination() {
        return denomination;
    }


    @Override
    protected String fileName() {
        return "ThousandMoneyCell.txt";
    }


    @Override
    public MoneyCell deserializeFromJson() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
            ThousandMoneyCell cell = mapper.readValue(new File(fileName()), this.getClass());
            return cell;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
