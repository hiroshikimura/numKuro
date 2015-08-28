package org.kimura.pazzle.numKuro.dto.dictionary;

import java.io.Serializable;

public class TargetDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ヒットする位置
	 */
	public int order;
	
	/**
	 * 辞書中の単語
	 */
	public String word;
}
