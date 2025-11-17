package com.fream_v2.buy_service.domain.buy.domain.exception;

import com.fream_v2.buy_service.global.presentation.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 구매 도메인 에러 코드
 */
@Getter
@RequiredArgsConstructor
public enum BuyErrorCode implements ErrorCode {

    // ===== 구매 조회 관련 (BUY_001 ~ BUY_099) =====
    BUY_NOT_FOUND("BUY_001", "구매 정보를 찾을 수 없습니다.", 404),
    BUY_ID_NOT_FOUND("BUY_002", "해당 ID의 구매 정보를 찾을 수 없습니다.", 404),
    BUYER_NOT_FOUND("BUY_003", "구매자를 찾을 수 없습니다.", 404),
    BUY_DATA_CORRUPTED("BUY_004", "구매 데이터가 손상되었습니다.", 500),

    // ===== 구매 등록 관련 (BUY_100 ~ BUY_199) =====
    PRODUCT_NOT_AVAILABLE_FOR_BUY("BUY_100", "구매할 수 없는 상품입니다.", 400),
    ALREADY_BUYING("BUY_101", "이미 구매 진행 중인 상품입니다.", 409),
    INVALID_BUY_PRICE("BUY_102", "구매 희망가가 유효하지 않습니다.", 400),
    DESIRED_PRICE_TOO_LOW("BUY_103", "구매 희망가가 너무 낮습니다.", 400),
    DESIRED_PRICE_TOO_HIGH("BUY_104", "구매 희망가가 너무 높습니다.", 400),
    MAX_PRICE_LOWER_THAN_DESIRED("BUY_105", "최대 가격이 희망 가격보다 낮을 수 없습니다.", 400),
    BUY_REGISTRATION_FAILED("BUY_106", "구매 등록에 실패했습니다.", 500),
    INVALID_SIZE_FOR_PRODUCT("BUY_107", "해당 상품에 유효하지 않은 사이즈입니다.", 400),
    BUYER_VERIFICATION_REQUIRED("BUY_108", "구매자 인증이 필요합니다.", 403),
    DAILY_BUY_LIMIT_EXCEEDED("BUY_109", "일일 구매 등록 한도를 초과했습니다.", 429),

    // ===== 구매 수정 관련 (BUY_200 ~ BUY_299) =====
    BUY_UPDATE_FAILED("BUY_200", "구매 정보 수정에 실패했습니다.", 500),
    CANNOT_UPDATE_PURCHASED_ITEM("BUY_201", "구매 완료된 상품은 수정할 수 없습니다.", 400),
    CANNOT_UPDATE_MATCHED_BUY("BUY_202", "매칭된 구매 요청은 수정할 수 없습니다.", 400),
    PRICE_INCREASE_LIMIT_EXCEEDED("BUY_203", "가격 인상 횟수를 초과했습니다.", 400),
    CANNOT_DECREASE_PRICE("BUY_204", "구매 희망가는 인하할 수 없습니다.", 400),
    UPDATE_NOT_ALLOWED_FOR_BUYER("BUY_205", "구매자 본인만 수정할 수 있습니다.", 403),

    // ===== 구매 상태 관련 (BUY_300 ~ BUY_399) =====
    INVALID_BUY_STATUS("BUY_300", "유효하지 않은 구매 상태입니다.", 400),
    ALREADY_MATCHED_WITH_SELLER("BUY_301", "이미 판매자와 매칭되었습니다.", 409),
    ALREADY_RESERVED_FOR_PAYMENT("BUY_302", "이미 결제 진행 중입니다.", 409),
    ALREADY_PURCHASED("BUY_303", "이미 구매 완료된 상품입니다.", 409),
    ALREADY_CANCELLED_BUY("BUY_304", "이미 취소된 구매입니다.", 409),
    BUY_EXPIRED("BUY_305", "구매 요청 기간이 만료되었습니다.", 400),
    NOT_MATCHABLE_BUY("BUY_306", "매칭 가능한 상태가 아닙니다.", 400),

    // ===== 구매 취소 관련 (BUY_400 ~ BUY_499) =====
    CANCEL_NOT_ALLOWED_FOR_BUY("BUY_400", "취소할 수 없는 구매입니다.", 400),
    CANCEL_AFTER_SELLER_MATCH("BUY_401", "판매자 매칭 후에는 취소할 수 없습니다.", 400),
    CANCEL_AFTER_PAYMENT_START("BUY_402", "결제 시작 후에는 취소할 수 없습니다.", 400),
    BUY_CANCEL_TIME_EXPIRED("BUY_403", "취소 가능 시간이 지났습니다.", 400),
    BUY_CANCELLATION_FAILED("BUY_404", "구매 취소에 실패했습니다.", 500),

    // ===== 구매자 관련 (BUY_500 ~ BUY_599) =====
    NOT_BUYER("BUY_500", "구매자가 아닙니다.", 403),
    BUYER_SUSPENDED("BUY_501", "구매 권한이 정지된 사용자입니다.", 403),
    BUYER_GRADE_INSUFFICIENT("BUY_502", "구매하기 위한 최소 등급을 충족하지 못했습니다.", 403),
    BUYER_TRUST_SCORE_LOW("BUY_503", "신뢰도가 낮아 구매할 수 없습니다.", 403),
    INSUFFICIENT_PURCHASE_HISTORY("BUY_504", "구매 이력이 부족합니다.", 403),

    // ===== 매칭 관련 (BUY_600 ~ BUY_699) =====
    NO_MATCHING_SELLER("BUY_600", "매칭 가능한 판매자가 없습니다.", 404),
    SELLER_MATCH_FAILED("BUY_601", "판매자 매칭에 실패했습니다.", 500),
    SELLER_CANCELLED("BUY_602", "판매자가 매칭을 취소했습니다.", 400),
    BUY_MATCH_EXPIRED("BUY_603", "매칭 유효 시간이 만료되었습니다.", 400),

    // ===== 가격 협상 관련 (BUY_700 ~ BUY_799) =====
    BUY_NEGOTIATION_NOT_ALLOWED("BUY_700", "가격 협상이 불가능한 구매입니다.", 400),
    PRICE_ABOVE_MAXIMUM("BUY_701", "제안 가격이 최대 가격을 초과합니다.", 400),
    BUY_NEGOTIATION_CLOSED("BUY_702", "가격 협상이 종료되었습니다.", 400),
    TOO_MANY_BUY_NEGOTIATIONS("BUY_703", "협상 시도 횟수를 초과했습니다.", 429),

    // ===== 결제 준비 관련 (BUY_800 ~ BUY_849) =====
    PAYMENT_INFO_MISSING("BUY_800", "결제 정보가 누락되었습니다.", 400),
    PAYMENT_METHOD_NOT_SUPPORTED("BUY_801", "지원하지 않는 결제 수단입니다.", 400),
    INSUFFICIENT_BALANCE("BUY_802", "잔액이 부족합니다.", 400),
    PAYMENT_PREPARATION_FAILED("BUY_803", "결제 준비에 실패했습니다.", 500),

    // ===== 검증 관련 (BUY_850 ~ BUY_899) =====
    BUY_DATA_INVALID("BUY_850", "구매 데이터가 유효하지 않습니다.", 400),
    REQUIRED_FIELD_MISSING("BUY_851", "필수 입력 항목이 누락되었습니다.", 400),
    DUPLICATE_BUY("BUY_852", "중복된 구매 등록입니다.", 409),
    INVALID_SIZE_SELECTION("BUY_853", "유효하지 않은 사이즈 선택입니다.", 400),
    INVALID_CONDITION_REQUIREMENT("BUY_854", "유효하지 않은 상품 상태 요구사항입니다.", 400);

    private final String code;
    private final String message;
    private final int status;
}