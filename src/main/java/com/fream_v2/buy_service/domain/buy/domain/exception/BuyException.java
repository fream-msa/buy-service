package com.fream_v2.buy_service.domain.buy.domain.exception;

import com.fream_v2.buy_service.global.presentation.exception.ErrorCode;
import com.fream_v2.buy_service.global.presentation.exception.GlobalException;

/**
 * 구매 도메인 예외
 */
public class BuyException extends GlobalException {

    public BuyException(ErrorCode errorCode) {
        super(errorCode);
    }

    public BuyException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public BuyException(ErrorCode errorCode, Throwable cause) {
        super(errorCode, cause);
    }

    public BuyException(ErrorCode errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }

    // ===== 자주 사용되는 예외 생성 정적 팩토리 메서드 =====

    // 조회 관련
    public static BuyException notFound() {
        return new BuyException(BuyErrorCode.BUY_NOT_FOUND);
    }

    public static BuyException notFound(Long buyId) {
        return new BuyException(BuyErrorCode.BUY_ID_NOT_FOUND,
                String.format("구매 정보를 찾을 수 없습니다. ID: %d", buyId));
    }

    // 등록 관련
    public static BuyException alreadyBuying(Long productId) {
        return new BuyException(BuyErrorCode.ALREADY_BUYING,
                String.format("이미 구매 진행 중인 상품입니다. 상품 ID: %d", productId));
    }

    public static BuyException invalidPrice(Long price) {
        return new BuyException(BuyErrorCode.INVALID_BUY_PRICE,
                String.format("구매 희망가가 유효하지 않습니다: %d원", price));
    }

    public static BuyException priceTooLow(Long price, Long minPrice) {
        return new BuyException(BuyErrorCode.DESIRED_PRICE_TOO_LOW,
                String.format("구매 희망가가 너무 낮습니다. 현재: %d원, 최소: %d원", price, minPrice));
    }

    public static BuyException maxPriceLowerThanDesired(Long desiredPrice, Long maxPrice) {
        return new BuyException(BuyErrorCode.MAX_PRICE_LOWER_THAN_DESIRED,
                String.format("최대 가격(%d원)이 희망 가격(%d원)보다 낮을 수 없습니다.", maxPrice, desiredPrice));
    }

    // 상태 관련
    public static BuyException alreadyMatched(Long buyId) {
        return new BuyException(BuyErrorCode.ALREADY_MATCHED_WITH_SELLER,
                String.format("이미 판매자와 매칭되었습니다. 구매 ID: %d", buyId));
    }

    public static BuyException alreadyPurchased(Long buyId) {
        return new BuyException(BuyErrorCode.ALREADY_PURCHASED,
                String.format("이미 구매 완료된 상품입니다. 구매 ID: %d", buyId));
    }

    public static BuyException expired(Long buyId) {
        return new BuyException(BuyErrorCode.BUY_EXPIRED,
                String.format("구매 요청 기간이 만료되었습니다. 구매 ID: %d", buyId));
    }

    public static BuyException notMatchable(Long buyId) {
        return new BuyException(BuyErrorCode.NOT_MATCHABLE_BUY,
                String.format("매칭 가능한 상태가 아닙니다. 구매 ID: %d", buyId));
    }

    // 취소 관련
    public static BuyException cancelNotAllowed(Long buyId, String reason) {
        return new BuyException(BuyErrorCode.CANCEL_NOT_ALLOWED_FOR_BUY,
                String.format("취소할 수 없는 구매입니다. ID: %d, 사유: %s", buyId, reason));
    }

    public static BuyException cancelAfterMatch(Long buyId) {
        return new BuyException(BuyErrorCode.CANCEL_AFTER_SELLER_MATCH,
                String.format("판매자 매칭 후에는 취소할 수 없습니다. 구매 ID: %d", buyId));
    }

    // 구매자 관련
    public static BuyException notBuyer(Long userId) {
        return new BuyException(BuyErrorCode.NOT_BUYER,
                String.format("구매자가 아닙니다. 사용자 ID: %d", userId));
    }

    public static BuyException buyerSuspended(Long userId) {
        return new BuyException(BuyErrorCode.BUYER_SUSPENDED,
                String.format("구매 권한이 정지된 사용자입니다. ID: %d", userId));
    }

    public static BuyException buyerGradeInsufficient(String currentGrade, String requiredGrade) {
        return new BuyException(BuyErrorCode.BUYER_GRADE_INSUFFICIENT,
                String.format("구매하기 위한 최소 등급을 충족하지 못했습니다. 현재: %s, 필요: %s",
                        currentGrade, requiredGrade));
    }

    // 사이즈 관련
    public static BuyException invalidSize(String size, Long productId) {
        return new BuyException(BuyErrorCode.INVALID_SIZE_FOR_PRODUCT,
                String.format("해당 상품에 유효하지 않은 사이즈입니다. 사이즈: %s, 상품 ID: %d",
                        size, productId));
    }

    // 결제 관련
    public static BuyException paymentInfoMissing() {
        return new BuyException(BuyErrorCode.PAYMENT_INFO_MISSING);
    }

    public static BuyException insufficientBalance(Long required, Long available) {
        return new BuyException(BuyErrorCode.INSUFFICIENT_BALANCE,
                String.format("잔액이 부족합니다. 필요: %d원, 보유: %d원", required, available));
    }

    // 가격 협상 관련
    public static BuyException negotiationNotAllowed() {
        return new BuyException(BuyErrorCode.BUY_NEGOTIATION_NOT_ALLOWED);
    }

    public static BuyException priceAboveMaximum(Long proposedPrice, Long maxPrice) {
        return new BuyException(BuyErrorCode.PRICE_ABOVE_MAXIMUM,
                String.format("제안 가격(%d원)이 최대 가격(%d원)을 초과합니다.", proposedPrice, maxPrice));
    }
}