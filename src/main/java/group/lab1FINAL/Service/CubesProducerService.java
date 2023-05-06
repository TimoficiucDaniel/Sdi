package group.lab1FINAL.Service;

import group.lab1FINAL.Model.CubesProducer;
import group.lab1FINAL.Repo.CubesProducerRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@org.springframework.stereotype.Service
public class CubesProducerService implements Service<CubesProducer>{

    private CubesProducerRepo repo;

    public CubesProducerService(CubesProducerRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<CubesProducer> getAll() {
        return repo.findAll(PageRequest.of(0,20)).getContent();
    }

    public List<CubesProducer> getAll(int page){
        return repo.findAll(PageRequest.of(page,100)).getContent();
    }
    @Override
    public CubesProducer save(CubesProducer obj) {
        return repo.save(obj);
    }

    @Override
    public CubesProducer getById(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public CubesProducer update(CubesProducer obj) {
        return repo.save(obj);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
