# Application de Location d’Articles

Cette application permet de louer différents types d’articles, exclusivement :
- Voitures
- Maisons
- Ordinateurs (PC)
- Téléphones
- Matériels de sonorisation
- Argent

Les utilisateurs pouvant effectuer une location peuvent être :
- Une personne
- Une entreprise
- Une église
- Une association

L’objectif principal de l’application est de permettre la location d’un ou plusieurs articles.

---

## Description

Le projet se compose d’une API backend développée en **Java Spring Boot**.

Fonctionnalités essentielles du backend:
- Gestion des entités (articles, utilisateurs, locations)
- Location d’articles
- Persistance via PostgreSQL
- Respect de la convention **camelCase**

La structure du backend suit le standard Spring Boot avec Maven :
```
controller/   # contient tous les controllers
entity/       # les entités JPA
repository/   # interfaces JPARepository
service/      # services métier
```

---

## Dépendances & Outils nécessaires

###  Docker
Utilisé pour conteneuriser l’application (backend, DB, etc.).
- Docker
- Docker Compose (optionnel)

###  Backend (Java + Spring Boot)
- **Java 17**
- **Spring Boot**
- **Maven**
- **JPA / Hibernate**
- **PostgreSQL 17**
- **Spring Data JPA**
- **Spring Web**
- **Lombok**

###  Base de données
- PostgreSQL
- Driver JDBC PostgreSQL

# Conventions du Projet Locate

## Structure des Packages
- `controller/` - Endpoints REST
- `service/` - Logique métier (interface + impl)
- `repository/` - Accès données Spring Data
- `entity/` - Modèles JPA
- `entity/children/` - Héritage des items
- `manager/` - Logique métier complexe
- `exception/` - Gestion des erreurs

## Conventions de Code
- **Entités** : `@Entity`, `@Table(name = "snake_case_plural")`
- **Colonnes** : `@Column(name = "snake_case")`
- **API** : Endpoints pluriels (`/rentals`, `/items`)
- **Services** : Interface + `ServiceImpl`
- **Nommage** : `camelCase` variables, `PascalCase` classes
- **Lombok** : `@Getter/@Setter`, `@SuperBuilder` pour héritage

## Base de Données
- PostgreSQL, schéma `snake_case`
- Héritage `JOINED` strategy
- Tables séparées par type d'item (`cars`, `houses`, etc.)

## API REST
- `GET` pour lire, `POST` pour créer, `PUT` pour mettre à jour
- Actions spécifiques : `PUT /resource/{id}/action`
- Validation dans le service, pas dans le controller

## Docker
- Services nommés simplement (`postgres`, `locate`)
- Network: `<projet>_network`
- Healthchecks sur tous les services
- Variables: `${VAR:-default}` syntaxe

## Branches Git
- `main` → Production
- `preprod` → Pré-production

### Installation:

```
git clone https://github.com/Tiavina-Andriamamivony/prog5-UwU-location.git
cd prog5-UwU-location
docker pull yuta2004/locate-locate:1.0
docker compose up
```
### Repatition des rôles:
Fanhasina: Backend
Ninah: Backend
Mihago: Documentation
Tiavina: BackOps

---

### Remarque
On a pas utilisé de DTO mais on a stocké direct les entités JPA direct dans le Dossier entity