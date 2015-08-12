package org.kimura.pazzle.numKuro.container;

import java.io.Serializable;
import java.util.List;

import org.kimura.pazzle.numKuro.operator.Finder;

/**
 * ナンクロの入力欄の集合
 * @author kimura
 *
 */
public class Word implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 正順
	 */
	protected List<Integer> fwdList;
	/**
	 * 逆順
	 */
	protected List<Integer> revList;

	/**
	 * このキーワードに当てはめるための検索条件を生成
	 * @return 
	 */
	public Finder createFinder(Analyzed a) {
		return null;
	}
}
