package org.kimura.pazzle.numKuro.container;

import java.io.Serializable;
import java.util.List;

import org.kimura.pazzle.numKuro.operator.Finder;
import org.seasar.framework.util.StringUtil;
import org.seasar.framework.util.tiger.CollectionsUtil;

/**
 * ナンクロの入力欄の集合
 * 初期マトリクスから得られた入力欄集合の１つ
 * @author kimura
 *
 */
public class InputFieldSet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static InputFieldSet create(List<String> words) {
		List<Integer> fwd = CollectionsUtil.newArrayList(words.size());
		List<Integer> rev = CollectionsUtil.newArrayList(words.size());
		int val;
		for ( int i = 0 ; i < words.size(); i++ ) {
			val = Integer.parseInt(words.get(i));
			fwd.set(i, val);
			rev.set(rev.size()-i-1, val);
		}
		InputFieldSet w = new InputFieldSet();
		w.fwdList = fwd;
		w.revList = rev;
		return w;
	}

	protected InputFieldSet() {
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
	
	/**
	 * 入力欄集合の埋まった割合を算出する
	 * @param a 解答情報
	 * @return
	 */
	public int	fillRatio(Analyzed a) {
		int cnt = 0;
		for( Integer pos : fwdList ) {
			cnt += StringUtil.isNotEmpty( a.map.get(pos - 1)) ? 100 : 0;
		}
		return cnt / len() ;
	}
	/**
	 * 入力欄集合のサイズを取得する
	 * @return
	 */
	public int len() {
		return this.fwdList.size();
	}
}
