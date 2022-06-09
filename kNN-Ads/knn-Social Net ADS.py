# Se importan las librerias necesarias para realizar la práctica
import numpy as np
import matplotlib.pyplot as plt
import pandas as pd

# Se importa el dataset a utilizar, este se encuentra en el directorio raíz
dataset = pd.read_csv('Social_Network_Ads.csv')

#Se determinan los valores dependientes X (Age, Salario) e independientes y
X = dataset.iloc[:, [2, 3]].values
print(X)
y = dataset.iloc[:, -1].values
print(y)

#Imprimimos el dataset 
print("Dataset: Social Network Ads ")
print(dataset)

# Dado a que nuestro dataset contiene 400 conjuntos, se asigna un 80% (320 conjuntos) de este para una muestra
# de training y un 20% para muestra de prueba (80 conjuntos)
from sklearn.model_selection import train_test_split
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size = 0.20, random_state = 0)

# Se hace una escalación a el conjunto de Training para reducir el tamaño a valores más pequeños
from sklearn.preprocessing import StandardScaler
sc = StandardScaler()
X_train = sc.fit_transform(X_train)
X_test = sc.transform(X_test)

print("X_train")
print(X_train)
print("X_test")
print(X_test)

# Se crea y entrena el modelo KNN con la muestra de Training bajo los parametros de
# Numero de Vecinos = 3,
# Metrica de Distancia Euclidiana
from sklearn.neighbors import KNeighborsClassifier
classifier = KNeighborsClassifier(n_neighbors = 3, metric = 'euclidean', p = 2)
classifier.fit(X_train, y_train)
print("Clasificador: ", classifier)
# Predecimos la salida a partir de la muestra de prueba
y_pred = classifier.predict(X_test)

print("Matriz de predicción:", y_pred)

# Evaluamos el modelo usando una matriz de confusion y precision
# esto para comparar los valores de prueba pronosticados con los valores reales
from sklearn.metrics import confusion_matrix, accuracy_score
cm = confusion_matrix(y_test, y_pred)
ac = accuracy_score(y_test, y_pred)
y_pred = classifier.predict(X_test)

print("Matriz de confusión ", cm)
print("¨Precisión: ", ac)


