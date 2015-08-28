package org.kimura.pazzle.numKuro.operator;

/**
 * 検索条件
 * @author kimura
 *
 */
public interface Finder<T> {
	
	/**
	 * 指定された検索条件から必要なクエリを返す
	 * @return クエリ
	 */
	T getQuery();
}
