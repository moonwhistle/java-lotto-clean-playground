package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LottoNumberGenerator implements CreateLottoNumber {

    private static final int INITIAL_NUMBER = 0;
    private static final int FIRST_LOTTO_NUMBER = 1;
    private static final int LAST_LOTTO_NUMBER = 45;
    private static final int LOTTO_NUMBER_LENGTH_BOUNDARY = 6;

    private final Random randomNumberGenerator;

    public LottoNumberGenerator(Random randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    @Override
    public List<Integer> getRandomLottoNumber() {
        List<Integer> getLotto = new ArrayList<>();
        for (int i = INITIAL_NUMBER; i < LOTTO_NUMBER_LENGTH_BOUNDARY; i++) {
            int randomLottoNumber = checkDuplicateNumber(getLotto, randomNumberGenerator.nextInt(FIRST_LOTTO_NUMBER,LAST_LOTTO_NUMBER));
            getLotto.add(randomLottoNumber);
        }
        return getLotto;
    }

    private int generateRandomNumber(){
        return randomNumberGenerator.nextInt(FIRST_LOTTO_NUMBER,LAST_LOTTO_NUMBER);
    }

    private int checkDuplicateNumber(List<Integer> buyLotto, int randomLottoNumber) {
        if (buyLotto.contains(randomLottoNumber)) {
            return checkDuplicateNumber(buyLotto, generateRandomNumber());
        }
        return randomLottoNumber;
    }
}
