# [![SUPERSEDE](../../../images/SUPERSEDE-logo.png)](https://www.supersede.eu/) project: Dynamic Adaptation and Personalization DM support and Enactment
This folder contains the Enactor tools developed in SUPERSEDE T4.2, T4.3 and T4.4. These tools supporting the dynamic adaptation and reconfiguration enactment.

See deliverables D4.6 and D4.9 in [Supersede Portal](https://www.supersede.eu/) for more details about this framework, including its functional description, its architecture and its components.

Enactors:
- HypervisorEnactor:

- ServiceCompositionEnactor:

- Feedback Gathering Reconfiguration Enactor: 
The Adapter acts as a dispatcher of the suggested feature configurations (FCs), which are computed by DM components. Once the feedback-gathering reconfiguration enactor gets the new FC model, it serializes this model as JSON. Then, the orchestrator RESTful API services are called to update the feedback-gathering configuration with the help of the JSON data. The orchestrator is a component developed as part of the WP1.

- Monitoring Reconfiguration Enactor: 
The monitor reconfiguration enactor receives from the Adapter the Adapted System Model that expresses the new configuration for the monitoring tools. The enactor transforms the Adapted System Model expressed in UML into JSON entries that are platform-specific and follow the JSON schema defined in WP1 components. Such JSON files are sent to the Orchestrator, which is the component of WP1 in charge of managing the monitoring tools.

Dynamic Adaptation and Reconfiguration Enactment framework is licensed under the [Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0)

*Please check the respective README.md for details.*

Main contact: Jesús Gorroñogoitia <jesus.gorronogoitia@atos.net>, Denisse Muñante <munante@fbk.eu>, Marc Oriol <moriol@essi.upc.edu>

![Project funded by the European Union](../../../images/european.union.logo.png)
