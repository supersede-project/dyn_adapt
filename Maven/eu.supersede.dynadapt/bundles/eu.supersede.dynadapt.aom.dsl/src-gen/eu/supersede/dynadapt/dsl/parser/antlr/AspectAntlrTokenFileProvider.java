/*
 * generated by Xtext
 */
package eu.supersede.dynadapt.dsl.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class AspectAntlrTokenFileProvider implements IAntlrTokenFileProvider {
	
	@Override
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
    	return classLoader.getResourceAsStream("eu/supersede/dynadapt/dsl/parser/antlr/internal/InternalAspect.tokens");
	}
}
