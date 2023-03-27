package group.lab1FINAL.Service;

import group.lab1FINAL.Model.Producer;
import group.lab1FINAL.Repo.ProducerRepo;

import java.util.List;

@org.springframework.stereotype.Service
public class ProducerService implements Service<Producer>{

    private ProducerRepo producerRepo;

    public ProducerService(ProducerRepo producerRepo) {
        super();
        this.producerRepo = producerRepo;
    }

    @Override
    public List<Producer> getAll() {
        return producerRepo.findAll();
    }

    @Override
    public Producer save(Producer obj) {
        return producerRepo.save(obj);
    }

    @Override
    public Producer getById(Long id) {
        return producerRepo.findById(id).get();
    }

    @Override
    public Producer update(Producer obj) {
        return producerRepo.save(obj);
    }

    @Override
    public void delete(Long id) {
       producerRepo.deleteById(id);
    }
}
