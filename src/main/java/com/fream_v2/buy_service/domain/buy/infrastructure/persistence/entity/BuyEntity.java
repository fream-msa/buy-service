package com.fream_v2.buy_service.domain.buy.infrastructure.persistence.entity;

import com.fream_v2.buy_service.domain.buy.domain.model.Buy;
import com.fream_v2.buy_service.domain.buy.domain.model.BuyStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import java.time.LocalDateTime;

/**
 * 구매 엔티티 (Infrastructure Layer)
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table("buys")
public class BuyEntity {
    @Id
    private Long id;
    private Long buyerId;
    private Long productId;
    private Long desiredPrice;
    private Long maxPrice;
    private String size;
    private String condition;
    private String description;
    private String status;
    private Integer viewCount;
    private String metadata; // JSON 문자열로 저장
    private LocalDateTime listedAt;
    private LocalDateTime expiresAt;
    private LocalDateTime updatedAt;

    /**
     * 도메인 모델로 변환
     */
    public Buy toDomain() {
        return Buy.builder()
                .buyId(this.id)
                .buyerId(this.buyerId)
                .productId(this.productId)
                .desiredPrice(this.desiredPrice)
                .maxPrice(this.maxPrice)
                .size(this.size)
                .condition(this.condition)
                .description(this.description)
                .status(BuyStatus.valueOf(this.status))
                .viewCount(this.viewCount)
                .metadata(parseMetadata(this.metadata))
                .listedAt(this.listedAt)
                .expiresAt(this.expiresAt)
                .updatedAt(this.updatedAt)
                .build();
    }

    /**
     * 도메인 모델로부터 엔티티 생성 (신규)
     */
    public static BuyEntity fromDomain(Buy buy) {
        return BuyEntity.builder()
                .buyerId(buy.getBuyerId())
                .productId(buy.getProductId())
                .desiredPrice(buy.getDesiredPrice())
                .maxPrice(buy.getMaxPrice())
                .size(buy.getSize())
                .condition(buy.getCondition())
                .description(buy.getDescription())
                .status(buy.getStatus().name())
                .viewCount(buy.getViewCount())
                .metadata(toJsonString(buy.getMetadata()))
                .listedAt(buy.getListedAt())
                .expiresAt(buy.getExpiresAt())
                .updatedAt(buy.getUpdatedAt())
                .build();
    }

    /**
     * 도메인 모델로부터 엔티티 업데이트 (기존 ID 포함)
     */
    public static BuyEntity updateFromDomain(Buy buy) {
        return BuyEntity.builder()
                .id(buy.getBuyId())
                .buyerId(buy.getBuyerId())
                .productId(buy.getProductId())
                .desiredPrice(buy.getDesiredPrice())
                .maxPrice(buy.getMaxPrice())
                .size(buy.getSize())
                .condition(buy.getCondition())
                .description(buy.getDescription())
                .status(buy.getStatus().name())
                .viewCount(buy.getViewCount())
                .metadata(toJsonString(buy.getMetadata()))
                .listedAt(buy.getListedAt())
                .expiresAt(buy.getExpiresAt())
                .updatedAt(buy.getUpdatedAt())
                .build();
    }

    // Metadata JSON 변환 헬퍼 메서드
    private static String toJsonString(Object metadata) {
        // 실제 구현 시 ObjectMapper 사용
        return metadata != null ? metadata.toString() : null;
    }

    private static java.util.Map<String, Object> parseMetadata(String json) {
        // 실제 구현 시 ObjectMapper 사용
        return json != null ? new java.util.HashMap<>() : null;
    }
}
