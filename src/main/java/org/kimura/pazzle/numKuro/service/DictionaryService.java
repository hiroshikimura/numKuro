package org.kimura.pazzle.numKuro.service;

import java.util.List;

public interface DictionaryService {

	/**
	 * 指定したクエリで単語を検索し、該当する単語を返却する
	 * @param query クエリ
	 * @return 単語リスト
	 */
	List<String>	find(List<Integer> query) ;
}
