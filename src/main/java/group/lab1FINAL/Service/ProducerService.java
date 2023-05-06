package group.lab1FINAL.Service;

import group.lab1FINAL.Model.Producer;
import group.lab1FINAL.Model.ProducerDto;
import group.lab1FINAL.Repo.ProducerRepo;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class ProducerService implements Service<Producer>{

    private ProducerRepo producerRepo;

    public ProducerService(ProducerRepo producerRepo) {
        super();
        this.producerRepo = producerRepo;
    }

    @Override
    public List<Producer> getAll() {
        return producerRepo.findAll(PageRequest.of(0,20)).getContent();
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


    public List<ProducerDto> getProducersForFront(int page){
        return producerRepo.findAll(PageRequest.of(page,100))
                .stream().map(prod -> {return new ProducerDto(prod.getId(),prod.getName(),prod.getCubesProducers()
                        .stream().map(cubesProducer -> {return cubesProducer.getCube().getName();})
                        .collect(Collectors.toList()));}).collect(Collectors.toList());
    }

    public List<ProducerDto> getProducerAutocompleteByName(String name){
        return producerRepo.findAllProducersByName(name).stream().limit(100)
                .map(list -> { return new ProducerDto((Long) list[0], (String) list[1]);}).collect(Collectors.toList());
    }
}
