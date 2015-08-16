package org.kimura.pazzle.numKuro.container;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 辞書データネットワークのノード情報
 * @author kimura
 *
 */
public class Node implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 上流方向へのノード参照
	 */
	protected	Map<String,Node> left;
	/**
	 * 下流方向へのノード参照
	 */
	protected	Map<String,Node> right;
	/**
	 * 辞書データ
	 */
	protected	List<String>	dictionary;
	/**
	 * 対象単語インデックス
	 */
	protected	int	wordIndex;
	/**
	 * 対象単語中の位置
	 */
	protected	int	positionOfWord;
}
