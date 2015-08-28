package org.kimura.pazzle.numKuro.container;

import java.util.List;
import java.util.Map;

import org.seasar.framework.util.tiger.CollectionsUtil;

/**
 * 解析結果
 * ナンクロマトリクスの対応表中の文字集合と、解答配列を保持する。
 * 入力欄集合と、対応する単語はここでは管理しない。
 * @author kimura
 *
 */
public class Analyzed {

	/**
	 * 対応表
	 * ここに数字と対応する文字を保持する
	 * 要は『文字のリスト』
	 */
	public List<String> map ;
	
	/**
	 * 解答配列
	 * 最終的に得られる文字の参照リスト
	 * ここに入っている情報は『対応表リスト中の位置』
	 */
	public List<Integer> answerMap;

	/**
	 * 初期パラメータ設定
	 * @param length 対応表長さ
	 * @param initialFeed 初期データ
	 * @param answerArray 解答配列
	 * @return
	 */
	public Analyzed initial(int length, Map<Integer,String> initialFeed, List<Integer> answer) {
		return initial(length,initialFeed).initial(answer);
	}
	/**
	 * 初期パラメータ設定
	 * @param length 対応表長さ
	 * @return
	 */
	public Analyzed initial(int length) {
		map = CollectionsUtil.newArrayList(length);
		return this;
	}
	/**
	 * 初期パラメータ設定
	 * @param length 対応表長さ
	 * @param initialFeed 初期データ
	 * @return
	 */
	public Analyzed initial(int length, Map<Integer,String> initialFeed) {
		
		map = CollectionsUtil.newArrayList(length);

		if ( null == initialFeed ) {
			return this;
		}

		for ( Integer i : initialFeed.keySet() ) {
			this.map.set( i - 1, initialFeed.get(i));
		}
		return this;
	}
	/**
	 * 初期パラメータ設定
	 * @param answer　解答配列
	 * @return
	 */
	public Analyzed initial(List<Integer> answer) {
		this.answerMap = CollectionsUtil.newArrayList(answer);
		return this;
	}
	
	/**
	 * 解答配列からWordを生成する
	 * @return
	 */
	public InputFieldSet analyzedWord() {
		return null;
	}
	
	public List<String> getLastPropagation() {
		return null;
	}
}
