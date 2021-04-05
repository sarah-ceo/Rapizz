DELIMITER $$
DROP TRIGGER IF EXISTS setCommande $$

CREATE TRIGGER setCommande 
    BEFORE INSERT ON commandes
    FOR EACH ROW 
BEGIN
	IF ((MOD((SELECT COUNT(idCommande) FROM commandes WHERE idClient = NEW.idClient)+1,10)=0) AND ((SELECT COUNT(idCommande) FROM commandes WHERE idClient = NEW.idClient)>0)) THEN 
    SET NEW.bonification = 'Fidelité';
    SET NEW.montantCommande = 0;
	END IF;
    SET NEW.statutCommande = 'En cours';
    SET NEW.tempsLivraison = 0;
    SET NEW.idLivreur=(SELECT idLivreur FROM livreurs ORDER BY rand() LIMIT 1);
    SET NEW.idVehicule = (SELECT idVehicule FROM vehicules ORDER BY rand() LIMIT 1);
END$$
DELIMITER ;

