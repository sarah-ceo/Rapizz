-- La carte
SELECT nomPizza AS 'PIZZA', CONCAT(ROUND(prixBase-(1/3*prixBase),2), ' €') as 'NAINE', CONCAT(ROUND(prixBase,2), ' €') as 'HUMAINE', CONCAT(ROUND(prixBase+(1/3*prixBase),2), ' €') as 'OGRESSE', GROUP_CONCAT(nomIngredient) as 'INGREDIENTS' 
FROM pizzas 
INNER JOIN pizzas_ingredients ON pizzas.idPizza=pizzas_ingredients.idPizza 
INNER JOIN ingredients ON pizzas_ingredients.idIngredient=ingredients.idIngredient 
GROUP BY nomPizza;

-- Fiche de livraison
SELECT CONCAT(prenomLivreur, ' ', nomLivreur) as 'LIVREUR', typeVehicule as 'VEHICULE', CONCAT(prenomClient, ' ', nomClient) as 'CLIENT', DATE(dateVente) as 'DATE DE LA COMMANDE', CONCAT(GREATEST(tempsLivraison-30,0), ' min') as RETARD, nomPizza as 'PIZZA', prixBase as 'PRIX (BASE)' 
FROM ventes 
INNER JOIN livreurs on ventes.idLivreur=livreurs.idLivreur 
INNER JOIN vehicules ON ventes.idVehicule = vehicules.idVehicule 
INNER JOIN clients ON ventes.idClient = clients.idClient
INNER JOIN pizzas ON ventes.idPizza = pizzas.idPizza;

-- Vehicules n'ayant jamais servi
SELECT typeVehicule, modeleVehicule, immatriculationVehicule
FROM vehicules 
LEFT JOIN ventes ON ventes.idVehicule = vehicules.idVehicule 
WHERE ventes.idVehicule IS NULL; 

-- Nombre de commandes par client
SELECT CONCAT(prenomClient, ' ', nomClient) AS 'CLIENT', COUNT(idVente) AS 'NOMBRE DE COMMANDES'
FROM clients
INNER JOIN ventes ON ventes.idClient = clients.idClient
GROUP BY ventes.idClient;

-- Moyenne des montants des commandes
SELECT ROUND(AVG(montantCommande),2) AS 'MOYENNE DES COMMANDES'
FROM ventes;

-- Clients ayant commandé plus que la moyenne
SELECT CONCAT(prenomClient, ' ', nomClient) AS 'CLIENT', ROUND(AVG(montantCommande),2) AS 'MOYENNE DES COMMANDES'
FROM clients
INNER JOIN ventes ON ventes.IdClient = clients.idClient
GROUP BY ventes.idClient
HAVING AVG(montantCommande) > (SELECT AVG(montantCommande) FROM ventes);