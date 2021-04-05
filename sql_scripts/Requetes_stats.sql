-- Meilleur client
DROP PROCEDURE IF EXISTS meilleurClient;
DELIMITER $$
CREATE PROCEDURE meilleurClient()
BEGIN
	SELECT CONCAT(prenomClient,' ',nomClient) as 'Client', COUNT(idCommande) as 'Nombre de commandes', ROUND(SUM(montantCommande),2) as 'Montant total'
	FROM commandes, clients
	WHERE commandes.idClient = clients.idClient
	GROUP BY commandes.idClient
	ORDER BY COUNT(idCommande) DESC;
END$$
DELIMITER ;

CALL meilleurClient();

-- Pire Livreur
DROP PROCEDURE IF EXISTS pireLivreur;
DELIMITER $$
CREATE PROCEDURE pireLivreur()
BEGIN
	SELECT livreurs.idLivreur as id, CONCAT(prenomLivreur,' ',nomLivreur) as 'Livreur', (SELECT COUNT(idCommande) FROM commandes WHERE idLivreur=id AND bonification='Retard') as 'Nombre de retard', ROUND(AVG(tempsLivraison)) as 'Temps de livraison moyen'
	FROM commandes, livreurs
	WHERE commandes.idLivreur = livreurs.idLivreur
	GROUP BY commandes.idLivreur
	ORDER BY  'Nombre de retard' DESC;
END$$
DELIMITER ;

CALL pireLivreur();

-- Pizza favorite
DROP PROCEDURE IF EXISTS pizzaFavorite;
DELIMITER $$
CREATE PROCEDURE pizzaFavorite()
BEGIN
	SELECT nomPizza as 'Pizza', COUNT(idCommande) as 'Nombre de commandes'
	FROM commandes_pizzas, pizzas
	WHERE commandes_pizzas.idPizza = pizzas.idPizza
	GROUP BY pizzas.idPizza
	ORDER BY COUNT(idCommande) DESC;
END$$
DELIMITER ;

CALL pizzaFavorite();

-- Ingrédient favori
DROP PROCEDURE IF EXISTS ingredientFavori;
DELIMITER $$
CREATE PROCEDURE ingredientFavori()
BEGIN
	SELECT nomIngredient as 'Ingrédient', COUNT(idPizza) as 'Nombre de pizzas'
	FROM pizzas_ingredients, ingredients
	WHERE pizzas_ingredients.idIngredient = ingredients.idIngredient
	GROUP BY ingredients.idIngredient
	ORDER BY COUNT(idPizza) DESC;
END$$
DELIMITER ;

CALL ingredientFavori();