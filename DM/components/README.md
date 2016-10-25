<link rel="shortcut icon" type="image/png" href="images/favicon.png">
# [![SUPERSEDE](../../images/SUPERSEDE-logo.png)](https://www.supersede.eu/) project 
## Decision Making (DM) support for Dynamic Adaptation and Personalization Enactment Components

Runtime DM support for Adaptation and Personalization framework prototype consists of a number of components. This M18 prototype includes first implementations for the following components:

- Feature Model editor: This editor, extended from [YAFMT Editor](https://bitbucket.org/jpikl/yafmt/wiki/Home)  by SUPERSEDE, enables modelers to create complex system variability models, which are tree-shape representations of all possible variants (e.g. features) in the adaptive system behaviour
- DM Optimization Planner: This component computes several complete optimal feature configurations out of an initial partial. This configuration shows the most optimal and balanced one with regards to multiple optimized quality attributes, while constraining expressed available resources.
- FM Serializer: This component transforms the feature model into a grammar representation required by the optimization algorithm to support automatic reasoning. It also extracts and serialize the quality and constraint attributes in separate input models.
- Feature Configuration Builder: This component transforms the optimization algorithm outputs (e.g. a list of IDs corresponding to the selected features for the complete feature configuration) into a YAFMT feature configuration

See deliverable D3.6 in [Supersede Portal](https://www.supersede.eu/) for more details about this framework, how to install and use it.

Runtime DM support for Adaptation and Personalization framework is licensed under the [Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0)

*Please check the respective README.md for details.*

Main contacts: Jesús Gorroñogoitia <jesus.gorronogoitia@atos.net>, Fitsum Kifetew <kifetew@fbk.eu>, Denisse Yessica Munante Arzapalo <munante@fbk.eu>, Edith Zavala <zavala@essi.upc.edu>, Srdjan Stevanetic <srdjan.stevanetic@gmail.com>

<center>![Project funded by the European Union](../../images/european.union.logo.png)</center>
