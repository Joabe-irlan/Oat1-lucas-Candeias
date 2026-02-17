 class Statistics:

    def _init_(self, dataset):
        self._validate_dataset(dataset)
        self.data = dataset

     def _validate_dataset(self, dataset):
        if not isinstance(dataset, dict):
            raise TypeError("Dataset deve ser um dicionário")

         if len(dataset) == 0:
            raise ValueError("Dataset vazio")

         tamanhos = [len(v) for v in dataset.values()]
         if len(set(tamanhos)) != 1:
            raise ValueError("Colunas com tamanhos diferentes")

         for coluna, valores in dataset.items():
            if len(valores) == 0:
                raise ValueError(f"Coluna {coluna} vazia")

             tipo_base = type(valores[0])
             for v in valores:
                 if type(v) != tipo_base:
                    raise TypeError(f"Tipos diferentes na coluna {coluna}")

     def _check_column(self, coluna):
        if coluna not in self.data:
            raise KeyError(f"Coluna {coluna} inexistente")

     def _is_numeric(self, coluna):
         self._check_column(coluna)
         return isinstance(self.data[coluna][0], (int, float))

     def count(self, coluna):
        self._check_column(coluna)
        return len(self.data[coluna])

     def unique(self, coluna):
        self._check_column(coluna)
        return list(set(self.data[coluna]))

     def frequency(self, coluna):
        self._check_column(coluna)
        freq = {}
         for v in self.data[coluna]:
            freq[v] = freq.get(v, 0) + 1
         return freq

     def min(self, coluna):
         if not self._is_numeric(coluna):
            raise TypeError("Operação apenas para dados numéricos")
         return sorted(self.data[coluna])[0]

     def max(self, coluna):
         if not self._is_numeric(coluna):
            raise TypeError("Operação apenas para dados numéricos")
         return sorted(self.data[coluna])[-1]

     def mean(self, coluna):
        if not self._is_numeric(coluna):
            raise TypeError("Operação apenas para dados numéricos")

         valores = self.data[coluna]
         return sum(valores) / len(valores)

     def median(self, coluna):
        if not self._is_numeric(coluna):
            raise TypeError("Operação apenas para dados numéricos")

         valores = sorted(self.data[coluna])
         n = len(valores)

         if n % 2 == 0:
            return (valores[n//2 - 1] + valores[n//2]) / 2
         else:
            return valores[n//2]

     def mode(self, coluna):
        self._check_column(coluna)
        freq = self.frequency(coluna)
        maior = max(freq.values())
        return [k for k, v in freq.items() if v == maior]

     def variance(self, coluna):
        if not self._is_numeric(coluna):
            raise TypeError("Operação apenas para dados numéricos")

         media = self.mean(coluna)
         soma = 0

         for v in self.data[coluna]:
            soma += (v - media) ** 2

         return soma / len(self.data[coluna])

     def std(self, coluna):
        if not self._is_numeric(coluna):
            raise TypeError("Operação apenas para dados numéricos")

         return self.variance(coluna) ** 0.5 