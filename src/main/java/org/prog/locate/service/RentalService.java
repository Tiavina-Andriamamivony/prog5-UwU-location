package org.prog.locate.service;

import lombok.RequiredArgsConstructor;
import org.prog.locate.entity.Article;
import org.prog.locate.entity.Invoice;
import org.prog.locate.entity.Renter;
import org.prog.locate.repository.ArticleRepository;
import org.prog.locate.repository.InvoiceRepository;
import org.prog.locate.repository.RenterRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RentalService {

    private final ArticleRepository articleRepository;
    private final RenterRepository renterRepository;
    private final InvoiceRepository invoiceRepository;

    public Article findArticleById(Long id) {
        return articleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Article not found with id " + id));
    }

    public Renter findRenterById(Long id) {
        return renterRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Renter not found with id " + id));
    }

    public Invoice rentArticle(Long articleId, Long renterId) {
        Article article = findArticleById(articleId);
        Renter renter = findRenterById(renterId);

        Invoice invoice = article.rent(renter);

        articleRepository.save(article);

        invoiceRepository.save(invoice);

        return invoice;
    }
}
