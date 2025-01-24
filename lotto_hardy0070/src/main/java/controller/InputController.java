package controller;

import Model.Matched;
import java.util.List;
import Model.Lotto;
import Model.WinLotto;
import java.util.Map;
import service.LottoService;
import service.MatchService;
import service.OrderService;
import service.WinLottoService;

public class InputController {

    private LottoService lottoService = new LottoService();
    private OrderService orderService = new OrderService();
    private WinLottoService winLottoService = new WinLottoService();
    private MatchService matchService = new MatchService();

    // 사용자가 구입 금액을 입력 ->
    // 입력 금액에 맞는 수량만큼 로또 구매 [핵심로직] [로또서비스] [주문서비스]
    public List<Lotto> buyLottos(int money) {
        int lottoQuantity = orderService.convertMoneyToQuantity(money);

        return lottoService.getLottos(lottoQuantity);
    }

    // 사용자가 당첨 로또 번호와 보너스 번호를 입력 ->
    // 당첨 결과 출력
    public Map<Matched, Integer> getWinLotto(String numbers, int bonusNumber, List<Lotto> userLottos) {
        WinLotto winLotto = winLottoService.getWinLotto(numbers, bonusNumber);

        return matchService.getResults(winLotto, userLottos);
    }

//      List<Matched>를 어떻게 출력할 것인가? 또 어떻게 수익률을 낼 것인가?
}
