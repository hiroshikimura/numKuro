package org.kimura.pazzle.numKuro.container.creator;

import org.seasar.framework.container.ComponentCustomizer;
import org.seasar.framework.container.assembler.AutoBindingDefFactory;
import org.seasar.framework.container.creator.ComponentCreatorImpl;
import org.seasar.framework.container.deployer.InstanceDefFactory;
import org.seasar.framework.convention.NamingConvention;

public class VisualCreator extends ComponentCreatorImpl {

	public VisualCreator(NamingConvention namingConvention) {
		super(namingConvention);
		setNameSuffix("Visual");
		setInstanceDef(InstanceDefFactory.PROTOTYPE);
		setAutoBindingDef(AutoBindingDefFactory.AUTO);
	}

	public ComponentCustomizer getVisualCustomizer() {
		return getCustomizer();
	}
 
	public void setVisualCustomizer(ComponentCustomizer customizer) {
		setCustomizer(customizer);
	}
}
