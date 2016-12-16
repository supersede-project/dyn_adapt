<link rel="shortcut icon" type="image/png" href="images/favicon.png">
# [![SUPERSEDE](../../images/SUPERSEDE-logo.png)](https://www.supersede.eu/) project 
## Dynamic Adaptation and Personalization Enactment (DAPPLE) Components

DAPPLE framework prototype consists of a number of components, as described in section  3.3.2. This M18 prototype includes first implementations for the following components:

- Adaptability Editor: this editor, based on Xtext, provides assisted authoring and validation of adaptability models, which are document instances of the AOM-based DSL defined by SUPERSEDE to describe adaptability variants in models
- Adapter: This component takes one or more variability selection models suggested by DM and enacts the actions they propose into the base model@runtime that describes the runtime behavior of the adaptive system
- (Service Composition) Enactor: The Enactor component receives the adapted system model@runtime and computes the platform specific artifacts, out of this model, to enact the changes proposed in the model
- (Composition) Adaptation Hook: The adaptation hook offers a generic interface, embeddable into adaptive systems, that enables the enactment of adaptation actions into the adaptable systems, provided that they adheres to the SUPERSEDE Adaptable System Architecture. This architecture requires supported adaptive systems to expose services that implement the Adaptation Hook API and apply received platform-specific adaptation actions
- ptII_SVN: The Ptolemy scientific workflow used from the Enactor and Hook components to execute the services

See deliverable D4.5 in [Supersede Portal](https://www.supersede.eu/) for more details about this framework, how to install and use it.

Dynamic Adaptation and Personalization Decision Making and Enactment framework is licensed under the [Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0)

*Please check the respective README.md for details.*

Main contacts: Jesús Gorroñogoitia <jesus.gorronogoitia@atos.net>, Edith Zavala <zavala@essi.upc.edu>, Srdjan Stevanetic <srdjan.stevanetic@gmail.com>

<center>![Project funded by the European Union](../../images/european.union.logo.png)</center>
