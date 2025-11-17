package com.fream_v2.buy_service.domain.buy.domain.model;

import lombok.Builder;
import lombok.Getter;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * 구매 도메인 모델 (순수 도메인)
 */
@Getter
@Builder
public class Buy {
    private final Long buyId;
    private final Long buyerId;
    private final Long productId;
    private final Long desiredPrice;
    private final Long maxPrice;
    private final String size;
    private final String condition;
    private final String description;
    private final BuyStatus status;
    private final Integer viewCount;
    private final Map<String, Object> metadata;
    private final LocalDateTime listedAt;
    private final LocalDateTime expiresAt;
    private final LocalDateTime updatedAt;

    /**
     * 구매 등록 생성
     */
    public static Buy createBuy(Long buyerId, Long productId, Long desiredPrice,
                                Long maxPrice, String size, String condition,
                                String description) {
        return Buy.builder()
                .buyerId(buyerId)
                .productId(productId)
                .desiredPrice(desiredPrice)
                .maxPrice(maxPrice)
                .size(size)
                .condition(condition)
                .description(description)
                .status(BuyStatus.PENDING)
                .viewCount(0)
                .listedAt(LocalDateTime.now())
                .expiresAt(LocalDateTime.now().plusDays(30))
                .updatedAt(LocalDateTime.now())
                .build();
    }

    /**
     * 희망 가격 수정
     */
    public Buy updatePrice(Long newDesiredPrice, Long newMaxPrice) {
        return Buy.builder()
                .buyId(this.buyId)
                .buyerId(this.buyerId)
                .productId(this.productId)
                .desiredPrice(newDesiredPrice)
                .maxPrice(newMaxPrice != null ? newMaxPrice : this.maxPrice)
                .size(this.size)
                .condition(this.condition)
                .description(this.description)
                .status(this.status)
                .viewCount(this.viewCount)
                .metadata(this.metadata)
                .listedAt(this.listedAt)
                .expiresAt(this.expiresAt)
                .updatedAt(LocalDateTime.now())
                .build();
    }

    /**
     * 상태 변경
     */
    public Buy changeStatus(BuyStatus newStatus) {
        return Buy.builder()
                .buyId(this.buyId)
                .buyerId(this.buyerId)
                .productId(this.productId)
                .desiredPrice(this.desiredPrice)
                .maxPrice(this.maxPrice)
                .size(this.size)
                .condition(this.condition)
                .description(this.description)
                .status(newStatus)
                .viewCount(this.viewCount)
                .metadata(this.metadata)
                .listedAt(this.listedAt)
                .expiresAt(this.expiresAt)
                .updatedAt(LocalDateTime.now())
                .build();
    }

    /**
     * 조회수 증가
     */
    public Buy incrementViewCount() {
        return Buy.builder()
                .buyId(this.buyId)
                .buyerId(this.buyerId)
                .productId(this.productId)
                .desiredPrice(this.desiredPrice)
                .maxPrice(this.maxPrice)
                .size(this.size)
                .condition(this.condition)
                .description(this.description)
                .status(this.status)
                .viewCount(this.viewCount + 1)
                .metadata(this.metadata)
                .listedAt(this.listedAt)
                .expiresAt(this.expiresAt)
                .updatedAt(this.updatedAt)
                .build();
    }

    /**
     * 매칭 가능 여부
     */
    public boolean isMatchable() {
        return this.status == BuyStatus.PENDING &&
                this.expiresAt.isAfter(LocalDateTime.now());
    }

    /**
     * 가격 협상 가능 여부
     */
    public boolean isNegotiable() {
        return this.maxPrice != null && this.maxPrice > this.desiredPrice;
    }
}