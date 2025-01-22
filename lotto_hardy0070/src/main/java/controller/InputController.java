package controller;

import java.util.List;
import lotto.Lotto;
import lotto.WinLotto;
import service.LottoService;
import service.OrderService;
import service.WinLottoService;

public class InputController {
    private LottoService lottoService = new LottoService();
    private OrderService orderService = new OrderService();
    private WinLottoService winLottoService = new WinLottoService();

    // 사용자가 구입 금액을 입력 ->
    // 입력 금액에 맞는 수량만큼 로또 구매 [핵심로직] [로또서비스] [주문서비스]
    public List<Lotto> buyLottos(int money) {
        int lottoQuantity = orderService.convertMoneyToQuantity(money);

        return lottoService.getLottos(lottoQuantity);
    }

    // 사용자 입력 받을 때 파라미터 2개를 잘 구분해야 한다.
    public WinLotto decideWinLottoNumbers(String numbers, int bonusNumber) {
        List<Integer> winLottoNumbers = winLottoService.getWinLotto(numbers);

        return new WinLotto(winLottoNumbers, bonusNumber);
    }

}
