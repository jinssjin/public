<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="mvc.model.PaymentDTO"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8" />
    <link rel="icon" href="https://static.toss.im/icons/png/4x/icon-toss-logo.png" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/paymentstyle.css" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>토스페이먼츠 샘플 프로젝트</title>
    <!-- 결제위젯 SDK 추가 -->
    <script src="https://js.tosspayments.com/v1/payment-widget"></script>
  </head>

  <body>
    <!-- 주문서 영역 -->
    <div class="wrapper">
      <div class="box_section" style="padding: 40px 30px 50px 30px; margin-top: 30px; margin-bottom: 50px">
        <!-- 결제 UI -->
        <div id="payment-method"></div>
        <!-- 이용약관 UI -->
        <div id="agreement"></div>
        <!-- 쿠폰 체크박스  -->
        <div class="checkable typography--p" style="padding-left: 25px">
          <label for="coupon-box" class="checkable__label typography--regular">
            <input id="coupon-box" class="checkable__input" type="checkbox" aria-checked="true" disabled />
             <span class="checkable__label-text">[선택] HobbyMe 마케팅 수신 동의</span>
          </label>
        </div>
        <!-- 결제하기 버튼 -->
        <button class="button" id="payment-button" style="margin-top: 30px" disabled>결제하기</button>
      </div>
    </div>
  </body>

  <script>
    const button = document.getElementById("payment-button");
    const coupon = document.getElementById("coupon-box");
    const currentURL = window.location.protocol + "//" + window.location.host + "${pageContext.request.contextPath}";
    const generateRandomString = () => window.btoa(Math.random()).slice(0, 20);
    var amount = parseInt("${reservationPaymentInfo.getPrice()}");

    const clientKey = "test_gck_docs_Ovk5rk1EwkEbP0W43n07xlzm";
    const customerKey = generateRandomString();
    const paymentWidget = PaymentWidget(clientKey, customerKey);

    // 결제 UI 렌더링
    paymentMethodWidget = paymentWidget.renderPaymentMethods(
      "#payment-method",
      { value: amount },
      { variantKey: "DEFAULT" }
    );

    // 약관 UI 렌더링
    paymentWidget.renderAgreement("#agreement", { variantKey: "AGREEMENT" });

    // UI 렌더 완료
    paymentMethodWidget.on("ready", function () {
      button.disabled = false;
      coupon.disabled = false;
    });

    // 쿠폰 체크 시 금액 변경
    coupon.addEventListener("change", function () {
      if (coupon.checked) {
        paymentMethodWidget.updateAmount(amount - 5000);
      } else {
        paymentMethodWidget.updateAmount(amount);
      }
    });
    
    const orderName = "${reservationPaymentInfo.getTitle()}";
    const customerEmail = "${reservationPaymentInfo.getEmail()}";
    const customerName = "${reservationPaymentInfo.getName()}";
    const customerMobilePhone = "${reservationPaymentInfo.getPhone().replace("-","")}";
    
    // 결제 요청
    button.addEventListener("click", function () {
      paymentWidget.requestPayment({
        orderId: generateRandomString(),
        orderName: orderName,
        successUrl: currentURL + "/success.jsp",
        failUrl: currentURL + "/fail.jsp",
        customerEmail: customerEmail,
        customerName: customerName,
        customerMobilePhone : customerMobilePhone
      });
    });
  </script>
</html>
