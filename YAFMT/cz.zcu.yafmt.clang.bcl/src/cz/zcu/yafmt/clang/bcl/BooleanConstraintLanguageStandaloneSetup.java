package cz.zcu.yafmt.clang.bcl;

import cz.zcu.yafmt.clang.bcl.BooleanConstraintLanguageStandaloneSetupGenerated;

/**
 * Initialization support for running Xtext languages without equinox extension
 * registry
 */
public class BooleanConstraintLanguageStandaloneSetup extends BooleanConstraintLanguageStandaloneSetupGenerated {

    public static void doSetup() {
        new BooleanConstraintLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
    }
}
