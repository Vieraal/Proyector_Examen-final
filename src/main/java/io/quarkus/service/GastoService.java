package io.quarkus.service;

import io.quarkus.model.Gasto;
import io.quarkus.repository.GastoRepository;

import java.io.IOException;
import java.util.List;

public class GastoService {
    private GastoRepository gastoRepository = new GastoRepository();

    // Se Obtiene los todos los gastos
    public List<Gasto> getAllGastos() throws IOException {
        return gastoRepository.getAllGastos();
    }

    // Se obtiene un gasto por su ID
    public Gasto getGastoById(int id) throws IOException {
        return gastoRepository.getGastoById(id);
    }

    // Se agregar un nuevo gasto
    public void addGasto(Gasto gasto) throws IOException {
        gastoRepository.addGasto(gasto);
    }

    // Se actualizar un gasto existente
    public void updateGasto(int id, Gasto updatedGasto) throws IOException {
        gastoRepository.updateGasto(id, updatedGasto);
    }

    // Se eliminar un gasto
    public void deleteGasto(int id) throws IOException {
        gastoRepository.deleteGasto(id);
    }

    // Se Obtiene el promedio de los gastos
    public double getPromedio() throws IOException {
        return gastoRepository.getPromedio();
    }

    // Se filtran los gastos por rango de fecha
    public List<Gasto> filterGastosByDateRange(long inicio, long fin) throws IOException {
        return gastoRepository.filterGastosByDateRange(inicio, fin);
    }
}
