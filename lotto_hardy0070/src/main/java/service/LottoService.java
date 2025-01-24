package service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import Model.Lotto;

// 클래스 명세
// 로또 상태에 랜덤값을 부여하는 로직
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
