package io.dcns.wantitauction.domain.auctionItem.service;

import io.dcns.wantitauction.domain.auctionItem.dto.AuctionItemResponseDto;
import io.dcns.wantitauction.domain.auctionItem.dto.FinishedItemResponseDto;
import io.dcns.wantitauction.domain.auctionItem.entity.AuctionItem;
import io.dcns.wantitauction.domain.auctionItem.repository.AuctionItemQueryRepository;
import io.dcns.wantitauction.domain.auctionItem.repository.AuctionItemRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuctionItemService {

    private final AuctionItemRepository auctionItemRepository;
    private final AuctionItemQueryRepository auctionItemQueryRepository;

    public AuctionItemResponseDto getAuctionItem(Long auctionItemId) {
        AuctionItem auctionItem = auctionItemRepository.findById(auctionItemId).orElseThrow(
            () -> new IllegalArgumentException("존재하지 않는 경매상품 입니다.")
        );

        return new AuctionItemResponseDto(auctionItem);
    }

    public List<AuctionItemResponseDto> getAuctionItems() {
        return auctionItemQueryRepository.findAll();
    }

    public List<FinishedItemResponseDto> getFinishedAuctionItems() {
        return auctionItemQueryRepository.findAllByFinished();
    }

    public FinishedItemResponseDto getFinishedAuctionItem(Long auctionItemId) {
        return auctionItemQueryRepository.findByIdAndFinished(auctionItemId)
            .orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 상품 ID 입니다.")
            );
    }

    public AuctionItem findById(Long auctionItemId) {
        return auctionItemRepository.findById(auctionItemId).orElseThrow(
            () -> new IllegalArgumentException("해당 상품을 찾을 수 없습니다.")
        );
    }
}
