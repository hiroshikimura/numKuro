package org.kimura.pazzle.numKuro.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.kimura.pazzle.numKuro.container.InputFieldSet;

/**
 * 入力欄集合に当てはめる単語の候補
 * <p>
 * 入力欄集合は１つしか対象とはならないが、単語そのものは複数が対象となり、
 * うち１つ以上が解答となり、ゼロになった時点で『その単語は間違いである』となり、
 * その先の候補ノードは破棄される。
 * ただし、次候補ノードが存在しなくても、残入力欄集合も存在しない場合は
 * その時点で解答が得られたということになる。
 * </p>
 * @author kimura
 *
 */
public class CandidateDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ここで取り扱う入力欄集合
	 */
	public InputFieldSet inputFields;

	/**
	 * 次の候補リスト
	 * Key :選択された辞書中の単語
	 * Data:次の候補
	 */
	public Map<String,CandidateDto> nextCandidate;
}
