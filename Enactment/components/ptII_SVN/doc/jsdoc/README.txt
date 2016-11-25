$Id: README.txt 72862 2015-07-26 14:53:34Z cxh $

This directory contains files used by JSDoc, which generates documentation for JavaScript.

Updating The JSDoc output
-------------------------

The JSDoc output is in $PTII/doc/codeDoc/js.

Running "ant jsdoc" will clone the terraswarm fork of JSDoc.

To build:

cd $PTII
./configure
ant jsdoc

To update the JSDoc fork after running "ant jsdoc"

cd $PTII
ant vendors-jsdoc-pull
ant jsdoc

See Also
--------
* https://chess.eecs.berkeley.edu/ptexternal/wiki/Main/JSDocSystems - Overview of JSDoc systems
** https://chess.eecs.berkeley.edu/ptexternal/wiki/Main/JSDocSystems#JSDocCustomTagPlugin - How @accessor, @input etc. are supported.
* https://www.terraswarm.org/accessors/wiki/Main/JSDoc - Information for Accessor writers (TerraSwarm membership required)



