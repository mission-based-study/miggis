package service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.Lotto;

// 클래스 명세
// 로또 생성을 책임진다.[핵심]
public class LottoService {

    public List<Lotto> getLottos(int lottoQuantity) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoQuantity; i++) {
            lottos.add(makeLottoTicket());
        }

        return lottos;
    }

    private Lotto makeLottoTicket() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(lottoNumbers);

        return new Lotto(lottoNumbers);
    }

}
