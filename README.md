# Banque

Application crée en JEE permettant d'effectuer des opérations bancaires classiques :

* Un composant EJB contenant des EJB sessions et un EJB entity dédié à la partie métier et permettant d'effectuer un certain nombre de traitements (Exposée en local et remote)
* Un client Java consommant cet EJB 
* Un client Web consommant cet EJB via les protocoles REST et SOAP

Serveur : Wildfly 8 (JBoss)
SGBD : PostgreSQL



