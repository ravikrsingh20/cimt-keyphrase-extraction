package de.rwth.i9.cimt.ke.repository.eval;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import de.rwth.i9.cimt.ke.model.eval.PublicationKeywords;

public interface PublicationKeywordsRepository extends PagingAndSortingRepository<PublicationKeywords, Integer> {
	List<PublicationKeywords> findByPublicationId(Integer publicationid);

	//List<PublicationKeywords> findByPublicationIdAndKeAlgorithm(Integer publicationId, String keAlgorithm);

	List<PublicationKeywords> findByPublicationIdAndKeAlgorithmAndIsWikipediaBased(Integer publicationId,
			String keAlgorithm, Boolean isWikipediaBased);

}
