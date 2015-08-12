package org.kimura.pazzle.numKuro.dto;

import java.io.Serializable;
import java.util.List;

import org.seasar.framework.util.tiger.CollectionsUtil;

public class ConfigDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static class RepositoryDto implements Serializable {
		private static final long serialVersionUID = 1L;
		
		/**
		 * リポジトリURL
		 */
		public String url;
		/**
		 * ワークスペース
		 */
		public String workspace;

		/**
		 * ユーザー名
		 */
		public String username;
		
		/**
		 * パスワード
		 */
		public String password;
	}
	
	/**
	 * 登録リポジトリ
	 */
	public List<RepositoryDto>	repositories = CollectionsUtil.newArrayList();
}
