package org.kimura.pazzle.numKuro.container;

import java.io.Serializable;
import java.util.List;

import org.kimura.pazzle.numKuro.operator.Finder;
import org.seasar.framework.util.tiger.CollectionsUtil;

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
	
	public static Word create(List<String> words) {
		List<Integer> fwd = CollectionsUtil.newArrayList(words.size());
		List<Integer> rev = CollectionsUtil.newArrayList(words.size());
		int val;
		for ( int i = 0 ; i < words.size(); i++ ) {
			val = Integer.parseInt(words.get(i));
			fwd.set(i, val);
			rev.set(rev.size()-i-1, val);
		}
		Word w = new Word();
		w.fwdList = fwd;
		w.revList = rev;
		return w;
	}
	
	protected Word() {
		
	}

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
