package org.kimura.pazzle.numKuro.dto.dictionary;

import java.io.Serializable;
import java.util.List;

/**
 * 辞書要素
 * Cassandra中の単語キーカラムにあたる
 * @author kimura
 *
 */
public class ElementDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * キーとなる文字
	 */
	public Character key;

	/**
	 * キー文字がヒットした場合に対象となる辞書中の単語
	 */
	public List<TargetDto>	hits;
}
