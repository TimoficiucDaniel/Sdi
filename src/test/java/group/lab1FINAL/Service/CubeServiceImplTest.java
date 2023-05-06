package group.lab1FINAL.Service;

import group.lab1FINAL.Model.Cubes;
import group.lab1FINAL.Model.CubesDTO;
import group.lab1FINAL.Repo.CubeRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CubeServiceImplTest {

    @Mock
    private CubeRepo cubeRepo;

    @InjectMocks
    private CubeServiceImpl cubeService;

    static private List<Cubes> list;


    @BeforeAll
    static public void init(){
        Cubes cub1 = new Cubes("1",200,"1","1",true);
		Cubes cub2 =new Cubes("2",300,"2","2",false);
		Cubes cub3 =new Cubes("3",100,"1","6",false);
		Cubes cub4 =new Cubes("45",500,"3","1",true);
		Cubes cub5 =new Cubes("10",50,"4","4",false);

        list = new ArrayList<>();

        list.add(cub1);
        list.add(cub2);
        list.add(cub3);
        list.add(cub4);
        list.add(cub5);

    }
    @Test
    void getCubesAlphabetically() {

        when(cubeRepo.findAll()).thenReturn(list);

        cubeService.setRepo(cubeRepo);

        CubesDTO cub1 =new CubesDTO(null,"2",300,"2","2",false);
        CubesDTO cub2 =new CubesDTO(null,"45",500,"3","1",true);

        List<CubesDTO> lista = new ArrayList<>();
        lista.add(cub1);
        lista.add(cub2);

        Assertions.assertEquals(Arrays.toString(new List[]{cubeService.getCubesAlphabetically(200)}),Arrays.toString(new List[]{lista}));
    }

    @Test
    void getCubesFiltered(){
        when(cubeRepo.findAll()).thenReturn(list);

        cubeService.setRepo(cubeRepo);
        cubeService.setFilter(250);

        Cubes cub1 =new Cubes("2",300,"2","2",false);
        Cubes cub2 =new Cubes("45",500,"3","1",true);

        List<Cubes> lista = new ArrayList<>();
        lista.add(cub1);
        lista.add(cub2);

        Assertions.assertEquals(Arrays.toString(new List[]{cubeService.getCubesAlphabetically(200)}),Arrays.toString(new List[]{lista}));
    }
}