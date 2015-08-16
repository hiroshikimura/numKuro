package org.kimura.pazzle.numKuro.operator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.kimura.pazzle.numKuro.container.Word;
import org.seasar.framework.util.StringUtil;
import org.seasar.framework.util.tiger.CollectionsUtil;
import org.supercsv.io.CsvListReader;
import org.supercsv.prefs.CsvPreference;

/**
 * 初期マップ２次元配列スキャナ
 * @author kimura
 *
 */
public class Scanner {

	/**
	 * 初期マップ情報から入力欄リストを取得
	 * @param filePath ファイルパス
	 * @return 入力欄リスト
	 */
	public List<Word> getWordList(String filePath) {
		return null;
	}
	
	/**
	 * ファイルから入力欄マトリクスを生成
	 * @param filePath ファイル名
	 * @return 入力欄マトリックス
	 * @throws IOException 
	 */
	protected List<List<String>>	getInitialMapRaw(String filePath) throws IOException {
		CsvListReader reader = new CsvListReader(new FileReader(new File(filePath)),CsvPreference.EXCEL_PREFERENCE);
		
		// 最初の行はヘッダーでは無い
		reader.getHeader(false);
		List<List<String>> matrix = CollectionsUtil.newArrayList();
		List<String> line;
		
		while( ( line = reader.read() ) != null ) {
			matrix.add(line);
		}
		return matrix;
	}
	
	/**
	 * 指定されたマトリクスから入力マス群をすべて取得する
	 * @param matrix ナンクロマトリクス
	 * @return
	 */
	protected List<Word> scanWholeWords(List<List<String>> matrix) {
		List<Word>	words = CollectionsUtil.newArrayList();

		// 横走査を行う。
		for ( List<String> scanLine : matrix) {
			words.addAll(scanWords(scanLine));
		}

		// 縦走査はデータ構造がメンドクサイのでスキャンラインとして抜き出す
		int len = matrix.get(0).size();
		for ( int i = 0 ; i < len ; i++ ) {
			words.addAll(scanWords(pickVirticalScanLine(matrix,i)));
		}
		
		return words;
	}
	/**
	 * 縦ラインからスキャンに容易なスキャンラインを生成する
	 * @param matrix ナンクロマトリクス
	 * @param column ぬきだすコラム位置
	 * @return
	 */
	protected List<String> pickVirticalScanLine(List<List<String>> matrix, int column) {
		List<String> scanLine = CollectionsUtil.newArrayList();
		for ( List<String> line : matrix) {
			scanLine.add(line.get(column));
		}
		return scanLine;
	}
	
	/**
	 * 指定されたスキャンライン情報から入力欄リストを生成する
	 * @param scanLine スキャンライン情報
	 * @return 入力欄情報
	 */
	protected	List<Word>	scanWords(List<String> scanLine) {
		List<String> stack = CollectionsUtil.newArrayList();
		List<Word> words = CollectionsUtil.newArrayList();
		
		for(String e : scanLine) {
			if ( StringUtil.isEmpty(e) || StringUtil.isBlank(e) ) {
				// eが空文字(スペース)の場合
				// ここで連続する入力欄が途切れているので、ここまでの集合を入力欄としてWordを生成する
				words.add(Word.create(stack));
				// 生成後にstackを初期化
				stack = CollectionsUtil.newArrayList();
			} else {
				// eに文字列あり
				// stackに積んでいく
				stack.add(e);
			}
		}
		if ( stack.size()>0) {
			// 最後の最後で残っているので、これで入力欄を生成
			words.add(Word.create(stack));
		}
		return words;
	}
}
