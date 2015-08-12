package org.kimura.pazzle.numKuro.container;

import java.util.List;
import java.util.Map;

import org.seasar.framework.util.tiger.CollectionsUtil;

/**
 * 解析結果
 * @author kimura
 *
 */
public class Analyzed {

	/**
	 * 対応表
	 */
	public List<String> map ;
	
	/**
	 * 解答配列
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
	
	public Analyzed initial(int length) {
		map = CollectionsUtil.newArrayList(length);
		return this;
	}
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
	public Analyzed initial(List<Integer> answer) {
		this.answerMap = CollectionsUtil.newArrayList(answer);
		return this;
	}
	
	/**
	 * 解答配列からWordを生成する
	 * @return
	 */
	public Word analyzedWord() {
		return null;
	}
}
