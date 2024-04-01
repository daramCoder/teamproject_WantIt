package io.dcns.wantitauction.domain.auctionItem.service;

import io.dcns.wantitauction.domain.auctionItem.dto.CreateProductRequestDto;
import io.dcns.wantitauction.domain.auctionItem.dto.MyAuctionItemsResponseDto;
import io.dcns.wantitauction.domain.auctionItem.entity.AuctionItem;
import io.dcns.wantitauction.domain.auctionItem.repository.AuctionItemRepository;
import io.dcns.wantitauction.domain.user.entity.User;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyAuctionItemService {

    private final AuctionItemRepository auctionItemRepository;

    public void createProduct(CreateProductRequestDto request, User user) {
        auctionItemRepository.save(new AuctionItem(request, user));
    }

    public List<MyAuctionItemsResponseDto> getAuctionItems(Long userId) {

        List<AuctionItem> auctionItems = auctionItemRepository.findAllByUserId(userId);

        return auctionItems.stream()
            .map(MyAuctionItemsResponseDto::new)
            .toList();
    }
}