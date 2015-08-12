package org.kimura.pazzle.numKuro;

import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import net.arnx.jsonic.JSON;

import org.apache.commons.io.IOUtils;
import org.kimura.pazzle.numKuro.dto.ConfigDto;
import org.kimura.pazzle.numKuro.visual.NumKuroMainVisual;
import org.seasar.framework.beans.util.BeanUtil;
import org.seasar.framework.container.S2Container;
import org.seasar.framework.container.factory.SingletonS2ContainerFactory;

/**
 * Hello world!
 *
 */
public class App
{
	protected ConfigDto	appConfig;
	protected S2Container container;

	protected	void	initApps(String[] args) {

		appConfig = new ConfigDto();
		Properties props = new Properties();
		try {
			InputStream is = new FileInputStream("numkuro.config");
			props.load(is);
			IOUtils.closeQuietly(is);
			ConfigDto config = JSON.decode(props.getProperty("props"), ConfigDto.class);
			BeanUtil.copyProperties(config, appConfig, false);
		} catch (IOException e) {
			// 読み込みに失敗した場合は、デフォルトをそのまま利用する
		}

		SingletonS2ContainerFactory.setConfigPath("app.dicon");
		SingletonS2ContainerFactory.init();
		container = SingletonS2ContainerFactory.getContainer();
	}

	protected void finalizeApps(String[] args) {

	}

	public	ConfigDto	getConfig() { return appConfig;}

	protected void myMain(String[] args) {
		initApps(args);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					((NumKuroMainVisual)container.getComponent(NumKuroMainVisual.class)).setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		finalizeApps(args);
	}

	public	static	App	application = null;

	public static void main( String[] args )
    {
    	App.application = new App();
    	App.application.myMain(args);
    }
}
