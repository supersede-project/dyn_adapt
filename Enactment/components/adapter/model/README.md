<link rel="shortcut icon" type="image/png" href="images/favicon.png">
# [![SUPERSEDE](../../../../images/SUPERSEDE-logo.png)](https://www.supersede.eu/) project 
## Model Adapter

### Functional Description
This component takes one or more variability selection models suggested by DM and enacts the actions they propose into the base model@runtime that describes the runtime behavior of the adaptive system. For each received selection model, it proceeds as follows. It compares the selection model against the the previously enacted one, in order to identify those variability actions to enact. Then, in turn, each action is applied to the current system model@runtime, by injecting the associated variant model as specified by the adaptability model. This process results on a new adapted model@runtime for the adaptive system. In case this new model is successfully enacted by the Enactor, the Adapter replaces this model in the Model repository as the current system model@runtime and also updates the current variability selection.

###Usage
To use the Model Adapter, the following inputs need to be provided: a variability model, which is the Feature Model provided by DM; an adaptability model, which includes the different possible execution variants and the features in the variability model; and the base model, which describes the current state of the system.
The adapter injects variability in the base model provided by the variant model associated to the specific feature. Given that feature, the adapter looks for the associated variant configuration. The associated elements are stereotyped in the base model, and the required composition directive (add, delete, replace, update) is applied by the Model Adapter (eu.supersede.dynadapt.adapter.ModelAdapter), modifying the base model with the variability injection.
The output for this component will be the adapted base model with the variability suggested by the adaptability model.


See deliverable D4.5 in [Supersede Portal](https://www.supersede.eu/) for more details about this DSL, how to install and use it.

Dynamic Adaptation and Personalization Decision Making and Enactment framework is licensed under the [Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0)

*Please check the respective README.md for details.*

Main contacts: Jesús Gorroñogoitia <jesus.gorronogoitia@atos.net>, Edith Zavala <zavala@essi.upc.edu>

<center>![Project funded by the European Union](../../../../images/european.union.logo.png)</center>
