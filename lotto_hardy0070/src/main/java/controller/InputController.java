package controller;

import java.util.List;
import lotto.Lotto;
import service.LottoService;
import service.OrderService;

public class InputController {
    private LottoService lottoService = new LottoService();
    private OrderService orderService = new OrderService();

    // 사용자가 구입 금액을 입력 ->
    // 입력 금액에 맞는 수량만큼 로또 구매 [핵심로직] [로또서비스] [주문서비스]
    public List<Lotto> buyLottos(int money) {
        int lottoQuantity = orderService.convertMoneyToQuantity(money);

        return lottoService.getLottos(lottoQuantity);
    }


}
