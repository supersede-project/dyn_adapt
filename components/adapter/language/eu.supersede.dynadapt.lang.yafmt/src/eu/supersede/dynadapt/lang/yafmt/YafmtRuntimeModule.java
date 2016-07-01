package eu.supersede.dynadapt.lang.yafmt;

import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy;
import org.eclipse.xtext.resource.generic.AbstractGenericResourceRuntimeModule;

/**
 * Implementation based on Christian Dietrichs blog post.
 * 
 * @see <a href="http://christiandietrich.wordpress.com/2011/07/17/xtext-2-0-and-uml/">
 * Original blog post by Christian Dietrich</a>
 */
public class YafmtRuntimeModule extends AbstractGenericResourceRuntimeModule {

	@Override
	protected String getLanguageName() {
		return "cz.zcu.yafmt.model.fm.presentation.FeatureModelEditorID";
	}

	@Override
	protected String getFileExtensions() {
		return "yafm";
	}

	public Class<? extends IDefaultResourceDescriptionStrategy> bindIDefaultResourceDescriptionStrategy() {
        return YafmtResourceDescriptionStrategy.class;
    }
 
    @Override
    public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
        return YafmtQualifiedNameProvider.class;
    }
}
