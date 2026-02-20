# Activité Pratique 1 : Inversion de Contrôle et Injection des Dépendances (IoC)

## 👤 Présentation
* **Nom :** [Essayouti Atiqa]
* **Filière :** Master Systèmes Distribués et Intelligence Artificielle (SDIA)
* **Établissement :** Université Cadi Ayyad
* **Module :** Frameworks Java/JEE
* **Encadré par :** Pr. Mohamed YOUSSFI

---

## 🎯 Objectifs de l'activité
L'objectif de ce projet est de comprendre les concepts fondamentaux de l'**Inversion de Contrôle (IoC)** et de l'**Injection des Dépendances (DI)** en Java à travers trois approches progressives :
1.  **Instanciation statique** (Couplage fort).
2.  **Instanciation dynamique** via la **Reflection API** (Couplage faible).
3.  **Utilisation du Framework Spring** (Versions XML et Annotations).

---

## 🏗️ Architecture du Projet
Le projet suit une architecture multicouche pour favoriser le couplage faible :
- **Couche DAO** : Interface `IDao` et ses implémentations (`DaoImpl`, `DaoImplV2`).
- **Couche Métier** : Interface `IMetier` et implémentation `MetierImpl`.
- **Couche Présentation** : Classes de test pour chaque type d'injection.



---

## 🛠️ Étapes de Réalisation

### 1. Couplage Faible et Instanciation Statique
Dans cette partie, nous avons défini les interfaces et les classes. L'injection est faite manuellement dans la classe `Pres1`.
* **Inconvénient** : Obligation de modifier le code source pour changer d'implémentation.

### 2. Instanciation Dynamique (Reflection API)
Utilisation d'un fichier de configuration `config.txt` pour charger les classes dynamiquement au runtime.
* **Avantage** : L'application devient fermée à la modification et ouverte à l'extension.

### 3. Injection des Dépendances avec Spring Framework
#### A. Version XML (`config.xml`)
Configuration des Beans et des injections via un fichier XML.
```xml
<bean id="dao" class="net.dao.DaoImpl"></bean>
<bean id="metier" class="net.metier.MetierImpl">
    <property name="dao" ref="dao"></property>
</bean>
