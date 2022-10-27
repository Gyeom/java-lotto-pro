package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.domain.LottoNumber.LOTTO_MAX_NUMBER;
import static lotto.domain.LottoNumber.LOTTO_MIN_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoNumberTest {

    @DisplayName("로또번호가 1 ~ 45 에 해당하면 생성 작업이 정상적으로 동작한다.")
    @ParameterizedTest(name ="{index} ) {displayName} [{arguments}]")
    @ValueSource(ints = {1, 11, 21, 31, 41})
    public void constructor(int number) {
        LottoNumber lottoNumber = new LottoNumber(number);
        assertThat(lottoNumber.getValue()).isBetween(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER);
    }

    @DisplayName("로또번호가 1 ~ 45 범위에 벗어나면 생성 작업 중 예외가 발생한다.")
    @ParameterizedTest(name ="{index} ) {displayName} [{arguments}]")
    @ValueSource(ints = {-1, 0, 46})
    public void constructor_fail(int number) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoNumber(number))
                .withMessageMatching("[+-]?\\d+는 1~45 범위에 벗어난 숫자입니다.");
    }
}
