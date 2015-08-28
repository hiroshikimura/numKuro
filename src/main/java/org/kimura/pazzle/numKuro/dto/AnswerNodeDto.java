package org.kimura.pazzle.numKuro.dto;

import java.io.Serializable;
import java.util.List;

/**
 * 解答手順ノード
 * @author kimura
 *
 */
public class AnswerNodeDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 入力欄集合に入れたワード
	 */
	public String word;
	
	/**
	 * 次の入力欄集合の候補リスト
	 * 基本的には１件に集約されるが、複数のルートの存在も肯定する
	 */
	public List<AnswerNodeDto> childNodes;
}
