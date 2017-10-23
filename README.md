# Simulation EmpruntSimulationCalculator
Application permettant de simuler le remboursement d'un emprunt à taux constant et mensualités constantes

## Besoin
 * L’utilisateur saisit le **capital emprunté**, le **taux d’intérêt (annuel)** et le **nombre de périodes (mois)**
 * L'application calcule et affiche le montant des mensualités et le coût total de l’opération

## Découpage en User Stories (US)
 * US1 : Calculer le montant des mensualités
 * US2 : Calculer le coût total de l'emprunt
 * US3 : Afficher le tableau d'amortissement
 * US4 : Proposer une interface graphique (formulaire web) pour saisir les données d'entrée et lancer le calcul
 * US5 : Proposer une restitution graphique pour le tableau d'amortissement

## US1 & US2 : Formule de calcul de la mensualité
 * Formule : **M = C × t / ( 1 – (1 + t)<sup>–n</sup> )**
 * **M** : montant des mensualités (ce qu’on recherche)
 * **C** : capital emprunté
 * **t** : taux mensuel c.a.d t = T / 1200 (T étant le taux saisi par l’utilisateur)
 * **n** : nombre de mois

__Exemple__ :
 * _Entrée_ :
    * __Capital__ : 100 000 €
    * __Taux annuel__ : 12 %
    * __Nombre de mois__ : 120
 * _Sortie_ :
    * Mensualité : __1 434.71 €__
    * Coût total : __172 165.14 €__

## US3 : Tableau d'amortissement
Il s'agit de la décomposition, mois par mois, de la mensualité en une somme qui correspond à l’intérêt sur un mois du capital restant dû et une partie remboursement qui vient se soustraire au capital restant

__Exemple__ :
 * Taux : 12%
 * Mensualité : 1 434.71 €
<html> 
<div>
<table>
 <tr align="center">
  <td>Mois</td>
  <td>Intérêt</td>
  <td>Remboursement</td>
  <td>Capital restant dû</td>
 </tr>
 <tr align="center">
  <td>----</td>
  <td>----</td>
  <td>----</td>
  <td>100 000</td>
 </tr>
 <tr align="center">
  <td>1</td>
  <td>1 000</td>
  <td>434.71</td>
  <td>99 565.29</td>
 </tr>
 <tr align="center">
   <td>2</td>
   <td>995.65</td>
   <td>439.06</td>
   <td>99 126.23</td>
 </tr>
 <tr align="center">
   <td>3</td>
   <td>991.26</td>
   <td>443.45</td>
   <td>98 682.79</td>
 </tr>
 <tr align="center">
   <td>4</td>
   <td>986.83</td>
   <td>447.88</td>
   <td>98 234.91</td>
 </tr>
 <tr align="center">
   <td>5</td>
   <td>982.35</td>
   <td>452.36</td>
   <td>97 782.54</td>
 </tr>
  <tr align="center">
    <td>....</td>
    <td>....</td>
    <td>....</td>
    <td>....</td>
  </tr> 
</table>
</div>
</html>


  