 from statistics import Statistics
 from loader import load_csv

 dataset = load_csv("spotify.csv")
 stats = Statistics(dataset)

 print("Quantidade de músicas:", stats.count("track_name"))

 print("Popularidade média:", stats.mean("popularity"))
 print("Mediana popularidade:", stats.median("popularity"))

 print("Energia média:", stats.mean("energy"))
 print("Dançabilidade média:", stats.mean("danceability"))

 print("Top gêneros:")
 freq_generos = stats.frequency("track_genre")

 ordenado = sorted(freq_generos.items(), key=lambda x: x[1], reverse=True)

 for genero, qtd in ordenado[:5]:
    print(genero, ":", qtd)